package chess;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	static MainMenu frame;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainMenu(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public MainMenu(String username) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Invite");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				ButtonBorder k = new ButtonBorder();
				String[] args = null;
				k.main(args);
			}
		});
		btnNewButton.setBounds(277, 27, 89, 49);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] args = null;
				LogIn.main(args);
				dispose();
			}
		});
		
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> headers = new Vector<String>();
		
		headers.add("Username");
		headers.add("Wins");
		headers.add("Losses");
		headers.add("In Game");
		
		DefaultTableModel t = new DefaultTableModel(data, headers);
		
		btnNewButton_1.setBounds(277, 87, 89, 49);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 257, 239);
		contentPane.add(scrollPane);
		
		table = new JTable(t);
		scrollPane.setViewportView(table);
	}
}
