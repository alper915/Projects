//Comment

package chess;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ButtonBorder extends JPanel {
	  private static final int N = 8;
	  private static final int SIZE = 76;
	  static JFrame f;
	  public char turn = 'W';
	  Position[][] p = new Position[8][8];
	  
	  Position one;
	  Position two;
	  
	  boolean cancel = false;
	  public ButtonBorder() {
		  //GridLayout gridLayout = new GridLayout(N, N);
		 
		 this.setPreferredSize(new Dimension(N * SIZE, N * SIZE));
		
		setLayout(new GridLayout(0, 8, 8, 8));
		
		Piece b;
		//Position s;
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				p[x][y] = new Position();
			}
		}
		
		JButton pos_00 = new JButton("");
		pos_00.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_rook.png")));
		add(pos_00);
		b = new Piece();
		b.button = pos_00;
		b.color = "Black";
		b.ident = "Rook";
		
		p[0][0].x = 0;
		p[0][0].y = 0;
		p[0][0].p = b;
		
		pos_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				PossibleMoves(0,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
			    
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_01 = new JButton("");
		pos_01.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_knight.png")));
		add(pos_01);
		b = new Piece();
		b.button = pos_01;
		b.color = "Black";
		b.ident = "Knight";
		
		p[0][1].x = 1;
		p[0][1].y = 0;
		p[0][1].p = b;
		
		pos_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_02 = new JButton("");
		pos_02.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_bishop.png")));
		add(pos_02);
		b = new Piece();
		b.button = pos_02;
		b.color = "Black";
		b.ident = "Bishop";
		
		p[0][2].x = 2;
		p[0][2].y = 0;
		p[0][2].p = b;
		
		pos_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});

		JButton pos_03 = new JButton("");
		pos_03.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_queen.png")));
		add(pos_03);
		b = new Piece();
		b.button = pos_03;
		b.color = "Black";
		b.ident = "Queen";
		
		p[0][3].x = 3;
		p[0][3].y = 0;
		p[0][3].p = b;
		
		pos_03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_04 = new JButton("");
		pos_04.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_king.png")));
		add(pos_04);
		b = new Piece();
		b.button = pos_04;
		b.color = "Black";
		b.ident = "King";
		
		p[0][4].x = 4;
		p[0][4].y = 0;
		p[0][4].p = b;
		
		pos_04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_05 = new JButton("");
		pos_05.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_bishop.png")));
		add(pos_05);
		b = new Piece();
		b.button = pos_05;
		b.color = "Black";
		b.ident = "Bishop";
		
		p[0][5].x = 5;
		p[0][5].y = 0;
		p[0][5].p = b;
		
		pos_05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
	
		JButton pos_06 = new JButton("");
		pos_06.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_knight.png")));
		add(pos_06);
		b = new Piece();
		b.button = pos_06;
		b.color = "Black";
		b.ident = "Knight";
		
		p[0][6].x = 6;
		p[0][6].y = 0;
		p[0][6].p = b;
		
		pos_06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_07 = new JButton("");
		pos_07.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_rook.png")));
		add(pos_07);
		b = new Piece();
		b.button = pos_07;
		b.color = "Black";
		b.ident = "Rook";
		
		p[0][7].x = 7;
		p[0][7].y = 0;
		p[0][7].p = b;
		
		pos_07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(0,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_10 = new JButton("");
		pos_10.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_10);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_10;
		
		p[1][0].x = 0;
		p[1][0].y = 1;
		p[1][0].p = b;
		
		pos_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_11 = new JButton("");
		pos_11.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_11);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_11;
		
		p[1][1].x = 1;
		p[1][1].y = 1;
		p[1][1].p = b;
		
		pos_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
	
		JButton pos_12 = new JButton("");
		pos_12.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_12);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_12;
		
		p[1][2].x = 2;
		p[1][2].y = 1;
		p[1][2].p = b;
		
		pos_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_13 = new JButton("");
		pos_13.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_13);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_13;
		
		p[1][3].x = 3;
		p[1][3].y = 1;
		p[1][3].p = b;
		
		
		pos_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_14 = new JButton("");
		pos_14.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_14);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_14;
		
		p[1][4].x = 4;
		p[1][4].y = 1;
		p[1][4].p = b;
		
		pos_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
	
		JButton pos_15 = new JButton("");
		pos_15.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_15);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_15;
		
		p[1][5].x = 5;
		p[1][5].y = 1;
		p[1][5].p = b;
		
		pos_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
	
		JButton pos_16 = new JButton("");
		pos_16.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_16);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_16;
		
		p[1][6].x = 6;
		p[1][6].y = 1;
		p[1][6].p = b;
		
		pos_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_17 = new JButton("");
		pos_17.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_pawn.png")));
		add(pos_17);
		b = new Piece();
		b.ident = "Pawn";
		b.color = "Black";
		b.button = pos_17;
		
		p[1][7].x = 7;
		p[1][7].y = 1;
		p[1][7].p = b;
		
		pos_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(1,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteB = checkPromotionBlack(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				boolean staleMateW = isStaleMate(kingW, p, "White", "Black");
				boolean staleMateB = isStaleMate(kingB, p, "Black", "White");
				if(staleMateW == true || staleMateB == true){
					displayEndGame("Draw!");
				}
				}
			});
	
		
		JButton pos_20 = new JButton("");
		pos_20.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_20);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_20;
		
		p[2][0].x = 0;
		p[2][0].y = 2;
		p[2][0].p = b;
		
		
		pos_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_21 = new JButton("");
		pos_21.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_21);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_21;
		
		p[2][1].x = 1;
		p[2][1].y = 2;
		p[2][1].p = b;
		
		
		pos_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_22 = new JButton("");
		pos_22.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_22);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_22;
		
		p[2][2].x = 2;
		p[2][2].y = 2;
		p[2][2].p = b;
		
		pos_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_23 = new JButton("");
		pos_23.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_23);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_23;
		
		p[2][3].x = 3;
		p[2][3].y = 2;
		p[2][3].p = b;
		
		pos_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_24 = new JButton("");
		pos_24.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_24);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_24;
		
		p[2][4].x = 4;
		p[2][4].y = 2;
		p[2][4].p = b;
		
		pos_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_25 = new JButton("");
		pos_25.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_25);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_25;
		
		p[2][5].x = 5;
		p[2][5].y = 2;
		p[2][5].p = b;
		
		pos_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_26 = new JButton("");
		pos_26.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_26);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_26;
		
		p[2][6].x = 6;
		p[2][6].y = 2;
		p[2][6].p = b;
		
		pos_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_27 = new JButton("");
		pos_27.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_27);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_27;
		
		p[2][7].x = 7;
		p[2][7].y = 2;
		p[2][7].p = b;
		
		
		pos_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(2,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_30 = new JButton("");
		pos_30.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_30);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_30;
	
		p[3][0].x = 0;
		p[3][0].y = 3;
		p[3][0].p = b;
		
		
		pos_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_31 = new JButton("");
		pos_31.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_31);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_31;
		
		p[3][1].x = 1;
		p[3][1].y = 3;
		p[3][1].p = b;
		
		pos_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_32 = new JButton("");
		pos_32.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_32);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_32;
		
		p[3][2].x = 2;
		p[3][2].y = 3;
		p[3][2].p = b;
		
		pos_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_33 = new JButton("");
		pos_33.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_33);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_33;
		
		p[3][3].x = 3;
		p[3][3].y = 3;
		p[3][3].p = b;
		
		pos_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_34 = new JButton("");
		pos_34.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_34);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_34;
		
		p[3][4].x = 4;
		p[3][4].y = 3;
		p[3][4].p = b;
		
		pos_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_35 = new JButton("");
		pos_35.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_35);
		b = new Piece();
		b.ident = "Empty";
		b.color = "Empty";
		b.button = pos_35;
		
		p[3][5].x = 5;
		p[3][5].y = 3;
		p[3][5].p = b;
		
		pos_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_36 = new JButton("");
		pos_36.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_36);
		b = new Piece();
		b.button = pos_36;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[3][6].x = 6;
		p[3][6].y = 3;
		p[3][6].p = b;
		
		pos_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_37 = new JButton("");
		pos_37.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_37);
		b = new Piece();
		b.button = pos_37;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[3][7].x = 7;
		p[3][7].y = 3;
		p[3][7].p = b;
		
		pos_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(3,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_40 = new JButton("");
		pos_40.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_40);
		b = new Piece();
		b.button = pos_40;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][0].x = 0;
		p[4][0].y = 4;
		p[4][0].p = b;
		
		pos_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		
		
		
		JButton pos_41 = new JButton("");
		pos_41.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_41);
		b = new Piece();
		b.button = pos_41;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][1].x = 1;
		p[4][1].y = 4;
		p[4][1].p = b;
		pos_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_42 = new JButton("");
		pos_42.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_42);
		b = new Piece();
		b.button = pos_42;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][2].x = 2;
		p[4][2].y = 4;
		p[4][2].p = b;
		pos_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_43 = new JButton("");
		pos_43.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_43);
		b = new Piece();
		b.button = pos_43;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][3].x = 3;
		p[4][3].y = 4;
		p[4][3].p = b;
		pos_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_44 = new JButton("");
		pos_44.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_44);
		b = new Piece();
		b.button = pos_44;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][4].x = 4;
		p[4][4].y = 4;
		p[4][4].p = b;
		pos_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_45 = new JButton("");
		pos_45.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_45);
		b = new Piece();
		b.button = pos_45;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][5].x = 5;
		p[4][5].y = 4;
		p[4][5].p = b;
		pos_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		
		JButton pos_46 = new JButton("");
		pos_46.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_46);
		b = new Piece();
		b.button = pos_46;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][6].x = 6;
		p[4][6].y = 4;
		p[4][6].p = b;
		pos_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_47 = new JButton("");
		pos_47.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_47);
		b = new Piece();
		b.button = pos_47;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[4][7].x = 7;
		p[4][7].y = 4;
		p[4][7].p = b;
		pos_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(4,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
				
			});
		
		JButton pos_50 = new JButton("");
		pos_50.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_50);
		b = new Piece();
		b.button = pos_50;
		b.ident = "Empty";
		b.color = "Empty";
		
		
		p[5][0].x = 0;
		p[5][0].y = 5;
		p[5][0].p = b;
		pos_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				PossibleMoves(5,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		
		JButton pos_51 = new JButton("");
		pos_51.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_51);
		b = new Piece();
		b.button = pos_51;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[5][1].x = 1;
		p[5][1].y = 5;
		p[5][1].p = b;
		
		pos_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				PossibleMoves(5,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		
		JButton pos_52 = new JButton("");
		pos_52.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_52);
		b = new Piece();
		b.button = pos_52;
		b.ident = "Empty";
		b.color = "Empty";
		
		p[5][2].x = 2;
		p[5][2].y = 5;
		p[5][2].p = b;
		pos_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		
		JButton pos_53 = new JButton("");
		pos_53.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_53);
		b = new Piece();
		b.button = pos_53;
		b.ident = "Empty";
		b.color = "Empty";
		p[5][3].x = 3;
		p[5][3].y = 5;
		p[5][3].p = b;
		pos_53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_54 = new JButton("");
		pos_54.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_54);
		b = new Piece();
		b.button = pos_54;
		b.ident = "Empty";
		b.color = "Empty";
		p[5][4].x = 4;
		p[5][4].y = 5;
		p[5][4].p = b;
		pos_54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_55 = new JButton("");
		pos_55.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_55);
		b = new Piece();
		b.button = pos_55;
		b.ident = "Empty";
		b.color = "Empty";
		p[5][5].x = 5;
		p[5][5].y = 5;
		p[5][5].p = b;
		pos_55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_56 = new JButton("");
		pos_56.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_56);
		b = new Piece();
		b.button = pos_56;
		b.ident = "Empty";
		b.color = "Empty";
		p[5][6].x = 6;
		p[5][6].y = 5;
		p[5][6].p = b;
		pos_56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_57 = new JButton("");
		pos_57.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		add(pos_57);
		b = new Piece();
		b.button = pos_57;
		b.ident = "Empty";
		b.color = "Empty";
		p[5][7].x = 7;
		p[5][7].y = 5;
		p[5][7].p = b;
		pos_57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(5,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_60 = new JButton("");
		pos_60.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_60);
		b = new Piece();
		b.button = pos_60;
		b.color = "White";
		b.ident = "Pawn";
		p[6][0].x = 0;
		p[6][0].y = 6;
		p[6][0].p = b;
		
		pos_60.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {		
			PossibleMoves(6,0);	
			Position kingW = getKing(p, "White");
			Position kingB = getKing(p, "Black");
			Position promoteW = checkPromotionWhite(p);
			boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
			boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
			     
			     
			if(chkMateW == true){
				displayEndGame("Black Wins!");
			}
			if(chkMateB == true){
				displayEndGame("White Wins!");
			}
			}
		});
		
		JButton pos_61 = new JButton("");
		pos_61.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_61);
		b = new Piece();
		b.button = pos_61;
		b.color = "White";
		b.ident = "Pawn";
		p[6][1].x = 1;
		p[6][1].y = 6;
		p[6][1].p = b;
		
		pos_61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PossibleMoves(6,1);	
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_62 = new JButton("");
		pos_62.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_62);
		b = new Piece();
		b.button = pos_62;
		b.color = "White";
		b.ident = "Pawn";
		p[6][2].x = 2;
		p[6][2].y = 6;
		p[6][2].p = b;
		
		pos_62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(6,2);	
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_63 = new JButton("");
		pos_63.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_63);
		b = new Piece();
		b.button = pos_63;
		b.color = "White";
		b.ident = "Pawn";
		p[6][3].x = 3;
		p[6][3].y = 6;
		p[6][3].p = b;
		
		
		pos_63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(6,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_64 = new JButton("");
		pos_64.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_64);
		b = new Piece();
		b.button = pos_64;
		b.color = "White";
		b.ident = "Pawn";
		p[6][4].x = 4;
		p[6][4].y = 6;
		p[6][4].p = b;
		pos_64.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(6,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_65 = new JButton("");
		pos_65.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_65);
		b = new Piece();
		b.button = pos_65;
		b.color = "White";
		b.ident = "Pawn";
		p[6][5].x = 5;
		p[6][5].y = 6;
		p[6][5].p = b;
		pos_65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(6,5);	
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				}
			});
		
		JButton pos_66 = new JButton("");
		pos_66.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_66);
		b = new Piece();
		b.button = pos_66;
		b.color = "White";
		b.ident = "Pawn";
		p[6][6].x = 6;
		p[6][6].y = 6;
		p[6][6].p = b;
		pos_66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				PossibleMoves(6,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}});
		
		JButton pos_67 = new JButton("");
		pos_67.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_pawn.png")));
		add(pos_67);
		b = new Piece();
		b.button = pos_67;
		b.color = "White";
		b.ident = "Pawn";
		p[6][7].x = 7;
		p[6][7].y = 6;
		p[6][7].p = b;
		pos_67.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(6,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		
		JButton pos_70 = new JButton("");
		pos_70.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_rook.png")));
		add(pos_70);
		b = new Piece();
		b.button = pos_70;
		b.color = "White";
		b.ident = "Rook";
		p[7][0].x = 0;
		p[7][0].y = 7;
		p[7][0].p = b;
		pos_70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,0);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		
		
		
		JButton pos_71 = new JButton("");
		pos_71.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_knight.png")));
		add(pos_71);	
		b = new Piece();
		b.button = pos_71;
		b.color = "White";
		b.ident = "Knight";
		p[7][1].x = 1;
		p[7][1].y = 7;
		p[7][1].p = b;
		pos_71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,1);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
				boolean staleMateW = isStaleMate(kingW, p, "White", "Black");
				boolean staleMateB = isStaleMate(kingB, p, "Black", "White");
				if(staleMateW == true || staleMateB == true){
					displayEndGame("Draw!");
				}
			}
		});
		
		
		JButton pos_72 = new JButton("");
		pos_72.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_bishop.png")));
		add(pos_72);
		b = new Piece();
		b.button = pos_72;
		b.color = "White";
		b.ident = "Bishop";
		p[7][2].x = 2;
		p[7][2].y = 7;
		p[7][2].p = b;
		pos_72.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,2);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_73 = new JButton("");
		pos_73.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_queen.png")));
		add(pos_73);
		b = new Piece();
		b.button = pos_73;
		b.color = "White";
		b.ident = "Queen";
		p[7][3].x = 3;
		p[7][3].y = 7;
		p[7][3].p = b;
		pos_73.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,3);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_74 = new JButton("");
		pos_74.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_king.png")));
		add(pos_74);
		b = new Piece();
		b.button = pos_74;
		b.color = "White";
		b.ident = "King";
		p[7][4].x = 4;
		p[7][4].y = 7;
		p[7][4].p = b;
		pos_74.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,4);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_75 = new JButton("");
		pos_75.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_bishop.png")));
		add(pos_75);
		b = new Piece();
		b.button = pos_75;
		b.color = "White";
		b.ident = "Bishop";
		p[7][5].x = 5;
		p[7][5].y = 7;
		p[7][5].p = b;
		pos_75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,5);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_76 = new JButton("");
		pos_76.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_knight.png")));
		add(pos_76);
		b = new Piece();
		b.button = pos_76;
		b.color = "White";
		b.ident = "Knight";
		p[7][6].x = 6;
		p[7][6].y = 7;
		p[7][6].p = b;
		pos_76.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,6);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
				     
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
		JButton pos_77 = new JButton("");
		pos_77.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_rook.png")));
		add(pos_77);
		b = new Piece();
		b.button = pos_77;
		b.color = "White";
		b.ident = "Rook";
		p[7][7].x = 7;
		p[7][7].y = 7;
		p[7][7].p = b;
		pos_77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PossibleMoves(7,7);
				Position kingW = getKing(p, "White");
				Position kingB = getKing(p, "Black");
				Position promoteW = checkPromotionWhite(p);
				boolean chkMateW = isCheckMate(kingW, p, "White", "Black");
				boolean chkMateB = isCheckMate(kingB, p, "Black", "White");
				     
			
				if(chkMateW == true){
					displayEndGame("Black Wins!");
				}
				if(chkMateB == true){
					displayEndGame("White Wins!");
				}
			}
		});
		
	
	}

    private void display() {
    	
    	final String[] options = new String[2];
    	options[0] = new String("Yes");
    	options[1] = new String("No");
        f = new JFrame("ButtonBorder");
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        
        f.addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showOptionDialog(f,"Forfeit Match?","", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null) == JOptionPane.OK_OPTION){
                    f.setVisible(false);
                    f.dispose();
                }
            }
            //Unused callbacks
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub			
			}
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ButtonBorder().display();
            }
        });
    }
   
    /*
     * Calls a piece's corresponding Positions() function to find the spot it can move to
     * Enables only the positions the selected pieces can go to, disables the rest.
     * 
     */
	public void getPositions(Position s)
	{
		
		
		//Added some basic first moves
		switch(s.p.ident)
		{
		case("Pawn"):
			PawnPositions(s);
			break;
		case("Rook"):
			RookPositions(s);
			break;
		case("Knight"):
			KnightPositions(s);
			break;
		case("Bishop"):
			BishopPositions(s);
			break;
		case("Queen"):
			QueenPositions(s);
			break;
		case("King"):
			KingPositions(s);
			break;
		
		
		}
		
		int x[] = new int[s.p.available.size()];
		int y[] = new int[s.p.available.size()];
		//System.out.println("available "+s.p.available);
		for(int i = 0; i < s.p.available.size(); i++)
		{
			x[i] = s.p.available.get(i).x;
			y[i] = s.p.available.get(i).y;
		}
		
		
		
		Disable();
		for(int i = 0; i < s.p.available.size(); i++)
		{
			//System.out.println(y[i] + " " + x[i]);
			p[y[i]][x[i]].p.button.setEnabled(true);
		}
		p[s.y][s.x].p.button.setEnabled(true);
		
		
	}
	
	/*
	 * Swaps attributes of two Position Objects
	 * 
	 */
	public void Swap (Position o, Position n)
	{
		if(o.p.ident.equals("Pawn") && o.p.color.equals("White") && n.y == 0)
		{
			String[] pieces = new String[4];
			pieces[0] = "Queen";
			pieces[1] = "Bishop";
			pieces[2] = "Knight";
			pieces[3] = "Rook";
			
			String promotion = (String)JOptionPane.showInputDialog(
                    f,
                    "Select the piece you'd like.",
                    "Promotion",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    pieces,
                    "Queen");
			
			
			if(promotion == null)
			{
				n.p.ident = o.p.ident;
				n.p.button.setIcon(o.p.button.getIcon());
			}
			else
			{
				n.p.ident = promotion;
				n.p.button.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/white_"+ promotion.toLowerCase() +".png" )));
			}
			n.p.color = o.p.color;
		}
		else if(o.p.ident.equals("Pawn") && o.p.color.equals("Black") && n.y == 7 )
		{
			String[] pieces = new String[4];
			pieces[0] = "Queen";
			pieces[1] = "Bishop";
			pieces[2] = "Knight";
			pieces[3] = "Rook";
			
			String promotion = (String)JOptionPane.showInputDialog(
                    f,
                    "Select the piece you'd like.",
                    "Promotion",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    pieces,
                    "Queen");	
			if(promotion == null)
			{
				n.p.ident = o.p.ident;
				n.p.button.setIcon(o.p.button.getIcon());
			}
			else
			{
				n.p.ident = promotion;
				n.p.button.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/black_"+ promotion.toLowerCase() +".png" )));
			}
			n.p.color = o.p.color;
		}
		else
		{
			n.p.button.setIcon(o.p.button.getIcon());
			n.p.ident = o.p.ident;
			n.p.color = o.p.color;
		}
		
		o.p.button.setIcon(new ImageIcon(ButtonBorder.class.getResource("/pieces/empty.png")));
		o.p.ident = "Empty";
		o.p.color = "Empty";
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				p[j][i].p.button.setEnabled(true);
			}
		}
		
		one = null;
		two = null;
		
		


	}
	
	/*
	 * Disables all the buttons
	 */
	public void Disable()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				p[j][i].p.button.setEnabled(false);
			}
		}	
	}
	
	
	/*
	 * This function is called whenever a button is clicked
	 * Function gets the Piece located in p[y][x] and calls getPositions() for that piece
	 * And enables only the positions the piece can go to.
	 * If Position varibles one and two are not empty then calls Swap to move the piece in one to two
	 * If one == two then re-enables all buttons
	 * 
	 */
	public void PossibleMoves(int y, int x)
	{
		if(!p[y][x].p.ident.equals("Empty") && (turn == p[y][x].p.color.charAt(0)))
		{
			
			Position s = new Position();
			s = p[y][x];
			
			if(one == null)
			{
				one = s;
				getPositions(s);
			}
			else
			{
				if(one != s && !(s.p.color.equals(one.p.color)))
				{
					two = s;
					Swap(one, two);
					if(turn == 'W')
					{
						turn = 'B';
					}
					else
					{
						turn = 'W';
					}
				}
				if(one == s)
				{
					for(int i = 0; i < 8; i++)
					{
						for(int j = 0; j < 8; j++)
						{
							p[j][i].p.button.setEnabled(true);
						}
					}
					one = null;
					two = null;
				}
			}
		}
		else
		{
			Position s = new Position();
			s = p[y][x];	
			if(one != null)
			{
				two = s;
				Swap(one,two);
				if(turn == 'W')
				{
					turn = 'B';
				}
				else
				{
					turn = 'W';
				}
				
			}
			
		}
	
	}
	
	// --------------------------- Piece Type Positions ------------------------
	
	public void PawnPositions(Position s){
		Position spot;
		s.p.available = new Vector<Position>();
		
		if(s.p.color.equals("Black"))
		{
			if(s.y == 1) //initial pawn position
			{
				spot = new Position(); //2 squares forward
				spot.y = 3;
				spot.x = s.x;
				
				if(!p[3][spot.x].p.color.equals(s.p.color))
				{
					if(p[2][s.x].p.color.equals("Empty")){ //Check that there is no piece in both possible squares
						s.p.available.add(spot);
					}
				}
				
				spot = new Position(); //1 square forward
				spot.y = 2;
				spot.x = s.x;
				
				if(!p[2][spot.x].p.color.equals(s.p.color))
				{
					s.p.available.add(spot);
				}
				
				if(s.x - 1 >= 0)
				{
					if(p[s.y+1][s.x-1].p.color.equals("White"))
					{
						spot = new Position();
						spot.y = s.y + 1;
						spot.x = s.x - 1;
						s.p.available.add(spot);
					}
				}
				if(s.x + 1 <= 7)
				{
					if(p[s.y+1][s.x+1].p.color.equals("White"))
					{
						spot = new Position();
						spot.y = s.y + 1;
						spot.x = s.x + 1;
						s.p.available.add(spot);
					}
					
				}
				
				
				
			}
			else
			{
				if(s.y < 7)
				{
					if(p[s.y+1][s.x].p.color.equals("Empty") )
					{
						spot = new Position();
						spot.y = s.y + 1;
						spot.x = s.x;
						s.p.available.add(spot);
					}
				
					if(s.x - 1 >= 0)
					{
						if(p[s.y+1][s.x-1].p.color.equals("White"))
						{
							spot = new Position();
							spot.y = s.y + 1;
							spot.x = s.x - 1;
							s.p.available.add(spot);
						}
					}
					if(s.x + 1 <= 7)
					{
						if(p[s.y+1][s.x+1].p.color.equals("White"))
						{
							spot = new Position();
							spot.y = s.y + 1;
							spot.x = s.x + 1;
							s.p.available.add(spot);
						}
						
					}
				}
			}
		}
		
		if(s.p.color.equals("White"))
		{
			if(s.y == 6) //Initial position of the pawn
			{
				spot = new Position(); //two squares forward
				spot.y = 4;
				spot.x = s.x;
				
				if(!p[4][spot.x].p.color.equals(s.p.color))
				{
					if(p[5][s.x].p.color.equals("Empty")){ //Check that there is no piece in both possible squares
						s.p.available.add(spot);
					}
				}
				
				spot = new Position(); //one square forward
				spot.y = 5;
				spot.x = s.x;
				
				if(!p[5][spot.x].p.color.equals(s.p.color))
				{
					s.p.available.add(spot);
				}
				
				if(s.x - 1 >= 0)
				{
					if(p[s.y-1][s.x-1].p.color.equals("Black"))
					{
						spot = new Position();
						spot.y = s.y - 1;
						spot.x = s.x - 1;
						s.p.available.add(spot);
					}
				}
				if(s.x + 1 <= 7)
				{
					if(p[s.y-1][s.x+1].p.color.equals("Black"))
					{
						spot = new Position();
						spot.y = s.y - 1;
						spot.x = s.x + 1;
						s.p.available.add(spot);
					}
					
				}
				
			}
			else
			{
				if(s.y > 0)
				{
					if(p[s.y-1][s.x].p.color.equals("Empty") )
					{
						spot = new Position();
						spot.y = s.y - 1;
						spot.x = s.x;
						s.p.available.add(spot);
					}
				
					if(s.x - 1 >= 0)
					{
						if(p[s.y-1][s.x-1].p.color.equals("Black"))
						{
							spot = new Position();
							spot.y = s.y - 1;
							spot.x = s.x - 1;
							s.p.available.add(spot);
						}
					}
					if(s.x + 1 <= 7)
					{
						if(p[s.y-1][s.x+1].p.color.equals("Black"))
						{
							spot = new Position();
							spot.y = s.y - 1;
							spot.x = s.x + 1;
							s.p.available.add(spot);
						}
						
					}
				}
			}
		}
		
	}
	
	public void KingPositions(Position s){
		Position spot;
		s.p.available = new Vector<Position>();
		
		spot = new Position();	// North
		spot.y = s.y - 1;
		spot.x = s.x ;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
	
		spot = new Position();	// NorthEast
		spot.y = s.y - 1;
		spot.x = s.x + 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1) ){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// East
		spot.y = s.y;
		spot.x = s.x + 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// SouthEast
		spot.y = s.y + 1;
		spot.x = s.x + 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// South 
		spot.y = s.y + 1;
		spot.x = s.x;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// SouthWest 
		spot.y = s.y + 1;
		spot.x = s.x - 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// West 
		spot.y = s.y;
		spot.x = s.x - 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();	// NorthWest 
		spot.y = s.y - 1;
		spot.x = s.x - 1;
		if((Math.abs(spot.y-s.y) <=1) && (Math.abs(spot.x-s.x) <=1) && (spot.y != 8) && (spot.x != 8)  && (spot.y != -1) && (spot.x != -1)){
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
	}
	
	public void QueenPositions(Position s){
		// pt to increment or decrement
		Position spot;	
		s.p.available = new Vector<Position>();
		
		
		//Southeast diagonal
		spot = new Position();
		for(int i = s.x+1, j = s.y+1; i < 8 && j < 8; i++, j++){
			spot = new Position();
			spot.x = i;
			spot.y = j;
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
				if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					i = 9;
					j = 9;
				}
			}
			else
			{
				i = 9;
				j = 9;
			}
			//System.out.println("bishop:southeast: "+"x="+spot.x+" y="+spot.y);
		}
		//Southwest diagonal
		spot = new Position();
		for(int i = s.x-1, j = s.y+1; i > -1 && j < 8; i--, j++){
			spot = new Position();
			spot.x = i;
			spot.y = j;
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
				if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					i = -2;
					j = 9;
				}
			}
			else
			{
				i = -2;
				j = 9;
			}
			//System.out.println("bishop:southwest: "+"x="+spot.x+" y="+spot.y);
		}
		//Northeast diagonal
		spot = new Position();
		for(int i = s.x+1, j = s.y-1; i < 8 && j > -1; i++, j--){
			spot = new Position();
			spot.x = i;
			spot.y = j;
			
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				//System.out.println(i + " " + j + " " + p[spot.y][spot.x].p.color);
				s.p.available.add(spot);
				if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					i = 9;
					j = -2;
				}
			}
			else
			{
				i = 9;
				j = -2;
			}
			//System.out.println("bishop:northeast: "+"x="+spot.x+" y="+spot.y);
		}
		//Northwest diagonal
		spot = new Position();
		for(int i = s.x-1, j = s.y-1; i > -1 && j > -1; i--, j--){
			spot = new Position();
			spot.x = i;
			spot.y = j;
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				//System.out.println(spot.x + " " + spot.y + " " + p[spot.y][spot.x].p.color);
				s.p.available.add(spot);
				if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					i = -2;
					j = -2;
				}
			}
			else
			{
				i = -2;
				j = -2;
			}
			//System.out.println("bishop:northwest: "+"x="+spot.x+" y="+spot.y);
		}
		
		spot = new Position();
		spot.x = s.x;
		spot.y = s.y;
		
		//All North
		while(spot.y > 0){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = --spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if((p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					spot.y = -1;
				}
			}
			else
			{
				spot.y = -1;
			}
			//System.out.println("rook:north: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All South
		while(spot.y < 7){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = ++spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if((p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					spot.y = 8;
				}
			}
			else
			{
				spot.y = 8;
			}
			//System.out.println("rook:south: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All East
		while(spot.x < 7){
			Position spotValid = new Position();
			spotValid.x = ++spot.x;
			spotValid.y = spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if((p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					spot.x = 8;
				}
			}
			else
			{
				spot.x = 8;
			}
			//System.out.println("rook:east: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot = new Position();
		spot.x = s.x;
		spot.y = s.y;
		
		//All West
		while (spot.x > 0){
			Position spotValid = new Position();
			spotValid.x = --spot.x;
			spotValid.y = spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if((p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
				{
					spot.x = -1;
				}
			}
			else
			{
				spot.x = -1;
			}
			//System.out.println("rook:west: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		
	}
	
	public void RookPositions(Position s)
	{
		Position spot = new Position();
		spot.x = s.x;
		spot.y = s.y;
		
		s.p.available = new Vector<Position>();
		
		//All North
		while(spot.y > 0){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = --spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if(p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White"))
				{
					spot.y = -1;
				}
			}
			else
			{
				spot.y = -1;
			}
			//System.out.println("rook:north: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All South
		while(spot.y < 7){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = ++spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if(p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White"))
				{
					spot.y = 8;
				}
			}
			else
			{
				spot.y = 8;
			}
			//System.out.println("rook:south: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All East
		while(spot.x < 7){
			Position spotValid = new Position();
			spotValid.x = ++spot.x;
			spotValid.y = spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if(p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White"))
				{
					spot.x = 8;
				}
			}
			else
			{
				spot.x = 8;
			}
			//System.out.println("rook:east: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All West
		while (spot.x > 0){
			Position spotValid = new Position();
			spotValid.x = --spot.x;
			spotValid.y = spot.y;
			if(!(p[spotValid.y][spotValid.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spotValid);
				if(p[spotValid.y][spotValid.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White"))
				{
					spot.x = -1;
				}
			}
			else
			{
				spot.x = -1;
			}
			//System.out.println("rook:west: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		
		
	}
	
	public void BishopPositions(Position s)
	{
		Position spot;
		s.p.available = new Vector<Position>();
		
		//Southeast diagonal
			spot = new Position();
			for(int i = s.x+1, j = s.y+1; i < 8 && j < 8; i++, j++){
				spot = new Position();
				spot.x = i;
				spot.y = j;
				if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
				{
					s.p.available.add(spot);
					if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
					{
						i = 9;
						j = 9;
					}
				}
				else
				{
					i = 9;
					j = 9;
				}
				//System.out.println("bishop:southeast: "+"x="+spot.x+" y="+spot.y);
			}
			
			//Southwest diagonal
			spot = new Position();
			for(int i = s.x-1, j = s.y+1; i > -1 && j < 8; i--, j++){
				spot = new Position();
				spot.x = i;
				spot.y = j;
				if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
				{
					s.p.available.add(spot);
					if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
					{
						i = -2;
						j = 9;
					}
				}
				else
				{
					i = -2;
					j = 9;
				}
				//System.out.println("bishop:southwest: "+"x="+spot.x+" y="+spot.y);
			}
			
			//Northeast diagonal
			spot = new Position();
			for(int i = s.x+1, j = s.y-1; i < 8 && j > -1; i++, j--){
				spot = new Position();
				spot.x = i;
				spot.y = j;
				
				if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
				{
					//System.out.println(i + " " + j + " " + p[spot.y][spot.x].p.color);
					s.p.available.add(spot);
					if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
					{
						i = 9;
						j = -2;
					}
				}
				else
				{
					i = 9;
					j = -2;
				}
				//System.out.println("bishop:northeast: "+"x="+spot.x+" y="+spot.y);
			}
			
			//Northwest diagonal
			spot = new Position();
			for(int i = s.x-1, j = s.y-1; i > -1 && j > -1; i--, j--){
				spot = new Position();
				spot.x = i;
				spot.y = j;
				if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
				{
					//System.out.println(spot.x + " " + spot.y + " " + p[spot.y][spot.x].p.color);
					s.p.available.add(spot);
					if((p[spot.y][spot.x].p.color.equals("Black") || p[spot.y][spot.x].p.color.equals("White")))
					{
						i = -2;
						j = -2;
					}
				}
				else
				{
					i = -2;
					j = -2;
				}
				//System.out.println("bishop:northwest: "+"x="+spot.x+" y="+spot.y);
			}

		
	}
	
	
	public void KnightPositions(Position s){
		Position spot;
		s.p.available = new Vector<Position>();
		
		spot = new Position();
		spot.y = s.y - 2;
		spot.x = s.x - 1;
		if(spot.x >= 0 && spot.y >= 0 )
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		spot = new Position();
		spot.y = s.y - 2;
		spot.x = s.x + 1;
		
		if(spot.x <= 7 && spot.y >= 0)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();
		spot.y = s.y + 2;
		spot.x = s.x + 1;
		
		if(spot.x <= 7 && spot.y <= 7)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();
		spot.y = s.y + 2;
		spot.x = s.x - 1;
		
		if(spot.x >= 0 && spot.y <= 7)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		
		
		
		spot = new Position();
		spot.y = s.y - 1;
		spot.x = s.x - 2;
		if(spot.x >= 0 && spot.y >= 0 )
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();
		spot.y = s.y + 1;
		spot.x = s.x - 2;
		
		if(spot.x >= 0 && spot.y <= 7)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();
		spot.y = s.y - 1;
		spot.x = s.x + 2;
		
		if(spot.x <= 7 && spot.y >= 0)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		spot = new Position();
		spot.y = s.y + 1;
		spot.x = s.x + 2;
		
		if(spot.x <= 7 && spot.y <= 7)
		{
			if(!(p[spot.y][spot.x].p.color.equals(s.p.color)))
			{
				s.p.available.add(spot);
			}
		}
		
		
	}
	
	//Used in isCheckMate
	public void getPossibleMoves(Position s){
		switch(s.p.ident)
		{
		case("Pawn"):
			PawnPositions(s);
			break;
		case("Rook"):
			RookPositions(s);
			break;
		case("Knight"):
			KnightPositions(s);
			break;
		case("Bishop"):
			BishopPositions(s);
			break;
		case("Queen"):
			QueenPositions(s);
			break;
		case("King"):
			KingPositions(s);
			break;
		
		}
	}
		
	public static Position checkPromotionBlack(Position[][] board){
		for(int j = 0; j < 8; j++){
			if(board[7][j].p.ident.endsWith("Pawn") && board[7][j].p.color.equals("Black")){
				System.out.println("Promote Black Pawn: 7," + j);
				return choosePromote(board[7][j]);
			}
		}
		return null;
	}
	
	public static Position choosePromote(Position board){
		Object[] options = {"Queen", "Rook", "Bishop", "Knight"};
		JFrame frame = new JFrame("Promote your Pawn");
		return null;
	}
	
	public static Position checkPromotionWhite(Position[][] board){
		for(int j = 0; j < 8; j++){
			if(board[0][j].p.ident.endsWith("Pawn") && board[0][j].p.color.equals("White")){
				System.out.println("Promote White Pawn: 0," + j);
				return board[0][j];
			}
		}
		return null;
	}
	
	public static Position getKing(Position[][] board, String usrColor){
		for (int i = 0; i < 8; i++) {
		    for (int j = 0; j < 8; j++) {   // == instead of equals
		    	if (board[i][j].p.color.equals(usrColor)){
		    		// get possible moves
		    		if(board[i][j].p.ident.endsWith("King")){
		    			return board[i][j];
		    		}
		    	}
		    }
		}
		return null;
		
	}

	// Check if user's king is in Checkmate
		public boolean isCheckMate(Position k, Position[][] board, String usrColor, String oppColor ){
			boolean check = false;	// king is in danger
			boolean checkMate = true;	// king can't get out of check
			Vector<Position> checkingP = new Vector<Position>(); // piece that can put king in check
			
			// if king is captured, opponent wins
			if(k == null){
				return checkMate;
			}
			
			// Is king in check?
			// for pieces with opponent's color:
			for (int i = 0; i < 8; i++) {
			    for (int j = 0; j < 8; j++) {
			    	if (board[i][j].p.color.equals(oppColor)){
			    		// get possible moves
			    		Position s = new Position();
						s = board[i][j];
						getPossibleMoves(s);
						if(s.p.available.size() != 0){
							for(int m = 0; m < s.p.available.size(); m++){
			    				// if square in opponent's possible moves has user's king
			    				if( (s.p.available.get(m).x == k.x) && (s.p.available.get(m).y == k.y)){
			    					// king is in check
			    					check = true;
			    					checkingP.add(s);
			    				}
			    			}
			    		}
			    	}
			    }
			}
			if(check == false){
				return false;
			}
			else{
				Object[] options = {"Ok"};
				JFrame frame = new JFrame("Check");
				int f = JOptionPane.showOptionDialog(frame,
						usrColor+" in Check!",
						"Check",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]); //default button title
				if (f == JOptionPane.YES_OPTION) {
					// do nothing
		        }
			// Can king get out of check?
				// get paths to king
				Vector<Vector<Position>> pathsToKing = new Vector<Vector<Position>>(); 
				for(int n = 0; n < checkingP.size(); n++){
					Position checkP = new Position();
					checkP = checkingP.get(n);
					getPossibleMoves(checkP);
				// see if king is in path
						for(int i = 0; i < checkP.p.available.size(); i++){
							if( (k.x == checkP.p.available.get(i).x) && (k.y == checkP.p.available.get(i).y)){
								Vector<Position> pathToKing = new Vector<Position>();
								for(int j = i; j > 0 ; j--){
									int pathX = checkP.p.available.get(j).x;
									int pathY = checkP.p.available.get(j).y;
									int pathX_prev = checkP.p.available.get(j-1).x;
									int pathY_prev = checkP.p.available.get(j-1).y;
									if( (Math.abs(pathX-pathX_prev) <= 1) && ((Math.abs(pathY-pathY_prev) <= 1)) ){
										pathToKing.add(checkP.p.available.get(j-1));
									}
								}
								//System.out.println("path to King "+ pathToKing);
								pathsToKing.add(pathToKing);
							}

						}
				}
				
				
			// for pieces with user's color:
				for (int i = 0; i < 8; i++) {
				    for (int j = 0; j < 8; j++) {
				    	if (board[i][j].p.color.equals(usrColor)){
				    		// get possible moves
				    		Position s = new Position();
							s = board[i][j];
							//System.out.println("user piece "+ s.x+" "+s.y);
							getPossibleMoves(s);
				    		if(s.p.available.size() != 0){
				    			for(int m = 0; m < s.p.available.size(); m++){
				    				// see if square in user's possible moves has opponent checking piece 
				    				//(checking piece can be captured)
				    				for(int n = 0; n < checkingP.size(); n++){
				    					if(s.p.ident.equals("Pawn")){	// Pawns can only capture diagonally
				    						if((s.p.available.get(m).x == s.x+1 || s.p.available.get(m).x == s.x-1) && (s.p.available.get(m).y == s.y+1 || s.p.available.get(m).y == s.y-1)){
				    							if( (s.p.available.get(m).x == checkingP.get(n).x) && (s.p.available.get(m).y == checkingP.get(n).y)){
				    								//System.out.println("chkmate1 Pawn s "+s.p.available.get(m).x+" "+s.p.available.get(m).y);
						    						//System.out.println("chkmate1 Pawn checkinP "+checkingP.get(n).x+" "+ checkingP.get(n).y);
				    								checkMate = false;
						    					}
				    						}
				    					}
				    					else{
				    						if( (s.p.available.get(m).x == checkingP.get(n).x) && (s.p.available.get(m).y == checkingP.get(n).y)){
				    							//System.out.println("chkmate1 s "+s.p.available.get(m).x+" "+s.p.available.get(m).y);
				    							//System.out.println("chkmate1 checkinP "+checkingP.get(n).x+" "+ checkingP.get(n).y);
				    							checkMate = false;
				    						}
				    					}
				    				// if square in user's possible moves is a square in the checking piece's possible move to the king 
				    					// (path to king can be blocked)
				    					//System.out.println("supposed to block?");
				    					//System.out.println("chkmate2 s "+s.p.available.get(m).x+" "+s.p.available.get(m).y);
			    						//System.out.println("chkmate2 checkinP "+checkingP.get(n).p.available.get(m).x+" "+ checkingP.get(n).p.available.get(m).y);
			    						for(int p = 0; p < pathsToKing.size(); p++){
			    							Vector<Position> pth = pathsToKing.get(p);
			    							for(int p2 = 0; p2 < pth.size(); p2++){
			    								if( (s.p.available.get(m).x == pth.get(p2).x) && (s.p.available.get(m).y == pth.get(p2).y)){
						    						System.out.println("block s "+s.p.available.get(m).x+" "+s.p.available.get(m).y);
						    						System.out.println("block p "+pth.get(p2).x+" "+pth.get(p2).y);
						    						//System.out.println("chkmate2 checkinP "+checkingP.get(n).p.available.get(m).x+" "+ checkingP.get(n).p.available.get(m).y);
						    						checkMate = false;
						    					}
			    							}
			    						}
				    				}
				    			}
				    		}
				    	}
				    }
				}
			// if possible moves of user's king is "Empty" square
			// and move is not in checking piece's path (king can move out of the way)
				
				// used to see if all king's move's are in checking path
				Vector<Integer> movesInChekPath = new Vector<Integer>(); 
				Position s = new Position();
				s = k;
				getPossibleMoves(s);
				// get king's possible moves
				if(s.p.available.size() != 0){
					for(int m = 0; m < s.p.available.size(); m++){
						for(int n = 0; n < checkingP.size(); n++){
							Position checkP = new Position();
							checkP = checkingP.get(n);
							getPossibleMoves(checkP);
							// see if a king possible move is in the path of a checking piece's possible move
							for(int i = 0; i < checkP.p.available.size(); i++){
								if( (s.p.available.get(m).x == checkP.p.available.get(i).x) && (s.p.available.get(m).y == checkP.p.available.get(i).y) && board[s.p.available.get(m).x][s.p.available.get(m).y].p.color.equals("Empty")){
									movesInChekPath.add(1);
								}
							}
						}
					}
				}
				//System.out.println("path "+movesInChekPath);
				if(movesInChekPath.size() == s.p.available.size()){
					// if all king's move's are in a checking piece path
					checkMate = true;
				}
			}
			
			return checkMate;
		}
	
	public void displayEndGame(String result){
		Object[] options = {"Rematch?", "Return to Lobby"};
		JFrame frame = new JFrame("End of Game");
		int n = JOptionPane.showOptionDialog(frame,
				result,
				"End of Match",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		if (n == JOptionPane.YES_OPTION) {
           // Rematch
			ButtonBorder.main(null);
			f.dispose();
        } else if (n == JOptionPane.NO_OPTION) {
        	// Return to Lobby
        	f.dispose();
        } else if (n == JOptionPane.CANCEL_OPTION) {
        	
        } else {
           
        }
	}
	
	// When user's king whose possible moves would all end up in check.
	// And other pieces of his/hers can't be moved
	public boolean isStaleMate(Position k, Position[][] board, String usrColor, String oppColor ){
			// allPossibleMovesChecked.size() >= k.p.available.size() ---> stalemate 
			Vector<Integer> allPossibleMovesChecked = new Vector<Integer>(); 
			Position kMoves = new Position();
			kMoves = k;
			getPossibleMoves(kMoves);
			
			// compare opponent and king's possible moves
			for (int i = 0; i < 8; i++) {
			    for (int j = 0; j < 8; j++) {
			    	if (board[i][j].p.color.equals(oppColor)){
			    		// get possible moves
			    		Position s = new Position();
						s = board[i][j];
						getPossibleMoves(s);
			    		for(int m = 0; m < s.p.available.size(); m++){
			    			if(s.p.available.size() != 0){
			    				for(int n = 0; n < kMoves.p.available.size(); n++){
					    			if(kMoves.p.available.size() != 0){
					    				// if an opponent possible move can land at king possible move 
					    				if((s.p.available.get(m).x == kMoves.p.available.get(n).x) && (s.p.available.get(m).y == kMoves.p.available.get(n).y)){
					    					 allPossibleMovesChecked.add(1);
					    				}
					    			}
			    				}
			    			}
			    		}
			    	}
			    }
			}
			
			boolean canMove = false;
			// check if user can't move other pieces
			for (int i = 0; i < 8; i++) {
			    for (int j = 0; j < 8; j++) {
			    	if (board[i][j].p.color.equals(usrColor)){
			    		// get possible moves
			    		// get possible moves
			    		Position s = new Position();
						s = board[i][j];
						getPossibleMoves(s);
						if(s.p.available.size() != 0){	// other piece can move
							for(int m = 0; m < s.p.available.size(); m++){
			    				canMove = true;
			    				return false;
			    			}
			    		}
			    	}
			    }
			}
			// if user's king can't avoid check and user can't move other pieces -> stalemate
			if( (allPossibleMovesChecked.size() >= k.p.available.size()) && (canMove == false)){
				return true;
			}
			else{
				return false;
			}
		}
	
	
}
