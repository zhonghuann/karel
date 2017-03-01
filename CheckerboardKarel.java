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
	private void moveToNextPoint() {
		moveOneStep();
		moveOneStep();
	}
	private void moveOneStep() {
		if (frontIsClear()) {
			move();
		}else {
			turnAndMove();
		}
	}
	private void trunAndMove() {
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
