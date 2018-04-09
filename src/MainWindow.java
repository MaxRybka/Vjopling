import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainWindow extends JFrame {
	private SpringLayout sl_contentPane;
	private JPanel contentPane;
	String username;
	private JLabel lblHello;
	static final int FPS_MIN = 0;
	static final int FPS_MAX = 30;
	static final int FPS_INIT = 15;
	private JTextField tfSerach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 847);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 800, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 287, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblFind = new JLabel("Finder");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFind, 91, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblFind, -61, SpringLayout.EAST, panel);
		lblFind.setFont(new Font("Century Gothic", Font.PLAIN, 56));
		panel.add(lblFind);
		
		JSlider slider = new JSlider();
		sl_panel.putConstraint(SpringLayout.WEST, slider, 27, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, slider, 260, SpringLayout.WEST, panel);
		panel.add(slider);
		
		tfSerach = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, slider, 50, SpringLayout.SOUTH, tfSerach);
		sl_panel.putConstraint(SpringLayout.WEST, tfSerach, 56, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, tfSerach, -47, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, tfSerach, 35, SpringLayout.SOUTH, lblFind);
		sl_panel.putConstraint(SpringLayout.SOUTH, tfSerach, 72, SpringLayout.SOUTH, lblFind);
		tfSerach.setText("Search...");
		panel.add(tfSerach);
		tfSerach.setColumns(10);
		
		JLabel lblSerachIcon = new JLabel("-O");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSerachIcon, 1, SpringLayout.NORTH, tfSerach);
		sl_panel.putConstraint(SpringLayout.WEST, lblSerachIcon, 9, SpringLayout.EAST, tfSerach);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSerachIcon, 0, SpringLayout.SOUTH, tfSerach);
		sl_panel.putConstraint(SpringLayout.EAST, lblSerachIcon, -9, SpringLayout.EAST, panel);
		panel.add(lblSerachIcon);
		
		JComboBox cbCategory = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, cbCategory, 53, SpringLayout.SOUTH, slider);
		sl_panel.putConstraint(SpringLayout.WEST, cbCategory, 2, SpringLayout.WEST, tfSerach);
		sl_panel.putConstraint(SpringLayout.SOUTH, cbCategory, 90, SpringLayout.SOUTH, slider);
		sl_panel.putConstraint(SpringLayout.EAST, cbCategory, -46, SpringLayout.EAST, panel);
		panel.add(cbCategory);
		
		JComboBox cbMader = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, cbMader, 87, SpringLayout.SOUTH, cbCategory);
		sl_panel.putConstraint(SpringLayout.WEST, cbMader, 2, SpringLayout.WEST, tfSerach);
		sl_panel.putConstraint(SpringLayout.SOUTH, cbMader, 124, SpringLayout.SOUTH, cbCategory);
		sl_panel.putConstraint(SpringLayout.EAST, cbMader, -46, SpringLayout.EAST, panel);
		panel.add(cbMader);
		
		JButton btnNewButton = new JButton("addStuff");
		btnNewButton.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -103, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblFind);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -42, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, tfSerach);
		panel.add(btnNewButton);
		
		
		addComponents();
		
		
	}

	private void addComponents() {
//		lblHello = new JLabel("Hi,"+LogIn.username+" nice to see you.");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHello, 345, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblHello, -1009, SpringLayout.EAST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHello, -358, SpringLayout.SOUTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblHello, -251, SpringLayout.EAST, contentPane);
//		lblHello.setFont(new Font("Century Gothic", Font.PLAIN, 70));
//		contentPane.add(lblHello);
		//TODO animation for text
		
	}
}
