import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/*
 * Custom ComboBox Class that searches foodNames for items that have its current value
 */
@SuppressWarnings("rawtypes")
public class Autocomplete extends JComboBox{

	

	static final long serialVersionUID = 4321421L;

	

	private final Search searchable;


	public Autocomplete(Search s)
	{

		super();

		this.searchable = s;

		setEditable(true);

		Component c = getEditor().getEditorComponent();

		if ( c instanceof JTextComponent )
		{

			final JTextComponent tc = (JTextComponent)c;
			tc.getDocument().addDocumentListener(new DocumentListener(){
				

			public void changedUpdate(DocumentEvent arg0) {}

			public void insertUpdate(DocumentEvent arg0) {
				update();
			}

			public void removeUpdate(DocumentEvent arg0) {
				update();
			}

				

			public void update()
			{
				SwingUtilities.invokeLater(new Runnable(){

				@SuppressWarnings("unchecked")
				@Override

				public void run() {
				
					List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));

					Set<String> foundSet = new HashSet<String>();

					for ( String s : founds ){

						foundSet.add(s.toLowerCase());
					}

					Collections.sort(founds);

					
					setEditable(false);
					removeAllItems();


					if ( !foundSet.contains( tc.getText().toLowerCase()) ){

						addItem( tc.getText() );

					}						

					for (String s : founds) {
						addItem(s);
					}

					setEditable(true);
					setPopupVisible(true);
					tc.requestFocus();

				}});
			}
		});
		tc.addFocusListener(new FocusListener(){

		@Override
		public void focusGained(FocusEvent arg0) {

			if ( tc.getText().length() > 0 ){

				setPopupVisible(true);
			}
		}

		@Override
		public void focusLost(FocusEvent arg0) {						

		}});

		}else{}
	}
}
