/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		fillFirstRow();	
		goToOrigin();
		//midpoint finding part
		while (beepersPresent()) {		
			pickBeeper();						
			move();
			moveToEnd();					
		}		
		putBeeper();
	}
	
	/*
	 * fillFirstRow method is defined to fill the 1st row with beepers
	 * Karel will put only one beeper at each corner
	 * precondition: facing east, at (1,1) point
	 * postcondition: facing east, at the end of 1st row
	 */
	private void fillFirstRow() {
		goToOrigin(); //go to (1,1) facing east
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper(); //Off-By-One-Bug
	}
	
	/*
	 * Karel will move to the last beeper of the beeper chain
	 * Precondition: standing at one end facing that chain
	 * Postcondition: standing at another end facing that chain 
	 * which means the orientation is changed oppositely 
	 */
	private void moveToEnd() {		
		while ( beepersPresent() && frontIsClear() ) {
			move();
		}
		if ( frontIsBlocked() && beepersPresent() ) { //for the case arrive at the wall
			turnAround();
		} else {
			turnAround();
			move();
		}
		
	}
	
	/*Move Karel back to origin of map (1,1), make it facing east
	 * Precondition: can be any case
	 * Postcondition: standing on (1,1) facing east
	 */
	private void goToOrigin() { 
		while (notFacingSouth()) {
			turnLeft();
		}
		moveToWall();
		while (notFacingWest()) {
			turnLeft();
		}
		moveToWall();
		while (notFacingEast()) {
			turnLeft(); //Karel will face east
		}
	}
	
	private void moveToWall() { //move Karel to wall
		while (frontIsClear()) {
			move();
		}
	}
}// end of public class

