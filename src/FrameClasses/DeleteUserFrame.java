package FrameClasses;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Auxilliary.ModelData;
import CustomComponents.adminButtons;
import HelperFunctionClasses.OnClickEventHelperAdminFunctions;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DeleteUserFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, DefaultTableModel model, JTable table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUserFrame window = new DeleteUserFrame(model, table);
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
	public DeleteUserFrame(DefaultTableModel model, JTable table) {
		initialize(model, table);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DefaultTableModel model, JTable table) {
		frame = new JFrame("[ADMIN] Delete user");
		frame.getContentPane().setBackground(new Color(35, 35, 35));
		frame.getContentPane().setForeground(new Color(35, 35, 35));
		frame.setBounds(100, 100, 500, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton delete_user_button = new adminButtons("DELETE USER", 12);
		delete_user_button.setBounds(145, 494, 190, 46);
		delete_user_button.setForeground(new Color(59, 67, 95));
		delete_user_button.setFont(new Font("Segoe UI", Font.BOLD, 23));
		frame.getContentPane().add(delete_user_button);
		
		JLabel create_note_label = new JLabel("Admin Mode: You're deleting a user");
		create_note_label.setForeground(new Color(255, 255, 0));
		create_note_label.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		create_note_label.setBounds(0, 10, 486, 18);
		create_note_label.setVerticalAlignment(SwingConstants.CENTER);
		create_note_label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(create_note_label);
        // Use DefaultListModel for dynamic changes
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String[] fullNames = ModelData.getFullNames();    
        for (int i=0; i<fullNames.length; i++) {
        	listModel.addElement(i+1 + ". " + fullNames[i]);
        }
        JList<String> users_list = new JList<>(listModel);
        users_list.setForeground(new Color(255, 255, 0));
        users_list.setBackground(new Color(35, 35, 35));
        users_list.setFont(new Font("Segoe UI", Font.BOLD, 15));
        JScrollPane scrollPane = new JScrollPane(users_list);
        scrollPane.setBounds(0, 44, 486, 421); 
		frame.getContentPane().add(scrollPane);
		

		
		JLabel unregister_handler_label = new JLabel("");
		unregister_handler_label.setVerticalAlignment(SwingConstants.CENTER);
		unregister_handler_label.setHorizontalAlignment(SwingConstants.CENTER);
		unregister_handler_label.setForeground(Color.YELLOW);
		unregister_handler_label.setFont(new Font("Segoe UI", Font.BOLD, 10));
		unregister_handler_label.setBounds(0, 480, 486, 18);
		frame.getContentPane().add(unregister_handler_label);
		
		OnClickEventHelperAdminFunctions.onClickDeleteUser(delete_user_button, unregister_handler_label, users_list, listModel, model, table);
	}
}
