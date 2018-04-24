import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInput;
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
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Client {
	static int port = 8080;
	static Socket socket;
	static String ip = "192.168.31.21";
	HashMap<String,Goods> goods;
	static Object lock = new Object();
	static Thread updateThread;

	public static void main(String args[]) throws Exception {
		synchronized(lock) {
			System.out.println("Update start");
			CheckUpdate();
//			editStuff("new2", "Description",1, 1, "Category", new File("Image\\background.jpg"));
			deleteStuff("new2");
		}
//		getGoodsMassive();
//		CheckUpdate();
	}
	
	public static void deleteStuff(String name) throws InterruptedException {
		updateThread.interrupt();
		
		DeleteStuff cs = new DeleteStuff(name);
		Thread thread = new Thread(cs);
		System.out.println("Thread starting");
		thread.start();
		synchronized(thread) {
			thread.wait();
		}
		System.out.println("Thread end");
		getGoodsMassive();
		
		CheckUpdate();
	}

	public static synchronized void editStuff(String name, String description,int price, int quantity, String category, File image) throws InterruptedException {
		updateThread.interrupt();
		
		EditStuffThread cs = new EditStuffThread(name, description,price, quantity, category, image);
		Thread thread = new Thread(cs);
		thread.start();
		synchronized(thread) {
			thread.wait();
		}
		getGoodsMassive();
		CheckUpdate();
	}

	public static synchronized HashMap<String,Goods> getGoodsMassive() {
		updateThread.interrupt();
		
		UpdateAll sa = new UpdateAll();
		Thread thread = new Thread(sa);
		thread.start();
		synchronized(thread) {
				try {
					thread.wait();
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
//					e.printStackTrace();
				}
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

class DeleteStuff implements Runnable{
	static String name;
	
	DeleteStuff(String name){
		this.name = name;
		System.out.println("Name set "+this.name);
	}
	@Override
	public void run() {
		synchronized(this) {
			try (Socket socket = new Socket(Client.ip, Client.port);
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);){
				pw.println("Delete");
				System.out.println("ask server");
				try(DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
						DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));) {
					dos.writeUTF(name);
					System.out.println("Name "+name+" pushed to server");
					
				} catch (IOException e) {
					e.printStackTrace();
					socket.close();
					System.out.println("Socket closed");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			notify();
		}
		
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
			try(Socket socket = new Socket(Client.ip, Client.port);) {
				
				try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);){
					
					pw.println("All");	
					try(DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
							DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));) {
						
						while(dis.readBoolean()) {
							String name = dis.readUTF(dis);
							String description = dis.readUTF();
							int price = dis.readInt();
							int quantity = dis.readInt();
							String category = dis.readUTF();
							System.out.println(name);
							int len = dis.readInt();
							System.out.println(len);
							byte[] imageB = new byte[len];
							if(len>0) {
							    dis.readFully(imageB, 0, imageB.length); // read the message
							}
							ImageIcon image = new ImageIcon(imageB);
							
							Goods good = new Goods(name,category,description,price,quantity,image);
							stuff.put(name, good);
						}

					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Socket closed");
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Socket closed");
					socket.close();
				}
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			notify();
		}
	}

}



class EditStuffThread implements Runnable {
	String name, description, category;
	int quantity,price;
	File image;

	EditStuffThread(String name1, String description1,int price1, int quantity1, String category1, File image1) {
		this.name = name1;
		this.description = description1;
		this.price=price1;
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
					System.out.println("Creating name "+name);
					dos.writeUTF(name);
					System.out.println("Name writed");
					dos.flush();
					dos.writeUTF(description);
					dos.flush();
					dos.write(price);
					dos.flush();
					dos.write(quantity);
					dos.flush();
					dos.writeUTF(category);
					dos.flush();
	
					
					int len =(int)image.length();
					dos.writeInt(len);
					dos.flush();
					byte[] byteArray = new byte[len];
					FileInputStream fileInputStream = new FileInputStream(image);
		            fileInputStream.read(byteArray);
		            
		            dos.write(byteArray);
					dos.flush();
					
//					dos.writeUTF(image.getName());
//					dos.flush();
//					int n = 0;
//					dos.writeInt((int)image.length());
//					System.out.println("" + image.length());
//					byte[] buf = new byte[(int) image.length()];
//	
//					System.out.println(image.getName());
//	
//					FileInputStream fis = new FileInputStream(image);
//	
//					while ((n = fis.read(buf)) != -1) {
//						dos.write(buf, 0, n);
//						dos.flush();
//					}
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


