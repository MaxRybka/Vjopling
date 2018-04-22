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
<<<<<<< HEAD
	static int port = 8080;
	static Socket socket;
	static String ip = "192.168.43.62";
	HashMap<String,Goods> goods;


	public static void main(String args[]) throws Exception {
		CheckUpdate();
//		editStuff("third", "Description", 1, "Category", new File("Image\\background.jpg"));
		
//		getGoodsMassive();
//		CheckUpdate();
	}

	public static void editStuff(String name, String description, int quantity, String category, File image) {
		Updating.updateWait();
		EditStuffThread cs = new EditStuffThread(name, description, quantity, category, image);
		Thread thread = new Thread(cs);
		thread.start();
	}

	public static HashMap<String,Goods> getGoodsMassive() {
		
		UpdateAll sa = new UpdateAll();
		Thread thread = new Thread(sa);
		thread.start();
		return sa.getGoods();

	}
	
	public static void CheckUpdate() {
		Updating uw = new Updating();
		Thread thread = new Thread(uw);
		thread.start();
	}
=======
  static int port = 8080;
  static Socket socket;
  HashMap<String,Goods> goods;
//  static boolean update = false;

  public static void main(String args[]) throws Exception {
//    createStuff("second", "Description", 1, "Category", new File("Image\\background.jpg"));
    getGoodsMassive();

  }

  public static void createStuff(String name, String description, int quantity, String category, File image) {
    CreateStuffThread cs = new CreateStuffThread(name, description, quantity, category, image);
    Thread thread = new Thread(cs);
    thread.start();
    
  }

  public static HashMap<String,Goods> getGoodsMassive() {
    UpdateAll sa = new UpdateAll();
    Thread thread = new Thread(sa);
    thread.start();
    return sa.getGoods();

  }
>>>>>>> c997d2322e526dc898db1e8da50bbed8424e0b8e

}

class UpdateAll implements Runnable {
<<<<<<< HEAD
	HashMap<String, Goods> stuff = new HashMap<>();
	Socket socket;
	
	public HashMap<String, Goods> getGoods() {
		return stuff;
	}

	@Override
	public void run() {
		try {
			socket = new Socket(Client.ip, Client.port);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println("All");	
			readGoods();
			pw.close();
			br.close();
			Updating.updateContinue();
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
			
			dis.close();
			dos.close();
			socket.close();
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
		try {
			Socket socket = new Socket(Client.ip, Client.port);
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
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Updating.updateContinue();
	}

}


=======
  HashMap<String, Goods> stuff = new HashMap<>();
  String name,description,category;
  Socket socket;
  
  public HashMap<String, Goods> getGoods() {
    return stuff;
  }

  @Override
  public void run() {
    try {
      socket = new Socket("192.168.137.72", 8080);
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
        Goods good = new Goods(name,category,description,quantity,image);
        stuff.put(name, good);
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

  @Override
  public void run() {
    try {
      Socket socket = new Socket("10.0.128.160", 8080);
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
        dis.close();
        dos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

//class UpdateWait extends Thread{
//
//  @Override
//  public void run() {
//    while(true) {
//      
//      while(!Client.update) {//while there is no signal for update
//        Thread.yield();
//      }
//      Client.getGoodsMassive();
//      
//    }
//  }
//  
//}
>>>>>>> c997d2322e526dc898db1e8da50bbed8424e0b8e
