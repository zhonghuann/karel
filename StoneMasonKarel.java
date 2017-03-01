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
		repairColumn();
	}
	/*
	 * repair the column
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
	 */
	private void repairStone() {
		if (noBeepersPresent()){
			putBeeper();
		}
	}
	/*
	 * back to the bottom line
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
	 */
	private void moveToNextLine() {
		if(frontIsClear()){
			for (int i=0; i<4; i++) {
				move();
			}	
		}
		
	}
	// You fill in this part

}
