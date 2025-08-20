package FrameClasses;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Auxilliary.DateData;
import Auxilliary.ModelData;
import CustomComponents.RoundedButtons;
import CustomComponents.RoundedLoginButton;
import CustomComponents.RoundedPanel;
import CustomComponents.RoundedTextField;
import CustomComponents.adminButtons;
import HelperFunctionClasses.OnClickEventHelper;
import HelperFunctionClasses.OnClickEventHelperAdminFunctions;
import HelperFunctionClasses.OnClickEventHelperBankFunctions;
import HelperFunctionClasses.OnClickEventHelperCoreFunctions;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;

public class DashboardFrame {

	private JFrame frame;
	private JTextField withdraw_amount_field;
	private JTable users_table;
	private JPanel profile_panel_shadow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String username, int userIndex, boolean authorizedAdmin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame window = new DashboardFrame(username, userIndex, authorizedAdmin);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashboardFrame(String username, int userIndex, boolean authorizedAdmin) {
		initialize(username, userIndex, authorizedAdmin);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username, int userIndex, boolean authorizedAdmin) {
		frame = new JFrame("Dashboard [" + username + "]");
		frame.setBounds(100, 100, 1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLayeredPane main_layered_pane = new JLayeredPane();
		main_layered_pane.setBounds(0, 0, 1266, 683);
		frame.getContentPane().add(main_layered_pane);
		
		JLayeredPane top_layered_pane = new JLayeredPane();
		main_layered_pane.setLayer(top_layered_pane, 2);
		top_layered_pane.setBackground(new Color(155, 155, 35));
		top_layered_pane.setBounds(0, 0, 1266, 159);
		main_layered_pane.add(top_layered_pane);
		
		JPanel top_background_color = new JPanel();
		top_background_color.setBackground(new Color(35, 35, 35));
		top_background_color.setBounds(0, -13, 1266, 129);
		top_layered_pane.add(top_background_color);
		top_background_color.setLayout(null);
		
		JButton logout_button = new JButton("");
//		logout_button.setIcon(new ImageIcon("C:\\Users\\Khen David Famadico\\Downloads\\logout_button.png"));
		
//		logout_button.setBackground(new Color(240, 240, 240));
		logout_button.setForeground(new Color(255, 255, 255));
		logout_button.setFont(new Font("Segoe UI", Font.BOLD, 15));
		logout_button.setBorderPainted(false);
		logout_button.setContentAreaFilled(false);
		logout_button.setOpaque(false);
		logout_button.setFocusPainted(false);
		OnClickEventHelper.logoutOnClickHandler(frame, logout_button);
		logout_button.setBounds(1216, 44, 40, 40);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/logout_button.png")); // Load your image
		Image image = icon.getImage();

		// Resize the image to fit the JLabel
		Image scaledImage = image.getScaledInstance(logout_button.getWidth(), logout_button.getHeight(), Image.SCALE_SMOOTH);

		// Set the scaled image as an icon
		logout_button.setIcon(new ImageIcon(scaledImage));
		top_background_color.add(logout_button);
		
		// BUTTONS
		JButton admin_button = new RoundedButtons("Admin", 12);
		admin_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		admin_button.setBounds(1003, 98, 143, 31);
		// If logged in as admin, the admin panel button will show
		admin_button.setVisible(authorizedAdmin);
		top_background_color.add(admin_button);

		
		JButton withdraw_button = new RoundedButtons("Withdraw", 5);
		withdraw_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		withdraw_button.setBounds(167, 98, 143, 31);

		top_background_color.add(withdraw_button);
		
		JButton transfer_button = new RoundedButtons("Transfer", 12);
		transfer_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		transfer_button.setBounds(335, 98, 143, 31);
		top_background_color.add(transfer_button);
		
		JButton deposit_button = new RoundedButtons("Deposit", 12);
		deposit_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		deposit_button.setBounds(501, 98, 143, 31);
		top_background_color.add(deposit_button);
		
		JButton transaction_button = new RoundedButtons("Transactions", 12);
		transaction_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		transaction_button.setBounds(842, 98, 143, 31);
		top_background_color.add(transaction_button);
		transaction_button.setVisible(authorizedAdmin);
		
		
		JButton about_button = new RoundedButtons("About", 12);
		about_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		about_button.setBounds(668, 98, 143, 31);
		top_background_color.add(about_button);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 35, 35));
		main_layered_pane.setLayer(panel, 1);
		panel.setForeground(new Color(59, 67, 95));
		panel.setBounds(0, 657, 1266, 26);
		main_layered_pane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setForeground(Color.WHITE);
		panel_3_2.setBackground(new Color(255, 255, 0));
		panel_3_2.setBounds(0, 0, 1266, 6);
		panel.add(panel_3_2);
		
		// Card Layouting
		CardLayout card_layout = new CardLayout();
		JPanel main_panel = new JPanel(card_layout);
		main_panel.setBackground(new Color(155, 155, 35));
		main_panel.setBounds(0, 159, 1266, 501);
		main_layered_pane.add(main_panel);
//		main_panel.setLayout(new CardLayout(0, 0));
		
		// Cards

		// Main Card
		JPanel main = new JPanel();
		main.setBackground(new Color(58, 58, 58));
		
		JPanel admin = new JPanel();
		admin.setBackground(new Color(58, 58, 58));
//		admin.setBackground(Color.green);
		
		JPanel withdraw = new JPanel();
		withdraw.setBackground(new Color(103, 103, 103));
//		withdraw.setBackground(Color.green);
		
		JPanel transfer = new JPanel();
		transfer.setBackground(new Color(103, 103, 103));
//		transfer.setBackground(Color.black);
		
		JPanel deposit = new JPanel();
		deposit.setBackground(new Color(103, 103, 103));
//		deposit.setBackground(Color.white);
		
		JPanel transactions = new JPanel();
		transactions.setBackground(new Color(103, 103, 103));
//		transactions.setBackground(Color.yellow);
		
		JPanel about = new JPanel();
		about.setBackground(new Color(103, 103, 103));
		main_panel.add(main, "main");
		main.setLayout(null);
		
