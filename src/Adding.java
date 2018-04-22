import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.imageio.ImageIO;
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
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	ImageIcon image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Adding();
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
		setUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 685);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Add Something");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 234, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 52));
		contentPane.add(lblNewLabel);

		JLabel Name = new JLabel("Name: ");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -19, SpringLayout.NORTH, Name);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Name, 109, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Name, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Name, 147, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Name, 125, SpringLayout.WEST, contentPane);
		Name.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Name);

		JLabel Maker = new JLabel("Maker: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Maker, 19, SpringLayout.SOUTH, Name);
		sl_contentPane.putConstraint(SpringLayout.WEST, Maker, 0, SpringLayout.WEST, Name);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Maker, 57, SpringLayout.SOUTH, Name);
		sl_contentPane.putConstraint(SpringLayout.EAST, Maker, 125, SpringLayout.WEST, contentPane);
		Maker.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(Maker);

		JLabel Catrgory = new JLabel("Category:");
		Catrgory.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		sl_contentPane.putConstraint(SpringLayout.NORTH, Catrgory, 19, SpringLayout.SOUTH, Maker);
		sl_contentPane.putConstraint(SpringLayout.WEST, Catrgory, 0, SpringLayout.WEST, Name);
		contentPane.add(Catrgory);

		JLabel Quontity = new JLabel("Quontity:");
		Quontity.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		sl_contentPane.putConstraint(SpringLayout.NORTH, Quontity, 24, SpringLayout.SOUTH, Catrgory);
		sl_contentPane.putConstraint(SpringLayout.WEST, Quontity, 0, SpringLayout.WEST, Name);
		contentPane.add(Quontity);

		JLabel Price = new JLabel("Price:");
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		sl_contentPane.putConstraint(SpringLayout.NORTH, Price, 23, SpringLayout.SOUTH, Quontity);
		sl_contentPane.putConstraint(SpringLayout.WEST, Price, 0, SpringLayout.WEST, Name);
		contentPane.add(Price);

		JLabel lblNewLabel_1 = new JLabel("Descriptions:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 435, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, Name);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(lblNewLabel_1);

		JButton btnChooseImage = new JButton("Choose Image");

		sl_contentPane.putConstraint(SpringLayout.WEST, btnChooseImage, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnChooseImage, -19, SpringLayout.NORTH, lblNewLabel_1);
		btnChooseImage.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.add(btnChooseImage);

		NameTF = new JTextField();
		NameTF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, NameTF, 9, SpringLayout.NORTH, Name);
		sl_contentPane.putConstraint(SpringLayout.WEST, NameTF, 60, SpringLayout.EAST, Name);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, NameTF, 56, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, NameTF, 451, SpringLayout.EAST, Name);
		contentPane.add(NameTF);
		NameTF.setColumns(10);

		MakerTF = new JTextField();
		MakerTF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, MakerTF, 9, SpringLayout.NORTH, Maker);
		sl_contentPane.putConstraint(SpringLayout.WEST, MakerTF, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, MakerTF, 37, SpringLayout.NORTH, Maker);
		sl_contentPane.putConstraint(SpringLayout.EAST, MakerTF, 391, SpringLayout.WEST, lblNewLabel);
		contentPane.add(MakerTF);
		MakerTF.setColumns(10);

		CategoryTF = new JTextField();
		CategoryTF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, CategoryTF, 24, SpringLayout.SOUTH, MakerTF);
		sl_contentPane.putConstraint(SpringLayout.WEST, CategoryTF, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, CategoryTF, 444, SpringLayout.EAST, Catrgory);
		contentPane.add(CategoryTF);
		CategoryTF.setColumns(10);

		JSpinner quontityTF = new JSpinner();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, quontityTF, -321, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, CategoryTF, -24, SpringLayout.NORTH, quontityTF);
		sl_contentPane.putConstraint(SpringLayout.NORTH, quontityTF, 4, SpringLayout.NORTH, Quontity);
		sl_contentPane.putConstraint(SpringLayout.WEST, quontityTF, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, quontityTF, 208, SpringLayout.EAST, Quontity);
		contentPane.add(quontityTF);

		JSpinner priceTF = new JSpinner();
		sl_contentPane.putConstraint(SpringLayout.NORTH, priceTF, 7, SpringLayout.NORTH, Price);
		sl_contentPane.putConstraint(SpringLayout.WEST, priceTF, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, priceTF, 2, SpringLayout.SOUTH, Price);
		sl_contentPane.putConstraint(SpringLayout.EAST, priceTF, 0, SpringLayout.EAST, quontityTF);
		contentPane.add(priceTF);

		JLabel ImageLb = new JLabel("");
		ImageLb.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		sl_contentPane.putConstraint(SpringLayout.NORTH, ImageLb, 0, SpringLayout.NORTH, btnChooseImage);
		sl_contentPane.putConstraint(SpringLayout.WEST, ImageLb, 6, SpringLayout.EAST, btnChooseImage);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ImageLb, 0, SpringLayout.SOUTH, btnChooseImage);
		sl_contentPane.putConstraint(SpringLayout.EAST, ImageLb, 309, SpringLayout.EAST, btnChooseImage);
		contentPane.add(ImageLb);

		Description = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(Description);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, -1, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 158, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, NameTF);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = NameTF.getText();
				maker = MakerTF.getText();
				category = CategoryTF.getText();
				quontity = (int) quontityTF.getValue();
				price = (int) priceTF.getValue();
				description = Description.getText();

				Goods newGoods = new Goods(name, category, description, price, quontity, image);
				Storage.stuff.put(name, newGoods);
				frame.dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, Description);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -21, SpringLayout.EAST, contentPane);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		contentPane.add(btnNewButton);

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
