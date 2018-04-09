import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
	static Connection conn;

	public static void main(String args[]) {
		int port = 8080;

		try {
			ServerSocket servSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Waiting for a connection on " + port);
				Socket fromClientSocket = servSocket.accept();
				try (Socket localSocket = fromClientSocket;
						PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
						BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {
					String str;
					while ((str = br.readLine()).equals("Start")) {
						try {
							Connection();
							try {
								String query = "SELECT * FROM employeeinfo ;";
								Statement stmnt =  conn.createStatement();

								ResultSet rs = stmnt.executeQuery(query);

								while (rs.next())
									pw.println("Name : " + rs.getString("name") + " " + rs.getString("surname")
											+ " Age : " + rs.getString("age"));

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

	static void Connection() {
		String userName = "root";
		String password = "postgres";
		String url = "jdbc:mysql://localhost:3306/database?verifyServerCertificate=false&useSSL=true";
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Complete!\n");
		} catch (Exception e) {
		}
	}
}
