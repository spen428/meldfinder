package com.lykat.meldfinder.main;

/**
 * A small program that I hacked together in order to attempt to find legal
 * hands from within an arbitrary set of random mahjong tiles. It's nowhere near
 * as efficient as it could be, but it does the job!
 * 
 * Used to verify the solution to the mathematical problem:
 * 
 * "What is the minimum number of *random* mahjong tiles required to guarantee
 * that at least one legal hand of 14 tiles can be formed from the tiles?"
 * 
 * The answer - like the answer to the ultimate question of life, the universe
 * and everything - appears to be 42 (136-94), which is immensely satisfying.
 * 
 * @author lykat
 *
 */
public class Main {

	private static final int PASSES = 100000;
	private static final int REMOVALS = 94;

	public static void main(String args[]) {
		new Test().startTest(PASSES, REMOVALS);
	}

}
