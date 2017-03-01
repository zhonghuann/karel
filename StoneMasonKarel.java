/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		while (frontIsClear()){
		repairColumn();
		moveToNextLine();
		}
		
	}
	/*
	 * make sure every spot on this column has a beeper
	 * precondition: karel facing east
	 * postcondition: karel back to the bottom of this column
	 */
	private void repairColumn() {
		turnLeft();
		while (frontIsClear()) {
			repairStone();
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
		moveToBottom();
	}
	/*
	 * put beepers where need to be repaired
	 * precondition: none
	 * postcondition: beepers on this column
	 */
	private void repairStone() {
		if (noBeepersPresent()){
			putBeeper();
		}
	}
	/*
	 * back to the bottom line
	 * precondition: none
	 * postcondition: karel at the bottom, facing east
	 */
	private void moveToBottom() {
		while (notFacingSouth()) {
			turnLeft();
		}
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	/*
	 * goto the next avenue
	 * precondition: none
	 * postcondition: karel move 4 units next, facing east
	 */
	private void moveToNextLine() {
		if(frontIsClear()){
			for (int i=0; i<4; i++) {
				if (frontIsClear()) {
					move();
				}
			}	
		}
		
	}

}
