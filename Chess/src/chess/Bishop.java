package chess;

import java.util.Vector;

/*
 * Graph Layout:
 * 
	0
	1
	2
	3
	4
	5
	6
	7/0 1 2 3 4 5 6 7
 *
 */

public class Bishop extends Piece{

	public String getColor(){
		return this.color;
	}
	
	public static void getPositions(Position s)
	{
		Position spot;
		s.p.available = new Vector<Position>();
		s.p.available.addElement(s);
		//Southeast diagonal
		spot = new Position();
		for(int i = s.x+1, j = s.y+1; i < 8 && j < 8; i++, j++){
			spot.x = i;
			spot.y = j;
			s.p.available.add(spot);
			System.out.println("bishop:southeast: "+"x="+spot.x+" y="+spot.y);
		}
		//Southwest diagonal
		spot = new Position();
		for(int i = s.x-1, j = s.y+1; i > -1 && j < 8; i--, j++){
			spot.x = i;
			spot.y = j;
			s.p.available.add(spot);
			System.out.println("bishop:southwest: "+"x="+spot.x+" y="+spot.y);
		}
		//Northeast diagonal
		spot = new Position();
		for(int i = s.x+1, j = s.y-1; i < 8 && j > -1; i++, j--){
			spot.x = i;
			spot.y = j;
			s.p.available.add(spot);
			System.out.println("bishop:northeast: "+"x="+spot.x+" y="+spot.y);
		}
		//Northwest diagonal
		spot = new Position();
		for(int i = s.x-1, j = s.y-1; i > -1 && j > -1; i--, j--){
			spot.x = i;
			spot.y = j;
			s.p.available.add(spot);
			System.out.println("bishop:northwest: "+"x="+spot.x+" y="+spot.y);
		}
	}
}