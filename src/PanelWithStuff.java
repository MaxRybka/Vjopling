import java.io.File;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;

public class PanelWithStuff extends JPanel {

	/**
	 * Create the panel.
	 */
//	public PanelWithStuff(String nameOfStuff,String wayImage) {
	public PanelWithStuff(String nameOfStuff, ImageIcon icon) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		setVisible(true);
		Goods current = Storage.stuff.get(nameOfStuff);
		
		JLabel img = new JLabel("Image");
		setBounds(0, 0, 300, 300);
		setSize(300,300);
		springLayout.putConstraint(SpringLayout.NORTH, img, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, img, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, img, 259, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, img, 290, SpringLayout.WEST, this);
//		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\"+wayImage));
		icon.setImage(icon.getImage().getScaledInstance(280, 224, Image.SCALE_DEFAULT));
		img.setIcon(icon);
		this.add(img);		
		JLabel quontiti = new JLabel("Quontity: "+current.getAmmount());
		springLayout.putConstraint(SpringLayout.EAST, quontiti, -140, SpringLayout.EAST, img);
		quontiti.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, quontiti, 6, SpringLayout.SOUTH, img);
		springLayout.putConstraint(SpringLayout.WEST, quontiti, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, quontiti, 31, SpringLayout.SOUTH, img);
	    
		this.add(quontiti);
		
		JLabel name = new JLabel(current.getName());
		name.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, name, -34, SpringLayout.NORTH, img);
		springLayout.putConstraint(SpringLayout.WEST, name, 0, SpringLayout.WEST, img);
		springLayout.putConstraint(SpringLayout.SOUTH, name, 0, SpringLayout.NORTH, img);
		springLayout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, img);
		this.add(name);
		
		JLabel Price = new JLabel("Price: "+current.getPrice());
		springLayout.putConstraint(SpringLayout.WEST, Price, 0, SpringLayout.EAST, quontiti);
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, Price, 6, SpringLayout.SOUTH, img);
		springLayout.putConstraint(SpringLayout.SOUTH, Price, 0, SpringLayout.SOUTH, quontiti);
		springLayout.putConstraint(SpringLayout.EAST, Price, 140, SpringLayout.EAST, quontiti);
		this.add(Price);
		
		addMouseListener(new MouseAdapter() {
			  @Override
              public void mousePressed(MouseEvent e) {
                  DecriptionStuff ds1 = new  DecriptionStuff(current.getName(), current.getDescription(), current.getCategory(), current.getAmmount(), current.getPrice(),current.getImage(),current.getMaker());
//                  ds1.main(null);
                  ds1.mianMain(ds1);
                  
              }
		});
		
	}
}
