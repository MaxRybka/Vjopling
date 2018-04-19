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

	private JPanel background;
	private JLabel Image;
	private JLabel lblKolichestvo;
	private JButton btnEditDescrition;
	private SpinnerNumberModel modelForSpinner;
	private JSpinner spinner;
	private JLabel Category;
	private JButton btnNewButton;
	private JTextArea Description;
	
	static DecriptionStuff frame = new DecriptionStuff("name", "description", "some shit", 14, "stuff1.jpg");
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
		JLabel background = new JLabel(new ImageIcon("Image\\background2.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 537);
		//background = new JPanel();
		background.setBackground(Color.WHITE);
		background.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(background);
		SpringLayout sl_background = new SpringLayout();
		background.setLayout(sl_background);
		background.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNewButton.doClick();
				}
			}
		});
		
		Image = new JLabel("");
		Image.setFont(new Font("Tahoma", Font.PLAIN, 99));
		background.add(Image);
		ImageIcon imgOfStuff = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\"+nameOfImage));
		imgOfStuff.setImage(imgOfStuff.getImage().getScaledInstance(362, 278, Image.SOUTH_WEST));
		Image.setIcon(imgOfStuff);
		lblKolichestvo = new JLabel("Quantity");
		sl_background.putConstraint(SpringLayout.NORTH, lblKolichestvo, 24, SpringLayout.SOUTH, Image);
		sl_background.putConstraint(SpringLayout.WEST, lblKolichestvo, 15, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, lblKolichestvo, -34, SpringLayout.SOUTH, background);
		sl_background.putConstraint(SpringLayout.EAST, lblKolichestvo, -654, SpringLayout.EAST, background);
		lblKolichestvo.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		background.add(lblKolichestvo);

		
		
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
		background.add(btnEditDescrition);
		
		modelForSpinner = new SpinnerNumberModel(quantiti, 0, 10000, 50);
		spinner = new JSpinner(modelForSpinner);
		sl_background.putConstraint(SpringLayout.NORTH, spinner, 12, SpringLayout.NORTH, lblKolichestvo);
		sl_background.putConstraint(SpringLayout.WEST, spinner, 21, SpringLayout.EAST, lblKolichestvo);
		sl_background.putConstraint(SpringLayout.SOUTH, spinner, -4, SpringLayout.SOUTH, lblKolichestvo);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		background.add(spinner);
		
		Category = new JLabel("Category: "+category);
		sl_background.putConstraint(SpringLayout.EAST, spinner, -175, SpringLayout.WEST, Category);
		sl_background.putConstraint(SpringLayout.NORTH, Category, 6, SpringLayout.SOUTH, btnEditDescrition);
		sl_background.putConstraint(SpringLayout.EAST, Category, 0, SpringLayout.EAST, btnEditDescrition);
		sl_background.putConstraint(SpringLayout.WEST, Category, 394, SpringLayout.WEST, background);
		Category.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		background.add(Category);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sl_background.putConstraint(SpringLayout.SOUTH, Category, -5, SpringLayout.NORTH, btnNewButton);
		sl_background.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, background);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		sl_background.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, background);
		background.add(btnNewButton);
		
//		Description = new JTextPane();
//		sl_background.putConstraint(SpringLayout.WEST, Description, 407, SpringLayout.WEST, background);
//		sl_background.putConstraint(SpringLayout.EAST, Image, -39, SpringLayout.WEST, Description);
//		sl_background.putConstraint(SpringLayout.NORTH, Description, 53, SpringLayout.NORTH, background);
//		sl_background.putConstraint(SpringLayout.SOUTH, Description, -119, SpringLayout.SOUTH, background);
//		sl_background.putConstraint(SpringLayout.EAST, Description, -10, SpringLayout.EAST, background);
//		sl_background.putConstraint(SpringLayout.NORTH, Image, 0, SpringLayout.NORTH, Description);
//		 JScrollPane jScrollPane1 = new JScrollPane();
//		 jScrollPane1.setVerticalScrollBarPolicy(
//	      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		 jScrollPane1.setViewportView(Description);
//		 background.add(jScrollPane1);
		
		//background.add(Description);
		Description = new JTextArea();
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		sl_background.putConstraint(SpringLayout.NORTH, Description, 60, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.SOUTH, Description, -6, SpringLayout.NORTH, btnEditDescrition);
		sl_background.putConstraint(SpringLayout.WEST, Description, 0, SpringLayout.WEST, Category);
		sl_background.putConstraint(SpringLayout.EAST, Description, 0, SpringLayout.EAST, btnEditDescrition);
		JScrollPane scrollPane = new JScrollPane(Description);
		sl_background.putConstraint(SpringLayout.NORTH, Image, -278, SpringLayout.SOUTH, scrollPane);
		sl_background.putConstraint(SpringLayout.SOUTH, Image, 0, SpringLayout.SOUTH, scrollPane);
		sl_background.putConstraint(SpringLayout.EAST, Image, -7, SpringLayout.WEST, scrollPane);
		sl_background.putConstraint(SpringLayout.WEST, scrollPane, 379, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, background);
		sl_background.putConstraint(SpringLayout.WEST, Image, -369, SpringLayout.WEST, scrollPane);
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		scrollPane.setBorder(null);
		sl_background.putConstraint(SpringLayout.NORTH, btnEditDescrition, 6, SpringLayout.SOUTH, scrollPane);
		sl_background.putConstraint(SpringLayout.EAST, btnEditDescrition, 0, SpringLayout.EAST, scrollPane);
		sl_background.putConstraint(SpringLayout.NORTH, scrollPane, 78, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.SOUTH, scrollPane, -124, SpringLayout.SOUTH, background);
		
		background.add(scrollPane);
		
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
		sl_background.putConstraint(SpringLayout.NORTH, edit, 0, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.WEST, edit, 28, SpringLayout.WEST, btnNewButton);
		sl_background.putConstraint(SpringLayout.SOUTH, edit, -11, SpringLayout.NORTH, scrollPane);
		sl_background.putConstraint(SpringLayout.EAST, edit, 0, SpringLayout.EAST, btnEditDescrition);
		ImageIcon imgEdit = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\remove.png"));
		imgEdit.setImage(imgEdit.getImage().getScaledInstance(70, 70, Image.SOUTH_WEST));
		edit.setIcon(imgEdit);
		background.add(edit);
		
		JLabel nameOfStuff = new JLabel(name);
		sl_background.putConstraint(SpringLayout.NORTH, nameOfStuff, 0, SpringLayout.NORTH, background);
		sl_background.putConstraint(SpringLayout.WEST, nameOfStuff, 10, SpringLayout.WEST, background);
		sl_background.putConstraint(SpringLayout.SOUTH, nameOfStuff, -6, SpringLayout.NORTH, scrollPane);
		sl_background.putConstraint(SpringLayout.EAST, nameOfStuff, -70, SpringLayout.WEST, edit);
		nameOfStuff.setFont(new Font("Century Gothic", Font.PLAIN, 49));
		background.add(nameOfStuff);
		
	}
}
