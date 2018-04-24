import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Updating extends Thread{
	public static boolean update = false;
	@Override
	public void run() {
		System.out.println("Update wait");
		while(true) {
			
			checkUpdate();
			if(update) {
				Client.getGoodsMassive();// return Goods Massive from DataBase
				//Changing the update in the DB;
				//break;
			}
			
		}
	}
	
	private void checkUpdate() {
		//synchronized(obj) {
		try(Socket socket = new Socket(Client.ip, Client.port);
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);) {
			
			pw.println("Check");
			try(DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));) {
				
				int updateInt=dis.readInt();
				if(updateInt==0) {
					update = false;
				}else update= true;
			} catch (IOException e) {
				e.printStackTrace();
				socket.close();
				System.out.println("Socket closed");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		notify();
//		}
	}
	
}