import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class MainWindow extends JFrame {
	
	static MainWindow frame = new MainWindow();
	private SpringLayout sl_contentPane;
	private JPanel contentPane;
	String username;
	private JLabel lblHello;
	static final int PRICE_MIN = 0;
	static final int PRICE_MAX = 3000;
	static final int FPS_INIT = 15;
	private JTextField tfSerach;
	private JLabel lblPrice;
	
	private JLabel ImStuff1;
	private JLabel ImStuff2;
	private JLabel ImStuff3;
	private int widthOfImages = 280;
	private int heightOfImages = 230;
<<<<<<< HEAD
	
	private static  JPanel panel;
	private static  JLabel lblFind;
	private static JSlider slider;
	private static JLabel lblSerachIcon;
	private static JComboBox cbCategory;
	private static JComboBox cbMader;
	private static JButton btnAddStuff;
	private static JScrollBar scrollBar;

=======
>>>>>>> master
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public MainWindow() {
<<<<<<< HEAD
		setUI();
		setMainContantPain();
		addFindPanel();
		
		scrollBar = new JScrollBar();
		scrollBar.setForeground(Color.WHITE);
		scrollBar.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollBar, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollBar, -21, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollBar, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollBar, 0, SpringLayout.EAST, contentPane);
		contentPane.add(scrollBar);
		
		

		addComponents();

	}

	private void addFindPanel() {
		panel = new JPanel();
		//	JLabel panel = new JLabel(new ImageIcon("Image\\background2.jpg"));  THIS IS BACKGROUND
			panel.setBackground(Color.WHITE);
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, panel, -5, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 800, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, panel, 287, SpringLayout.WEST, contentPane);
			contentPane.add(panel);
			SpringLayout sl_panel = new SpringLayout();
			panel.setLayout(sl_panel);

			lblFind = new JLabel("Finder");
			sl_panel.putConstraint(SpringLayout.NORTH, lblFind, 52, SpringLayout.NORTH, panel);
			lblFind.setFont(new Font("Century Gothic", Font.PLAIN, 56));
			panel.add(lblFind);

			slider = new JSlider();
			sl_panel.putConstraint(SpringLayout.WEST, slider, 27, SpringLayout.WEST, panel);
			sl_panel.putConstraint(SpringLayout.EAST, slider, 260, SpringLayout.WEST, panel);
			slider.setForeground(Color.BLACK);
			slider.setBackground(Color.WHITE);
			slider.setMaximum(PRICE_MAX);
			slider.setMinimum(PRICE_MIN);
			//slider.setMinorTickSpacing(2);
		    slider.setMajorTickSpacing(PRICE_MAX/3);
		    slider.setPaintTicks(true);
		    slider.setPaintLabels(true);
			panel.add(slider);
			slider.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					int value = slider.getValue();
					lblPrice.setText("Price(USD): " + value);

				}
			});

			tfSerach = new JTextField();
			sl_panel.putConstraint(SpringLayout.NORTH, tfSerach, 56, SpringLayout.SOUTH, lblFind);
			sl_panel.putConstraint(SpringLayout.EAST, tfSerach, -46, SpringLayout.EAST, panel);
			tfSerach.setText("Search...");
			panel.add(tfSerach);
			tfSerach.setColumns(10);

			lblSerachIcon = new JLabel("-O");
			sl_panel.putConstraint(SpringLayout.NORTH, lblSerachIcon, 0, SpringLayout.NORTH, tfSerach);
			sl_panel.putConstraint(SpringLayout.WEST, lblSerachIcon, 6, SpringLayout.EAST, tfSerach);
			sl_panel.putConstraint(SpringLayout.EAST, lblSerachIcon, -11, SpringLayout.EAST, panel);
			panel.add(lblSerachIcon);

			cbCategory = new JComboBox();
			sl_panel.putConstraint(SpringLayout.WEST, tfSerach, 0, SpringLayout.WEST, cbCategory);
			sl_panel.putConstraint(SpringLayout.WEST, cbCategory, 57, SpringLayout.WEST, panel);
			sl_panel.putConstraint(SpringLayout.EAST, cbCategory, -47, SpringLayout.EAST, panel);
			cbCategory.setBackground(Color.WHITE);
			sl_panel.putConstraint(SpringLayout.NORTH, cbCategory, 417, SpringLayout.NORTH, panel);
			sl_panel.putConstraint(SpringLayout.SOUTH, slider, -66, SpringLayout.NORTH, cbCategory);
			panel.add(cbCategory);

			cbMader = new JComboBox();
			sl_panel.putConstraint(SpringLayout.NORTH, cbMader, 565, SpringLayout.NORTH, panel);
			sl_panel.putConstraint(SpringLayout.WEST, cbMader, 57, SpringLayout.WEST, panel);
			sl_panel.putConstraint(SpringLayout.EAST, cbMader, -47, SpringLayout.EAST, panel);
			cbMader.setBackground(Color.WHITE);
			sl_panel.putConstraint(SpringLayout.SOUTH, cbCategory, -111, SpringLayout.NORTH, cbMader);
			panel.add(cbMader);

			
			btnAddStuff = new JButton("+ Stuff");
			sl_panel.putConstraint(SpringLayout.SOUTH, cbMader, -109, SpringLayout.NORTH, btnAddStuff);
			sl_panel.putConstraint(SpringLayout.WEST, btnAddStuff, -1, SpringLayout.WEST, panel);
			sl_panel.putConstraint(SpringLayout.EAST, btnAddStuff, -1, SpringLayout.EAST, panel);
			btnAddStuff.setFont(new Font("Century Gothic", Font.PLAIN, 33));
			sl_panel.putConstraint(SpringLayout.SOUTH, btnAddStuff, -1, SpringLayout.SOUTH, panel);
			btnAddStuff.setBackground(Color.WHITE);
			
			sl_panel.putConstraint(SpringLayout.NORTH, btnAddStuff, -103, SpringLayout.SOUTH, panel);
			panel.add(btnAddStuff);

			lblPrice = new JLabel("Price(USD): 0");
			sl_panel.putConstraint(SpringLayout.SOUTH, lblSerachIcon, -49, SpringLayout.NORTH, lblPrice);
			sl_panel.putConstraint(SpringLayout.SOUTH, tfSerach, -48, SpringLayout.NORTH, lblPrice);
			sl_panel.putConstraint(SpringLayout.WEST, lblPrice, 66, SpringLayout.WEST, panel);
			sl_panel.putConstraint(SpringLayout.EAST, lblPrice, -9, SpringLayout.EAST, panel);
			sl_panel.putConstraint(SpringLayout.WEST, lblFind, 0, SpringLayout.WEST, lblPrice);
			sl_panel.putConstraint(SpringLayout.SOUTH, lblPrice, -6, SpringLayout.NORTH, slider);
			lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 23));
			panel.add(lblPrice);
			
		
	}

	private void setMainContantPain() {
=======
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
>>>>>>> master
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 847);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
<<<<<<< HEAD
		
	}
