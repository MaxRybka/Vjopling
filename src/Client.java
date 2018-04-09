import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String args[]) throws Exception {

		int portNumber = 8080;
		String str = DataInput.getString();
		System.out.println("Client is started");
		Socket socket = new Socket("192.168.31.21", portNumber);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		pw.println(str);

		while ((str = br.readLine()) != null) {
			if (str.equals("bye")) {
				break;
			}
			System.out.println(str);
		}

		br.close();
		pw.close();
		socket.close();
	}
}
