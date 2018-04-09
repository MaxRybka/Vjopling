import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
import javax.swing.JScrollBar;

public class MainWindow extends JFrame {
	private SpringLayout sl_contentPane;
	private JPanel contentPane;
	String username;
	private JLabel lblHello;
	static final int PRICE_MIN = 0;
	static final int PRICE_MAX = 3000;
	static final int FPS_INIT = 15;
	private JTextField tfSerach;
	private JLabel lblPrice;

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
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, -1, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -1, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		sl_panel.putConstraint(SpringLayout.SOUTH, cbMader, -107, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -1, SpringLayout.SOUTH, panel);
		btnNewButton.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -103, SpringLayout.SOUTH, panel);
		panel.add(btnNewButton);

		lblPrice = new JLabel("Price(USD):");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSerachIcon, -49, SpringLayout.NORTH, lblPrice);
		sl_panel.putConstraint(SpringLayout.SOUTH, tfSerach, -48, SpringLayout.NORTH, lblPrice);
		sl_panel.putConstraint(SpringLayout.WEST, lblPrice, 66, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPrice, -9, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFind, 0, SpringLayout.WEST, lblPrice);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPrice, -6, SpringLayout.NORTH, slider);
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		panel.add(lblPrice);
		
		JScrollBar scrollBar = new JScrollBar();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollBar, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollBar, -21, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollBar, 780, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollBar, 0, SpringLayout.EAST, contentPane);
		contentPane.add(scrollBar);

		addComponents();

	}

	private void addComponents() {
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

	}
}
