import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static MainWindow frame = new MainWindow();
	private SpringLayout sl_contentPane;
	private JPanel contentPane;
	String username;
	// private JLabel lblHello;
	static final int PRICE_MIN = 0;
	static final int PRICE_MAX = 3000;
	static final int QUATNITY_MIN = 0;
	static final int QUANTITY_MAX = 3000;
	static final int FPS_INIT = 15;
	private JTextField tfSearch;
	private JLabel lblPrice;

	private static JPanel panel;
	private static JLabel lblFind;
	private static JSlider slider;
	private static JLabel lblSerachIcon;
	private static JComboBox<String> cbCategory;
	private static JComboBox<String> cbMaker;
	private static JButton btnAddStuff;
	private static JScrollBar scrollBar;
	private static JPanel mainPanel;
	JLabel lbQuantity ;
	// private JPanel panel_2;
	// private JPanel defaultPane;

	Storage storage = new Storage();
	  private String currentCategory = Goods.all;
	  private int currentPrice = 999999;
	  private String currentName = null;
	  private String currentMaker = Goods.defaultMaker;
	  private int currentQuantity = 999999;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame.setVisible(true);
				//	frame.setResizable(false);
					frame.requestFocus();
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
		// setUI();
		setMainContantPain();
		addFindPanel();
		addScrollBar();

	}

	private void addScrollBar() {

		mainPanel = new JPanel();

		 mainPanel.setLayout(null);

	//	mainPanel.setLayout(new BoxLayout(mainPanel, 1));

		mainPanel.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, mainPanel, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, mainPanel, 5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mainPanel, 0, SpringLayout.WEST, scrollBar);
		// contentPane.add(mainPanel);

		JScrollPane scrollBar = new JScrollPane(mainPanel);

		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scrollBar.setPreferredSize(new Dimension(500, 500));
		// scrollPane.setBounds(100, 130, 400, 250);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollBar, 278, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollBar, 5, SpringLayout.EAST, contentPane);
		// scrollBar.setForeground(Color.WHITE);
		// scrollBar.setBackground(Color.WHITE);
		// scrollBar.setBounds(100, 130, 400, 250);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollBar, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollBar, 5, SpringLayout.SOUTH, contentPane);
		contentPane.add(scrollBar);
		 lblFind.addMouseListener(new MouseAdapter() {
		 public void mousePressed(MouseEvent e) {
		 repaint();
		// mainPanel.setLayout(new BoxLayout(mainPanel, 1));
		 JPanel defaultPane = new JPanel();
		 defaultPane.setBounds(10, 10, 300, 300);
		 for (int i = 0; i < 100; i++) {
			 System.out.println("lrl");
			 	
	           mainPanel.add(new JButton("kjdh"));
	        }

		 }
		});
	}

	private void addFindPanel() {
		panel = new JPanel();
		JLabel panel = new JLabel(new ImageIcon("Image\\nice2.jpg")); // THIS IS BACKGROUND
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
		lblFind.setForeground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, lblFind, 52, SpringLayout.NORTH, panel);
		lblFind.setFont(new Font("Century Gothic", Font.PLAIN, 56));
		panel.add(lblFind);
		

		slider = new JSlider();
		sl_panel.putConstraint(SpringLayout.WEST, slider, 27, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, slider, -457, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, slider, 260, SpringLayout.WEST, panel);
		slider.setForeground(new Color(255, 255, 255));
		slider.setBackground(new Color(77, 191, 199));
		slider.setMaximum(PRICE_MAX);
		slider.setMinimum(PRICE_MIN);
		// slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(PRICE_MAX / 3);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				lblPrice.setText("Price(USD): " + value);
				currentPrice = value;

			}
		});

		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sl_panel.putConstraint(SpringLayout.NORTH, tfSearch, 56, SpringLayout.SOUTH, lblFind);
		sl_panel.putConstraint(SpringLayout.EAST, tfSearch, -46, SpringLayout.EAST, panel);
		tfSearch.setText("Search...");
		panel.add(tfSearch);
		tfSearch.setColumns(10);
		tfSearch.setForeground(new Color(221, 221, 187));
		tfSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				tfSearch.setText("Search...");

			}

			@Override
			public void focusGained(FocusEvent e) {
				tfSearch.setText("");
				tfSearch.setForeground(Color.BLACK);

			}
		});
		tfSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					currentName = tfSearch.getText();
					if (!Storage.stuff.isEmpty())
						paintGoodsPane(
								storage.searchByQuantity(storage.searchByPrice(
										storage.searchByMaker(storage.searchByCategory(
												storage.searchByName(currentName), currentCategory), currentMaker),
										currentPrice), currentQuantity));
				}
			}
		});

		lblSerachIcon = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSerachIcon, 0, SpringLayout.NORTH, tfSearch);
		sl_panel.putConstraint(SpringLayout.WEST, lblSerachIcon, 6, SpringLayout.EAST, tfSearch);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSerachIcon, 0, SpringLayout.SOUTH, tfSearch);
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\loop.png"));
		icon.setImage(icon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		lblSerachIcon.setIcon(icon);
		panel.add(lblSerachIcon);

		cbCategory = new JComboBox<String>();
		sl_panel.putConstraint(SpringLayout.NORTH, cbCategory, 66, SpringLayout.SOUTH, slider);
		sl_panel.putConstraint(SpringLayout.SOUTH, cbCategory, -355, SpringLayout.SOUTH, panel);
		cbCategory.setForeground(Color.WHITE);
		cbCategory.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.WEST, tfSearch, 0, SpringLayout.WEST, cbCategory);
		sl_panel.putConstraint(SpringLayout.WEST, cbCategory, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cbCategory, -47, SpringLayout.EAST, panel);
		cbCategory.setBackground(new Color(81, 194, 200));
		for (int i = 0; i < Storage.categories.size(); i++) {
			if (Storage.categories.get(i) != null) {
				// System.out.println("cg++");
				cbCategory.addItem(Storage.categories.get(i));
			}
		}
		cbCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					currentCategory = (String) cbCategory.getSelectedItem();
				} catch (NullPointerException e) {
					currentCategory = null;
				}

			}
		});
		panel.add(cbCategory);

		cbMaker = new JComboBox<String>();
		sl_panel.putConstraint(SpringLayout.NORTH, cbMaker, 52, SpringLayout.SOUTH, cbCategory);
		sl_panel.putConstraint(SpringLayout.WEST, cbMaker, 58, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cbMaker, 0, SpringLayout.EAST, tfSearch);
		cbMaker.setForeground(Color.WHITE);
		cbMaker.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbMaker.setBackground(new Color(166, 232, 228));
		for (int i = 0; i < Storage.makers.size(); i++) {
			if (Storage.makers.get(i) != null) {
				// System.out.println("mk++");
				if (Storage.makers.get(i).equals(Goods.defaultMaker)) {
					cbMaker.addItem("All");
				} else {
					cbMaker.addItem(Storage.makers.get(i));
				}
			}
		}
		cbCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					currentCategory = (String) cbCategory.getSelectedItem();
				} catch (NullPointerException e) {
					currentCategory = null;
				}

			}
		});
		cbMaker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					currentMaker = (String) cbMaker.getSelectedItem();
				} catch (NullPointerException n) {
					currentMaker = null;
				}
			};
		});
		panel.add(cbMaker);

		btnAddStuff = new JButton("+ Stuff");
		sl_panel.putConstraint(SpringLayout.SOUTH, cbMaker, -163, SpringLayout.NORTH, btnAddStuff);
		btnAddStuff.setForeground(new Color(0, 0, 0));
		sl_panel.putConstraint(SpringLayout.EAST, lblSerachIcon, 0, SpringLayout.EAST, btnAddStuff);
		btnAddStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Adding adding = new Adding();
				Adding.main(null);
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnAddStuff, -1, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnAddStuff, -1, SpringLayout.EAST, panel);
		btnAddStuff.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAddStuff, -1, SpringLayout.SOUTH, panel);
		btnAddStuff.setBackground(new Color(206, 245, 242));

		sl_panel.putConstraint(SpringLayout.NORTH, btnAddStuff, -103, SpringLayout.SOUTH, panel);
		panel.add(btnAddStuff);

		lblPrice = new JLabel("Price(USD): 0");
		lblPrice.setForeground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.SOUTH, tfSearch, -48, SpringLayout.NORTH, lblPrice);
		sl_panel.putConstraint(SpringLayout.WEST, lblPrice, 66, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPrice, -9, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFind, 0, SpringLayout.WEST, lblPrice);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPrice, -6, SpringLayout.NORTH, slider);
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		panel.add(lblPrice);

		setUI();

		panel.add(slider);
		
		JSlider slider_1 = new JSlider();
		
		slider_1.setForeground(Color.DARK_GRAY);
		sl_panel.putConstraint(SpringLayout.NORTH, slider_1, -76, SpringLayout.NORTH, btnAddStuff);
		sl_panel.putConstraint(SpringLayout.WEST, slider_1, 28, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, slider_1, -24, SpringLayout.NORTH, btnAddStuff);
		sl_panel.putConstraint(SpringLayout.EAST, slider_1, 1, SpringLayout.EAST, slider);
		panel.add(slider_1);
		slider_1.setMaximum(QUANTITY_MAX);
		slider_1.setMinimum(QUATNITY_MIN);
		// slider.setMinorTickSpacing(2);
		slider_1.setMajorTickSpacing(QUANTITY_MAX / 3);
		slider_1.setBackground(new Color(198, 244, 241));
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		
		lbQuantity = new JLabel("Quantity:");
		lbQuantity.setForeground(new Color(0,0,0));
		lbQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		sl_panel.putConstraint(SpringLayout.WEST, lbQuantity, 0, SpringLayout.WEST, lblFind);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbQuantity, -20, SpringLayout.NORTH, slider_1);
		panel.add(lbQuantity);
		slider_1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider_1.getValue();
				lbQuantity.setText("Quantity: " + value);
				currentQuantity = value;

			}
		});

	}
	public static void repaintAdd(String category, String maker) {
	    if(category!=null) {
	      cbCategory.addItem(category);
	    }
	    if(maker!=null)
	      cbMaker.addItem(maker);  
	  }
	  
	  public static void repaintDelCat(String category) {
	    if(category!=null) 
	      cbCategory.removeItem(category);
	  }
	  
	  public static void repaintDelMaker(String maker) {
	    if(maker!=null)
	      cbMaker.removeItem(maker);
	  }

	private void setMainContantPain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 841);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		// PanelWithStuff pn1 = new PanelWithStuff("Kek", "stiff1", 100, 1000);
		// panel.add(pn1,contentPane.getX()+310,contentPane.getY());
		//
	}

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

	public static void paintGoodsPane(HashMap<String, Goods> stuff) {
//		mainPanel.revalidate();
//		mainPanel.validate();
		mainPanel.repaint();
		//frame.remove(mainPanel);
		
		int x = 0;
		int y = 0;
		for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
			
			PanelWithStuff pf = new PanelWithStuff(entry.getValue().getName(), entry.getValue().getImage());
			
			pf.setBounds(10 + (310) * x, 10 + (310) * y, 300, 300);
			mainPanel.add(pf);
			
			x++;
			if (x == 3) {
				x = 0;
				y++;
			}
		}
	}
}
