/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run() {
		putBeeper();
		while (facingEast()||facingWest()) {
			moveToNextPoint();
			if (facingEast()||facingWest()) {
				putBeeper();
			}
		}
	}
	/*
	 * move to next point
	 * precondition: facing east or facing west
	 * postcondition: facing east or facing west
	 */
	private void moveToNextPoint() {
		moveOneStep();
		moveOneStep();
	}
	/*
	 * when front is clear, move
	 * when front is blocked, turnAndMove
	 * precondition: facing east or facing west
	 * postcondition: facing east or facing west
	 */
	private void moveOneStep() {
		if (frontIsClear()) {
			move();
		}else {
			turnAndMove();
		}
	}
	/*
	 * turn move and turn
	 */
	private void turnAndMove() {
		if (facingEast()) {
			turnLeft();
			if (frontIsClear()){
				move();
				turnLeft();
			}
		} else {
			if(facingWest()) {
				turnRight();
				if (frontIsClear()){
					move();
					turnRight();
				}
			}
		}
	}

	// You fill in this part

}
