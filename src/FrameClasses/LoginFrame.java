package FrameClasses;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import CustomComponents.RoundedLabel;
import CustomComponents.RoundedLoginButton;
import CustomComponents.RoundedPanel;
import CustomComponents.RoundedPasswordField;
import CustomComponents.RoundedTextField;
import HelperFunctionClasses.OnClickEventHelper;


import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;

public class LoginFrame {

	private JFrame frame;
	private JTextField username_field;
	private JPasswordField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sign In");
		frame.setBounds(100, 100, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane login__left_pane = new JLayeredPane();
		login__left_pane.setOpaque(true);
		login__left_pane.setBackground(new Color(35, 35, 35));
		login__left_pane.setBounds(0, 0, 477, 563);
		frame.getContentPane().add(login__left_pane);
		
		username_field = new RoundedTextField(12);
		username_field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		username_field.setBounds(103, 234, 284, 42);
		login__left_pane.add(username_field);
		username_field.setColumns(10);
		
		password_field = new RoundedPasswordField(12);
		password_field.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		password_field.setBounds(103, 308, 284, 42);
		login__left_pane.add(password_field);
		
		JLabel field_handler = new JLabel("");
		field_handler.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		login__left_pane.setLayer(field_handler, 1);
		field_handler.setBounds(0, 360, 475, 13);
		field_handler.setVerticalAlignment(SwingConstants.CENTER);
		field_handler.setHorizontalAlignment(SwingConstants.CENTER);
		login__left_pane.add(field_handler);
		
		
		JLabel lblNewLabel = new JLabel("Sign In to BankoBato?");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(93, 182, 270, 42);
		login__left_pane.add(lblNewLabel);
		
		JButton login_button = new RoundedLoginButton("Sign In");
		login_button.setForeground(new Color(35, 35, 35));
		login_button.setFont(new Font("Segoe UI", Font.BOLD, 16));
//		login_button.setFont(new Font("Arial Black", Font.BOLD, 14));
		login_button.setBounds(182, 384, 120, 37);
		// Listener
		OnClickEventHelper.loginOnClickHandler(frame, login_button, username_field, password_field, field_handler);
		login__left_pane.add(login_button);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(39, 517, 113, 13);
		login__left_pane.add(lblNewLabel_1);
		
		JLabel mini_title_label = new JLabel("Start your day with a rock!");
		mini_title_label.setForeground(new Color(255, 255, 255));
		mini_title_label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mini_title_label.setBounds(93, 170, 246, 19);
		login__left_pane.add(mini_title_label);
		
		JLabel username_text_holder = new JLabel("Username");
		username_text_holder.setBackground(new Color(255, 255, 0));
		username_text_holder.setFont(new Font("Segoe UI", Font.BOLD, 10));
		login__left_pane.setLayer(username_text_holder, 3);
		username_text_holder.setBounds(129, 228, 73, 13);
		login__left_pane.add(username_text_holder);
		username_text_holder.setOpaque(true);
		username_text_holder.setVerticalAlignment(SwingConstants.CENTER);
		username_text_holder.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel password_text_holder = new JLabel("Password");
		password_text_holder.setBackground(new Color(255, 255, 0));
		password_text_holder.setFont(new Font("Segoe UI", Font.BOLD, 10));
		login__left_pane.setLayer(password_text_holder, 3);
		password_text_holder.setVerticalAlignment(SwingConstants.CENTER);
		password_text_holder.setOpaque(true);
		password_text_holder.setHorizontalAlignment(SwingConstants.CENTER);
		password_text_holder.setBounds(129, 300, 73, 13);
		login__left_pane.add(password_text_holder);
		
		JLabel lblNewLabel_1_1 = new JLabel("Version 69.420");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(376, 517, 73, 13);
		login__left_pane.add(lblNewLabel_1_1);
		
		JLabel signup_text_button = new JLabel("Sign Up");
		signup_text_button.setForeground(new Color(255, 255, 0));
		signup_text_button.setFont(new Font("Segoe UI", Font.BOLD, 10));
		signup_text_button.setBounds(150, 517, 113, 13);
		signup_text_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup_text_button.setText("<html><u>Sign Up</u></html>");
		signup_text_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("[SYSTEM] Sign Up Detected!");
				SignUpFrame.main(null);
			}
		});
		login__left_pane.add(signup_text_button);
		
		JLabel bankobato_icon_image = new JLabel("");
		login__left_pane.setLayer(bankobato_icon_image, 4);
//		bankobato_icon_image.setIcon(new ImageIcon("C:\\Users\\Khen David Famadico\\Downloads\\bank_logo_2-removebg-preview (1).png"));
		bankobato_icon_image.setBounds(199, 10, 78, 66);
		login__left_pane.add(bankobato_icon_image);
		
   
		bankobato_icon_image.setPreferredSize(new Dimension(75, 75)); // or any size you want

        // Load original image
