package FrameClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import Auxilliary.ModelData;
import CustomComponents.RoundedLoginButton;
import CustomComponents.RoundedPasswordField;
import CustomComponents.RoundedTextField;
import HelperFunctionClasses.OnClickEventHelper;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.JSpinner;

public class SignUpFrame {

	private JFrame frame;
	private JTextField create_username_field;
	private JPasswordField create_password_field;
	private JPasswordField confirm_password_field;
	private JLabel create_username_text;
	private JLabel create_password_text;
	private JLabel confirm_password_text;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame window = new SignUpFrame();
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
	public SignUpFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sign Up");
		frame.setBounds(100, 100, 500, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(35, 35, 35));
		layeredPane.setBounds(0, 0, 486, 563);
		layeredPane.setOpaque(true);
		frame.getContentPane().add(layeredPane);
		
		create_username_field = new RoundedTextField(12);
		create_username_field.setForeground(new Color(255, 255, 255));
		create_username_field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		create_username_field.setBackground(new Color(103, 103, 103));
		create_username_field.setBounds(82, 230, 328, 45);
		layeredPane.add(create_username_field);
		create_username_field.setColumns(10);
		
		create_password_field = new RoundedPasswordField(12);
		create_password_field.setForeground(new Color(255, 255, 255));
		create_password_field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		create_password_field.setBackground(new Color(103, 103, 103));
		create_password_field.setColumns(10);
		create_password_field.setBounds(82, 309, 328, 45);
		layeredPane.add(create_password_field);
		
		confirm_password_field = new RoundedPasswordField(12);
		confirm_password_field.setForeground(new Color(255, 255, 255));
		confirm_password_field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		confirm_password_field.setBackground(new Color(103, 103, 103));
		confirm_password_field.setColumns(10);
		confirm_password_field.setBounds(82, 391, 328, 45);
		layeredPane.add(confirm_password_field);
		
		JLabel register_handler = new JLabel("");
		register_handler.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		register_handler.setBounds(0, 486, 486, 13);
		register_handler.setVerticalAlignment(SwingConstants.CENTER);
		register_handler.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(register_handler);
		JLabel create_username_text_1 = new JLabel("Full Name");
		create_username_text_1.setBackground(new Color(255, 255, 0));
		create_username_text_1.setVerticalAlignment(SwingConstants.CENTER);
		create_username_text_1.setOpaque(true);
		create_username_text_1.setHorizontalAlignment(SwingConstants.CENTER);
		create_username_text_1.setFont(new Font("Segoe UI", Font.BOLD, 10));
		create_username_text_1.setBounds(106, 89, 61, 13);
		layeredPane.add(create_username_text_1);
		RoundedTextField full_name_field = new RoundedTextField(12);
		full_name_field.setForeground(new Color(255, 255, 255));
		full_name_field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		full_name_field.setBackground(new Color(103, 103, 103));
		full_name_field.setColumns(10);
		full_name_field.setBounds(82, 94, 328, 45);
		layeredPane.add(full_name_field);
		// BUTTON
		JButton register_button = new RoundedLoginButton("Create Account");
		register_button.setForeground(new Color(35, 35, 35));
		register_button.setBackground(new Color(255, 255, 0));
		register_button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		register_button.setBounds(165, 508, 163, 45);
		
		layeredPane.add(register_button);
		
		JLabel create_account_text = new JLabel("Create Account to BankoBato!");
		create_account_text.setOpaque(true);
		create_account_text.setBackground(new Color(255, 255, 0));
		create_account_text.setForeground(new Color(35, 35, 35));
		create_account_text.setFont(new Font("Segoe UI", Font.BOLD, 17));
		create_account_text.setBounds(0, 40, 486, 27);
		create_account_text.setVerticalAlignment(SwingConstants.CENTER);
		create_account_text.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(create_account_text);
		
		create_username_text = new JLabel("Create Username");
		create_username_text.setBackground(new Color(255, 255, 0));
		create_username_text.setFont(new Font("Segoe UI", Font.BOLD, 10));
		layeredPane.setLayer(create_username_text, 1);
		create_username_text.setBounds(106, 224, 100, 13);
		create_username_text.setOpaque(true);
		create_username_text.setVerticalAlignment(SwingConstants.CENTER);
		create_username_text.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(create_username_text);
		
