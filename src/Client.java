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
	HashMap<String,Goods> goods;

	public static void main(String args[]) throws Exception {
//		createStuff("second", "Description", 1, "Category", new File("Image\\background.jpg"));
		goodsMassive();

	}

	public static void createStuff(String name, String description, int quantity, String category, File image) {
		CreateStuffThread cs = new CreateStuffThread(name, description, quantity, category, image);
		Thread thread = new Thread(cs);
		thread.start();
		
	}

	public static HashMap<String,Goods> goodsMassive() {
		System.out.println("Goods1");
		ShowAll sa = new ShowAll();
		Thread thread = new Thread(sa);
		thread.start();
		System.out.println("Goods2");
		return sa.getGoods();

	}

}

class ShowAll implements Runnable {
	HashMap<String, Goods> stuff = new HashMap<>();
	String name,description,category;
	Socket socket;
	
	public HashMap<String, Goods> getGoods() {
		return stuff;
	}

	@Override
	public void run() {
		try {
			socket = new Socket("192.168.31.21", 8080);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println("All");	
			readGoods();
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readGoods() {
		try {
			DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			while(dis.readBoolean()) {
				String name = dis.readUTF();
				String description = dis.readUTF();
				int quantity = dis.readInt();
				String category = dis.readUTF();
				int len = dis.readInt();
				System.out.println(len);
				byte[] imageB = new byte[len];
				if(len>0) {
				    
				    dis.readFully(imageB, 0, imageB.length); // read the message
				}
				ImageIcon image = new ImageIcon(imageB);
				//Goods stuff = new Goods();
			}
			
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class CreateStuffThread implements Runnable {
	String name, description, category;
	int quantity;
	File image;

	CreateStuffThread(String name1, String description1, int quantity1, String category1, File image1) {
		this.name = name1;
		this.description = description1;
		this.quantity = quantity1;
		this.category = category1;
		this.image = image1;
	}

<<<<<<< Updated upstream
	@Override
	public void run() {
		try {
			Socket socket = new Socket("192.168.31.21", 8080);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(socket.getInputStream()));
			pw.println("Create");

			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

				dos.writeUTF(name);
				dos.flush();
				dos.writeUTF(description);
				dos.flush();
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
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
=======
		int portNumber = 8080;
		String str = DataInput.getString();
		System.out.println("Client is started");
		Socket socket = new Socket("192.168.137.66", portNumber);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		pw.println(str);

		while ((str = br.readLine()) != null) {
			if (str.equals("bye")) {
				break;
>>>>>>> Stashed changes
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
