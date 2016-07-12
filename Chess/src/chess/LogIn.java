package chess;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/* 
 * Log In Interface
 * 
 */
@SuppressWarnings("serial")
public class LogIn extends JFrame {

	private JPanel contentPane;
	public final JTextField text;
	public static LogIn frame;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Panel.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text = new JTextField();
		text.setBounds(108, 54, 126, 20);
		contentPane.add(text);
		text.setColumns(10);
		text.setText("");
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 57, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 88, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton newUserButton = new JButton("Create New User");
		//newUserButton.setBackground(SystemColor.menu);
		newUserButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		newUserButton.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		newUserButton.setBounds(50, 220, 140, 25);
		newUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUser.main(null);
			}
		});
		contentPane.add(newUserButton);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Panel.background"));
		textArea.setBounds(10, 144, 224, 72);
		contentPane.add(textArea);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(108, 85, 126, 20);
		contentPane.add(passwordField);
		
		JButton login = new JButton("Log In");
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.addActionListener(new ActionListener() {
			Map<String,String> m = new HashMap<String, String>(); //holds username and password
			@SuppressWarnings({ "static-access", "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				try{
					URL oracle = new URL("https://www.cs.drexel.edu/~aa3268/userData");
			        URLConnection yc = oracle.openConnection();
			        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			        String inputLine = in.readLine();
			        String[] tokens = null;
			        String id;
			        String password;
			        
			        while(inputLine != null)
			        {
			        	tokens = inputLine.split(",");
			        	id = tokens[0].trim();
			        	password = tokens[3].trim();
			        	m.put(id, password);
			        	inputLine = in.readLine();
			        }	
			
			        in.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(!text.getText().equals("") && !passwordField.getText().equals(""))
				{
					if(!m.containsKey(text.getText())){
						textArea.setText("Username does not exist");
					}
					else if(m.get(text.getText()).equals(passwordField.getText()))
					{
						MainMenu k;
						try {
							k = new MainMenu(text.getText());
							String[] args = null;
							k.main(args, text.getText());
							frame.dispose();
						} catch(Exception e){
							e.printStackTrace();
						}
					}
					else
					{
						textArea.setText("Wrong password, try again");
						System.out.println(m.get(text.getText()));
					}
				}
				else if(text.getText().equals("") && !passwordField.getText().equals(""))
				{
					textArea.setText("Please Enter Username");
				}
				else if(passwordField.getText().equals("") && !text.getText().equals(""))
				{
					textArea.setText("Please Enter Password");
				}
				else
				{
					textArea.setText("Please Enter Username and Password");
				}
			}
		});
		login.setBounds(75, 120, 90, 25);
		contentPane.add(login);
		
	}
}
