import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Updating extends Thread{
	public static boolean update = false;
	public boolean getUpdate() {
		return update;
	}
	Object obj = new Object();
	@Override
	public void run() {
		while(true) {
			try {
				//Thread.sleep(1000);
				checkUpdate();
//				synchronized(obj) {
//					wait();
//				}
				System.out.println(update);
				if(update) {
					Client.getGoodsMassive();// return Goods Massive from DataBase
					//Changing the update in the DB;
					//break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
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
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		notify();
//		}
	}
	
}