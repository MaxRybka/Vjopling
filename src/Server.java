import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.tree.RowMapper;

import javafx.scene.chart.PieChart.Data;

public class Server {
	static Connection conn;
	static int port = 8080;
	static Socket localSocket;

	public static void main(String args[]) {

		Connection();
		try {
			ServerSocket servSocket = new ServerSocket(port);
			System.out.println("Waiting for a connection on " + port);

			PrintWriter pw = null;
			BufferedReader br = null;
			while (true) {
				try {
					localSocket = servSocket.accept();
					System.out.println("Accepted");
					pw = new PrintWriter(localSocket.getOutputStream(), true);
					br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
					String str = br.readLine();
					switch (str) {
					case "Create":
					{
						Create create = new Create();
						Thread thread = new Thread(create);
						thread.setPriority(Thread.MAX_PRIORITY);
						thread.start();
						break;
					}
					case "Save":
						saveImage("4", "Wow", "Its working!", new File("Image\\exit.png"));
						break;
					case "All":
					{
//						showAllStuff();
						Update update = new Update();
						Thread thread = new Thread(update);
						thread.setPriority(Thread.MAX_PRIORITY);
						thread.start();
						break;
					}
					}
				} catch (IOException ex) {
					// ex.printStackTrace(System.out);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void showTable() {
		try {
			ServerSocket servSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Waiting for a connection on " + port);
				Socket fromClientSocket = servSocket.accept();
				try (Socket localSocket = fromClientSocket;
						PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
						BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {
					String str;
					if ((str = br.readLine()).equals("Start")) {
						try {
							Connection();
							try {
								String query = "SELECT * FROM employeeinfo;";
								Statement stmnt = conn.createStatement();

								ResultSet rs = stmnt.executeQuery(query);

								while (rs.next())
									pw.println("Login : " + rs.getString("Login") + " " + rs.getString("Password")
											+ " Info : " + rs.getString("Info"));

							} finally {
								conn.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace(System.out);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}

	}

	private static void showAllStuff() {
		try (
			DataInputStream dis = new DataInputStream(new BufferedInputStream(localSocket.getInputStream()));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(localSocket.getOutputStream()));){
			
			String query = "SELECT * FROM stuff;";
			Statement stmnt;
			try {
				stmnt = conn.createStatement();
				ResultSet rs = stmnt.executeQuery(query);

				while (rs.next()) {
					dos.writeBoolean(true);
					dos.flush();
					dos.writeUTF(rs.getString("Name"));
					dos.flush();
					dos.writeUTF(rs.getString("Description"));
					dos.flush();
					dos.writeDouble(rs.getDouble("Price"));
					dos.flush();
					dos.writeInt(rs.getInt("Quantity"));
					dos.flush();
					dos.writeUTF(rs.getString("Category"));
					dos.flush();
					Blob blob = rs.getBlob("Image");
					int blobLength = (int) blob.length();  
					byte[] blobAsBytes = blob.getBytes(1, blobLength);
					blob.free();
					dos.writeInt(blobLength);
					dos.flush();
					System.out.println(blobLength);
					dos.write(blobAsBytes);
					dos.flush();
				}
				dos.writeBoolean(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();

		}finally{
			
		}
	}

	private static void createStuff() {
		System.out.println(localSocket.toString());
		try (PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {

			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(localSocket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(localSocket.getOutputStream()));
				;

				String name = dis.readUTF();
				System.out.println(name);
				String description = dis.readUTF();
				System.out.println(description);
				int quantity = dis.read();
				System.out.println();
				String category = dis.readUTF();

				File file = new File(dis.readUTF());
				int n = 0;
				int len = dis.readInt();
				System.out.println("" + len);
				byte[] buf = new byte[len];

				System.out.println("Receiving file: " + file.getName());
				// create a new fileoutputstream for each new file
				FileOutputStream fos = new FileOutputStream(file);
				// read file
				while ((n = dis.read(buf)) != -1) {
					fos.write(buf, 0, n);
					fos.flush();
				}
				fos.close();
				dis.close();
				dos.close();

				boolean isUserExists = false;
				try (PreparedStatement ps = conn.prepareStatement("select 1 from stuff where Name = ?")) {
					ps.setString(1, name);
					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							isUserExists = true;
						}
					}
				}

				if (isUserExists) {
					System.out.println("User exists!");
				} else {
					PreparedStatement ps = conn.prepareStatement(
							"insert into stuff(Name,Description,Quantity,Category,Image) values(?,?,?,?,?)");
					InputStream is = new FileInputStream(file);
					ps.setString(1, name);
					ps.setString(2, description);
					ps.setInt(3, quantity);
					ps.setString(4, category);
					ps.setBlob(5, is);
					ps.executeUpdate();
				}

			} catch (IOException e) {
				e.printStackTrace();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			pw.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveImage(String id, String name, String Info, File selectedFile) {

		try {
			Connection();
			boolean isUserExists = false;
			try (PreparedStatement ps = conn.prepareStatement("select 1 from image where ID = ?")) {
				ps.setString(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						isUserExists = true;
					}
				}
			}

			if (isUserExists) {
				System.out.println("User exists!");
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into image(ID,Name,Info,Img) values(?,?,?,?)");
				InputStream is = new FileInputStream(selectedFile);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, Info);
				ps.setBlob(4, is);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void Connection() {
		String userName = "root";
		String password = "postgres";
		String url = "jdbc:mysql://localhost:3306/database?verifyServerCertificate=false&useSSL=true";
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Complete!\n");
		} catch (Exception e) {
			System.out.println("No connection to database!!!");
		}
	}
}

class Update implements Runnable{

	@Override
	public void run() {
		try (
				DataInputStream dis = new DataInputStream(new BufferedInputStream(Server.localSocket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Server.localSocket.getOutputStream()));){
				
				String query = "SELECT * FROM stuff;";
				Statement stmnt;
				try {
					stmnt = Server.conn.createStatement();
					ResultSet rs = stmnt.executeQuery(query);

					while (rs.next()) {
						dos.writeBoolean(true);
						dos.flush();
						dos.writeUTF(rs.getString("Name"));
						dos.flush();
						dos.writeUTF(rs.getString("Description"));
						dos.flush();
						dos.writeDouble(rs.getDouble("Price"));
						dos.flush();
						dos.writeInt(rs.getInt("Quantity"));
						dos.flush();
						dos.writeUTF(rs.getString("Category"));
						dos.flush();
						Blob blob = rs.getBlob("Image");
						int blobLength = (int) blob.length();  
						byte[] blobAsBytes = blob.getBytes(1, blobLength);
						blob.free();
						dos.writeInt(blobLength);
						dos.flush();
						System.out.println(blobLength);
						dos.write(blobAsBytes);
						dos.flush();
					}
					dos.writeBoolean(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();

			}finally{
				
			}
	}
	
}

class Create implements Runnable{

	@Override
	public void run() {
		System.out.println(Server.localSocket.toString());
		try (PrintWriter pw = new PrintWriter(Server.localSocket.getOutputStream(), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(Server.localSocket.getInputStream()))) {

			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(Server.localSocket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Server.localSocket.getOutputStream()));
				;

				String name = dis.readUTF();
				System.out.println(name);
				String description = dis.readUTF();
				System.out.println(description);
				int quantity = dis.read();
				System.out.println();
				String category = dis.readUTF();

				File file = new File(dis.readUTF());
				int n = 0;
				int len = dis.readInt();
				System.out.println("" + len);
				byte[] buf = new byte[len];

				System.out.println("Receiving file: " + file.getName());
				// create a new fileoutputstream for each new file
				FileOutputStream fos = new FileOutputStream(file);
				// read file
				while ((n = dis.read(buf)) != -1) {
					fos.write(buf, 0, n);
					fos.flush();
				}
				fos.close();
				dis.close();
				dos.close();

				boolean isUserExists = false;
				try (PreparedStatement ps = Server.conn.prepareStatement("select 1 from stuff where Name = ?")) {
					ps.setString(1, name);
					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							isUserExists = true;
						}
					}
				}

				if (isUserExists) {
					System.out.println("User exists!");
				} else {
					PreparedStatement ps = Server.conn.prepareStatement(
							"insert into stuff(Name,Description,Quantity,Category,Image) values(?,?,?,?,?)");
					InputStream is = new FileInputStream(file);
					ps.setString(1, name);
					ps.setString(2, description);
					ps.setInt(3, quantity);
					ps.setString(4, category);
					ps.setBlob(5, is);
					ps.executeUpdate();
				}

			} catch (IOException e) {
				e.printStackTrace();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			pw.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
