package FrameClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Auxilliary.ModelData;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import CustomComponents.adminButtons;
import HelperFunctionClasses.OnClickEventHelperAdminFunctions;

public class UpdateUserFrame {

	private JFrame frame;
	private JTextField username_text_field;
	private JTextField fullname_text_field;
	private JTextField password_text_field;
	private int userIndex = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, DefaultTableModel model, JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserFrame window = new UpdateUserFrame(model, table);
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
	public UpdateUserFrame(DefaultTableModel model, JTable table) {
		initialize(model, table);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DefaultTableModel model, JTable table) {
		frame = new JFrame("[ADMIN] Update User");
		frame.getContentPane().setBackground(new Color(35, 35, 35));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel update_user_label = new JLabel("You're updating a user's information [Admin has bypass to restrictions]"); 
		update_user_label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		update_user_label.setForeground(new Color(255, 255, 0));
		update_user_label.setBounds(0, 24, 486, 13);
		update_user_label.setHorizontalAlignment(SwingConstants.CENTER);
		update_user_label.setVerticalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(update_user_label);
		// Get the list of users first
		String[] users = ModelData.getUsernames();
		
		JComboBox users_combobox = new JComboBox(users); // Maybe use combobox for deleting users too
		users_combobox.setForeground(new Color(255, 255, 0));
		users_combobox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		users_combobox.setBackground(new Color(35, 35, 35));
		users_combobox.setBounds(159, 84, 193, 21);
		users_combobox.setBorder(null);
		users_combobox.setBorder(BorderFactory.createEmptyBorder());

		frame.getContentPane().add(users_combobox);
		
		username_text_field = new JTextField();
		username_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		username_text_field.setBounds(159, 151, 193, 19);
		frame.getContentPane().add(username_text_field);
		username_text_field.setColumns(10);
		username_text_field.setBorder(null);
		
		fullname_text_field = new JTextField();
		fullname_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		fullname_text_field.setColumns(10);
		fullname_text_field.setBounds(159, 191, 193, 19);
		fullname_text_field.setBorder(null);
		frame.getContentPane().add(fullname_text_field);
		
		password_text_field = new JTextField();
		password_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		password_text_field.setColumns(10);
		password_text_field.setBounds(159, 228, 193, 19);
		password_text_field.setBorder(null);
		frame.getContentPane().add(password_text_field);
		
		JRadioButton male_radiobutton = new JRadioButton("Male");
		male_radiobutton.setBackground(new Color(35, 35, 35));
		male_radiobutton.setForeground(new Color(255, 255, 0));
		male_radiobutton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		male_radiobutton.setBounds(193, 279, 58, 21);
		frame.getContentPane().add(male_radiobutton);
		
		JRadioButton female_radiobutton = new JRadioButton("Female");
		female_radiobutton.setForeground(Color.YELLOW);
		female_radiobutton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		female_radiobutton.setBackground(new Color(35, 35, 35));
		female_radiobutton.setBounds(269, 279, 75, 21);
		frame.getContentPane().add(female_radiobutton);
		
		JRadioButton basic_radiobutton = new JRadioButton("Basic");
		basic_radiobutton.setForeground(Color.YELLOW);
		basic_radiobutton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		basic_radiobutton.setBackground(new Color(35, 35, 35));
		basic_radiobutton.setBounds(193, 316, 58, 21);
		frame.getContentPane().add(basic_radiobutton);
		
		JRadioButton premium_radiobutton = new JRadioButton("Premium");
		premium_radiobutton.setForeground(Color.YELLOW);
		premium_radiobutton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		premium_radiobutton.setBackground(new Color(35, 35, 35));
		premium_radiobutton.setBounds(269, 316, 117, 21);
		frame.getContentPane().add(premium_radiobutton);
		
		JSpinner age_spinner = new JSpinner();
		age_spinner.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		age_spinner.setForeground(new Color(255, 255, 0));
		age_spinner.setBackground(new Color(35, 35, 35));
		age_spinner.setBounds(198, 359, 75, 20);
		age_spinner.setBorder(null);
		frame.getContentPane().add(age_spinner);
	       JComponent editor = age_spinner.getEditor();
	        if (editor instanceof JSpinner.DefaultEditor) {
	            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
//	            textField.setOpaque(false);
	            textField.setForeground(Color.WHITE);              // Text color
	            textField.setBackground(new Color(35, 35, 35));          // Background
	            textField.setCaretColor(Color.YELLOW);             // Cursor color
	            textField.setFont(new Font("Segoe UI", Font.BOLD, 10));
//	            textField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
	            textField.setBorder(null);
	        }
		JLabel lblNewLabel = new JLabel("Age:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(66, 358, 45, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTransactionCount = new JLabel("Transaction Count:");
		lblTransactionCount.setForeground(Color.YELLOW);
		lblTransactionCount.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTransactionCount.setBounds(66, 443, 128, 21);
		frame.getContentPane().add(lblTransactionCount);
		
		JSpinner transaction_count_spinner = new JSpinner();
		transaction_count_spinner.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		transaction_count_spinner.setForeground(Color.YELLOW);
		transaction_count_spinner.setBackground(new Color(35, 35, 35));
		transaction_count_spinner.setBounds(198, 445, 75, 20);
		transaction_count_spinner.setBorder(null);
		frame.getContentPane().add(transaction_count_spinner);
        JComponent editor1 = transaction_count_spinner.getEditor();
        if (editor1 instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor1).getTextField();
//            textField.setOpaque(false);
            textField.setForeground(Color.WHITE);              // Text color
            textField.setBackground(new Color(35, 35, 35));          // Background
            textField.setCaretColor(Color.YELLOW);             // Cursor color
            textField.setFont(new Font("Segoe UI", Font.BOLD, 10));
//            textField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
            textField.setBorder(null);
        }
        
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setForeground(Color.YELLOW);
		lblBalance.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblBalance.setBounds(66, 400, 128, 21);
		frame.getContentPane().add(lblBalance);
		
		JSpinner balance_spinner = new JSpinner();
		balance_spinner.setForeground(Color.YELLOW);
		balance_spinner.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		balance_spinner.setBorder(null);
		balance_spinner.setBackground(new Color(35, 35, 35));
		balance_spinner.setBounds(198, 402, 75, 20);
		frame.getContentPane().add(balance_spinner);
        JComponent editor2 = balance_spinner.getEditor();
        if (editor2 instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor2).getTextField();
//            textField.setOpaque(false);
            textField.setForeground(Color.green);              // Text color
            textField.setBackground(new Color(35, 35, 35));          // Background
            textField.setCaretColor(Color.YELLOW);             // Cursor color
            textField.setFont(new Font("Segoe UI", Font.BOLD, 10));
//            textField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
            textField.setBorder(null);
        }
		JLabel update_user_label_1 = new JLabel("Except for account creation dates");
		update_user_label_1.setVerticalAlignment(SwingConstants.CENTER);
		update_user_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		update_user_label_1.setForeground(new Color(255, 128, 192));
		update_user_label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		update_user_label_1.setBounds(0, 45, 486, 13);
		frame.getContentPane().add(update_user_label_1);
		
