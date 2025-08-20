package HelperFunctionClasses;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Auxilliary.ModelData;

public class OnClickEventHelperCoreFunctions {
	public static void withdrawOnClick(JButton withdrawButton, JLabel withdrawAmount, int userIndex) {
		withdrawButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String user_balance_amount = ModelData.getBalances()[userIndex];
				int user_balance_amount_int = Integer.parseInt(user_balance_amount);
				String user_balance_amount_formatted = Integer.toString(user_balance_amount_int);
				withdrawAmount.setText(ModelData.formatBalance(user_balance_amount_formatted));
			}
			}); 
		}
	
	public static void depositOnClick(JButton depositButton, JTextField withdrawAmount, int userIndex, JLabel balanceLabel) {
		depositButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("[SYSTEM] DEPOSIT MODE");
				int depositAmount = Integer.parseInt(withdrawAmount.getText());
				String depositAmountStrFormatted = ModelData.formatBalance(Integer.toString(depositAmount));
				System.out.println("[SYSTEM] Depositing: " + depositAmount);
				int balance = Integer.parseInt(ModelData.getBalances()[userIndex]);
				int newBalance  = depositAmount + balance;
				ModelData.updateBalance(userIndex, Integer.toString(newBalance));
				// Update the balance
				balanceLabel.setText(ModelData.formatBalance(Integer.toString(newBalance)));
				ModelData.updateTransactionCount(userIndex);
				ModelData.addTransaction("[DEPOSIT] " + ModelData.getUsernames()[userIndex] + " - " + depositAmountStrFormatted);
			}
			}); 
		}
	
	public static void transferOnclick(JButton transferButton, JTextField transferRecipientField, JTextField transferAmountField, int userIndex, JLabel transferHandlerLabel) {
		transferButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String transferRecipient = transferRecipientField.getText();
				String transferAmount = transferAmountField.getText();
				String transferAmountFormatted = ModelData.formatBalance(transferAmount);
				// Check whether the user exists
				int recipientUserIndex = ModelData.getUser(transferRecipient);
				if (recipientUserIndex >= 0) {
					System.out.println("[SYSTEM] Recipient Found");
					// Add money to the recipient
					System.out.println("[SYSTEM] Transferring " + ModelData.formatBalance(transferAmount) + " to " + transferRecipient);
					if (Integer.parseInt(ModelData.getBalances()[userIndex]) >= Integer.parseInt(transferAmount)) {
						System.out.println("[SYSTEM] User has enough money for Money Transfer");
						try {
							ModelData.reduceBalance(userIndex, transferAmount); // Reduce the balance of the sender
							ModelData.addBalance(recipientUserIndex, transferAmount); // Add money to the recipient
														System.out.println("[SYSTEM] Money Transfer Successful");
							transferHandlerLabel.setForeground(new Color(0, 255, 0));
							transferHandlerLabel.setText("Money Transfer Successful");
							ModelData.addTransaction("[Transfer] " + ModelData.getUsernames()[userIndex] + " to " + transferRecipient + " " + transferAmountFormatted);
						} catch (Exception transferError) {
							System.out.println("[SYSTEM] Money Transfer Failed");
							transferError.printStackTrace();
						}
					} else {
						System.out.println("[SYSTEM] Money Transfer Failed");
						transferHandlerLabel.setForeground(new Color(255, 0, 0));
						transferHandlerLabel.setText("Not Enough Balance");
					}
					
				} else {
					System.out.println("[SYSTEM] Recipient Not Found");
					transferHandlerLabel.setForeground(new Color(255, 0, 0));
					transferHandlerLabel.setText("Recipient Not Found");
				}
			}
		});
	}
}
