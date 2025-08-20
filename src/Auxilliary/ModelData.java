package Auxilliary;

import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import HelperFunctionClasses.StringFormatters;

public class ModelData {
	// NOTE: We prefer using string for balances, since it's easier to format
	// and most Swing components use string for arguments. 
	// FOR USER DATA (dummy data)
	private static String[] usernames = {"admin", "Justin", "Jhen", "Nathan", "Sarah"};
	private static String[] passwords = {"admin", "justinbahogbalat", "saturndeeznuts", "jejemonako123", "IloveShrek123"};
	private static String[] balances = {"1000", "99", "99", "99", "2000000"};
	private static String[] fullNames = {"Khen David F. Famadico", "Jutsin Rainier Magante", "Jhen Kames M. Saturnino", "Nathaneel H. Balauag", "Sarah Z. Duterte"};
	private static String[] genders = {"Male", "Male", "Male", "Female", "Female"};
	private static String[] accountTypes = {"Premium", "Premium", "Premium", "Premium", "Basic"};
	private static String[] ages = {"19", "19", "20", "69", "46"};
	private static String[] accountCreationDates = {"Before The Gods", "Medieval Era", "Dark Age", "Gen Z", "War on Drugs"};
	private static int[] numberOfTransactions = {23, 6, 9, 102, 2000};
	
	// FOR TRANSACTION HISTORY
	private static String[] transactionHistory = {};
	
	// Get values
	public static String[] getTransactionHistory() {
		return transactionHistory;
	}
	public static String[] getUsernames() {
		return usernames;
	}
	
	public static String[] getPasswords() {
		return passwords;
	}
	
	public static String[] getAges() {
		return ages;
	}
	
	public static String[] getGenders() {
		return genders;
	}
	
	public static String[] getAccountTypes() {
		return accountTypes;
	}
	
	public static String[] getAccountCreationDates() {
		return accountCreationDates;
	}
	
	public static String[] getBalances() {
		return balances;
	}
	
	public static String[] getFullNames() {
		return fullNames;
	}
	
	public static int[] getAccountTransactionCounts() {
		return numberOfTransactions;
	}
	public static int getUser(String username) {
		for(int i=0; i<usernames.length; i++) {
			if (username.trim().equals(usernames[i])) {
				return i;
			}
		} return -1;
	}
	
	public static boolean checkDuplicates(String fullName, String username) {
		boolean duplicate = false;
		System.out.println("[SYSTEM] Checking for duplicates");
		for (int i=0; i<usernames.length; i++) {
			if (username.equals(usernames[i]) || fullName.equals(fullNames[i])) {
				System.out.println("[SYSTEM] Duplicate Found!");
				System.out.println("[SYSTEM] Cannot add user");
				duplicate = true;
			}
		} return duplicate;
	}
	
	// Update values for user data
	public static void updateBalance(int userIndex, String newBalance) {
		balances[userIndex] = newBalance;
	}
	
	public static void updateUsername(int userIndex, String newUsername) {
		usernames[userIndex] = newUsername;
	}
	
	public static void updatePassword(int userIndex, String newPassword) {
		passwords[userIndex] = newPassword;
	}
	public static void updateFullName(int userIndex, String newFullName) {
		fullNames[userIndex] = newFullName;
	}
	
	public static void updateGender(int userIndex, String newGender) {
		genders[userIndex] = newGender;
	}
	
	public static void updateAge(int userIndex, String newAge) {
		ages[userIndex] = newAge;
	}
	
	public static void updateAccountType(int userIndex, String newAccountType) {
		accountTypes[userIndex] = newAccountType;
	}
	
	public static void updateTransactionCounts(int userIndex, int newTransactionCount) {
		numberOfTransactions[userIndex] = newTransactionCount;
	}
	public static void addBalance(int userIndex, String additionalBalance) {
		int newBalance = Integer.parseInt(balances[userIndex]) + Integer.parseInt(additionalBalance);
		balances[userIndex] = Integer.toString(newBalance);
	}
	
	public static void reduceBalance(int userIndex, String reducedBalance) {
		int newBalance = Integer.parseInt(balances[userIndex]) - Integer.parseInt(reducedBalance);
		balances[userIndex] = Integer.toString(newBalance);
	}
	
	public static void updateNumOfTransactions(int userIndex) {
		String user = usernames[userIndex];
		numberOfTransactions[userIndex]++;
		int transactionCount = numberOfTransactions[userIndex];
		System.out.println("[SYSTEM] The user " + user + " now has " + transactionCount + " transactions.");
		
	}
	
