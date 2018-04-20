import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.border.EmptyBorder;

public class DecriptionStuff extends JFrame {

	private JPanel contentPane;
	private JLabel Image;
	private JLabel lblKolichestvo;
	private JButton btnEditDescrition;
	private SpinnerNumberModel modelForSpinner;
	private JSpinner spinner;
	private JLabel Category;
	private JButton btnNewButton;
	private JTextArea Description;
	
	static DecriptionStuff frame = new DecriptionStuff("name", "description", "some shit", 14, "stuff1.png");
	private JLabel Price;
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
	public DecriptionStuff(String name, String description,String category,int quantiti,String nameOfImage) {
		//JLabel contentPane = new JLabel(new ImageIcon("Image\\wallper.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ImageIcon imgOfStuff = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\"+nameOfImage));
		imgOfStuff.setImage(imgOfStuff.getImage().getScaledInstance(362, 278, Image.SOUTH_WEST));
		Image.setIcon(imgOfStuff);
		lblKolichestvo = new JLabel("Quantity:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKolichestvo, 0, SpringLayout.WEST, Image);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblKolichestvo, 0, SpringLayout.SOUTH, contentPane);
		lblKolichestvo.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		contentPane.add(lblKolichestvo);

		
		
		btnEditDescrition = new JButton("Edit description");
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
		
		modelForSpinner = new SpinnerNumberModel(quantiti, 0, 10000, 50);
		spinner = new JSpinner(modelForSpinner);
		sl_contentPane.putConstraint(SpringLayout.WEST, spinner, 169, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblKolichestvo, -6, SpringLayout.WEST, spinner);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(spinner);
		
		Category = new JLabel("Category: "+category);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinner, -22, SpringLayout.WEST, Category);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Category, 9, SpringLayout.NORTH, lblKolichestvo);
		sl_contentPane.putConstraint(SpringLayout.WEST, Category, 260, SpringLayout.WEST, contentPane);
		Category.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		contentPane.add(Category);
		
		btnNewButton = new JButton("Enter");
		sl_contentPane.putConstraint(SpringLayout.EAST, Category, -11, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 42, SpringLayout.SOUTH, btnEditDescrition);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -5, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEditDescrition, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
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
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, contentPane);
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		scrollPane.setBorder(null);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 78, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -124, SpringLayout.SOUTH, contentPane);
		
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEditDescrition, 303, SpringLayout.SOUTH, edit);
		sl_contentPane.putConstraint(SpringLayout.EAST, edit, -5, SpringLayout.EAST, contentPane);
		ImageIcon imgEdit = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\remove.png"));
		imgEdit.setImage(imgEdit.getImage().getScaledInstance(70, 70, Image.SOUTH_WEST));
		edit.setIcon(imgEdit);
		contentPane.add(edit);
		
		JLabel nameOfStuff = new JLabel(name);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameOfStuff, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nameOfStuff, -408, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Image, 6, SpringLayout.SOUTH, nameOfStuff);
		sl_contentPane.putConstraint(SpringLayout.EAST, nameOfStuff, -139, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, edit, 70, SpringLayout.EAST, nameOfStuff);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameOfStuff, 10, SpringLayout.WEST, contentPane);
		nameOfStuff.setFont(new Font("Century Gothic", Font.PLAIN, 49));
		contentPane.add(nameOfStuff);
		
		Price = new JLabel("Price(USD):");
		sl_contentPane.putConstraint(SpringLayout.NORTH, Price, 375, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Image, -19, SpringLayout.NORTH, Price);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Price, -60, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKolichestvo, 6, SpringLayout.SOUTH, Price);
		Price.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		sl_contentPane.putConstraint(SpringLayout.WEST, Price, 0, SpringLayout.WEST, Image);
		sl_contentPane.putConstraint(SpringLayout.EAST, Price, 150, SpringLayout.WEST, Image);
		contentPane.add(Price);
		
		JSpinner spinner_1 = new JSpinner();
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinner, 32, SpringLayout.SOUTH, spinner_1);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinner_1, 8, SpringLayout.NORTH, Price);
		sl_contentPane.putConstraint(SpringLayout.WEST, spinner_1, 0, SpringLayout.WEST, spinner);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinner_1, -9, SpringLayout.SOUTH, Price);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinner_1, 0, SpringLayout.EAST, spinner);
		contentPane.add(spinner_1);
		
	}
}