=======

		JPanel panel = new JPanel();
	//	JLabel panel = new JLabel(new ImageIcon("Image\\background2.jpg"));  THIS IS BACKGROUND
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 800, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 287, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblFind = new JLabel("Finder");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFind, 52, SpringLayout.NORTH, panel);
		lblFind.setFont(new Font("Century Gothic", Font.PLAIN, 56));
		panel.add(lblFind);

		JSlider slider = new JSlider();
		sl_panel.putConstraint(SpringLayout.WEST, slider, 27, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, slider, 260, SpringLayout.WEST, panel);
		slider.setForeground(Color.BLACK);
		slider.setBackground(Color.WHITE);
		slider.setMaximum(PRICE_MAX);
		slider.setMinimum(PRICE_MIN);
		//slider.setMinorTickSpacing(2);
	    slider.setMajorTickSpacing(PRICE_MAX/3);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
		panel.add(slider);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				lblPrice.setText("Price(USD): " + value);

			}
		});

		tfSerach = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, tfSerach, 56, SpringLayout.SOUTH, lblFind);
		sl_panel.putConstraint(SpringLayout.EAST, tfSerach, -46, SpringLayout.EAST, panel);
		tfSerach.setText("Search...");
		panel.add(tfSerach);
		tfSerach.setColumns(10);

		JLabel lblSerachIcon = new JLabel("-O");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSerachIcon, 0, SpringLayout.NORTH, tfSerach);
		sl_panel.putConstraint(SpringLayout.WEST, lblSerachIcon, 6, SpringLayout.EAST, tfSerach);
		sl_panel.putConstraint(SpringLayout.EAST, lblSerachIcon, -11, SpringLayout.EAST, panel);
		panel.add(lblSerachIcon);

		JComboBox cbCategory = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, tfSerach, 0, SpringLayout.WEST, cbCategory);
		sl_panel.putConstraint(SpringLayout.WEST, cbCategory, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cbCategory, -47, SpringLayout.EAST, panel);
		cbCategory.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, cbCategory, 417, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, slider, -66, SpringLayout.NORTH, cbCategory);
		panel.add(cbCategory);

		JComboBox cbMader = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, cbMader, 565, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, cbMader, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cbMader, -47, SpringLayout.EAST, panel);
		cbMader.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.SOUTH, cbCategory, -111, SpringLayout.NORTH, cbMader);
		panel.add(cbMader);

		JButton btnNewButton = new JButton("+ Stuff");
		sl_panel.putConstraint(SpringLayout.SOUTH, cbMader, -109, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, -1, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -1, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -1, SpringLayout.SOUTH, panel);
		btnNewButton.setBackground(Color.WHITE);
		
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -103, SpringLayout.SOUTH, panel);
		panel.add(btnNewButton);

		lblPrice = new JLabel("Price(USD): 0");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSerachIcon, -49, SpringLayout.NORTH, lblPrice);
		sl_panel.putConstraint(SpringLayout.SOUTH, tfSerach, -48, SpringLayout.NORTH, lblPrice);
		sl_panel.putConstraint(SpringLayout.WEST, lblPrice, 66, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPrice, -9, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFind, 0, SpringLayout.WEST, lblPrice);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPrice, -6, SpringLayout.NORTH, slider);
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		panel.add(lblPrice);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(Color.WHITE);
		scrollBar.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollBar, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollBar, -21, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollBar, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollBar, 0, SpringLayout.EAST, contentPane);
		contentPane.add(scrollBar);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 18, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 310, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 318, SpringLayout.EAST, panel);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, 310, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 306, SpringLayout.EAST, panel_1);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 6, SpringLayout.EAST, panel_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, 300, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, -6, SpringLayout.WEST, scrollBar);
		contentPane.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		ImStuff3 = new JLabel("");
		sl_panel_3.putConstraint(SpringLayout.NORTH, ImStuff3, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, ImStuff3, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, ImStuff3, 247, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, ImStuff3, 298, SpringLayout.WEST, panel_3);
		panel_3.add(ImStuff3);
		
		JLabel lblNameOfStuff_3 = new JLabel("Gaming Mouse");
		lblNameOfStuff_3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNameOfStuff_3, 6, SpringLayout.SOUTH, ImStuff3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNameOfStuff_3, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_3, -10, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNameOfStuff_3, 0, SpringLayout.EAST, ImStuff3);
		panel_3.add(lblNameOfStuff_3);
		
		JPanel panel_4 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 18, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, 306, SpringLayout.SOUTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		ImStuff1 = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, ImStuff1, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, ImStuff1, 10, SpringLayout.WEST, panel_1);
		panel_1.add(ImStuff1);
	
		
		JLabel lblNameOfStuff_1 = new JLabel("Fashionable shoes Nike SB 2018");
		lblNameOfStuff_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNameOfStuff_1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNameOfStuff_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, ImStuff1, -18, SpringLayout.NORTH, lblNameOfStuff_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, ImStuff1, 0, SpringLayout.EAST, lblNameOfStuff_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNameOfStuff_1, 258, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_1, -10, SpringLayout.SOUTH, panel_1);
		panel_1.add(lblNameOfStuff_1);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_5, 306, SpringLayout.SOUTH, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		ImStuff2 = new JLabel("");
		sl_panel_2.putConstraint(SpringLayout.NORTH, ImStuff2, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, ImStuff2, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, ImStuff2, 244, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, ImStuff2, 290, SpringLayout.WEST, panel_2);
		panel_2.add(ImStuff2);
		
		JLabel lblNameOfStuff_2 = new JLabel("Java T-Shirt");
		lblNameOfStuff_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNameOfStuff_2, 10, SpringLayout.SOUTH, ImStuff2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNameOfStuff_2, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_2, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNameOfStuff_2, 0, SpringLayout.EAST, ImStuff2);
		panel_2.add(lblNameOfStuff_2);
		
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_5, 306, SpringLayout.EAST, panel_4);
		panel_4.setLayout(new SpringLayout());
		contentPane.add(panel_5);
		panel_5.setLayout(new SpringLayout());

		addComponents();
