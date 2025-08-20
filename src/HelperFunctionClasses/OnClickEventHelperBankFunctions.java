package HelperFunctionClasses;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Auxilliary.ModelData;

public class OnClickEventHelperBankFunctions {
	public static void withdrawAmountOnClick(JButton withdrawButton, JLabel balanceLabel, JTextField withdrawAmountField, JLabel withdrawHandler, int userIndex) {
		withdrawButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String[] balances = ModelData.getBalances();
				String withdrawAmountStr = withdrawAmountField.getText();
				String withdrawAmountStrFormatted = ModelData.formatBalance(withdrawAmountStr);
				int withdrawAmount = Integer.parseInt(withdrawAmountStr);
				int balance = Integer.parseInt(balances[userIndex]);
				int remainingBalance;
				// Process the transaction
				if (balance >= withdrawAmount) { // If you have enough balance
					System.out.println("[SYSTEM] Withdrawal Success");
					ModelData.updateTransactionCount(userIndex);
					withdrawHandler.setForeground(new Color(0, 255, 0));
					withdrawHandler.setText("Withdrawal successful");
					remainingBalance = balance - withdrawAmount;
					String remainingBalanceStr = Integer.toString(remainingBalance);
					
					// Format first
					String remainingBalanceStrFormatted = ModelData.formatBalance(remainingBalanceStr);
					balanceLabel.setText(remainingBalanceStrFormatted);
					ModelData.updateBalance(userIndex, remainingBalanceStr);
					System.out.println("[SYSTEM] Remaining balance: " + remainingBalanceStr);
					ModelData.addTransaction("[WITHDRAW] " + ModelData.getUsernames()[userIndex] + " - " + withdrawAmountStrFormatted);
				} else { // Not enough balance
					System.out.println("[SYSTEM] Withdrawal Failure");
					System.out.println("[SYSTEM] Not enough balance");
					withdrawHandler.setForeground(new Color(255, 0, 0));
					withdrawHandler.setText("Not enough Balance");
				}
			}
		});
	}
}
