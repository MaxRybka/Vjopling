import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.SystemColor;

public class Adding extends JFrame {

	private static Adding frame;

	private JPanel contentPane;
	private JTextField NameTF;
	private JTextField MakerTF;
	private JTextField CategoryTF;
	private JTextArea Description;
	public String name;
	public String maker;
	public String category;
	public String description;
	public int quontity;
	public int price;
	private int xx;
	private int xy;
	ImageIcon image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Adding();
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
	public Adding() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		contentPane.addMouseMotionListener(new MouseMotionListener() {
			
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

		JLabel lblNewLabel = new JLabel("Add Something");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -121, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 52));
		contentPane.add(lblNewLabel);

		JLabel Name = new JLabel("Name: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Name, 109, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Name, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Name, 147, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Name, 125, SpringLayout.WEST, contentPane);
		Name.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Name);

		JLabel Maker = new JLabel("Maker: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Maker, 19, SpringLayout.SOUTH, Name);
		sl_contentPane.putConstraint(SpringLayout.WEST, Maker, 22, SpringLayout.WEST, contentPane);
		Maker.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Maker);

		JLabel Catrgory = new JLabel("Category:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Catrgory, 223, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Catrgory, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Maker, -19, SpringLayout.NORTH, Catrgory);
		Catrgory.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Catrgory);

		JLabel Quontity = new JLabel("Quontity:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Quontity, 275, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Quontity, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Catrgory, -24, SpringLayout.NORTH, Quontity);
		Quontity.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Quontity);

		JLabel Price = new JLabel("Price:");
		sl_contentPane.putConstraint(SpringLayout.WEST, Price, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Quontity, -23, SpringLayout.NORTH, Price);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Price, 326, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Price, 354, SpringLayout.NORTH, contentPane);
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Price);

		JLabel lblNewLabel_1 = new JLabel("Descriptions:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 435, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -165, SpringLayout.SOUTH, contentPane);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(lblNewLabel_1);

		JButton btnChooseImage = new JButton("Choose Image");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnChooseImage, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnChooseImage, -560, SpringLayout.EAST, contentPane);
		btnChooseImage.setForeground(SystemColor.text);
		btnChooseImage.setBackground(SystemColor.textHighlight);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnChooseImage, -19, SpringLayout.NORTH, lblNewLabel_1);
		btnChooseImage.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.add(btnChooseImage);

		NameTF = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, NameTF, 118, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -28, SpringLayout.NORTH, NameTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, NameTF, 60, SpringLayout.EAST, Name);
		sl_contentPane.putConstraint(SpringLayout.EAST, NameTF, -171, SpringLayout.EAST, contentPane);
		NameTF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		contentPane.add(NameTF);
		NameTF.setColumns(10);

		
		
		MakerTF = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, MakerTF, 175, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, NameTF, -29, SpringLayout.NORTH, MakerTF);
		sl_contentPane.putConstraint(SpringLayout.EAST, Maker, -60, SpringLayout.WEST, MakerTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, MakerTF, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, MakerTF, -171, SpringLayout.EAST, contentPane);
		MakerTF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		contentPane.add(MakerTF);
		MakerTF.setColumns(10);

		CategoryTF = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, CategoryTF, 227, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, MakerTF, -24, SpringLayout.NORTH, CategoryTF);
		sl_contentPane.putConstraint(SpringLayout.EAST, Catrgory, -53, SpringLayout.WEST, CategoryTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, CategoryTF, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, CategoryTF, -171, SpringLayout.EAST, contentPane);
		CategoryTF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		contentPane.add(CategoryTF);
		CategoryTF.setColumns(10);

		SpinnerNumberModel modelForSpinner = new SpinnerNumberModel(0, 0, 99999, 50);
		JSpinner quontityTF = new JSpinner(modelForSpinner);
		quontityTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, CategoryTF, -24, SpringLayout.NORTH, quontityTF);
		sl_contentPane.putConstraint(SpringLayout.EAST, Quontity, -65, SpringLayout.WEST, quontityTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, quontityTF, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, quontityTF, 328, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, quontityTF, 279, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, quontityTF, 307, SpringLayout.NORTH, contentPane);
		contentPane.add(quontityTF);

		SpinnerNumberModel modelForSpinner2 = new SpinnerNumberModel(0, 0, 999999, 50);
		JSpinner priceTF = new JSpinner(modelForSpinner2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnChooseImage, 25, SpringLayout.SOUTH, priceTF);
		priceTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.EAST, Price, -105, SpringLayout.WEST, priceTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, priceTF, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, priceTF, 328, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, priceTF, 333, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, priceTF, 356, SpringLayout.NORTH, contentPane);
		contentPane.add(priceTF);

		JLabel ImageLb = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, ImageLb, 0, SpringLayout.NORTH, btnChooseImage);
		sl_contentPane.putConstraint(SpringLayout.WEST, ImageLb, 21, SpringLayout.EAST, btnChooseImage);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ImageLb, 60, SpringLayout.SOUTH, priceTF);
		sl_contentPane.putConstraint(SpringLayout.EAST, ImageLb, 511, SpringLayout.WEST, contentPane);
		ImageLb.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.add(ImageLb);

		Description = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(Description);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -35, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 587, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 434, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 593, SpringLayout.NORTH, contentPane);
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		// scrollPane.setBorder(null);
		Description.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, Description, 435, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Description, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Description, -15, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Description, 0, SpringLayout.EAST, NameTF);
		contentPane.add(scrollPane);
		Description.setColumns(10);

		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBackground(new Color(0, 192, 0));
		btnNewButton.setForeground(SystemColor.text);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 486, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 19, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 523, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -21, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = NameTF.getText();
				maker = MakerTF.getText();
				category = CategoryTF.getText();
				quontity = (int) quontityTF.getValue();
				price = (int) priceTF.getValue();
				description = Description.getText();

				Storage.createNewGoods(name, category, maker, description, price, quontity, image);
			//	MainWindow pn = new MainWindow();
				MainWindow.paintGoodsPane(Storage.stuff);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New la");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 62, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 93, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\exit.png"));
		icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(icon);
		lblNewLabel_2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				frame.dispose();
				
			}
		});
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file;
				String nameOfImage;
				JButton open = new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
				fc.setDialogTitle("Choose file");
				if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

					if (fc.getSelectedFile() == null) {

					} else {
						file = fc.getSelectedFile();
						image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\" + file.getName()));
						nameOfImage = new String(file.getName());
						ImageLb.setText(nameOfImage);
					}
				}
			};

		});
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
}
