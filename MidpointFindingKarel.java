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
		//midpoint finding part
		while (beepersPresent()) {
			collectLeftEnd();
			secondRowAddOne();
			collectRightEnd();	
			
			//step forward one more to make sure there is no more beeper
			if (frontIsClear()) { //check whether all beepers have been collected
				move(); //if width is odd number Karel will finally arrive (1,1)
			} //if width is even number, Karel will finally arrive mid-point
		}
		
		//go to the midpoint of the first row, put beeper then collect beepers
		//on the 2nd row
		goToMidpoint();
		putBeeper();
		collectSecondRow();	
		goToOrigin();
		moveToBeeper();
	}
	
	/*
	 * fillFirstRow method is defined to fill the 1st row with beepers
	 * Karel will put only one beeper at each corner
	 * precondition: facing east, at (1,1) point
	 * postcondition: facing east, (1,1) point
	 */
	private void fillFirstRow() {
		goToOrigin(); //go to (1,1) facing east
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper(); //Off-By-One-Bug
		//make sure go back to (1,1) point facing east
		turnAround();
		moveToWall();
		turnAround();
	}

	
	/*
	 * Collect the most left beeper on the 1st row, if there is any
	 * Precondition: any case
	 * Postcondition: facing east, stop at the position where Karel 
	 * just collected one beeper, 1st row
	 */
	private void collectLeftEnd() {
		goToOrigin();
		moveToBeeper();
		if (beepersPresent()) {
			pickBeeper();
		}		
	}
	
	/*Similar as collectLeftEnd, while in this method, Karel will start
	  from the most right end, and try to collect the beeper at the 
	  most right end
	*/
	private void collectRightEnd() {
		goToOrigin();
		moveToWall(); //Reach the right end of the 1st row
		turnAround(); //To face west
		moveToBeeper();
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	/*
	 * go to 2nd row, add one more beeper
	 * precondition: anywhere at 1st row facing east
	 * postcondition: on 2nd row, at the most end where no more beeper exist
	 */
	private void secondRowAddOne() {
		goToOrigin();
		bigTurnLeft();
		turnRight();
		while( beepersPresent()) { //arrive at the end of existing beepers
			move();
		}
		putBeeper();
	}
	
	
	/*
	 * Make sure Karel will go to the midpoint of the first row
	 * Precondition: any case
	 * Postcondition: arrive at the mid point of the 1st row, facing south
	 */
	private void goToMidpoint() {
		goToOrigin();
		moveToWall(); //reach right end 
		bigTurnLeft();
		turnLeft();
		moveToBeeper();
		bigTurnLeft();		
	}
	
	private void collectSecondRow() {
		goToOrigin();
		bigTurnLeft(); //facing north
		turnRight(); //facing east
		while (beepersPresent() || frontIsBlocked()) {
			pickBeeper();
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
	
	
	/*
	 * move Karel to first beeper on its way
	 * precondition: facing east/west
	 * postcondition: share same orientation as in precondition, standing on 
	 * the corner where first beeper appears on its way
	 */
	private void moveToBeeper() { 
		while ( noBeepersPresent() && frontIsClear() ) {
			move();
		}
	}
	
	/*
	 * go to upper/lower row above without changing column number, 
	 * make a big turn left
	 * precondition: any case
	 * postcondition: same column, arrive at upper/lower row 
	 * which is one above/under the row in precondition, 
	 * direction will turn left
	 */
	private void bigTurnLeft() {
		turnLeft();
		move(); 
	}
	
	// Similar as in bigTurnLeft, but in this case make a big
	//turn right
	private void bigTurnRight() {
		turnRight();
		move(); 
	}
	
	private void moveToWall() { //move Karel to wall
		while (frontIsClear()) {
			move();
		}
	}
	
}// end of public class