		JPanel panel_2 = new RoundedPanel(25);
		panel_2.setBackground(new Color(35, 35, 35));
		panel_2.setBounds(25, 0, 304, 465);
		main.add(panel_2);
		panel_2.setLayout(null);
		ImageIcon iconProfile = new ImageIcon(getClass().getResource("/images/profile_icon.png")); // Load your image
		Image imageProfile = iconProfile.getImage();
		top_background_color.add(logout_button);
		
		JLabel username_label_holder = new JLabel(username.toUpperCase());
		username_label_holder.setFont(new Font("Segoe UI", Font.BOLD, 20));
		username_label_holder.setForeground(new Color(255, 255, 255));
		username_label_holder.setBounds(0, 210, 304, 37);
		username_label_holder.setVerticalAlignment(SwingConstants.CENTER);
		username_label_holder.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(username_label_holder);
		
		JLabel title_2_1_1_1 = new JLabel("User Profile");
		title_2_1_1_1.setBackground(new Color(255, 255, 0));
		title_2_1_1_1.setVerticalAlignment(SwingConstants.CENTER);
		title_2_1_1_1.setOpaque(true);
		title_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_1_1_1.setForeground(new Color(35, 35, 35));
		title_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		title_2_1_1_1.setBounds(0, 23, 304, 24);
		panel_2.add(title_2_1_1_1);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(0, 59, 304, 6);
		panel_2.add(panel_3_1_2);
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setForeground(Color.WHITE);
		panel_3_1_2.setBackground(new Color(255, 255, 255));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(35, 35, 35));
		panel_6.setBounds(0, 243, 304, 191);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel age_label = new JLabel("Age:");
		age_label.setForeground(new Color(255, 255, 0));
		age_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_label.setBounds(202, 34, 34, 29);
		panel_6.add(age_label);
		
		JLabel age_label_1 = new JLabel("Sex:");
		age_label_1.setForeground(Color.YELLOW);
		age_label_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_label_1.setBounds(33, 34, 34, 29);
		panel_6.add(age_label_1);
		
		JLabel age_label_1_1 = new JLabel("Account Type:");
		age_label_1_1.setForeground(Color.YELLOW);
		age_label_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_label_1_1.setBounds(33, 124, 96, 29);
		panel_6.add(age_label_1_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setValue(47);
		progressBar.setForeground(new Color(255, 255, 0));
		progressBar.setBounds(33, 10, 245, 14);
		panel_6.add(progressBar);
		
		JLabel age_label_1_2 = new JLabel("Account Created:");
		age_label_1_2.setForeground(Color.YELLOW);
		age_label_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_label_1_2.setBounds(33, 65, 117, 29);
		panel_6.add(age_label_1_2);
		
		JLabel age_label_1_2_1 = new JLabel("Transactions:");
		age_label_1_2_1.setForeground(Color.YELLOW);
		age_label_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_label_1_2_1.setBounds(33, 93, 96, 29);
		panel_6.add(age_label_1_2_1);
		
		JLabel account_type_label = new JLabel("Premium");
		account_type_label.setForeground(new Color(0, 255, 64));
		account_type_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		account_type_label.setBounds(134, 125, 96, 29);
		panel_6.add(account_type_label);
		
		JLabel age_holder_label = new JLabel("18");
		age_holder_label.setForeground(new Color(0, 255, 64));
		age_holder_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		age_holder_label.setBounds(240, 34, 54, 29);
		panel_6.add(age_holder_label);
		
		JLabel gender_label = new JLabel("Male");
		gender_label.setForeground(new Color(0, 255, 64));
		gender_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		gender_label.setBounds(69, 34, 96, 29);
		panel_6.add(gender_label);
		
		JLabel account_creation_label = new JLabel("2");
		account_creation_label.setForeground(new Color(0, 255, 64));
		account_creation_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		account_creation_label.setBounds(154, 65, 140, 29);
		panel_6.add(account_creation_label);
		
		JLabel transaction_count_label = new JLabel("N/A");
		transaction_count_label.setForeground(new Color(0, 255, 64));
		transaction_count_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		transaction_count_label.setBounds(134, 93, 96, 29);
		panel_6.add(transaction_count_label);
		
		JPanel panel_3_1_2_2 = new JPanel();
		panel_3_1_2_2.setLayout(null);
		panel_3_1_2_2.setForeground(Color.WHITE);
		panel_3_1_2_2.setBackground(Color.WHITE);
		panel_3_1_2_2.setBounds(0, 432, 304, 6);
		panel_2.add(panel_3_1_2_2);
		
		JPanel panel_7 = new RoundedPanel(100);
		panel_7.setBackground(new Color(255, 255, 0));
		panel_7.setBounds(95, 90, 110, 110);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel profile_icon_label = new JLabel("");
		profile_icon_label.setBounds(5, 5, 100, 100);
		panel_7.add(profile_icon_label);
		
				// Resize the image to fit the JLabel
				Image scaledImageProfile = imageProfile.getScaledInstance(profile_icon_label.getWidth(), profile_icon_label.getHeight(), Image.SCALE_SMOOTH);
				
						// Set the scaled image as an icon
						profile_icon_label.setIcon(new ImageIcon(scaledImageProfile));
		
		RoundedPanel panel_2_1 = new RoundedPanel(25);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(35, 35, 35));
		panel_2_1.setBounds(349, 0, 642, 301);
		main.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel dashboard_balance_label = new JLabel("Balance");
		dashboard_balance_label.setFont(new Font("Segoe UI", Font.ITALIC, 23));
		dashboard_balance_label.setForeground(new Color(255, 255, 0));
		dashboard_balance_label.setBounds(27, 124, 139, 34);
		panel_2_1.add(dashboard_balance_label);
		
		JLabel dashboard_balance_label_holder = new JLabel("NO MONEY");
		// get the money first 
		String user_balance = ModelData.getBalances()[userIndex];
		String user_balance_formatted = ModelData.formatBalance(user_balance);
		
		dashboard_balance_label_holder.setText(user_balance_formatted);
		dashboard_balance_label_holder.setForeground(new Color(128, 255, 128));
		dashboard_balance_label_holder.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 27));
		dashboard_balance_label_holder.setBounds(27, 157, 367, 56);
		panel_2_1.add(dashboard_balance_label_holder);
		
		JLabel dashboard_card_holder = new JLabel("Card Holder");
		dashboard_card_holder.setForeground(new Color(255, 255, 0));
		dashboard_card_holder.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dashboard_card_holder.setBounds(27, 223, 139, 36);
		panel_2_1.add(dashboard_card_holder);
		
		JLabel dashboard_card_holder_name = new JLabel(ModelData.getFullNames()[userIndex].toUpperCase());
		dashboard_card_holder_name.setForeground(Color.WHITE);
		dashboard_card_holder_name.setFont(new Font("Segoe UI", Font.BOLD, 22));
		dashboard_card_holder_name.setBounds(27, 245, 367, 56);
		panel_2_1.add(dashboard_card_holder_name);
		
		JLabel title_1_1 = new JLabel("G");
		title_1_1.setForeground(new Color(255, 255, 255));
		title_1_1.setFont(new Font("Segoe UI", Font.BOLD, 45));
		title_1_1.setBounds(504, 10, 39, 63);
		panel_2_1.add(title_1_1);
		
		JLabel title_2_1 = new JLabel("ROCK");
		title_2_1.setBackground(new Color(0, 64, 128));
		title_2_1.setVerticalAlignment(SwingConstants.CENTER);
		title_2_1.setOpaque(true);
		title_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_1.setForeground(new Color(255, 255, 255));
		title_2_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		title_2_1.setBounds(539, 26, 74, 34);
		panel_2_1.add(title_2_1);
		
		JLabel card_number_1 = new JLabel("1234");
		card_number_1.setVerticalAlignment(SwingConstants.CENTER);
		card_number_1.setOpaque(false);
		card_number_1.setHorizontalAlignment(SwingConstants.CENTER);
		card_number_1.setForeground(new Color(255, 255, 255));
		card_number_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		card_number_1.setBounds(248, 140, 99, 34);
		panel_2_1.add(card_number_1);
		
		JLabel card_number_2 = new JLabel("4567");
		card_number_2.setVerticalAlignment(SwingConstants.CENTER);
		card_number_2.setOpaque(false);
		card_number_2.setHorizontalAlignment(SwingConstants.CENTER);
		card_number_2.setForeground(new Color(255, 255, 255));
		card_number_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		card_number_2.setBounds(336, 140, 99, 34);
		panel_2_1.add(card_number_2);
		
		JLabel card_number_3 = new JLabel("7891");
		card_number_3.setVerticalAlignment(SwingConstants.CENTER);
		card_number_3.setOpaque(false);
		card_number_3.setHorizontalAlignment(SwingConstants.CENTER);
		card_number_3.setForeground(new Color(255, 255, 255));
		card_number_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		card_number_3.setBounds(428, 140, 99, 34);
		panel_2_1.add(card_number_3);
		
		JLabel card_number_4 = new JLabel("1224");
		card_number_4.setOpaque(false);
		card_number_4.setVerticalAlignment(SwingConstants.CENTER);
		card_number_4.setHorizontalAlignment(SwingConstants.CENTER);
		card_number_4.setForeground(new Color(255, 255, 255));
		card_number_4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		card_number_4.setBounds(521, 140, 99, 34);
		panel_2_1.add(card_number_4);
		
		JLabel dashboard_date_label = new JLabel("Date");
		dashboard_date_label.setForeground(Color.WHITE);
		dashboard_date_label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		dashboard_date_label.setBounds(483, 213, 139, 36);
		panel_2_1.add(dashboard_date_label);
		
		JLabel dashboard_date_holder = new JLabel("No time nigga");
		dashboard_date_holder.setText(DateData.getDate());
		dashboard_date_holder.setForeground(Color.WHITE);
		dashboard_date_holder.setFont(new Font("Segoe UI", Font.ITALIC, 22));
		dashboard_date_holder.setBounds(480, 235, 152, 56);
		panel_2_1.add(dashboard_date_holder);
		
		RoundedPanel panel_2_2 = new RoundedPanel(25);
		panel_2_2.setBackground(new Color(35, 35, 35));
		panel_2_2.setBounds(349, 322, 642, 143);
		main.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel title_2_1_1_2 = new JLabel("POWERED BY");
		title_2_1_1_2.setBounds(0, 10, 642, 28);
		title_2_1_1_2.setVerticalAlignment(SwingConstants.CENTER);
		title_2_1_1_2.setOpaque(true);
		title_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_1_1_2.setForeground(Color.WHITE);
		title_2_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		title_2_1_1_2.setBackground(new Color(35, 35, 35));
		panel_2_2.add(title_2_1_1_2);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setForeground(Color.WHITE);
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBounds(0, 64, 642, 6);
		panel_2_2.add(panel_3_1_1);
		
		JLabel lblBato_1 = new JLabel("Bato");
		lblBato_1.setForeground(Color.WHITE);
		lblBato_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBato_1.setBounds(10, 93, 53, 27);
		panel_2_2.add(lblBato_1);
		
		RoundedPanel login_title_background_panel = new RoundedPanel(25);
		login_title_background_panel.setBackground(new Color(255, 128, 64));
		login_title_background_panel.setBounds(60, 94, 71, 25);
		panel_2_2.add(login_title_background_panel);
		login_title_background_panel.setLayout(null);
		
		JLabel login_title_label = new JLabel("Hub");
		login_title_label.setBounds(10, -13, 51, 46);
		login_title_background_panel.add(login_title_label);
		login_title_label.setVerticalAlignment(SwingConstants.CENTER);
		login_title_label.setOpaque(false);
		login_title_label.setHorizontalAlignment(SwingConstants.CENTER);
		login_title_label.setForeground(new Color(35, 35, 35));
		login_title_label.setFont(new Font("Segoe UI", Font.BOLD, 20));
		login_title_label.setBackground(new Color(255, 128, 64));
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setForeground(Color.WHITE);
		panel_3_3.setBackground(Color.YELLOW);
		panel_3_3.setBounds(0, 48, 642, 6);
		panel_2_2.add(panel_3_3);
		
		JLabel title_2_1_2 = new JLabel("R");
		title_2_1_2.setVerticalAlignment(SwingConstants.CENTER);
		title_2_1_2.setOpaque(true);
		title_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_1_2.setForeground(Color.WHITE);
		title_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		title_2_1_2.setBackground(new Color(0, 64, 128));
		title_2_1_2.setBounds(141, 88, 30, 34);
		panel_2_2.add(title_2_1_2);
		
		JLabel lblBato_1_1 = new JLabel("ockbook");
		lblBato_1_1.setForeground(Color.WHITE);
		lblBato_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBato_1_1.setBounds(175, 93, 87, 27);
		panel_2_2.add(lblBato_1_1);
		
		JLabel lblBato_1_2 = new JLabel("Rock");
		lblBato_1_2.setForeground(Color.WHITE);
		lblBato_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBato_1_2.setBounds(266, 93, 53, 27);
		panel_2_2.add(lblBato_1_2);
		
		RoundedPanel login_title_background_panel_1 = new RoundedPanel(25);
		login_title_background_panel_1.setForeground(new Color(255, 255, 255));
		login_title_background_panel_1.setLayout(null);
		login_title_background_panel_1.setBackground(new Color(255, 0, 0));
		login_title_background_panel_1.setBounds(316, 93, 71, 25);
		panel_2_2.add(login_title_background_panel_1);
		
		JLabel login_title_label_1 = new JLabel("Tube");
		login_title_label_1.setVerticalAlignment(SwingConstants.CENTER);
		login_title_label_1.setOpaque(false);
		login_title_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		login_title_label_1.setForeground(new Color(255, 255, 255));
		login_title_label_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		login_title_label_1.setBackground(new Color(255, 128, 64));
		login_title_label_1.setBounds(10, -13, 51, 46);
		login_title_background_panel_1.add(login_title_label_1);
		
		RoundedPanel login_title_background_panel_2 = new RoundedPanel(25);
		login_title_background_panel_2.setForeground(new Color(255, 255, 255));
		login_title_background_panel_2.setLayout(null);
		login_title_background_panel_2.setBackground(new Color(0, 64, 128));
		login_title_background_panel_2.setBounds(394, 93, 71, 25);
		panel_2_2.add(login_title_background_panel_2);
		
		JLabel login_title_label_2 = new JLabel("RD");
		login_title_label_2.setVerticalAlignment(SwingConstants.CENTER);
		login_title_label_2.setOpaque(false);
		login_title_label_2.setHorizontalAlignment(SwingConstants.CENTER);
		login_title_label_2.setForeground(new Color(255, 255, 255));
		login_title_label_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		login_title_label_2.setBackground(new Color(255, 128, 64));
		login_title_label_2.setBounds(0, -13, 51, 46);
		login_title_background_panel_2.add(login_title_label_2);
		
		JLabel login_title_label_2_1 = new JLabel("O");
		login_title_label_2_1.setVerticalAlignment(SwingConstants.CENTER);
		login_title_label_2_1.setOpaque(false);
		login_title_label_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		login_title_label_2_1.setForeground(new Color(255, 255, 0));
		login_title_label_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		login_title_label_2_1.setBackground(new Color(255, 128, 64));
		login_title_label_2_1.setBounds(21, -13, 51, 46);
		login_title_background_panel_2.add(login_title_label_2_1);
		
		JLabel lblBato_1_2_1 = new JLabel("StoneMaya");
		lblBato_1_2_1.setForeground(new Color(0, 255, 64));
		lblBato_1_2_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblBato_1_2_1.setBounds(475, 93, 122, 27);
		panel_2_2.add(lblBato_1_2_1);
		
		RoundedPanel panel_2_3 = new RoundedPanel(25);
		panel_2_3.setBackground(new Color(35, 35, 35));
		panel_2_3.setBounds(1016, 0, 229, 465);
		main.add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel title_2_1_1 = new JLabel("NEWS");
		title_2_1_1.setBackground(new Color(255, 255, 0));
		title_2_1_1.setVerticalAlignment(SwingConstants.CENTER);
		title_2_1_1.setOpaque(true);
		title_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_1_1.setForeground(new Color(35, 35, 35));
		title_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		title_2_1_1.setBounds(0, 25, 229, 25);
		panel_2_3.add(title_2_1_1);
		
		JPanel panel_3_1_2_1 = new JPanel();
		panel_3_1_2_1.setLayout(null);
		panel_3_1_2_1.setForeground(Color.WHITE);
		panel_3_1_2_1.setBackground(Color.WHITE);
		panel_3_1_2_1.setBounds(0, 60, 229, 7);
		panel_2_3.add(panel_3_1_2_1);
		
		JTextArea txtrwithdrawtransfer = new JTextArea();
		txtrwithdrawtransfer.setText("[MAY] Bank Opening\r\n[MAY] 5% Interest for new users\r\n[2026] Rice will be ₱20\r\n[2027] 69% Interest");
		txtrwithdrawtransfer.setForeground(new Color(255, 255, 0));
		txtrwithdrawtransfer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtrwithdrawtransfer.setBackground(new Color(26, 26, 26));
		txtrwithdrawtransfer.setBounds(10, 77, 209, 378);
		panel_2_3.add(txtrwithdrawtransfer);
		main_panel.add(admin, "admin");
		admin.setLayout(null);
		
		RoundedButtons dashboard_button = new RoundedButtons("Dashboard", 5);
		dashboard_button.setText("Dashboard");
		dashboard_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		dashboard_button.setBounds(0, 98, 143, 31);
		top_background_color.add(dashboard_button);
		
		JButton create_button = new adminButtons("CREATE", 12);
		create_button.setBounds(481, 459, 85, 21);
		admin.add(create_button);
		
		JButton update_button = new adminButtons("UPDATE", 12);
		update_button.setBounds(581, 459, 85, 21);
		admin.add(update_button);
		
		JButton delete_button = new adminButtons("DELETE", 12);
		delete_button.setBounds(687, 459, 85, 21);
		admin.add(delete_button);
		// TABLE FOR CRUD OPERATIONS
		// CAN ONLY BE ACCESSED BY THE ADMIN


		DefaultTableModel model = new DefaultTableModel(new String[] { "ID", "Creation Date", "Sex", "Name", "Username", "Password", "Balance", "Age", "Account Type", "Transactions"}, 0);
