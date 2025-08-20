package HelperFunctionClasses;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.table.DefaultTableModel;

import Auxilliary.ModelData;
import FrameClasses.CreateUserFrame;
import FrameClasses.DeleteUserFrame;
import FrameClasses.UpdateUserFrame;

public class OnClickEventHelperAdminFunctions {
	public static void onClickAdmin(JButton adminButton, DefaultTableModel model, JTable table) {
		adminButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ModelData.updateTable(model, table);
			}
		});
	}
	
	public static void onClickCreate(JButton createButton, DefaultTableModel model, JTable table) {
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[ADMIN] Creation Mode");
				CreateUserFrame.main(null, model, table);
			}
		});
	}
	
	public static void onClickUpdate(JButton updateButton, DefaultTableModel model, JTable table) {
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[ADMIN] Update Mode");
				UpdateUserFrame.main(null, model, table);
			}
		});
	}
	
	public static void onClickDelete(JButton deleteButton, DefaultTableModel model, JTable table) {
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[ADMIN] Deletion Mode");
				DeleteUserFrame.main(null, model, table);
			}
		});
	}
	
	public static void onClickDeleteUser(JButton deleteUserButton, JLabel deleteHandlerLabel, JList usersList, DefaultListModel<String> listModel, DefaultTableModel model, JTable table) {
		deleteUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int[] unregisterUsersList = usersList.getSelectedIndices();
				for (int i=0; i<unregisterUsersList.length; i++) {
					if (unregisterUsersList[i] == 0) {
						System.out.println("[SYSTEM] Cannot unregister the admin.");
						deleteHandlerLabel.setForeground(new Color(255, 0, 0));
						deleteHandlerLabel.setText("Cannot unregister the admin");
						break;
					} else {
						System.out.println("[SYSTEM] Unregistering Users");
						ModelData.unregisterUser(unregisterUsersList[i]);
						System.out.println("[SYSTEM] Updating tables...");
				        listModel.remove(unregisterUsersList[i]);
						ModelData.updateTable(model, table);
						deleteHandlerLabel.setForeground(new Color(0, 255, 0));
						deleteHandlerLabel.setText("Succesfully Unregistered the Users");
					}

				}
			}
		});
	}
	
	public static void onClickCreateUser(JButton createUserButton, JTextField fullNameField, JTextField usernameField, JTextField passwordField, JTextField balanceField, DefaultTableModel model, JTable table, JLabel userCreationHandler, ButtonGroup genderGroup, JSpinner ageSpinner) {
		createUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				String fullname = fullNameField.getText();
				String username = usernameField.getText();
				String password = passwordField.getText();
				String balance = balanceField.getText();
				System.out.println("[SYSTEM] Adding " + username + "to the system");
				// Check first for empty fields
				if (fullname.isBlank() || username.isBlank() || password.isBlank() || balance.isBlank()) { // Check for blank fiels
					System.out.println("[SYSTEM] Empty Fields Detected");
					userCreationHandler.setForeground(new Color(255, 0, 0));
					userCreationHandler.setText("Empty fields");
					return;
				}
				if (!ModelData.checkDuplicates(fullname, username)) {
	                for (Enumeration<AbstractButton> buttons = genderGroup.getElements(); buttons.hasMoreElements(); ) { // Check all radiobuttons
	                    AbstractButton button = buttons.nextElement();
	                    if (button.isSelected()) {
	                    	int age = (Integer) ageSpinner.getValue(); // The admin can create account bypassing age restrictions	                 
	                    	ModelData.registerUser(username, password, fullname, balance, button.getText(), Integer.toString(age));
	        				ModelData.updateTable(model, table);
	        				userCreationHandler.setForeground(new Color(0, 255, 0));
	        				userCreationHandler.setText("User added by Admin");
	        				return;
	                    } else {
	    					userCreationHandler.setForeground(new Color(255, 0, 0));
	    					userCreationHandler.setText("Please select a gender");
	                    }
	                }
			

				return;
				} else {
					userCreationHandler.setForeground(new Color(255, 0, 0));
					userCreationHandler.setText("User already exists dumbass");
					return;
				}
			}
		});
	}
	
	public static void onClickUpdateUser(JButton updateButton, int userIndex, JTextField usernameField, JTextField fullNameField, JTextField passwordField, ButtonGroup genderButtonGroup, ButtonGroup accountTypeButtonGroup, JSpinner balanceSpinner, JSpinner ageSpinner, JSpinner transactionCountSpinner, JLabel updateUserHandlerLabel, DefaultTableModel model, JTable table) {
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[SYSTEM] Updating user...");
				
				// New info from textfields
				String newUsername = usernameField.getText();
				String newFullName = fullNameField.getText();
				String newPassword = passwordField.getText();
				
				// New info from radio
				for (Enumeration<AbstractButton> buttons = genderButtonGroup.getElements(); buttons.hasMoreElements(); ) { // Check all radiobuttons
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                    	String newGender = button.getText();
                    	ModelData.updateGender(userIndex, newGender);
                    	}
                    }
				
				for (Enumeration<AbstractButton> buttons = accountTypeButtonGroup.getElements(); buttons.hasMoreElements(); ) { // Check all radiobuttons
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                    	String newAccountType = button.getText();
                    	ModelData.updateAccountType(userIndex, newAccountType);
                    	}
                    }
				
				// New info from spinners
				String newAge = Integer.toString((Integer) ageSpinner.getValue()); // advance shit XD
				int newTransactionCount = (Integer) transactionCountSpinner.getValue();
				String newBalance = Integer.toString((Integer) balanceSpinner.getValue());
				
				// Apply all the changes
				ModelData.updateUsername(userIndex, newUsername);
				ModelData.updateFullName(userIndex,  newFullName);
				ModelData.updatePassword(userIndex, newPassword);
				ModelData.updateAge(userIndex, newAge);
				ModelData.updateBalance(userIndex, newBalance);
				ModelData.updateTransactionCounts(userIndex, newTransactionCount);
				System.out.println("[SYSTEM] Changes applied");
				updateUserHandlerLabel.setForeground(new Color(0, 255, 0));
				updateUserHandlerLabel.setText("User updated!");
				ModelData.updateTable(model, table);
			}
		});
	}
}