	public static void updateTransactionCount(int userIndex) {
		numberOfTransactions[userIndex]++;
	}
	
	// END OF USER FUNCTIONS
	
	// Update transaction
	public static void addTransaction(String username, String transactionAmount, String transactionMode) {
		
	}
	// END OF TRANSACTION HISTORY FUNCTIONS
	
	// Core Functions
	public static String[] appendtoArray(String[] original, String data) {
        String[] newArray = Arrays.copyOf(original, original.length + 1);
        newArray[newArray.length - 1] = data;
        return newArray;
	}
	
	public static int[] appendtoIntArray(int[] original) {
        int[] newArray = Arrays.copyOf(original, original.length + 1);
        newArray[newArray.length - 1] = 0;
        return newArray;
	}

	
    public static String[] removeStringFromArray(String[] array, int indexToRemove) {
        if (array == null || indexToRemove < 0 || indexToRemove >= array.length) {
            return array; // Return unchanged if index is invalid
        }

        String[] result = new String[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != indexToRemove) {
                result[j++] = array[i];
            }
        }
        return result;
    }
    
    public static int[] removeIntegerFromArray(int[] array, int indexToRemove) {
        if (array == null || indexToRemove < 0 || indexToRemove >= array.length) {
            return array; // Return unchanged if index is invalid
        }

        int[] result = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != indexToRemove) {
                result[j++] = array[i];
            }
        }
        return result;
    }

	public static void registerUser(String username, String password, String fullName, String balance, String gender, String age) {
        // Create a new array with +1 size
        usernames = appendtoArray(usernames, username);
        passwords = appendtoArray(passwords, password);
        fullNames = appendtoArray(fullNames, StringFormatters.toTitleCase(fullName));
        balances = appendtoArray(balances, balance);
        numberOfTransactions = appendtoIntArray(numberOfTransactions);
        accountCreationDates = appendtoArray(accountCreationDates, DateData.getDate());
        accountTypes = appendtoArray(accountTypes, "Basic");
        genders = appendtoArray(genders, gender);
        ages = appendtoArray(ages, age);
	}
	
	public static void unregisterUser(int userIndex) {
		System.out.println("[SYSTEM] Unregistering " + usernames[userIndex]);
		usernames = removeStringFromArray(usernames, userIndex);
		passwords = removeStringFromArray(passwords, userIndex);
		fullNames = removeStringFromArray(fullNames, userIndex);
		balances = removeStringFromArray(balances, userIndex);
		numberOfTransactions = removeIntegerFromArray(numberOfTransactions, userIndex);
		accountCreationDates = removeStringFromArray(accountCreationDates, userIndex);
		accountTypes = removeStringFromArray(accountTypes, userIndex);
		genders = removeStringFromArray(genders, userIndex);
		ages = removeStringFromArray(ages, userIndex);
	}
	
	
	public static void addTransaction(String transactionInvoice) {
		transactionHistory = appendtoArray(transactionHistory, transactionInvoice);
	}
	public static void deleteUser(String username) {}
	// Delete the user along with its parallel datas
	
	// END OF CORE FUNCTIONS
	
	// TABLE FUNCTIONS
	public static String formatBalance(String balance) {
		double balanceInt = Double.parseDouble(balance);
        Locale philippines = new Locale("en", "PH");
        NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(philippines);
        String formattedBalance = pesoFormat.format(balanceInt);
		
		return formattedBalance;
	}
	// Update the table
	public static void updateTable(DefaultTableModel model, JTable table) {
		// update the table
		System.out.println("[SYSTEM] Updating tables...");
		// Clear the row first
		model.setRowCount(0);
//		table.getColumnModel().getColumn(0).setPreferredWidth(15);
//		table.getColumnModel().getColumn(0).setMinWidth(-15); // Why is this not working >:(
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(7).setPreferredWidth(0);
		table.getColumnModel().getColumn(8).setPreferredWidth(0);
		table.getColumnModel().getColumn(9).setPreferredWidth(0);
		table.setFont(new Font("Segoe UI", Font.BOLD, 13));
		for (int i=0; i<usernames.length; i++) {
//			System.out.println("[SYSTEM] Adding " + usernames[i]);
			model.addRow(new Object[] {i, accountCreationDates[i], genders[i], fullNames[i], usernames[i], passwords[i], formatBalance(balances[i]), ages[i], accountTypes[i], numberOfTransactions[i]});
		}

	}
	
	// END OF TABLE FUNCTIONS
}
