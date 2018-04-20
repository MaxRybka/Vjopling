import java.io.File;

import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
=======
>>>>>>> master

public class PanelWithStuff extends JPanel {

	/**
	 * Create the panel.
	 */
<<<<<<< HEAD
	public PanelWithStuff(String nameOfStuff,String wayImage,int price, int Quontiti) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel img = new JLabel("Image");
	
		springLayout.putConstraint(SpringLayout.NORTH, img, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, img, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, img, 259, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, img, 290, SpringLayout.WEST, this);
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\"+wayImage));
		icon.setImage(icon.getImage().getScaledInstance(280, 224, Image.SCALE_DEFAULT));
		img.setIcon(icon);
		add(img);		
		JLabel quontiti = new JLabel("Quontiti: "+Quontiti);
		springLayout.putConstraint(SpringLayout.EAST, quontiti, -140, SpringLayout.EAST, img);
		quontiti.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, quontiti, 6, SpringLayout.SOUTH, img);
		springLayout.putConstraint(SpringLayout.WEST, quontiti, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, quontiti, 31, SpringLayout.SOUTH, img);
		add(quontiti);
		
		JLabel name = new JLabel(nameOfStuff);
		name.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, name, -34, SpringLayout.NORTH, img);
		springLayout.putConstraint(SpringLayout.WEST, name, 0, SpringLayout.WEST, img);
		springLayout.putConstraint(SpringLayout.SOUTH, name, 0, SpringLayout.NORTH, img);
		springLayout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, img);
		add(name);
		
		JLabel Price = new JLabel("|Price: "+price);
		springLayout.putConstraint(SpringLayout.WEST, Price, 0, SpringLayout.EAST, quontiti);
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, Price, 6, SpringLayout.SOUTH, img);
		springLayout.putConstraint(SpringLayout.SOUTH, Price, 0, SpringLayout.SOUTH, quontiti);
		springLayout.putConstraint(SpringLayout.EAST, Price, 140, SpringLayout.EAST, quontiti);
		add(Price);
		
	}
=======
	public PanelWithStuff(String nameOfStuff,File image) {
		
	}

>>>>>>> master
}
