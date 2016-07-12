package chess;


/*
 * Piece class
 * Each piece has a color, an identifier
 * positions it can move to, and a button that represents it
 * 
 */
import java.util.Vector;

import javax.swing.JButton;

public class Piece {
	
	public String color;
	public String ident;
	public JButton button;
	public Vector<Position> available; //This will be used to modify the board to highlight available positions and disable others
	
	

}
