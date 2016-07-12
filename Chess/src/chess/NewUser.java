package chess;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class NewUser extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordVField;
	private JTextField textField;
	static NewUser frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setBounds(200, 200, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		Cancel.setBounds(200, 130, 124, 23);
		contentPane.add(Cancel);
		
		JLabel username = new JLabel("Username");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(10, 10, 81, 20);
		contentPane.add(username);
		
		JLabel lblPasswords = new JLabel("Password");
		lblPasswords.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswords.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswords.setBounds(10, 50, 81, 20);
		contentPane.add(lblPasswords);
		
		JLabel verifyPasswords = new JLabel("Verify Password");
		verifyPasswords.setHorizontalAlignment(SwingConstants.CENTER);
		verifyPasswords.setFont(new Font("Tahoma", Font.PLAIN, 16));
		verifyPasswords.setBounds(10, 90, 120, 20);
		contentPane.add(verifyPasswords);

		textField = new JTextField();
		textField.setBounds(150, 10, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 50, 175, 23);
		contentPane.add(passwordField);
		
		passwordVField = new JPasswordField();
		passwordVField.setBounds(150, 90, 175, 23);
		contentPane.add(passwordVField);
		
		JButton Submit = new JButton("Submit");
		Submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		Submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				  	if(textField.getText().length() != 0 && passwordField.getText().length() != 0 && passwordField.getText().equals(passwordVField.getText()))
				  	{
				  		/* 		If username already exist in database
				  		 *			JOptionPane.showMessageDialog(frame, "Username already exists");
				  		 *		else
				  		 *			Add username and password to database
				  		 */
				  		dispose();
				  		
				  	}
				  	else if(textField.getText().equals("") || passwordField.getText().equals("")){
				 		JOptionPane.showMessageDialog(frame, "Please provide Username and Password");
				  	}
				  	else if(!passwordField.getText().equals(passwordVField.getText()))
				 	{
				 		JOptionPane.showMessageDialog(frame, "Passwords do not match");
				 	}
			}
		});
		Submit.setBounds(10, 130, 124, 23);
		contentPane.add(Submit);
	}
}
