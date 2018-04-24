import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class DecriptionStuff extends JFrame {

	private JPanel contentPane;
	private JLabel Image;
	private JLabel lblKolichestvo;
	private JButton btnEditDescrition;
	private SpinnerNumberModel modelForSpinner;
	private SpinnerNumberModel modelForSpinner2;
	private JSpinner spinner;
	private JLabel Category;
	private JButton btnNewButton;
	private JTextArea Description;
	JLabel nameOfStuff;
	
	private int xx;
	private int xy;
	
	static DecriptionStuff frame = new DecriptionStuff(null, "description", "some shit", 14,999999, null, "sosa-sola");
	private JLabel Price;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
//  public DecriptionStuff(String name, String description,String category,int quantiti,String nameOfImage) {
	public void mianMain(DecriptionStuff ds) {
		ds.setUndecorated(true);
		ds.setVisible(true);

		contentPane.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =e.getXOnScreen();
				int y = e.getYOnScreen();
				ds.setLocation(x-xx,y-xy);
			}
		});
		contentPane.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				setOpacity((float)1.0);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setOpacity((float)0.8);
				xx = e.getX();
				xy = e.getY();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent arg0) {
		        Storage.editGoods(nameOfStuff.getText(), Description.getText(), (int)spinner.getValue(), (int)spinner.getValue());
		        ds.dispose();
		        MainWindow.paintGoodsPane(Storage.stuff);
		      }
		    });
	}
  public DecriptionStuff(String name, String description,String category,int quantiti, int price, ImageIcon imgOfStuff,String maker) {
    //JLabel contentPane = new JLabel(new ImageIcon("Image\\wallper.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 537);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		contentPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNewButton.doClick();
				}
			}
		});

		Image = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, Image, 10, SpringLayout.WEST, contentPane);
		Image.setFont(new Font("Tahoma", Font.PLAIN, 99));
		contentPane.add(Image);
		imgOfStuff = (imgOfStuff == null ? new ImageIcon("Image\\meme.png") : imgOfStuff);
	//	ImageIcon imgOfStuff = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\"+nameOfImage));
		imgOfStuff.setImage(imgOfStuff.getImage().getScaledInstance(362, 278, Image.SOUTH_WEST));
		Image.setIcon(imgOfStuff);
		lblKolichestvo = new JLabel("Quantity:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKolichestvo, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblKolichestvo, 163, SpringLayout.WEST, contentPane);
		lblKolichestvo.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		contentPane.add(lblKolichestvo);

		
		
		btnEditDescrition = new JButton("Edit description");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEditDescrition, -5, SpringLayout.EAST, contentPane);
		btnEditDescrition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Description.requestFocus();
				Description.setEditable(true);
			}
		});
		btnEditDescrition.setForeground(Color.WHITE);
		btnEditDescrition.setBackground(new Color(51, 153, 51));
		btnEditDescrition.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		contentPane.add(btnEditDescrition);
		
		modelForSpinner = new SpinnerNumberModel(quantiti, 0, 99999, 50);
		spinner = new JSpinner(modelForSpinner);
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinner, -37, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, spinner, 7, SpringLayout.EAST, lblKolichestvo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinner, -9, SpringLayout.SOUTH, contentPane);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(spinner);
		
		Category = new JLabel("Category: "+category);
		sl_contentPane.putConstraint(SpringLayout.WEST, Category, 286, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinner, -29, SpringLayout.WEST, Category);
		Category.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		contentPane.add(Category);
		
		btnNewButton = new JButton("Enter");
		sl_contentPane.putConstraint(SpringLayout.EAST, Category, -6, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -43, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnEditDescrition);
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(btnNewButton);
		
//		Description = new JTextPane();
//		sl_contentPane.putConstraint(SpringLayout.WEST, Description, 407, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, Image, -39, SpringLayout.WEST, Description);
//		sl_contentPane.putConstraint(SpringLayout.NORTH, Description, 53, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, Description, -119, SpringLayout.SOUTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, Description, -10, SpringLayout.EAST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.NORTH, Image, 0, SpringLayout.NORTH, Description);
//		 JScrollPane jScrollPane1 = new JScrollPane();
//		 jScrollPane1.setVerticalScrollBarPolicy(
//	      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		 jScrollPane1.setViewportView(Description);
//		 contentPane.add(jScrollPane1);
		
		//contentPane.add(Description);
		Description = new JTextArea();
		Description.setText(description);
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		sl_contentPane.putConstraint(SpringLayout.NORTH, Description, 60, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Description, -6, SpringLayout.NORTH, btnEditDescrition);
		sl_contentPane.putConstraint(SpringLayout.WEST, Description, 0, SpringLayout.WEST, Category);
		sl_contentPane.putConstraint(SpringLayout.EAST, Description, 0, SpringLayout.EAST, btnEditDescrition);
		JScrollPane scrollPane = new JScrollPane(Description);
		sl_contentPane.putConstraint(SpringLayout.EAST, Image, -17, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 379, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 783, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 78, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 356, SpringLayout.NORTH, contentPane);
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		scrollPane.setBorder(null);
		
		contentPane.add(scrollPane);
	
		Description.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		Description.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Description.setEditable(false);
					frame.requestFocus();
				}
			}
		});
		Description.setText(description);
		Description.setEditable(false);
		
		JLabel edit = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, edit, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, edit, -21, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, edit, -5, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEditDescrition, 303, SpringLayout.SOUTH, edit);
		ImageIcon imgEdit = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\remove.png"));
		imgEdit.setImage(imgEdit.getImage().getScaledInstance(70, 70, Image.SOUTH_WEST));
		edit.setIcon(imgEdit);
		contentPane.add(edit);
		
		nameOfStuff = new JLabel(name);
		nameOfStuff.setText(name);
		sl_contentPane.putConstraint(SpringLayout.WEST, edit, 70, SpringLayout.EAST, nameOfStuff);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Image, 6, SpringLayout.SOUTH, nameOfStuff);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameOfStuff, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nameOfStuff, 649, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameOfStuff, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nameOfStuff, 72, SpringLayout.NORTH, contentPane);
		nameOfStuff.setFont(new Font("Century Gothic", Font.PLAIN, 49));
		contentPane.add(nameOfStuff);
		
		Price = new JLabel("Price(USD):");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Image, -19, SpringLayout.NORTH, Price);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKolichestvo, 6, SpringLayout.SOUTH, Price);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblKolichestvo, 60, SpringLayout.SOUTH, Price);
		sl_contentPane.putConstraint(SpringLayout.EAST, Price, 150, SpringLayout.WEST, Image);
		sl_contentPane.putConstraint(SpringLayout.WEST, Price, 0, SpringLayout.WEST, Image);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Price, -60, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Price, -105, SpringLayout.SOUTH, contentPane);
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		contentPane.add(Price);
		
		modelForSpinner2 = new SpinnerNumberModel(price, 0, 999999, 50);
		JSpinner spinner_1 = new JSpinner(modelForSpinner2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinner_1, 27, SpringLayout.SOUTH, Image);
		sl_contentPane.putConstraint(SpringLayout.WEST, spinner_1, 9, SpringLayout.EAST, Price);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinner_1, -32, SpringLayout.NORTH, spinner);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(spinner_1);
		
		JLabel lblMaker = new JLabel("Maker: "+ maker);
		lblMaker.setText("Maker: "+ maker);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMaker, -60, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Category, 15, SpringLayout.SOUTH, lblMaker);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinner_1, -30, SpringLayout.WEST, lblMaker);
		lblMaker.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMaker, 0, SpringLayout.WEST, Category);
		contentPane.add(lblMaker);
		
	}
}
