package HelperFunctionClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import Auxilliary.ModelData;
import FrameClasses.DashboardFrame;
import FrameClasses.LoginFrame;


public class OnClickEventHelper {
	public static void registerAccount(JFrame registerFrame, JButton registerButton, JLabel registerHandler, JTextField fullNameField, JTextField usernameField, JPasswordField passwordField, JPasswordField confirmPasswordField, ButtonGroup genderButtonsGroup, JCheckBox agreedTOS, JSpinner ageSpinner) {
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String username = usernameField.getText();
				String fullName = fullNameField.getText();
				char[] passwordChars = passwordField.getPassword();
				char[] confirmPasswordChars = confirmPasswordField.getPassword();
				String password = new String(passwordChars);
				String confirmPassword = new String(confirmPasswordChars);
				String[] usernames = ModelData.getUsernames();
				// Check if the username already exists
				for (int i=0; i<usernames.length; i++) {
					if (username.equals(usernames[i])) {
						System.out.println("[SYSTEM] Username aldreay taken");
						registerHandler.setForeground(new Color(255, 0, 0));
						registerHandler.setText("Username already taken");
						return;
					} else if (username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
						System.out.println("[SYSTEM] Empty fields");
						registerHandler.setForeground(new Color(255, 0, 0));
						registerHandler.setText("Cannot register with empty fields");
						return;
					} else if (!password.equals(confirmPassword)) {
						System.out.println("[SYSTEM] Password does not match");
						registerHandler.setForeground(new Color(255, 0, 0));
						registerHandler.setText("Password doesn't match");
						return;
					} else if (password.equals(confirmPassword)) { // Registering the user
						System.out.println("[SYSTEM] Registering user");
		                for (Enumeration<AbstractButton> buttons = genderButtonsGroup.getElements(); buttons.hasMoreElements(); ) {
		                    AbstractButton button = buttons.nextElement();
		                    if (button.isSelected()) {
//		                    	System.out.println(button.getText());
		                        String gender = button.getText();
		                        if (agreedTOS.isSelected()) {
		                        	int age = (Integer) ageSpinner.getValue();
		                        	if (age >= 18 && age <= 120) {
		    	                		ModelData.registerUser(username, password, fullName, "0", gender, Integer.toString(age));
										System.out.println("[SYSTEM] User registered");
										registerHandler.setForeground(new Color(55, 115, 37));
										registerHandler.setText("User registered");
										registerFrame.setVisible(false);
										registerFrame.dispose();
				                        break;
		                        	} else if (age < 18) {
		        						System.out.println("Underage Detected");
		        						registerHandler.setForeground(new Color(255, 0, 0));
		        						registerHandler.setText("Under 18 Detected");
		        						break;
		                        	} else {
		                    			System.out.println("Underage Detected");
		        						registerHandler.setForeground(new Color(255, 0, 0));
		        						registerHandler.setText("Unrealistic Age");
		        						break;
		                        	}
		
		                        } else {
									registerHandler.setForeground(new Color(255, 0, 0));
									System.out.println("[SYSTEM] Disagreed TOS Detected");
									System.out.println("[SYSTEM] Could not create user");
									registerHandler.setText("Please agree to the TOS");
									break;
		                        }

		                    } else {
		                    	System.out.println("[SYSTEM] No Gender Detected");
								registerHandler.setForeground(new Color(255, 0, 0));
								registerHandler.setText("Please select a gender");
		                    }
		                }
				
				

						return;
					}
					
					
				}
 			}
		});
	}
	public static void logoutOnClickHandler(JFrame dashboardFrame, JButton logoutButton) {
		logoutButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[SYSTEM] Logout detected");
				dashboardFrame.setVisible(false);
				dashboardFrame.dispose();
				LoginFrame.main(null);
			}
		});
	}
	
    public static void loginOnClickHandler(JFrame loginFrame, JButton button, JTextField usernameField, JPasswordField passwordField, JLabel fieldHandler) {
        button.addMouseListener(new MouseAdapter() {

            @Override
            // Take the inputs
            public void mousePressed(MouseEvent e) {
            	String username = usernameField.getText();
            	char[] passwordChars = passwordField.getPassword();
            	String password = new String(passwordChars);
            	System.out.println("[SYSTEM] Login Detected!");
                System.out.println("[SYSTEM] Username: " + username);
                System.out.println("[SYSTEM] Password: " + password);
            	
//                button.setContentAreaFilled(true);
//                button.setOpaque(true);
//                button.repaint();
                
                // HANDLE INPUTS
                // If there is no inputs for either username or password field
                if (username.length() == 0 || password.length() == 0) {
                	System.out.println("[SYSTEM] Empty username or password fields");
                	fieldHandler.setForeground(new Color(255, 0, 0));
                	fieldHandler.setText("Empty username or password fields");
                } else {
                	String[] usernames = ModelData.getUsernames();
                	String[] passwords = ModelData.getPasswords();
                	for (int i=0; i<usernames.length; i++) {
                		if (username.equals(usernames[i])) {
                			if (password.equals(passwords[i])) {
                            	System.out.println("[SYSTEM] Login Successful");
                            	loginFrame.setVisible(false);
                            	loginFrame.dispose();
                            	boolean authorizedAdmin = false;
								if (username.equals("admin")) {
                            		authorizedAdmin  = true;
                            	}
                            	DashboardFrame.main(null, username, i, authorizedAdmin); // is the userIndex
                            	return;
                			} else {
                            	System.out.println("[SYSTEM] Wrong password");
                            	fieldHandler.setForeground(new Color(255, 0, 0));
                            	fieldHandler.setText("Wrong password");
                            	return;

                			}
                		}
                	} // If the user does not exist
                	fieldHandler.setForeground(new Color(255, 0, 0));
                	System.out.println("[SYSTEM] Unregistered User");
                	fieldHandler.setText("Unregistered user");
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                button.repaint();
            }
        });
    }

}