//		model.addRow(new Object[] {"0", "admin", "admin", "9999999", 9});
		JTable table = new JTable(model);
		table.setBackground(new Color(58, 58, 58));
		table.setForeground(new Color(255, 255, 0));
		table.setFocusable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(7).setPreferredWidth(0);
		table.getColumnModel().getColumn(8).setPreferredWidth(0);
		table.getColumnModel().getColumn(9).setPreferredWidth(0);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 0, 1205, 439);
		scrollPane.setBackground(new Color(35, 35, 35));
		admin.add(scrollPane, BorderLayout.CENTER);
		
		main_panel.add(withdraw, "withdraw");
		withdraw.setLayout(null);
		
		JPanel withdraw_panel = new RoundedPanel(12);
		withdraw_panel.setBackground(new Color(35, 35, 35));
		withdraw_panel.setBounds(40, 23, 1188, 440);
		withdraw.add(withdraw_panel);
		withdraw_panel.setLayout(null);
		
		withdraw_amount_field = new RoundedTextField(12);
		withdraw_amount_field.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		withdraw_amount_field.setBounds(396, 244, 466, 67);
		withdraw_panel.add(withdraw_amount_field);
		withdraw_amount_field.setColumns(10);
		
		JLabel withdraw_amount_label = new JLabel("WITHDRAW AMOUNT:");
		withdraw_amount_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
		withdraw_amount_label.setForeground(new Color(255, 255, 255));
		withdraw_amount_label.setBounds(126, 246, 260, 56);
		withdraw_panel.add(withdraw_amount_label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(42, 398, 1101, 4);
		withdraw_panel.add(panel_1);
		
		JLabel balance_label = new JLabel("BALANCE:");
		balance_label.setForeground(Color.WHITE);
		balance_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
		balance_label.setBounds(262, 104, 124, 56);
		withdraw_panel.add(balance_label);
		
		JButton withdraw_amount_button = new RoundedLoginButton("WITHDRAW");
		withdraw_amount_button.setForeground(new Color(0, 0, 0));
		withdraw_amount_button.setFont(new Font("Segoe UI", Font.BOLD, 21));
		withdraw_amount_button.setBounds(550, 338, 160, 37);
		withdraw_panel.add(withdraw_amount_button);
		
		JLabel balance_amount_label = new JLabel("Fried Chicken ni Gloc-9");
		balance_amount_label.setForeground(new Color(128, 255, 128));
		balance_amount_label.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		balance_amount_label.setBounds(396, 104, 466, 56);
		withdraw_panel.add(balance_amount_label);
		main_panel.add(transfer, "transfer");
		transfer.setLayout(null);
		
		RoundedPanel withdraw_panel_1 = new RoundedPanel(12);
		withdraw_panel_1.setLayout(null);
		withdraw_panel_1.setBackground(new Color(35, 35, 35));
		withdraw_panel_1.setBounds(40, 23, 1188, 440);
		transfer.add(withdraw_panel_1);
		
		RoundedTextField transfer_amount_field = new RoundedTextField(12);
		transfer_amount_field.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		transfer_amount_field.setColumns(10);
		transfer_amount_field.setBounds(396, 210, 466, 67);
		withdraw_panel_1.add(transfer_amount_field);
		
		JLabel transfer_amount_label = new JLabel("TRANSFER AMOUNT:");
		transfer_amount_label.setForeground(Color.WHITE);
		transfer_amount_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
		transfer_amount_label.setBounds(126, 212, 260, 56);
		withdraw_panel_1.add(transfer_amount_label);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(42, 398, 1101, 4);
		withdraw_panel_1.add(panel_1_1);
		
		JLabel transfer_to_label = new JLabel("TRANSFER TO:");
		transfer_to_label.setForeground(Color.WHITE);
		transfer_to_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
		transfer_to_label.setBounds(126, 105, 260, 56);
		withdraw_panel_1.add(transfer_to_label);
		
		JButton transfer_to_button = new RoundedLoginButton("TRANSFER");
		transfer_to_button.setForeground(new Color(35, 35, 35));
		transfer_to_button.setFont(new Font("Segoe UI", Font.BOLD, 21));
		transfer_to_button.setBounds(566, 338, 144, 37);
		withdraw_panel_1.add(transfer_to_button);
		
		RoundedTextField transfer_to_field = new RoundedTextField(12);
		transfer_to_field.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		transfer_to_field.setColumns(10);
		transfer_to_field.setBounds(396, 105, 466, 67);
		withdraw_panel_1.add(transfer_to_field);
		
		JLabel transfer_label = new JLabel("Transfer money to other BankoBato accounts");
		transfer_label.setForeground(new Color(255, 255, 255));
		transfer_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		transfer_label.setBounds(396, 0, 466, 64);
		transfer_label.setVerticalAlignment(SwingConstants.CENTER);
		transfer_label.setHorizontalAlignment(SwingConstants.CENTER);
		withdraw_panel_1.add(transfer_label);
		
		JLabel transfer_handler_label = new JLabel("");
		transfer_handler_label.setVerticalAlignment(SwingConstants.CENTER);
		transfer_handler_label.setHorizontalAlignment(SwingConstants.CENTER);
		transfer_handler_label.setForeground(Color.WHITE);
		transfer_handler_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		transfer_handler_label.setBounds(396, 306, 466, 22);
		withdraw_panel_1.add(transfer_handler_label);
		main_panel.add(deposit, "deposit");
		deposit.setLayout(null);
		
		RoundedPanel withdraw_panel_2 = new RoundedPanel(12);
		withdraw_panel_2.setLayout(null);
		withdraw_panel_2.setBackground(new Color(35, 35, 35));
		withdraw_panel_2.setBounds(40, 23, 1188, 440);
		deposit.add(withdraw_panel_2);
		
		RoundedTextField deposit_amount_field = new RoundedTextField(12);
		deposit_amount_field.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		deposit_amount_field.setColumns(10);
		deposit_amount_field.setBounds(396, 244, 466, 67);
		withdraw_panel_2.add(deposit_amount_field);
		
		JLabel deposit_label = new JLabel("DEPOSIT AMOUNT:");
		deposit_label.setForeground(Color.WHITE);
		deposit_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
		deposit_label.setBounds(150, 244, 220, 56);
		withdraw_panel_2.add(deposit_label);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(42, 398, 1101, 4);
		withdraw_panel_2.add(panel_1_2);
		
		JLabel balance_label_1 = new JLabel("BALANCE:");
		balance_label_1.setForeground(Color.WHITE);
		balance_label_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		balance_label_1.setBounds(246, 108, 124, 56);
		withdraw_panel_2.add(balance_label_1);
		
		JButton deposit_amount_button = new RoundedLoginButton("DEPOSIT");
		deposit_amount_button.setForeground(new Color(35, 35, 35));
		deposit_amount_button.setFont(new Font("Segoe UI", Font.BOLD, 21));
		deposit_amount_button.setBounds(566, 338, 144, 37);
		withdraw_panel_2.add(deposit_amount_button);
		
		JLabel deposit_balance_label = new JLabel("9,999,999");
		deposit_balance_label.setForeground(new Color(128, 255, 128));
		deposit_balance_label.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		deposit_balance_label.setBounds(396, 108, 466, 56);
		withdraw_panel_2.add(deposit_balance_label);
		main_panel.add(transactions, "transactions");
		transactions.setLayout(null);
		
		RoundedPanel withdraw_panel_2_2 = new RoundedPanel(12);
		withdraw_panel_2_2.setBackground(new Color(35, 35, 35));
		withdraw_panel_2_2.setBounds(40, 23, 1188, 440);
		transactions.add(withdraw_panel_2_2);
		withdraw_panel_2_2.setLayout(null);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setBounds(42, 398, 1101, 4);
		withdraw_panel_2_2.add(panel_1_2_2);
		
		JPanel panel_3_2_1_1_3_3 = new JPanel();
		panel_3_2_1_1_3_3.setLayout(null);
		panel_3_2_1_1_3_3.setForeground(Color.WHITE);
		panel_3_2_1_1_3_3.setBackground(Color.WHITE);
		panel_3_2_1_1_3_3.setBounds(0, 62, 1188, 10);
		withdraw_panel_2_2.add(panel_3_2_1_1_3_3);
		
		JPanel panel_3_2_1_1_3_4 = new JPanel();
		panel_3_2_1_1_3_4.setLayout(null);
		panel_3_2_1_1_3_4.setForeground(Color.WHITE);
		panel_3_2_1_1_3_4.setBackground(new Color(255, 255, 0));
		panel_3_2_1_1_3_4.setBounds(0, 42, 1188, 10);
		withdraw_panel_2_2.add(panel_3_2_1_1_3_4);
		DefaultListModel<String> model_list = new DefaultListModel<>();
		JList transactions_list = new JList(model_list);
		transactions_list.setForeground(new Color(255, 255, 0));
		transactions_list.setBackground(new Color(35, 35, 35));
		transactions_list.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		transactions_list.setBounds(42, 105, 1101, 258);
		withdraw_panel_2_2.add(transactions_list);
		
		JLabel transaction_label = new JLabel("Only the admin can see all transactions");
		transaction_label.setForeground(new Color(255, 255, 0));
		transaction_label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		transaction_label.setBounds(0, 19, 1188, 13);
		transaction_label.setVerticalAlignment(SwingConstants.CENTER);
		transaction_label.setHorizontalAlignment(SwingConstants.CENTER);
		withdraw_panel_2_2.add(transaction_label);
		
		JLabel transaction_label_1 = new JLabel("Transaction History");
		transaction_label_1.setVerticalAlignment(SwingConstants.CENTER);
		transaction_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		transaction_label_1.setForeground(Color.YELLOW);
		transaction_label_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		transaction_label_1.setBounds(0, 82, 1188, 26);
		withdraw_panel_2_2.add(transaction_label_1);
		
		RoundedPanel withdraw_panel_3_1_1_1 = new RoundedPanel(12);
		withdraw_panel_3_1_1_1.setLayout(null);
		withdraw_panel_3_1_1_1.setBackground(new Color(26, 26, 26));
		withdraw_panel_3_1_1_1.setBounds(53, 37, 1188, 440);
		transactions.add(withdraw_panel_3_1_1_1);
		main_panel.add(about, "about");
		about.setLayout(null);
		
		JPanel about_panel = new RoundedPanel(12);
		about_panel.setBackground(new Color(35, 35, 35));
		about_panel.setBounds(27, 29, 1212, 438);
		about_panel.setBorder(null);
		about.add(about_panel);
		about_panel.setLayout(null);
		
		JLabel about_us_text = new JLabel("ABOUT US");
		about_us_text.setForeground(new Color(255, 255, 0));
		about_us_text.setBackground(new Color(255, 255, 0));
		about_us_text.setFont(new Font("Segoe UI", Font.BOLD, 22));
		about_us_text.setBounds(40, 44, 141, 38);
		about_panel.add(about_us_text);
		
		JLabel about_us_text_2 = new JLabel("What is BankoBato?");
		about_us_text_2.setForeground(new Color(255, 255, 0));
		about_us_text_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		about_us_text_2.setBounds(81, 92, 208, 29);
		about_panel.add(about_us_text_2);
		
		JTextArea txtrBankoBatoIs = new JTextArea();
		txtrBankoBatoIs.setForeground(new Color(255, 255, 255));
		txtrBankoBatoIs.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		txtrBankoBatoIs.setText("Banko Bato is a reputable and internationallly engaged local \r\nbank that produces future-ready global professionals by 2035.\r\n\r\nIt is cultivating future-ready global professionals \r\nthrough inclusive education, research-oriented culture, \r\nand collaborative partnership.");
		txtrBankoBatoIs.setOpaque(false);
		txtrBankoBatoIs.setBounds(80, 130, 531, 256);
		about_panel.add(txtrBankoBatoIs);
		
		 JPanel panel_3 = new JPanel();
		 panel_3.setBackground(new Color(255, 255, 0));
		 panel_3.setForeground(new Color(255, 255, 255));
		 panel_3.setBounds(0, 79, 642, 6);
		 panel_2_1.add(panel_3);
		 panel_3.setLayout(null);
		 
		 JPanel panel_3_1 = new JPanel();
		 panel_3_1.setLayout(null);
		 panel_3_1.setForeground(Color.WHITE);
		 panel_3_1.setBackground(new Color(0, 128, 255));
		 panel_3_1.setBounds(0, 95, 642, 6);
		 panel_2_1.add(panel_3_1);
		 
		 RoundedPanel panel_2_3_1 = new RoundedPanel(25);
		 panel_2_3_1.setLayout(null);
		 panel_2_3_1.setBackground(new Color(26, 26, 26));
		 panel_2_3_1.setBounds(1026, 11, 229, 465);
		 main.add(panel_2_3_1);
		 
		 RoundedPanel panel_4_1 = new RoundedPanel(25);
		 panel_4_1.setLayout(null);
		 panel_4_1.setBackground(new Color(13, 13, 13));
		 panel_4_1.setBounds(0, 0, 642, 85);
		 panel_2_1.add(panel_4_1);
		 
		 JPanel panel_4 = new RoundedPanel(25);
		 panel_4.setBackground(new Color(26, 26, 26));
		 panel_4.setBounds(35, 6, 304, 470);
		 main.add(panel_4);
		 panel_4.setLayout(null);
		 
		 RoundedPanel panel_2_2_1 = new RoundedPanel(25);
		 panel_2_2_1.setLayout(null);
		 panel_2_2_1.setBackground(new Color(26, 26, 26));
		 panel_2_2_1.setBounds(359, 336, 642, 143);
		 main.add(panel_2_2_1);
		 RoundedPanel panel_2_1_1 = new RoundedPanel(25);
		 panel_2_1_1.setLayout(null);
		 panel_2_1_1.setBorder(null);
		 panel_2_1_1.setBackground(new Color(26, 26, 26));
		 panel_2_1_1.setBounds(359, 11, 642, 301);
		 main.add(panel_2_1_1);
		JLabel bato_and_sarah = new JLabel("");
		bato_and_sarah.setIcon(new ImageIcon(getClass().getResource("/images/bato_and_sarah.png")));
		bato_and_sarah.setBounds(712, 92, 677, 428);
		about_panel.add(bato_and_sarah);
		
		RoundedPanel withdraw_panel_3_1_1_1_1 = new RoundedPanel(12);
		withdraw_panel_3_1_1_1_1.setLayout(null);
		withdraw_panel_3_1_1_1_1.setBackground(new Color(26, 26, 26));
		withdraw_panel_3_1_1_1_1.setBounds(67, 10, 1188, 440);
		about.add(withdraw_panel_3_1_1_1_1);
		
		JLabel withdraw_handler = new JLabel("");
		withdraw_handler.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		withdraw_handler.setBounds(396, 181, 466, 37);
		withdraw_handler.setVerticalAlignment(SwingConstants.CENTER);
		withdraw_handler.setHorizontalAlignment
		(SwingConstants.CENTER);
		withdraw_panel.add(withdraw_handler);

		// Buttons
		admin_button.addActionListener(e -> {
		    card_layout.show(main_panel, "admin");
		    admin_button.setForeground(new Color(59, 67, 95));
		    admin_button.setBackground(Color.white);
		
		});
		dashboard_button.addActionListener(e -> {
			card_layout.show(main_panel, "main");
			 dashboard_balance_label_holder.setText(ModelData.formatBalance(ModelData.getBalances()[userIndex]));
			 age_holder_label.setText(ModelData.getAges()[userIndex]);
			 gender_label.setText(ModelData.getGenders()[userIndex]);
			 account_creation_label.setText(ModelData.getAccountCreationDates()[userIndex]);
			 account_type_label.setText(ModelData.getAccountTypes()[userIndex]);
			 transaction_count_label.setText(Integer.toString(ModelData.getAccountTransactionCounts()[userIndex]));			 

		});
		withdraw_button.addActionListener(e -> {
			card_layout.show(main_panel, "withdraw");
			balance_amount_label.setText(ModelData.formatBalance(ModelData.getBalances()[userIndex]));
		   
			
		});
		transfer_button.addActionListener(e -> card_layout.show(main_panel, "transfer"));
		deposit_button.addActionListener(e -> {
			card_layout.show(main_panel, "deposit");
			deposit_balance_label.setText(ModelData.formatBalance(ModelData.getBalances()[userIndex]));
		
		});
		transaction_button.addActionListener(e -> {
			card_layout.show(main_panel, "transactions");
			String[] transactionHistory = ModelData.getTransactionHistory();
			model_list.clear();
			for(int i=0; i<transactionHistory.length; i++) {
				model_list.addElement(transactionHistory[i]);
			}
			});
		about_button.addActionListener(e -> card_layout.show(main_panel, "about"));
		
		

		JLabel title_1 = new JLabel("BANKO");
		title_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		title_1.setForeground(new Color(255, 255, 255));
		title_1.setBounds(21, 16, 136, 63);
		top_background_color.add(title_1);
		
		JLabel title_2 = new JLabel("BATO");
		title_2.setBackground(new Color(255, 255, 255));
		title_2.setForeground(new Color(35, 35, 35));
		title_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		title_2.setBounds(151, 30, 74, 34);
		title_2.setOpaque(true);
		title_2.setVerticalAlignment(SwingConstants.CENTER);
		title_2.setHorizontalAlignment(SwingConstants.CENTER);
		top_background_color.add(title_2);
		
		JLabel version_label = new JLabel("Version 69.420");
		version_label.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		version_label.setForeground(new Color(255, 255, 255));
		version_label.setBounds(25, 70, 103, 14);
		top_background_color.add(version_label);
		
		
		// Core functions
//		OnClickEventHelperCoreFunctions.withdrawOnClick(withdraw_button, balance_amount_label, userIndex);
		OnClickEventHelperCoreFunctions.depositOnClick(deposit_amount_button, deposit_amount_field, userIndex, deposit_balance_label);
		
		JPanel panel_3_2_1_1_2 = new JPanel();
		panel_3_2_1_1_2.setLayout(null);
		panel_3_2_1_1_2.setForeground(Color.WHITE);
		panel_3_2_1_1_2.setBackground(new Color(255, 255, 0));
		panel_3_2_1_1_2.setBounds(0, 52, 1188, 10);
		withdraw_panel_2.add(panel_3_2_1_1_2);
		
		JPanel panel_3_2_1_1_3_2 = new JPanel();
		panel_3_2_1_1_3_2.setLayout(null);
		panel_3_2_1_1_3_2.setForeground(Color.WHITE);
		panel_3_2_1_1_3_2.setBackground(Color.WHITE);
		panel_3_2_1_1_3_2.setBounds(0, 72, 1188, 10);
		withdraw_panel_2.add(panel_3_2_1_1_3_2);
		
		RoundedPanel withdraw_panel_3_1_1 = new RoundedPanel(12);
		withdraw_panel_3_1_1.setLayout(null);
		withdraw_panel_3_1_1.setBackground(new Color(26, 26, 26));
		withdraw_panel_3_1_1.setBounds(48, 34, 1188, 440);
		deposit.add(withdraw_panel_3_1_1);
		OnClickEventHelperCoreFunctions.transferOnclick(transfer_to_button, transfer_to_field, transfer_amount_field, userIndex, transfer_handler_label);
		
		JPanel panel_3_2_1_1_1 = new JPanel();
		panel_3_2_1_1_1.setLayout(null);
		panel_3_2_1_1_1.setForeground(Color.WHITE);
		panel_3_2_1_1_1.setBackground(new Color(255, 255, 0));
		panel_3_2_1_1_1.setBounds(0, 54, 1188, 10);
		withdraw_panel_1.add(panel_3_2_1_1_1);
		
		JPanel panel_3_2_1_1_3_1 = new JPanel();
		panel_3_2_1_1_3_1.setLayout(null);
		panel_3_2_1_1_3_1.setForeground(Color.WHITE);
		panel_3_2_1_1_3_1.setBackground(Color.WHITE);
		panel_3_2_1_1_3_1.setBounds(0, 74, 1188, 10);
		withdraw_panel_1.add(panel_3_2_1_1_3_1);
		
		RoundedPanel withdraw_panel_3_1 = new RoundedPanel(12);
		withdraw_panel_3_1.setLayout(null);
		withdraw_panel_3_1.setBackground(new Color(26, 26, 26));
		withdraw_panel_3_1.setBounds(52, 34, 1188, 440);
		transfer.add(withdraw_panel_3_1);
		// Bank functions
		OnClickEventHelperBankFunctions.withdrawAmountOnClick(withdraw_amount_button, balance_amount_label, withdraw_amount_field, withdraw_handler, userIndex);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setLayout(null);
		panel_3_2_1_1.setForeground(Color.WHITE);
		panel_3_2_1_1.setBackground(new Color(255, 255, 0));
		panel_3_2_1_1.setBounds(0, 48, 1188, 10);
		withdraw_panel.add(panel_3_2_1_1);
		
		JPanel panel_3_2_1_1_3 = new JPanel();
		panel_3_2_1_1_3.setLayout(null);
		panel_3_2_1_1_3.setForeground(Color.WHITE);
		panel_3_2_1_1_3.setBackground(new Color(255, 255, 255));
		panel_3_2_1_1_3.setBounds(0, 68, 1188, 10);
		withdraw_panel.add(panel_3_2_1_1_3);
		
		RoundedPanel withdraw_panel_3 = new RoundedPanel(12);
		withdraw_panel_3.setLayout(null);
		withdraw_panel_3.setBackground(new Color(26, 26, 26));
		withdraw_panel_3.setBounds(53, 36, 1188, 440);
		withdraw.add(withdraw_panel_3);
		
		// Admin functions
		OnClickEventHelperAdminFunctions.onClickAdmin(admin_button, model, table);
		
		JPanel panel_5 = new RoundedPanel(50);
		panel_5.setBackground(new Color(255, 255, 0));
		panel_5.setBounds(349, 0, 639, 72);
		top_background_color.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel title_2_2 = new JLabel("TUESDAY");
		title_2_2.setBackground(new Color(35, 35, 35));
		title_2_2.setBounds(0, 25, 639, 34);
		panel_5.add(title_2_2);
		title_2_2.setVerticalAlignment(SwingConstants.CENTER);
		title_2_2.setOpaque(false);
		title_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2_2.setForeground(new Color(35, 35, 35));
		title_2_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		RoundedPanel panel_5_1 = new RoundedPanel(50);
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(new Color(13, 13, 13));
		panel_5_1.setBounds(1199, 28, 177, 72);
		top_background_color.add(panel_5_1);
		
		RoundedPanel panel_5_2 = new RoundedPanel(50);
		panel_5_2.setLayout(null);
		panel_5_2.setBackground(new Color(26, 26, 26));
		panel_5_2.setBounds(357, 16, 622, 72);
		top_background_color.add(panel_5_2);
		
	
		profile_panel_shadow = new JPanel();
		profile_panel_shadow.setBackground(new Color(58, 58, 58));
		profile_panel_shadow.setBounds(0, 106, 1266, 53);
		top_layered_pane.add(profile_panel_shadow);
		profile_panel_shadow.setLayout(null);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBounds(0, 10, 1266, 6);
		profile_panel_shadow.add(panel_3_2_1);
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setForeground(Color.WHITE);
		panel_3_2_1.setBackground(new Color(255, 255, 0));
		
		OnClickEventHelperAdminFunctions.onClickCreate(create_button, model, table);
		OnClickEventHelperAdminFunctions.onClickDelete(delete_button, model, table);
		OnClickEventHelperAdminFunctions.onClickUpdate(update_button, model, table);
		
		 dashboard_balance_label_holder.setText(ModelData.formatBalance(ModelData.getBalances()[userIndex]));
		 age_holder_label.setText(ModelData.getAges()[userIndex]);
		 gender_label.setText(ModelData.getGenders()[userIndex]);
		 account_creation_label.setText(ModelData.getAccountCreationDates()[userIndex]);
		 account_type_label.setText(ModelData.getAccountTypes()[userIndex]);
		 transaction_count_label.setText(Integer.toString(ModelData.getAccountTransactionCounts()[userIndex]));	
		
	}
}
