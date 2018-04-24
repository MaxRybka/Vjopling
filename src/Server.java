import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.tree.RowMapper;

import javafx.scene.chart.PieChart.Data;

public class Server {
	static Connection conn;
	static int port = 8080;
	static Socket localSocket;
	static Object lock = new Object();

	public static void main(String args[])  {
		
		Connection();
		try (ServerSocket servSocket = new ServerSocket(port);) {
			System.out.println("Waiting for a connection on " + port);

			while (true) {
				synchronized(lock) {
				
				try {
					localSocket = servSocket.accept();
					try (PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(localSocket.getInputStream()));) {

						String str = br.readLine();
						switch (str) {
						case "Create": {
							Create create = new Create();
							Thread thread = new Thread(create);
							thread.start();
							synchronized (thread) {
								try {
									thread.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							break;
						}
						case "All": {
							Update update = new Update();
							Thread thread = new Thread(update);
							thread.start();
							synchronized (thread) {
								try {
									thread.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							break;
						}
						case "Check": {
							CheckUpdate cu = new CheckUpdate();
							Thread thread = new Thread(cu);
							thread.start();
							synchronized (thread) {
								try {
									thread.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							break;
						}
						case "Delete": {
							Delete cu = new Delete();
							Thread thread = new Thread(cu);
							thread.start();
							synchronized (thread) {
								try {
									thread.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println("Delite thread end");
							break;
						}
						}
					}
				} catch (IOException ex) {
					//Problem is somewhere here!!!!
					System.out.println("Socket closed");
					localSocket.close();
				}
				}
			}
		} catch (IOException e) {
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

class Update implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			try (DataInputStream dis = new DataInputStream(
					new BufferedInputStream(Server.localSocket.getInputStream()));
					DataOutputStream dos = new DataOutputStream(
							new BufferedOutputStream(Server.localSocket.getOutputStream()));) {
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
						dos.writeInt(rs.getInt("Price"));
						dos.flush();
						dos.writeInt(rs.getInt("Quantity"));
						dos.flush();
						dos.writeUTF(rs.getString("Category"));
						dos.flush();
						System.out.println(rs.getString("Name"));
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

			}
			notify();
		}

	}

}

class Create implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
//			System.out.println(Server.localSocket.toString());
//			try (PrintWriter pw = new PrintWriter(Server.localSocket.getOutputStream(), true);) {

				try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Server.localSocket.getInputStream()));
						DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Server.localSocket.getOutputStream()));) {
					String name = dis.readUTF();
					System.out.println(name);
					String description = dis.readUTF();
					System.out.println(description);
					int price = dis.read();
					System.out.println(price);
					int quantity = dis.read();
					System.out.println(quantity);
					String category = dis.readUTF();
					System.out.println(category);
					
					int len = dis.readInt();
					System.out.println("" + len);
					byte[] buf = new byte[(int) len];
					if(len>0) {
					    dis.readFully(buf, 0, buf.length); // read the message
					}
					
					

//					System.out.println("Receiving file: " + file.getName());
//					FileOutputStream fos = new FileOutputStream(file);
//					
//					while ((n = dis.read(buf)) != -1) {
//						fos.write(buf, 0, n);
//						fos.flush();
//					}
//					fos.close();

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
								"insert into stuff(Name,Description,Price,Quantity,Category,Image) values(?,?,?,?,?,?)");
						Blob blob = new javax.sql.rowset.serial.SerialBlob(buf);


						ps.setString(1, name);
						ps.setString(2, description);
						ps.setInt(3, price);
						ps.setInt(4, quantity);
						ps.setString(5, category);
						ps.setBlob(6,blob);
						ps.executeUpdate();
						// Changing the Data Base need for Update
						System.out.println("Changing the Data Base need for Update");
						PreparedStatement update = Server.conn.prepareStatement("update updatecheck set needForUpdate=1 where ID=1;");
						update.executeUpdate();
					}

				} catch (IOException e) {
					System.out.println("Socket trouble");
					try {
						Server.localSocket.close();
						System.out.println("Socket closed");
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			notify();
		}

	}

}

class CheckUpdate implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			try (DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(Server.localSocket.getOutputStream()));
					DataInputStream dis = new DataInputStream(
							new BufferedInputStream(Server.localSocket.getInputStream()));
					PreparedStatement ps = Server.conn.prepareStatement("select * from updatecheck;")) {
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						int needForUpdate = rs.getInt("needForUpdate");
						dos.writeInt(needForUpdate);
						dos.flush();
						if (needForUpdate != 0) {
							PreparedStatement update = Server.conn
									.prepareStatement("update updatecheck set needForUpdate=0 where ID=1;");
							update.executeUpdate();
						}
					}
				}catch(SocketException se) {
					Server.localSocket.close();
					System.out.println("SocketClosed");
				}

			} catch (IOException | SQLException e) {
				//e.printStackTrace();
				try {
					Server.localSocket.close();
					System.out.println("Socket closed");
				} catch (IOException e1) {
					
					System.out.println("Socket Already closed");
				}
			}
			notify();
		}
	}

}

class Delete implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Server.localSocket.getOutputStream()));
					DataInputStream dis = new DataInputStream(new BufferedInputStream(Server.localSocket.getInputStream()));) {
				System.out.println(dis.available());
				String name = dis.readUTF();
				try (PreparedStatement check = Server.conn.prepareStatement("select * from stuff where Name = ?;");) {
					check.setString(1, name);
					ResultSet rs = check.executeQuery();
					if (rs.next()) {
						try (PreparedStatement ps = Server.conn.prepareStatement("delete from stuff where Name =?;");) {
							ps.setString(1, name);
							ps.executeUpdate();

						} catch (SQLException sql) {
							System.out.println("SQL problems\nName " + name);
						}
						System.out.println("Changing the Data Base need for Update");
						PreparedStatement update = Server.conn.prepareStatement("update updatecheck set needForUpdate=1 where ID=1;");
						update.executeUpdate();
					} else {
						System.out.println("No stuff with this name!");
					}
				}
			} catch (IOException | SQLException e) {
				try {
					Server.localSocket.close();
					System.out.println("Socket closed");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			notify();
		}
	}

}