>>>>>>> master

	private void setUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void addComponents() {
<<<<<<< HEAD
	
		
		// PICTURES FOR PANEL
		
//		ImStuff1.setIcon(new ImageIcon(new ImageIcon("Image\\stuff1.png").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
//		ImStuff2.setIcon(new ImageIcon(new ImageIcon("Image\\stuff2.png").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
//		ImStuff3.setIcon(new ImageIcon(new ImageIcon("Image\\stuff3.png").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
=======
		//frame.pack();
		ImStuff1.setIcon(new ImageIcon(new ImageIcon("Image\\stuff1.jpg").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
		ImStuff2.setIcon(new ImageIcon(new ImageIcon("Image\\stuff2.png").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
		ImStuff3.setIcon(new ImageIcon(new ImageIcon("Image\\stuff3.png").getImage().getScaledInstance(widthOfImages, heightOfImages, Image.SCALE_DEFAULT)));
>>>>>>> master
		
		// lblHello = new JLabel("Hi,"+LogIn.username+" nice to see you.");
		// sl_contentPane.putConstraint(SpringLayout.NORTH, lblHello, 345,
		// SpringLayout.NORTH, contentPane);
		// sl_contentPane.putConstraint(SpringLayout.WEST, lblHello, -1009,
		// SpringLayout.EAST, contentPane);
		// sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHello, -358,
		// SpringLayout.SOUTH, contentPane);
		// sl_contentPane.putConstraint(SpringLayout.EAST, lblHello, -251,
		// SpringLayout.EAST, contentPane);
		// lblHello.setFont(new Font("Century Gothic", Font.PLAIN, 70));
		// contentPane.add(lblHello);
		// TODO animation for text
		
// PANELS
		
//		JPanel panel_1 = new JPanel();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 18, SpringLayout.EAST, panel);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 310, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 318, SpringLayout.EAST, panel);
//		contentPane.add(panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, 310, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 306, SpringLayout.EAST, panel_1);
//		contentPane.add(panel_2);
//		
//		JPanel panel_3 = new JPanel();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 6, SpringLayout.EAST, panel_2);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, 300, SpringLayout.NORTH, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, -6, SpringLayout.WEST, scrollBar);
//		contentPane.add(panel_3);
//		SpringLayout sl_panel_3 = new SpringLayout();
//		panel_3.setLayout(sl_panel_3);
//		
//		ImStuff3 = new JLabel("");
//		sl_panel_3.putConstraint(SpringLayout.NORTH, ImStuff3, 10, SpringLayout.NORTH, panel_3);
//		sl_panel_3.putConstraint(SpringLayout.WEST, ImStuff3, 10, SpringLayout.WEST, panel_3);
//		sl_panel_3.putConstraint(SpringLayout.SOUTH, ImStuff3, 247, SpringLayout.NORTH, panel_3);
//		sl_panel_3.putConstraint(SpringLayout.EAST, ImStuff3, 298, SpringLayout.WEST, panel_3);
//		panel_3.add(ImStuff3);
//		
//		JLabel lblNameOfStuff_3 = new JLabel("Gaming Mouse");
//		lblNameOfStuff_3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNameOfStuff_3, 6, SpringLayout.SOUTH, ImStuff3);
//		sl_panel_3.putConstraint(SpringLayout.WEST, lblNameOfStuff_3, 10, SpringLayout.WEST, panel_3);
//		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_3, -10, SpringLayout.SOUTH, panel_3);
//		sl_panel_3.putConstraint(SpringLayout.EAST, lblNameOfStuff_3, 0, SpringLayout.EAST, ImStuff3);
//		panel_3.add(lblNameOfStuff_3);
//		
//		JPanel panel_4 = new JPanel();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 18, SpringLayout.EAST, panel);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, 306, SpringLayout.SOUTH, panel_1);
//		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_1);
//		SpringLayout sl_panel_1 = new SpringLayout();
//		panel_1.setLayout(sl_panel_1);
//		
//		ImStuff1 = new JLabel();
//		sl_panel_1.putConstraint(SpringLayout.NORTH, ImStuff1, 10, SpringLayout.NORTH, panel_1);
//		sl_panel_1.putConstraint(SpringLayout.WEST, ImStuff1, 10, SpringLayout.WEST, panel_1);
//		panel_1.add(ImStuff1);
//	
//		
//		JLabel lblNameOfStuff_1 = new JLabel("Fashionable shoes Nike SB 2018");
//		lblNameOfStuff_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//		sl_panel_1.putConstraint(SpringLayout.WEST, lblNameOfStuff_1, 10, SpringLayout.WEST, panel_1);
//		sl_panel_1.putConstraint(SpringLayout.EAST, lblNameOfStuff_1, -10, SpringLayout.EAST, panel_1);
//		sl_panel_1.putConstraint(SpringLayout.SOUTH, ImStuff1, -18, SpringLayout.NORTH, lblNameOfStuff_1);
//		sl_panel_1.putConstraint(SpringLayout.EAST, ImStuff1, 0, SpringLayout.EAST, lblNameOfStuff_1);
//		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNameOfStuff_1, 258, SpringLayout.NORTH, panel_1);
//		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_1, -10, SpringLayout.SOUTH, panel_1);
//		panel_1.add(lblNameOfStuff_1);
//		contentPane.add(panel_4);
//		
//		JPanel panel_5 = new JPanel();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, panel_2);
//		sl_contentPane.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_2);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_5, 306, SpringLayout.SOUTH, panel_2);
//		
//		sl_contentPane.putConstraint(SpringLayout.EAST, panel_5, 306, SpringLayout.EAST, panel_4);
//		SpringLayout sl_panel_2 = new SpringLayout();
//		panel_2.setLayout(sl_panel_2);
//		
//		ImStuff2 = new JLabel("");
//		sl_panel_2.putConstraint(SpringLayout.NORTH, ImStuff2, 10, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.WEST, ImStuff2, 10, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.SOUTH, ImStuff2, 244, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, ImStuff2, 290, SpringLayout.WEST, panel_2);
//		panel_2.add(ImStuff2);
//		
//		JLabel lblNameOfStuff_2 = new JLabel("Java T-Shirt");
//		lblNameOfStuff_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNameOfStuff_2, 10, SpringLayout.SOUTH, ImStuff2);
//		sl_panel_2.putConstraint(SpringLayout.WEST, lblNameOfStuff_2, 10, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNameOfStuff_2, -10, SpringLayout.SOUTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, lblNameOfStuff_2, 0, SpringLayout.EAST, ImStuff2);
//		panel_2.add(lblNameOfStuff_2);
//		panel_4.setLayout(new SpringLayout());
//		contentPane.add(panel_5);
//		panel_5.setLayout(new SpringLayout());

	}
}
