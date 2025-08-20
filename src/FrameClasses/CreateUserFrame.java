package FrameClasses;

import java.awt.EventQueue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CustomComponents.PlaceholderTextField;
import CustomComponents.RoundedPasswordField;
import CustomComponents.RoundedTextField;
import CustomComponents.adminButtons;
import HelperFunctionClasses.OnClickEventHelperAdminFunctions;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class CreateUserFrame {

	private JFrame frame;
	private JTextField username_text_field;
	private JTextField password_text_field;
	private JTextField balance_text_field;
	private JTextField full_name_texfield;
	private JRadioButton female_radio_button;
	private JSpinner age_spinner;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, DefaultTableModel model, JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUserFrame window = new CreateUserFrame(model, table);
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
	public CreateUserFrame(DefaultTableModel model, JTable table) {
		initialize(model, table);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DefaultTableModel model, JTable table) {
		frame = new JFrame("[ADMIN] Create user");
		frame.getContentPane().setBackground(new Color(35, 35, 35));
		frame.setBounds(100, 100, 500, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add_user_button = new adminButtons("ADD USER", 12);
		add_user_button.setBackground(new Color(255, 255, 0));
		add_user_button.setForeground(new Color(255, 255, 0));
		add_user_button.setFont(new Font("Segoe UI", Font.BOLD, 23));
		add_user_button.setBounds(159, 472, 170, 46);
		frame.getContentPane().add(add_user_button);
		
		JLabel create_note_label = new JLabel("Admin Mode: You're creating a user (Bypass all restrictions)");
		create_note_label.setForeground(new Color(255, 255, 0));
		create_note_label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		create_note_label.setBounds(0, 121, 486, 18);
		create_note_label.setVerticalAlignment(SwingConstants.CENTER);
		create_note_label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(create_note_label);
		
		username_text_field = new PlaceholderTextField("Username");
		username_text_field.setBorder(new EmptyBorder(0, 10, 0, 0));
		username_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		username_text_field.setBounds(105, 294, 273, 31);
		frame.getContentPane().add(username_text_field);
		username_text_field.setColumns(10);
		
		password_text_field = new PlaceholderTextField("Password");
		password_text_field.setBorder(new EmptyBorder(0, 10, 0, 0)); 
		password_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		password_text_field.setColumns(10);
		password_text_field.setBounds(105, 348, 273, 31);
		frame.getContentPane().add(password_text_field);
		
		balance_text_field = new PlaceholderTextField("Starting Balance");
		balance_text_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		balance_text_field.setBorder(new EmptyBorder(0, 10, 0, 0)); 
		balance_text_field.setColumns(10);
		balance_text_field.setBounds(105, 398, 273, 31);
		frame.getContentPane().add(balance_text_field);
		
		full_name_texfield = new PlaceholderTextField("Name");
		full_name_texfield.setBorder(new EmptyBorder(0, 10, 0, 0));
		full_name_texfield.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		full_name_texfield.setColumns(10);
		full_name_texfield.setBounds(105, 159, 273, 31);
		frame.getContentPane().add(full_name_texfield);
		
		JLabel user_creation_handler = new JLabel("");
		user_creation_handler.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		user_creation_handler.setBounds(0, 453, 486, 13);
		user_creation_handler.setVerticalAlignment(SwingConstants.CENTER);
		user_creation_handler.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(user_creation_handler);
		
		
		JRadioButton male_radio_button = new JRadioButton("Male");
		male_radio_button.setBackground(new Color(35, 35, 35));
		male_radio_button.setForeground(new Color(255, 255, 0));
		male_radio_button.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		male_radio_button.setSelected(true); // Making this the default code cuz I don't want to write a long ass code that handles no radiobutton input

		male_radio_button.setBounds(105, 209, 49, 21);
		male_radio_button.setOpaque(false);
		male_radio_button.setBorder(null);
		male_radio_button.setBorderPainted(false);
		male_radio_button.setFocusPainted(false);
		frame.getContentPane().add(male_radio_button);
		
		JRadioButton female_radio_button = new JRadioButton("Female");
		female_radio_button.setBackground(new Color(35, 35, 35));
		female_radio_button.setOpaque(false);
		female_radio_button.setFocusPainted(false);
		female_radio_button.setContentAreaFilled(false);
		female_radio_button.setBorder(null);
		female_radio_button.setBorderPainted(false);
		female_radio_button.setForeground(Color.YELLOW);
		female_radio_button.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		female_radio_button.setBounds(177, 209, 59, 21);
		frame.getContentPane().add(female_radio_button);
		
        // Group the buttons
        ButtonGroup gender_group = new ButtonGroup();
        gender_group.add(male_radio_button);
        gender_group.add(female_radio_button);
		
		
    	SpinnerNumberModel model_spinner = new SpinnerNumberModel(18, 0, 100, 1);
		age_spinner = new JSpinner(model_spinner);
		age_spinner.setBounds(159, 250, 32, 20);
		age_spinner.setOpaque(false);
		age_spinner.setBorder(null);
		frame.getContentPane().add(age_spinner);
        JComponent editor = age_spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
//            textField.setOpaque(false);
            textField.setForeground(Color.WHITE);              // Text color
            textField.setBackground(new Color(35, 35, 35));          // Background
            textField.setCaretColor(Color.YELLOW);             // Cursor color
            textField.setFont(new Font("Segoe UI", Font.BOLD, 10));
            textField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
//            textField.setBorder(null);
        }
		lblNewLabel = new JLabel("Age");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel.setBounds(126, 253, 32, 13);
		frame.getContentPane().add(lblNewLabel);
	
		// BUTTON HANDLERS
		OnClickEventHelperAdminFunctions.onClickCreateUser(add_user_button, full_name_texfield, username_text_field, password_text_field, balance_text_field, model, table, user_creation_handler, gender_group, age_spinner);
	}
}