//        BufferedImage originalImage = null;
//		try {
//			originalImage = ImageIO.read(new File("C:\\Users\\Khen David Famadico\\Downloads\\bankbato_icon.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//        // Resize the image to fit the label
//        Image scaledImage = originalImage.getScaledInstance(
//        		bankobato_icon_image.getPreferredSize().width,
//        		bankobato_icon_image.getPreferredSize().height,
//            Image.SCALE_SMOOTH
//        );

        // Set icon
//        bankobato_icon_image.setIcon(new ImageIcon(scaledImage));
        
        JLabel person_icon = new JLabel("");
        login__left_pane.setLayer(person_icon, 3);
        person_icon.setBounds(60, 234, 45, 45);
        login__left_pane.add(person_icon);
     		bankobato_icon_image.setPreferredSize(new Dimension(25, 25)); // or any size you want

             // Load original image
             BufferedImage originalImage1 = null;
     		try {
     			originalImage1 = ImageIO.read(getClass().getResource("/images/person_icon.png"));
     		} catch (IOException e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}

             // Resize the image to fit the label
             Image scaledImage1 = originalImage1.getScaledInstance(
             		bankobato_icon_image.getPreferredSize().width,
             		bankobato_icon_image.getPreferredSize().height,
                 Image.SCALE_SMOOTH
             );
             person_icon.setIcon(new ImageIcon(scaledImage1));
             
	     JLabel password_icon = new JLabel("");
	     login__left_pane.setLayer(password_icon, 3);
	     password_icon.setBounds(60, 308, 45, 45);
	     login__left_pane.add(password_icon);
	     password_icon.setPreferredSize(new Dimension(25, 25)); // or any size you want

        // Load original image
        BufferedImage originalImage11 = null;
		try {
			originalImage11 = ImageIO.read(getClass().getResource("/images/lock_icon.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        // Resize the image to fit the label
        Image scaledImage11 = originalImage11.getScaledInstance(
        		password_icon.getPreferredSize().width,
        		password_icon.getPreferredSize().height,
            Image.SCALE_SMOOTH
        );
        password_icon.setIcon(new ImageIcon(scaledImage11));
        
        JLabel lblBato = new JLabel("BANKO");
        lblBato.setForeground(new Color(255, 255, 255));
        lblBato.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblBato.setBounds(72, 57, 199, 80);
        login__left_pane.add(lblBato);
        
        JLabel login_title_label = new JLabel("BATO");
        login_title_label.setBackground(new Color(255, 128, 64));
        login_title_label.setOpaque(false);        
        login_title_label.setForeground(new Color(35, 35, 35));
        login_title_label.setFont(new Font("Segoe UI", Font.BOLD, 48));
        login_title_label.setBounds(251, 75, 142, 46);
        login_title_label.setVerticalAlignment(SwingConstants.CENTER);
        login_title_label.setHorizontalAlignment(SwingConstants.CENTER);
        login__left_pane.add(login_title_label);
        
        JPanel login_title_background_panel = new RoundedPanel(25);
        login_title_background_panel.setBackground(new Color(255, 128, 64));
        login_title_background_panel.setBounds(251, 75, 142, 52);
        login__left_pane.add(login_title_background_panel);
        
		JLayeredPane login_right_pane = new JLayeredPane();
		login_right_pane.setOpaque(true);
		login_right_pane.setBackground(new Color(255, 255, 0));
		login_right_pane.setBounds(470, 0, 516, 563);
		frame.getContentPane().add(login_right_pane);
		
//        try {
//            BufferedImage original_image = ImageIO.read(new File("C:\\Users\\Khen David Famadico\\Downloads\\background6.jpg"));
//
//            // Resize the image to fit JLabel's size
//            Image scaledImage = original_image.getScaledInstance(
//                    login_right_image_holder.getWidth(), login_right_image_holder.getHeight(), Image.SCALE_SMOOTH);
//
//            // In case label size is not set yet, use preferred size or manually set size
//            // So we resize based on a fixed size or the frame’s known size
//            scaledImage = original_image.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
//
//            ImageIcon imageIcon = new ImageIcon(scaledImage);
//            login_right_image_holder.setIcon(imageIcon);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		// BATO IMAGE
		JLabel bato_image = new JLabel("");
//		bato_image.setIcon(new ImageIcon("C:\\Users\\Khen David Famadico\\Downloads\\bankobato.png"));
		login_right_pane.setLayer(bato_image, 3);
//		bato_image.setIcon(new ImageIcon("C:\\Users\\Khen David Famadico\\Downloads\\image-removebg-preview (3).png"));
		bato_image.setBounds(55, 181, 451, 382);
		login_right_pane.add(bato_image);
		
        try {
            BufferedImage original_image = ImageIO.read(getClass().getResource("/images/bankobato.png"));

            // Resize the image to fit JLabel's size
            Image scaledImage111 = original_image.getScaledInstance(
                    bato_image.getWidth(), bato_image.getHeight(), Image.SCALE_SMOOTH);

            // In case label size is not set yet, use preferred size or manually set size
            // So we resize based on a fixed size or the frame’s known size
            scaledImage111 = original_image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

            ImageIcon imageIcon = new ImageIcon(scaledImage111);
            bato_image.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
