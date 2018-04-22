import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Updating extends Thread{
	public static boolean update = false;
	public static boolean wait = false;
	public boolean getUpdate() {
		return update;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println(update);
			if(!wait) {
				checkUpdate();
				System.out.println(update);
				if(update) {
					Client.getGoodsMassive();// return Goods Massive from DataBase
					//Changing the update in the DB;
				}
			}
		}
	}
	
	public static void updateWait() {
//		if(!wait)
			wait=true;
	}
	
	public static void updateContinue() {
//		if(wait)
			wait=false;
	}
	
	private void checkUpdate() {
		try {
			Socket socket = new Socket(Client.ip, Client.port);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("Check");


			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				int updateInt=dis.readInt();
				if(updateInt==0) {
					update=false;
				}else update=true;
				dos.close();
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}