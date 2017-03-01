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
		//find midpoint
		while(beepersPresent()) {
			collectLeftEnd();
			firstRowAddOne();
			move();
			moveToBeeper();
		}
		goTomidpoint();
	}
	/*
	 * fillFirstRow method is defined to fill the 1st row with beepers
	 * Karel will put only one beeper at each corner
	 * precondition: facing east, at(1,1) point
	 * postcondition: facing east, at the most right end of 1st row
	 */
	private void fillFirstRow(){
		while(frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper(); //off-by-one-bug
	}
	/*
	 * Collect the most left beeper on the 1st row, if there is any
	 * Precondition: any case
	 * Postcondition: facing east, stop at the position where Karel just collected one beeper, 1st row
	 * 
	 */
	private void collectLeftEnd() {
		if(beepersPresent()) {
			pickBeeper();
			
		}
		if (frontIsClear()){
			move();
		}
		if(beepersPresent()){
			pickBeeper();
		}
	}
	/*
	 * go to origin 1st row, add one more beeper
	 * precondition: anywhere at 1st row facing east
	 * postcondition: on 2nd row, at the most end where no more beeper exist
	 */
	private void firstRowAddOne() {
		goToOrigin();
		while(beepersPresent()) {//arrive at the end of existing beepers
			move();
		}
		putBeeper();
	}
	/*
	 * Make sure Karel will go to the midpoint of the first row
	 * precondition: any case
	 * postcondition: arrive at the mid point of the 1st row, facing south
	 */
	private void goTomidpoint() {
		goToOrigin();
		while (beepersPresent()) {
			pickBeeper();
			move();
		}
		putBeeper();
	}
	
	/*
	 * Move Karel back to origin of map(1,1), make it facing east
	 * precondition: can be any caxe
	 * postcondition: standing on (1,1) facing east
	 */
	private void goToOrigin() {
		while(notFacingSouth()) {
			turnLeft();
		}
		moveToWall();
		while(notFacingWest()){
			turnLeft();
		}
		moveToWall();
		while (notFacingEast()) {
			turnLeft(); //karel will face east
		}
	}
	/*
	 * move Karel to first beeper on its way
	 * precondition: facing east/west
	 * postcondition: share same orientation as in precondition, standing on the corner where first beeper appears on its way
	 */
	private void moveToBeeper(){
		while (noBeepersPresent()) {
			move();
		}
	}
	/*
	 * go to upper/lower row above without changing column number
	 * make a big turn left
	 * precondition: any case
	 * postcondition: same column, arrive at uper/lower row
	 * which is one above/under the row in precondition
	 * direction will turn left
	 */
	private void bigTurnLeft(){
		turnLeft();
		move();
	}
	/*
	 * move Karel to the wall
	 * precondition: any case
	 * postcondition: near the wall
	 */
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
}// end of public class

