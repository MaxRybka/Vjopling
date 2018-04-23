import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Client {
	static int port = 8080;
	static Socket socket;
	static String ip = "10.0.128.194";
	HashMap<String,Goods> goods;
	static Object lock = new Object();
	static Thread updateThread;

	public static void main(String args[]) throws Exception {
		synchronized(lock) {
		CheckUpdate();
		
		editStuff("third", "Description", 1, "Category", new File("Image\\background.jpg"));
		
		
		}
//		getGoodsMassive();
//		CheckUpdate();
	}

	public static synchronized void editStuff(String name, String description, int quantity, String category, File image) throws InterruptedException {
		updateThread.interrupt();
		
		EditStuffThread cs = new EditStuffThread(name, description, quantity, category, image);
		Thread thread = new Thread(cs);
		thread.start();
		synchronized(thread) {
			thread.wait();
		}
		
		CheckUpdate();
	}

	public static synchronized HashMap<String,Goods> getGoodsMassive() throws InterruptedException {
		updateThread.interrupt();
		
		UpdateAll sa = new UpdateAll();
		Thread thread = new Thread(sa);
		thread.start();
		synchronized(thread) {
			thread.wait();
		}
		
		CheckUpdate();
		return sa.getGoods();

	}
	
	public static synchronized void CheckUpdate() {
		Updating uw = new Updating();
		updateThread = new Thread(uw);
		updateThread.start();
	}

}

class UpdateAll implements Runnable {
	HashMap<String, Goods> stuff = new HashMap<>();
	Socket socket;
	
	public HashMap<String, Goods> getGoods() {
		return stuff;
	}

	@Override
	public void run() {
		synchronized(this) {
			try {
				System.out.println("!!!");
				socket = new Socket(Client.ip, Client.port);
				try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
						){
					
					pw.println("All");	
					readGoods();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			notify();
		}
	}
	
	private void readGoods() {
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));) {
			
			while(dis.readBoolean()) {
				String name = dis.readUTF();
				String description = dis.readUTF();
				double price = dis.readDouble();
				int quantity = dis.readInt();
				String category = dis.readUTF();
				int len = dis.readInt();
				System.out.println(len);
				byte[] imageB = new byte[len];
				if(len>0) {
				    dis.readFully(imageB, 0, imageB.length); // read the message
				}
				ImageIcon image = new ImageIcon(imageB);
				
//				Goods good = new Goods(name,category,description,quantity,image);
//				stuff.put(name, good);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



class EditStuffThread implements Runnable {
	String name, description, category;
	int quantity;
	File image;

	EditStuffThread(String name1, String description1, int quantity1, String category1, File image1) {
		this.name = name1;
		this.description = description1;
		this.quantity = quantity1;
		this.category = category1;
		this.image = image1;
	}

	@Override
	public void run() {
		synchronized(this) {
			try (Socket socket = new Socket(Client.ip, Client.port);
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);){
				pw.println("Create");
	
				try(DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
						DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));) {
					dos.writeUTF(name);
					dos.flush();
					dos.writeUTF(description);
					dos.flush();
					//dos.writeInt(price);
					dos.write(quantity);
					dos.flush();
					dos.writeUTF(category);
					dos.flush();
	
					dos.writeUTF(image.getName());
					dos.flush();
	
					int n = 0;
					dos.writeInt((int) image.length());
					System.out.println("" + image.length());
					byte[] buf = new byte[(int) image.length()];
	
					System.out.println(image.getName());
	
					FileInputStream fis = new FileInputStream(image);
	
					while ((n = fis.read(buf)) != -1) {
						dos.write(buf, 0, n);
						dos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			notify();
		}
	}

}


