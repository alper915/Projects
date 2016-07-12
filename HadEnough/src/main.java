import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/* Alper Akgoz
 * CS338 Project - HadEnough?
 * 
 * August 16 2015
 */
@SuppressWarnings("serial")

public class main extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JPanel panel;
	
	
	private JTextField amtField;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField[] textFields;
	
	private JComboBox unitBox;
	private JComboBox comboBox_0;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	
	private Autocomplete comboBox_8;
	
	private JComboBox[] dayBoxes;
	
	private JCheckBox mondayBox;
	private JCheckBox tuesdayBox;
	private JCheckBox wednesdayBox;
	private JCheckBox thursdayBox;
	private JCheckBox fridayBox;
	private JCheckBox saturdayBox;
	private JCheckBox sundayBox;
	private JCheckBox[] weekBox;
	
	private JLabel lblFood;
	private JLabel lblAmount;
	private JLabel lblDays;
	
	private JButton addButton;
	private JButton clearField;
	private JButton clearTable;
	private JButton calcButton;
	
	private List<String> foodList;
	private List<String> ids;
	private Vector<String> header;
	private Vector<Map<String, Float>> totals;
	
	private JCheckBoxMenuItem chckbxmntmPdf;
	private JMenuItem mntmBackground;
	private JMenuItem mntmColor_1;
	private JMenuItem mntmBackground_1;
	private JMenu mnTextboxes;
	private JMenuItem mntmColor_2;
	private JMenuItem mntmBackground_2;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
	
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public main() throws IOException {
		setTitle("HadEnough?");
		
		setResizable(false);

		// Headers for the table
		header = new Vector<String>();
		header.add("Monday");
		header.add("Tuesday");
		header.add("Wednesday");
		header.add("Thursday");
		header.add("Friday");
		header.add("Saturday");
		header.add("Sunday");
		final Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		weekBox = new JCheckBox[7];
		dayBoxes = new JComboBox[7];
		textFields = new JTextField[7];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 22, 990, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 970, 363);
		panel.add(scrollPane);
		
		model = new DefaultTableModel(data, header);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		
		addCheckBoxes();
		addComboBoxes();
		addTextBoxes();
		
		
		
		//List of food names
		foodList  = new ArrayList<String>();
		ids = new ArrayList<String>();
		
		File foodFile = new File("foodNames.txt");
		FileInputStream fis = new FileInputStream(foodFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String current = "";
		while((current = br.readLine()) != null)
		{
			foodList.add(current);
		}
		
		//List of food ids
		File ndbFile = new File("foodNo.txt");
		FileInputStream ndb = new FileInputStream(ndbFile);
		BufferedReader ndbr = new BufferedReader(new InputStreamReader(ndb));
		
		current = "";
		while((current = ndbr.readLine()) != null)
		{
			ids.add(current);
		}	
		Search searchable = new Search(foodList);
		
		comboBox_8 = new Autocomplete(searchable);
			
		comboBox_8.setMaximumRowCount(15);
		comboBox_8.setBounds(1084, 11, 200, 20);
		contentPane.add(comboBox_8);

		
		lblFood = new JLabel("Food");
		lblFood.setHorizontalAlignment(SwingConstants.LEFT);
		lblFood.setBounds(1036, 14, 46, 14);
		contentPane.add(lblFood);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setBounds(1036, 45, 46, 14);
		contentPane.add(lblAmount);
		
		unitBox = new JComboBox();
		unitBox.setModel(new DefaultComboBoxModel(new String[] {"kg", "g", "lb"}));
		unitBox.setBounds(1224, 42, 60, 20);
		contentPane.add(unitBox);
		
		lblDays = new JLabel("Days");
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setBounds(1140, 98, 46, 20);
		contentPane.add(lblDays);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1034, 73, 250, 14);
		contentPane.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 97, 23);
		menuItems(menuBar);
		contentPane.add(menuBar);

		
		addButton = new JButton("Add");
		addButton.setToolTipText("Click this to add the selected food to selected days.");
		addButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_8.getSelectedItem() != null && amtField.getText() != null)
				{
					boolean isEmpty = true;
					for(int i = 0; i < 7; i++)
					{
						if(weekBox[i].isSelected())
						{
							isEmpty = false;
						}
					}
					
					if(foodList.contains(comboBox_8.getSelectedItem().toString()) && !isEmpty)
					{
						Vector<String> entry = new Vector<String>();
						
						for(int i = 0; i < 7; i++)
						{
							if(weekBox[i].isSelected())
							{
								String item = comboBox_8.getSelectedItem().toString() + "@" + Convert(Float.parseFloat(Filter(amtField.getText())), unitBox.getSelectedItem().toString());
								
								entry.add(item);
							}
							else
							{
								entry.add("");
							}
						}
						data.add(entry);
						model = new DefaultTableModel(data, header);
						table = new JTable(model);
						table.setFillsViewportHeight(true);
						table.getTableHeader().setReorderingAllowed(false);
						scrollPane.setViewportView(table);
					}
				}
			}
			});
		addButton.setBounds(1036, 373, 110, 23);
		contentPane.add(addButton);
		
		clearField = new JButton("Clear Fields");
		clearField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_8.setSelectedItem("");
				amtField.setText("");
				for(int i = 0; i < 7; i++)
				{
					weekBox[i].setSelected(false);
				}
			}
		});
		clearField.setFont(new Font("Tahoma", Font.BOLD, 11));
		clearField.setBounds(1174, 373, 110, 23);
		contentPane.add(clearField);
		
		clearTable = new JButton("Clear Table");
		clearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.clear();
				model = new DefaultTableModel(data, header);
				table = new JTable(model);
				table.setFillsViewportHeight(true);
				table.getTableHeader().setReorderingAllowed(false);
				scrollPane.setViewportView(table);
			}
		});
		clearTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		clearTable.setBounds(1174, 407, 110, 23);
		contentPane.add(clearTable);
		
		
		calcButton = new JButton("Calculate");
		calcButton.setToolTipText("Calculate the total nutrients in the table.");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.size() >= 1)
				{
					Calculate(data);
				}
			}
		});
		calcButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		calcButton.setBounds(1036, 407, 110, 23);
		contentPane.add(calcButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("<html>\r\nType the name of the food to start the search.<br>\r\nFirst letter must be capitalized.<br>\r\nYou can also type only the first letter and select the food from the drop down menu.<br>\r\nTotal amounts are represented in grams.<br>\r\n</html>");
		lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		lblNewLabel.setBounds(1252, 439, 32, 32);
		contentPane.add(lblNewLabel);

	}
	
	//Adds Checkboxes
	//Used to make main neater
	void addCheckBoxes()
	{
		mondayBox = new JCheckBox("Monday");
		mondayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mondayBox.setBounds(1036, 146, 97, 23);
		weekBox[0] = mondayBox;
		contentPane.add(mondayBox);
		
		tuesdayBox = new JCheckBox("Tuesday");
		tuesdayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tuesdayBox.setBounds(1036, 172, 97, 23);
		weekBox[1] = tuesdayBox;
		contentPane.add(tuesdayBox);
		
		wednesdayBox = new JCheckBox("Wednesday");
		wednesdayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wednesdayBox.setBounds(1036, 198, 110, 23);
		weekBox[2] = wednesdayBox;
		contentPane.add(wednesdayBox);
		
		thursdayBox = new JCheckBox("Thursday");
		thursdayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		thursdayBox.setBounds(1036, 224, 97, 23);
		weekBox[3] = thursdayBox;
		contentPane.add(thursdayBox);
		
		fridayBox = new JCheckBox("Friday");
		fridayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fridayBox.setBounds(1036, 250, 97, 23);
		weekBox[4] = fridayBox;
		contentPane.add(fridayBox);
		
		saturdayBox = new JCheckBox("Saturday");
		saturdayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saturdayBox.setBounds(1036, 276, 97, 23);
		weekBox[5] = saturdayBox;
		contentPane.add(saturdayBox);
		
		sundayBox = new JCheckBox("Sunday");
		sundayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sundayBox.setBounds(1036, 302, 97, 23);
		weekBox[6] = sundayBox;
		contentPane.add(sundayBox);
	}
	
	//Adds Comboboxes
	//Used to make main neater
	@SuppressWarnings("rawtypes")
	void addComboBoxes()
	{
		comboBox_0 = new JComboBox();
		comboBox_0.setBounds(10, 379, 130, 20);
		dayBoxes[0] = comboBox_0;
		comboBox_0.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        textField_0.setText( (totals.get(0).get(comboBox_0.getSelectedItem().toString())).toString());
				
		    }
		});
		panel.add(comboBox_0);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(150, 379, 130, 20);
		dayBoxes[1] = comboBox_1;
		
		comboBox_1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_1.setText( (totals.get(1).get(comboBox_1.getSelectedItem().toString())).toString()  );
		    }
		});
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(290, 379, 130, 20);
		dayBoxes[2] = comboBox_2;
		panel.add(comboBox_2);
		comboBox_2.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_2.setText( (totals.get(2).get(comboBox_2.getSelectedItem().toString())).toString()  );
		    }
		});
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(430, 379, 130, 20);
		dayBoxes[3] = comboBox_3;
		panel.add(comboBox_3);
		comboBox_3.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_3.setText( (totals.get(3).get(comboBox_3.getSelectedItem().toString())).toString()  );
		    }
		});
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(570, 379, 130, 20);
		dayBoxes[4] = comboBox_4;
		panel.add(comboBox_4);
		comboBox_4.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_4.setText( (totals.get(4).get(comboBox_4.getSelectedItem().toString())).toString()  );
		    }
		});
		
		comboBox_5 = new JComboBox();
		comboBox_5.setBounds(710, 379, 130, 20);
		dayBoxes[5] = comboBox_5;
		panel.add(comboBox_5);
		comboBox_5.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_5.setText( (totals.get(5).get(comboBox_5.getSelectedItem().toString())).toString()  );
		    }
		});
		
		comboBox_6 = new JComboBox();
		comboBox_6.setBounds(850, 379, 130, 20);
		dayBoxes[6] = comboBox_6;
		panel.add(comboBox_6);	
		comboBox_6.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	textField_6.setText( (totals.get(6).get(comboBox_6.getSelectedItem().toString())).toString()  );
		    }
		});
	}

	
	//Adds Textboxes
	//Used to make main neater
	void addTextBoxes()
	{
		amtField = new JTextField();
		amtField.setBounds(1084, 42, 130, 20);
		contentPane.add(amtField);
		amtField.setColumns(10);
	
		textField_0 = new JTextField();
		textField_0.setColumns(10);
		textField_0.setBounds(10, 405, 130, 20);
		panel.add(textField_0);
		textFields[0] = textField_0;
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 405, 130, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textFields[1] = textField_1;
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 405, 130, 20);
		panel.add(textField_2);
		textFields[2] = textField_2;
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(430, 405, 130, 20);
		panel.add(textField_3);
		textFields[3] = textField_3;
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(570, 405, 130, 20);
		panel.add(textField_4);
		textFields[4] = textField_4;
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(710, 405, 130, 20);
		panel.add(textField_5);
		textFields[5] = textField_5;
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(850, 405, 130, 20);
		panel.add(textField_6);
		textFields[6] = textField_6;
	}

	
	//Adds Menu Items
	//Used to make main neater
	void menuItems(final JMenuBar menuBar)
	{
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "HadEnough? v1.0.0\n" + "by Alper Akgoz\n" + "\nResources\n" + "National Institutes of Health\n" + "National Nutrient Database\n");
			}
		});
		mnNewMenu.add(mntmInfo);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mntmExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = JOptionPane.showInputDialog("Enter File Name(without extension):");
				Export(fileName);
				
			}
		});
		mnNewMenu.add(mntmExport);
		mnNewMenu.add(mntmClose);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnFont = new JMenu("Customize");
		mnSettings.add(mnFont);
		
		JMenu mnButtons = new JMenu("Buttons");
		mnFont.add(mnButtons);
		
		JMenuItem mntmColor = new JMenuItem("Text Color");
		mntmColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color a = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
				addButton.setForeground(a);
				clearField.setForeground(a);
				clearTable.setForeground(a);
				calcButton.setForeground(a);
				unitBox.setForeground(a);
				for(int i = 0; i < 7; i++)
				{
					dayBoxes[i].setForeground(a);
				}
				
				
			}
		});
		mnButtons.add(mntmColor);
		
		mntmBackground_1 = new JMenuItem("Background");
		mntmBackground_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color a = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
				addButton.setBackground(a);
				clearField.setBackground(a);
				clearTable.setBackground(a);
				calcButton.setBackground(a);
				unitBox.setBackground(a);
				for(int i = 0; i < 7; i++)
				{
					dayBoxes[i].setBackground(a);
				}
				
			}
		});
		mnButtons.add(mntmBackground_1);
		
		
		
		JMenu mnLabels = new JMenu("Labels");
		mnFont.add(mnLabels);
		
		mntmColor_1 = new JMenuItem("Text Color");
		mntmColor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color lc = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
				for(int i = 0; i < 7; i++)
				{
					weekBox[i].setForeground(lc);
				}
				lblFood.setForeground(lc);
				lblAmount.setForeground(lc);
				lblDays.setForeground(lc);
				
			}
		});
		mnLabels.add(mntmColor_1);
		
		mntmBackground = new JMenuItem("Background");
		mntmBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color bg = JColorChooser.showDialog(null, "Pick a Color", Color.GRAY);
				contentPane.setBackground(bg);
				panel.setBackground(bg);
				for(int i = 0; i < 7; i++)
				{
					weekBox[i].setBackground(bg);
				}
				menuBar.setBackground(bg);
				
			}
		});
		
		mnTextboxes = new JMenu("Textboxes");
		mnFont.add(mnTextboxes);
		
		mntmColor_2 = new JMenuItem("Text Color");
		mntmColor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color fg = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
				for(int i = 0; i < 7; i++)
				{
					textFields[i].setForeground(fg);
				}
				amtField.setForeground(fg);
				comboBox_8.setForeground(fg);
				
			}
		});
		mnTextboxes.add(mntmColor_2);
		
		mntmBackground_2 = new JMenuItem("Background");
		mntmBackground_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color bg = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
				for(int i = 0; i < 7; i++)
				{
					textFields[i].setBackground(bg);
				}
				amtField.setBackground(bg);
				comboBox_8.setBackground(bg);
			}
		});
		mnTextboxes.add(mntmBackground_2);
		mnFont.add(mntmBackground);
		
		JMenu mnExport = new JMenu("Export");
		mnSettings.add(mnExport);
		
		chckbxmntmPdf = new JCheckBoxMenuItem("PDF");
		mnExport.add(chckbxmntmPdf);
		
	}
	
	
	/*	Main Export Function
	 * 	Writes the Table Data to a Text File
	 *	If Settings -> Export -> PDF is selected then calls convertTextToPDF
	 */
	void Export(String name)
	{
		try {
			File outFile = new File((name + ".txt"));
			if(outFile.exists())
			{
				JOptionPane.showMessageDialog(null, "File Already Exists");
			}
			else
			{
				outFile.createNewFile();
				
				FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				
				String ntr;
				Float val;
				bw.write("\t\t\t\t" + "NUTRIENT TOTALS(g)\n");
				bw.newLine();
				if(comboBox_0.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Monday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_0.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_0.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_0.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_1.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Tuesday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_1.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_1.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_1.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_2.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Wednesday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_2.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_2.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_2.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_3.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Thursday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_3.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_3.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_3.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_4.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Friday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_4.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_4.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_4.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_5.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Saturday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_5.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_5.getModel().getElementAt(i);
						val = totals.get(0).get(comboBox_5.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}
				if(comboBox_6.getModel().getSize() > 1)
				{
					bw.write("\t\t" + "Sunday\n");
					bw.newLine();
					for(int i = 0; i < comboBox_6.getModel().getSize(); i++)
					{
						ntr = (String) comboBox_6.getModel().getElementAt(i);
						val = totals.get(6).get(comboBox_6.getModel().getElementAt(i).toString());
						
						bw.write(ntr + "\t" +  val.toString() + "\n");
						bw.newLine();
						
					}
				}				
				bw.close();
			
			}
			if(chckbxmntmPdf.isSelected())
			{
				convertTextToPDF(outFile);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Creates a PDF version of exported text file 
	 */
	public static void convertTextToPDF(File file) throws Exception  
	    {  
		 	
	        FileInputStream fis=null;  
	        DataInputStream in=null;  
	        InputStreamReader isr=null;  
	        BufferedReader br=null;  
	 
	        try {  
	 
	            Document pdfDoc = new Document();  
	            String output_file =file.getName().substring(0, file.getName().length()-4) + ".pdf"; 
	            
	            @SuppressWarnings("unused")
				PdfWriter writer=PdfWriter.getInstance(pdfDoc,new FileOutputStream(output_file));  
	            pdfDoc.open();  
	            pdfDoc.setMarginMirroring(true);  
	            pdfDoc.setMargins(36, 72, 108,180);  
	            pdfDoc.topMargin();  
	            
	            @SuppressWarnings("unused")
				Font myfont = new Font("Times New Roman", Font.PLAIN,12);    
	            pdfDoc.add(new Paragraph("\n"));  
	 
	            if(file.exists()){  
	 
	                fis = new FileInputStream(file);  
	                in = new DataInputStream(fis);  
	                isr=new InputStreamReader(in);  
	                br = new BufferedReader(isr);  
	                String strLine;  
	 
	                while ((strLine = br.readLine()) != null)  {  
	 
	                    Paragraph para =new Paragraph(strLine+"\n");  
	                    pdfDoc.add(para);  
	                }  
	            }     
	            else {  
	 
	                JOptionPane.showMessageDialog(null, ("File doesn't exists."));   
	            }  
	            pdfDoc.close();   
	        }  
	 
	        catch(Exception e) {  
	        	JOptionPane.showMessageDialog(null,"Exception: " + e.getMessage());  
	        }  
	        finally {  
	 
	            if(br!=null)  
	            {  
	                br.close();  
	            }  
	            if(fis!=null)  
	            {  
	                fis.close();  
	            }  
	            if(in!=null)  
	            {  
	                in.close();  
	            }  
	            if(isr!=null)  
	            {  
	                isr.close();  
	            }  
	 
	        }   
	    }  
	
	/*
	 * Checks if Amount Textbox is containing letters, symbols etc.
	 */
	String Filter(String amount)
	{
		char c;
		for(int s = 0; s < amount.length(); s++)
		{
			c = amount.charAt(s);
			if(c >= 58)
				return "0";
			else if(c <= 47)
				return "0";
		}
		return amount;
	}
	
	
	/*
	 * Retrieves the nutrient info from National Nutrient Database for each food item
	 * Calculates the total amount of of each nutrient for each day (represented in grams)
	 * and populates the comboBoxes of each day
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void Calculate(Vector<Vector<String>> data)
	{
		totals = new Vector<Map<String, Float>>();
		Vector<String> entry;
		Vector<String> food;
		Map<String,Float> total;
		
		Vector<String> com;
		for(int c = 0; c < 7; c++)
		{	
			total = new HashMap<String, Float>();
			food = new Vector<String>();
			com = new Vector<String>();
			for(int r = 0; r < data.size(); r++)
			{
				entry = data.get(r);
				food.add(entry.get(c));
			}
		
			int index;
			for(int j = 0; j < food.size(); j++)
			{
				if(food.get(j).toString().length() > 0)
				{
					try 
					{
						float amount = Float.parseFloat(food.get(j).split("@")[1]);
						index = foodList.indexOf(food.get(j).split("@")[0]);
			
						URL reportUrl = new URL("http://api.nal.usda.gov/usda/ndb/reports/?ndbno=" + ids.get(index) + "&type=b&format=json&api_key=RAgZWvqzBYNJwDfIWvmI8JxnOA8vDwWWe1ySSmEt");
						URLConnection connection = reportUrl.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
						String urlString = "";
						String current;
						
						while((current = in.readLine()) != null)
						{
							urlString += current;
						}
						
						JSONObject obj = new JSONObject(urlString);
						JSONObject reportResult = (JSONObject) obj.get("report");
						JSONObject foodResult = (JSONObject) reportResult.get("food");
						JSONArray nutrientsResult = (JSONArray) foodResult.get("nutrients");
						
						JSONObject nutrient;
						String unit;
						String name;
						float value;
						
						List<String> keys;
						for(int i = 0; i < nutrientsResult.length(); i++)
						{
							nutrient = (JSONObject) nutrientsResult.get(i);
							name = nutrient.get("name").toString();
							unit = nutrient.get("unit").toString();
							value = Float.parseFloat(nutrient.get("value").toString()) * (amount/100);
							
							keys = new ArrayList<String>( total.keySet() );
							if(unit.equals("g") || unit.equals("mg"))
							{
								
								if(keys.contains(name))
								{
									float oldVal = total.get(name);
									float newVal = value + oldVal;
									total.put(name, newVal);
								}
								else
								{
									com.add(name);
									total.put(name, value);
								}
							}
							else
							{
								if(!name.equals("Vitamin A, IU"))
								{
									value = (Convert(value, unit) * (amount/100));
								}
							}	
						}
					} 
					catch (Exception e){
						e.printStackTrace();}
				}
			}
			
			
			totals.add(total);
			dayBoxes[c].setModel(new DefaultComboBoxModel(com));
			}
		}

	/*
	 * Unit Conversion function used when retrieving nutrient info
	 * Default is reserved for micrograms
	 */
	float Convert(float value, String unit)
	{
		switch(unit)
		{
		case("kg"):
			return (value * 1000);
		case("lb"):
			return (value / 0.00220462f);
		case("mg"):
			return (value / 1000);
		case("g"):
			return value;
		default: 
			return (value / 1000000);
		} 
	}
}
