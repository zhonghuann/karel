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
		for (int i = 0; i<3; i++){
		repairColumn();
		moveToBottom();
		moveToNextLine();
		}
		repairColumn();
		moveToBottom();
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
	}
	private void repairStone() {
		if (noBeepersPresent()){
			putBeeper();
		}
	}
	private void moveToBottom() {
		while (notFacingSouth()) {
			turnLeft();
		}
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	private void moveToNextLine() {
		for (int i=0; i<4; i++) {
			move();
		}
	}
	// You fill in this part

}
