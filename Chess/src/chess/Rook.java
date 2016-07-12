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
public class Rook extends Piece{
	
	public String getColor(){
		return this.color;
	}
	
	public static void getPositions(Position s)
	{
		Position spot = new Position();
		spot.x = s.x;
		spot.y = s.y;
		
		s.p.available = new Vector<Position>();
		
		s.p.available.addElement(s);
		//All North
		while(spot.y > 0){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = --spot.y;
			s.p.available.add(spotValid);
			System.out.println("rook:north: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All South
		while(spot.y < 7){
			Position spotValid = new Position();
			spotValid.x = spot.x;
			spotValid.y = ++spot.y;
			s.p.available.add(spotValid);
			System.out.println("rook:south: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All East
		while(spot.x < 7){
			Position spotValid = new Position();
			spotValid.x = ++spot.x;
			spotValid.y = spot.y;
			System.out.println("rook:east: "+"x="+spotValid.x+" y="+spotValid.y);
		}
		
		spot.x = s.x;
		spot.y = s.y;
		
		//All West
		while (spot.x > 0){
			Position spotValid = new Position();
			spotValid.x = --spot.x;
			spotValid.y = spot.y;
			System.out.println("rook:west: "+"x="+spotValid.x+" y="+spotValid.y);
		}
	}
}