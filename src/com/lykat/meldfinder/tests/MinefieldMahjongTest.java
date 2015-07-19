package com.lykat.meldfinder.tests;

import com.lykat.meldfinder.main.Hand;
import com.lykat.meldfinder.main.Tile;
import com.lykat.meldfinder.main.TileSet;
import com.lykat.meldfinder.main.Hand.HandType;

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
public class MinefieldMahjongTest {

	private static final int PASSES = 100000;
	private static final int REMOVALS = 94;

	public static void main(String args[]) {
		new MinefieldMahjongTest().startTest(PASSES, REMOVALS);
	}
	
	/**
	 * Initiates a test run.
	 * 
	 * @param passes
	 *            number of runs
	 * @param removeNum
	 *            the number of tiles to remove (for random mode)
	 */
	public void startTest(int passes, int removeNum) {
		System.out.printf(
				"Running %d passes, estimated completion time: <%.2fs%n",
				passes, passes * 0.00001d);
		long start = System.currentTimeMillis();
		int fail = 0, reg = 0, chii = 0, km = 0;
		for (int i = 0; i < passes; i++) {
			Tile[] tileSet;
			tileSet = TileSet.fourPlayerTileSet();
			HandType test = Hand.canConstructHand(TileSet.removeRandomTiles(
					tileSet, removeNum));

			switch (test) {
			case CHIITOITSU:
				chii++;
				break;
			case INVALID:
				fail++;
				break;
			case KOKUSHI_MUSOU:
				km++;
				break;
			case REGULAR:
				reg++;
				break;
			}

		}
		System.out.printf("%d/%d were successful (%.4f%%)%n", passes - fail,
				passes, 100 * ((double) (passes - fail) / passes));
		System.out
				.printf("%4d Regular | %4d Chiitoitsu | %4d Kokushi Musou | %4d Invalid %n",
						reg, chii, km, fail);
		long finish = System.currentTimeMillis();
		System.out.printf("Operation took %.2f seconds%n",
				(double) (finish - start) / 1000.0d);
	}

}
