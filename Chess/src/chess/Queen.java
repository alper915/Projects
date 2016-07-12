package chess;

import java.util.Vector;

public class Queen extends Piece{

	public static void getPositions(Position s)
	{
		s.p.available = new Vector<Position>();
		
		// pt to increment or decrement
		Position spt = new Position();	
		spt.y = s.y;
		spt.x = s.x ;
		System.out.println("queen " + s.x +" "+s.y);
		// North
		while (spt.y > 0){
			spt.y--;
			Position spot = new Position();	
			spot.x = spt.x;
			spot.y = spt.y;
			s.p.available.add(spot);
		}
		
		spt.y = s.y;
		spt.x = s.x ;
		// South
		while (spt.y < 7){
			spt.y++;
			Position spot = new Position();	
			spot.x = spt.x;
			spot.y = spt.y;
			s.p.available.add(spot);
		}
		
		// iterate up
		while (spt.x < 7){		// while spot is on chessboard
			// Queen can make either a rook or bishop move
			// East
			if(spt.x < 7){
				spt.x++;
				Position spot = new Position();	
				spot.x = spt.x ;
				spot.y = s.y;
				// Rook move if X2 == X1 or Y2 == Y1
				if((spot.y == s.y) || (spot.x==s.x)){
					s.p.available.add(spot);
				}
				else{
					spt.x--;	// reverse increment
				}
			}
			
			// NorthEast
			if(spt.y > 0){
				spt.y--;
				Position spot2 = new Position();	
				spot2.x = spt.x ;
				spot2.y = spt.y;
				if(Math.abs(spt.y-s.y) == Math.abs(spt.x-s.x)){
					s.p.available.add(spot2);
				}
				else{
					spt.y++;	// reverse increment
				}
			}
			// SouthEast diagonal
			if(spt.y < 7){
				spt.y++;
				Position spot2 = new Position();	
				spot2.x = spt.x ;
				spot2.y = spt.y;
				if(Math.abs(spt.y-s.y) == Math.abs(spt.x-s.x)){
					s.p.available.add(spot2);
				}	
				else{
					spt.y--;	// reverse decrement
				}
			}
		}
		
		// reset
		spt.y = s.y;
		spt.x = s.x;
		// iterate down
		while (spt.x > 0){		// while spot is on chessboard
			// Queen can make either a rook or bishop move
			// West
			if(spt.x > 0){
				spt.x--;
				Position spot = new Position();	
				spot.x = spt.x ;
				spot.y = s.y;
				
				// Rook move if X2 == X1 or Y2 == Y1
				if((spot.y == s.y) || (spot.x==s.x)){
					s.p.available.add(spot);
				}
				else{
					spt.x++;	// reverse decrement
				}
			}
			// NorthWest
			if(spt.y > 0){
				spt.y--;
				Position spot2 = new Position();	
				spot2.x = spt.x;
				spot2.y = spt.y;
				if(Math.abs(spt.y-s.y) == Math.abs(spt.x-s.x)){
					s.p.available.add(spot2);
				}
				else{
					spt.y++;	// reverse increment
				}
			}
			
			// SouthWest 
			if(spt.y < 7){
				spt.y++;
				Position spot2 = new Position();	
				spot2.x = spt.x ;
				spot2.y = spt.y;
				if(Math.abs(spt.y-s.y) == Math.abs(spt.x-s.x)){
					s.p.available.add(spot2);
				}
				else{
					spt.y--;	// reverse decrement
				}
			}
		}
		 
	}
		
}