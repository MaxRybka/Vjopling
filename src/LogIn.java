import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JLabel lbLogoVjopling;
	static private JTextField tfEmail;
	private static JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnEnter;
	private static LogIn frame;
	public static String username;
	private char defaultEchoChar;
	private JLabel lbUserIcon;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int xx;
	private int xy;
	private JLabel lblExitIcon;
	private JLabel lblLineICONFIED;
	// private Image backgroundImage;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.requestFocus();
					frame.setResizable(false);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	// Some code to initialize the background image.
	// Here, we use the constructor to load the image. This
	// can vary depending on the use case of the panel.

	public LogIn() {
		addComponents();
		addBtnEnterListeners();
		addFocusListenersOnLabels();
		addImagesOnLabels();
	}

	private void addImagesOnLabels() {
		ImageIcon lock = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\log.png"));
		Image helpImage = lock.getImage();
		Image helpImage2 = helpImage.getScaledInstance(27, 32, Image.SCALE_SMOOTH);
		ImageIcon trueLock = new ImageIcon(helpImage2);
		lblPassword.setIcon(trueLock);
		
		ImageIcon user = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\userIcon.png"));
		Image img11 = user.getImage();
		Image img22 = img11.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon b = new ImageIcon(img22);
		lbUserIcon.setIcon(b);
		
		ImageIcon exit = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\exit.png"));
		Image img111 = exit.getImage();
		Image img222 = img111.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon c = new ImageIcon(img222);
		lblExitIcon.setIcon(c);
		
		
	}

	private void addFocusListenersOnLabels() {
		tfEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (tfEmail.getText().equals("")) {
					tfEmail.setText("Username");
					tfEmail.setForeground(new Color(221, 221, 187));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (tfEmail.getText().equals("Username")) {
					JTextComponent component1 = (JTextComponent) e.getSource();
					tfEmail.setForeground(Color.BLACK);
					component1.setText("");
				}

			}
		});
		tfEmail.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocusInWindow();
				}
			}
		});
		
		
		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (getPassword().equals("")) {
					passwordField.setEchoChar((char) 0);
					passwordField.setText("Password");
					passwordField.setForeground(new Color(221, 221, 187));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (getPassword().equals("Password")) {
					JTextComponent component = (JTextComponent) e.getSource();
					passwordField.setForeground(Color.BLACK);
					component.setText("");
					passwordField.setEchoChar(defaultEchoChar);
				}

			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEnter.doClick();
				}
			}
		});
	}

	private void addComponents() {

		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, screenSize.width-640, screenSize.height-233);
		getContentPane().setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("Image\\background2.jpg"));
		background.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x-xx,y-xy);
			}
		});
		background.addMouseListener(new MouseListener() {
			
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
		
		// add(background);
		 //background = new JPanel();
		//contentPane = new JPanel();
		background.setBackground(new Color(176, 224, 230));
		background.setForeground(Color.WHITE);
		background.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(background);
		SpringLayout sl_background = new SpringLayout();

		background.setLayout(sl_background);

		// try {
		// frame.getbackground().add(new JPanelWithbackground("Image\\background.jpg"));
		// } catch (IOException e1) {
		//
		// e1.printStackTrace();
		// }

		lbLogoVjopling = new JLabel("Vjopling");
		sl_background.putConstraint(SpringLayout.NORTH, lbLogoVjopling, 102, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.WEST, lbLogoVjopling, 418, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, lbLogoVjopling, -559, SpringLayout.SOUTH, background);
		sl_background.putConstraint(SpringLayout.EAST, lbLogoVjopling, 808, SpringLayout.WEST, background);
		// Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		// lbLogoVjopling.setBorder(border);

		lbLogoVjopling.setFont(new Font("Century Gothic", Font.PLAIN, 99));
		background.add(lbLogoVjopling);

		tfEmail = new JTextField();
		tfEmail.setForeground(new Color(221, 221, 187));
		tfEmail.setText("Username");
		sl_background.putConstraint(SpringLayout.NORTH, tfEmail, 87, SpringLayout.SOUTH, lbLogoVjopling);
		sl_background.putConstraint(SpringLayout.WEST, tfEmail, 0, SpringLayout.WEST, lbLogoVjopling);
		sl_background.putConstraint(SpringLayout.SOUTH, tfEmail, -430, SpringLayout.SOUTH, background);
		sl_background.putConstraint(SpringLayout.EAST, tfEmail, -434, SpringLayout.EAST, background);
		tfEmail.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		Font font = new Font("Century Gothic", Font.PLAIN, 26);
		
		background.add(tfEmail);
		tfEmail.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(221, 221, 187));
		defaultEchoChar = passwordField.getEchoChar();
		passwordField.setText("Password");
		passwordField.setEchoChar((char) 0);
		sl_background.putConstraint(SpringLayout.NORTH, passwordField, 79, SpringLayout.SOUTH, tfEmail);
		sl_background.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, lbLogoVjopling);
		sl_background.putConstraint(SpringLayout.SOUTH, passwordField, 121, SpringLayout.SOUTH, tfEmail);
		sl_background.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, tfEmail);
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		background.add(passwordField);

		lblPassword = new JLabel("");
		sl_background.putConstraint(SpringLayout.WEST, lblPassword, 360, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, passwordField);
		sl_background.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, passwordField);
		sl_background.putConstraint(SpringLayout.SOUTH, lblPassword, 1, SpringLayout.SOUTH, passwordField);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		background.add(lblPassword);

		btnEnter = new JButton("LOGIN");
		sl_background.putConstraint(SpringLayout.WEST, btnEnter, 487, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, btnEnter, 117, SpringLayout.SOUTH, passwordField);
		sl_background.putConstraint(SpringLayout.EAST, btnEnter, 742, SpringLayout.WEST, background);
		btnEnter.setForeground(new Color(255, 255, 255));
		sl_background.putConstraint(SpringLayout.NORTH, btnEnter, 70, SpringLayout.SOUTH, passwordField);
		btnEnter.setBackground(new Color(51, 102, 255));
		btnEnter.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		background.add(btnEnter);

		lbUserIcon = new JLabel("");
		sl_background.putConstraint(SpringLayout.NORTH, lbUserIcon, 0, SpringLayout.NORTH, tfEmail);
		sl_background.putConstraint(SpringLayout.WEST, lbUserIcon, -62, SpringLayout.WEST, tfEmail);
		sl_background.putConstraint(SpringLayout.SOUTH, lbUserIcon, 0, SpringLayout.SOUTH, tfEmail);
		sl_background.putConstraint(SpringLayout.EAST, lbUserIcon, -10, SpringLayout.WEST, tfEmail);
		background.add(lbUserIcon);
		
		lblExitIcon = new JLabel("");
		sl_background.putConstraint(SpringLayout.NORTH, lblExitIcon, 10, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.WEST, lblExitIcon, -66, SpringLayout.EAST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, lblExitIcon, 52, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.EAST, lblExitIcon, -10, SpringLayout.EAST, background);
		background.add(lblExitIcon);
		
		lblLineICONFIED = new JLabel("______");
		sl_background.putConstraint(SpringLayout.SOUTH, lblLineICONFIED, 46, SpringLayout.NORTH, background);
		lblLineICONFIED.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sl_background.putConstraint(SpringLayout.NORTH, lblLineICONFIED, 0, SpringLayout.NORTH, lblExitIcon);
		sl_background.putConstraint(SpringLayout.WEST, lblLineICONFIED, -93, SpringLayout.WEST, lblExitIcon);
		sl_background.putConstraint(SpringLayout.EAST, lblLineICONFIED, -37, SpringLayout.WEST, lblExitIcon);
		background.add(lblLineICONFIED);

	}

	private void addBtnEnterListeners() {
		btnEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate(getUsername(), getPassword())) {
				//	MainWindow mainWindow = new MainWindow();
					MainWindow.main(null);
					frame.setVisible(false);
				} else {
					 try {
		                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
		                }
					 UIManager UI=new UIManager();
					 UI.put("OptionPane.background", Color.white);
					 UI.put("Panel.background", Color.white);
					ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\cross.gif"));
					icon.setImage(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
					JLabel label = new JLabel("Your login or password is wong! Try again...");
					label.setFont(new Font("Century Gothic", Font.PLAIN, 24));
					
					JOptionPane.showMessageDialog(frame, label, "WRONG", JOptionPane.INFORMATION_MESSAGE, icon);
					
				}
			}
		});
		lblExitIcon.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
	          System.exit(0);
	         
	        }
		});
		lblLineICONFIED.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
	         
	        }
		});
		

	}

	public static boolean authenticate(String username, String password) {
		if (username.equals("David") && password.equals("admin228")) {
			return true;
		}
		if (username.equals("login") && password.equals("letmein")) {
			return true;
		}if (username.equals("andrey") && password.equals("jopa")) {
			return true;
		}
		
		return false;
	}

	protected static String getUsername() {
		return tfEmail.getText().trim();
	}

	private static String getPassword() {
		return new String(passwordField.getPassword());
	}
//	@SuppressWarnings("unchecked")
//	int xy;
//	int xx;
//	private void sidebarMousePressed(java.awt.event.MouseEvent evt) {
//		setOpacity((float)0.8);
//		xx = evt.getX();
//		xy = evt.getY();
//		
//	}
//	private void sidebarMouseDragged(java.awt.event.MouseEvent evt) {
//		int x =evt.getXOnScreen();
//		int y = evt.getYOnScreen();
//		this.setLocation(x-xx,y-xy);
//	}
//	private void slidebarMouseReleased(java.awt.event.MouseEvent evt) {
//		setOpacity((float)1.0);
//	}
}