		create_password_text = new JLabel("Create Password");
		create_password_text.setBackground(new Color(255, 255, 0));
		create_password_text.setFont(new Font("Segoe UI", Font.BOLD, 10));
		layeredPane.setLayer(create_password_text, 1);
		create_password_text.setVerticalAlignment(SwingConstants.CENTER);
		create_password_text.setOpaque(true);
		create_password_text.setHorizontalAlignment(SwingConstants.CENTER);
		create_password_text.setBounds(103, 302, 100, 13);
		layeredPane.add(create_password_text);
		
		confirm_password_text = new JLabel("Confirm Password");
		confirm_password_text.setBackground(new Color(255, 255, 0));
		confirm_password_text.setFont(new Font("Segoe UI", Font.BOLD, 10));
		layeredPane.setLayer(confirm_password_text, 1);
		confirm_password_text.setVerticalAlignment(SwingConstants.CENTER);
		confirm_password_text.setOpaque(true);
		confirm_password_text.setHorizontalAlignment(SwingConstants.CENTER);
		confirm_password_text.setBounds(103, 386, 100, 13);
		layeredPane.add(confirm_password_text);
		
		lblNewLabel_1 = new JLabel("Version 69.420");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 540, 76, 13);
		layeredPane.add(lblNewLabel_1);
		
		JRadioButton male_radio_button = new JRadioButton("Male");
		male_radio_button.setForeground(new Color(255, 255, 0));
		male_radio_button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		male_radio_button.setBackground(new Color(35, 35, 35));
		male_radio_button.setBounds(91, 157, 66, 21);
		male_radio_button.setBorderPainted(false);
		male_radio_button.setFocusPainted(false);
		male_radio_button.setContentAreaFilled(false);
		male_radio_button.setIcon(null);              // Removes the icon (radio circle)
		male_radio_button.setSelectedIcon(null);      // Removes selected state icon

		layeredPane.add(male_radio_button);
		
		JRadioButton female_radio_button = new JRadioButton("Female");
		female_radio_button.setForeground(Color.YELLOW);
		female_radio_button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		female_radio_button.setBackground(new Color(35, 35, 35));
		female_radio_button.setBounds(172, 157, 103, 21);
		female_radio_button.setBorderPainted(false);
		female_radio_button.setFocusPainted(false);
		female_radio_button.setContentAreaFilled(false);
		layeredPane.add(female_radio_button);
		
        ButtonGroup gender_group = new ButtonGroup();
        gender_group.add(male_radio_button);
        gender_group.add(female_radio_button);
		
		JCheckBox tos_checkbox = new JCheckBox(" I agree to the Terms and Services");
		tos_checkbox.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 9));
		tos_checkbox.setForeground(new Color(255, 255, 0));
		tos_checkbox.setOpaque(false);
		tos_checkbox.setBounds(106, 459, 307, 21);
		layeredPane.add(tos_checkbox);
		

		
		SpinnerNumberModel model = new SpinnerNumberModel(18, 0, 100, 1);
		JSpinner age_spinner = new JSpinner(model);
		age_spinner.setForeground(new Color(255, 255, 0));
		age_spinner.setFont(new Font("Segoe UI", Font.BOLD, 10));
		age_spinner.setBackground(new Color(35, 35, 35));
		age_spinner.setBounds(152, 194, 35, 20);
		age_spinner.setOpaque(false);
		age_spinner.setBorder(null);
	
		
		JLabel create_username_text_2 = new JLabel("Age");
		create_username_text_2.setVerticalAlignment(SwingConstants.CENTER);
		create_username_text_2.setOpaque(true);
		create_username_text_2.setHorizontalAlignment(SwingConstants.CENTER);
		create_username_text_2.setFont(new Font("Segoe UI", Font.BOLD, 10));
		create_username_text_2.setBackground(Color.YELLOW);
		create_username_text_2.setBounds(103, 196, 39, 13);
        JComponent editor = age_spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
//            textField.setOpaque(false);
            textField.setForeground(Color.WHITE);              // Text color
            textField.setBackground(new Color(35, 35, 35));          // Background
            textField.setCaretColor(Color.YELLOW);             // Cursor color
            textField.setFont(new Font("Segoe UI", Font.BOLD, 10));
//            textField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
            textField.setBorder(null);
        }
		layeredPane.add(create_username_text_2);
		layeredPane.add(age_spinner);

		OnClickEventHelper.registerAccount(frame, register_button, register_handler, full_name_field, create_username_field, create_password_field, confirm_password_field, gender_group, tos_checkbox, age_spinner);

	}
}