		adminButtons update_user_button = new adminButtons("DELETE USER", 12);
		update_user_button.setText("UPDATE USER");
		update_user_button.setForeground(new Color(59, 67, 95));
		update_user_button.setFont(new Font("Segoe UI", Font.BOLD, 23));
		update_user_button.setBounds(139, 507, 190, 46);
		frame.getContentPane().add(update_user_button);
		
		JLabel update_user_handler_label = new JLabel("");
		update_user_handler_label.setVerticalAlignment(SwingConstants.CENTER);
		update_user_handler_label.setHorizontalAlignment(SwingConstants.CENTER);
		update_user_handler_label.setForeground(Color.YELLOW);
		update_user_handler_label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		update_user_handler_label.setBounds(0, 482, 486, 13);
		frame.getContentPane().add(update_user_handler_label);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.YELLOW);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblUsername.setBounds(66, 149, 83, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setForeground(Color.YELLOW);
		lblFullName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblFullName.setBounds(66, 189, 83, 21);
		frame.getContentPane().add(lblFullName);
		
		JLabel passwrod_label = new JLabel("Password:");
		passwrod_label.setForeground(Color.YELLOW);
		passwrod_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		passwrod_label.setBounds(66, 226, 83, 21);
		passwrod_label.setBorder(null);
		frame.getContentPane().add(passwrod_label);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setForeground(Color.YELLOW);
		lblSex.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSex.setBounds(66, 279, 83, 21);
		frame.getContentPane().add(lblSex);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setForeground(Color.YELLOW);
		lblAccountType.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblAccountType.setBounds(66, 316, 104, 21);
		frame.getContentPane().add(lblAccountType);
		frame.setBounds(100, 100, 500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Grouping radio buttons
		ButtonGroup gender_group = new ButtonGroup();
		gender_group.add(male_radiobutton);
		gender_group.add(female_radiobutton);
		
		ButtonGroup account_type_group = new ButtonGroup();
		account_type_group.add(basic_radiobutton);
		account_type_group.add(premium_radiobutton);
		
		// Listener for the combobox
		users_combobox.addActionListener(e -> {
			// Set current information
			int userIndex = users_combobox.getSelectedIndex();
			// For field Texts
			username_text_field.setText(ModelData.getUsernames()[userIndex]);
			fullname_text_field.setText(ModelData.getFullNames()[userIndex]);
			password_text_field.setText(ModelData.getPasswords()[userIndex]);
			// For RadioButtons
			String gender = ModelData.getGenders()[userIndex];
			String account_type = ModelData.getAccountTypes()[userIndex];
			if (gender.equals("Male")) {
				male_radiobutton.setSelected(true);
			} else {
				female_radiobutton.setSelected(true);
			}
			
			if (account_type.equals("Basic")) {
				basic_radiobutton.setSelected(true);
			} else {
				premium_radiobutton.setSelected(true);
			}
			// For the spinners
			age_spinner.setValue(Integer.parseInt(ModelData.getAges()[userIndex]));
			transaction_count_spinner.setValue(ModelData.getAccountTransactionCounts()[userIndex]);
			balance_spinner.setValue(Integer.parseInt(ModelData.getBalances()[userIndex]));

			// If the update user button it clicked
			OnClickEventHelperAdminFunctions.onClickUpdateUser(update_user_button, userIndex, fullname_text_field, username_text_field,  password_text_field, gender_group, account_type_group, balance_spinner, age_spinner, transaction_count_spinner, update_user_handler_label, model, table);
			
		});
	}
}
