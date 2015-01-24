package com.lykat.meldfinder.main;

import java.util.ArrayList;
import java.util.Random;

/**
 * Contains static tile set operations. Could possibly convert to an extension
 * of {@link java.util.Set} for a nice OO implementation.
 * 
 * @author lykat
 *
 */
public class TileSet {

	// TODO: Extend java.util.Set?

	/**
	 * Returns a standard set of 136 tiles.
	 */
	public static Tile[] fourPlayerTileSet() {
		Tile[] tileSet = new Tile[136];

		for (int i = 0; i < 4; i++) {
			int j = 0;
			for (Tile t : TileSet.uniqueTileSet()) {
				tileSet[(i * 34) + j++] = t;
			}
		}

		return tileSet;
	}

	/**
	 * Returns the set of tiles used in 3 player mahjong (2~8 Wanzu removed)
	 */
	public static Tile[] threePlayerTileSet() {
		ArrayList<Tile> tileSet = new ArrayList<Tile>();
		for (Tile t : fourPlayerTileSet()) {
			if (t.getSuit() != TileSuit.WANZU) {
				tileSet.add(t);
			} else if (t.getValue().isTermHon()) {
				tileSet.add(t);
			}
		}
		Tile[] tileSetArray = new Tile[tileSet.size()];
		int i = 0;
		for (Tile t : tileSet)
			tileSetArray[i++] = t;
		return tileSetArray;
	}

	/**
	 * Returns the set of tiles used in 2 player mahjong (2~8 Pinzu and Wanzu
	 * removed)
	 */
	public static Tile[] twoPlayerTileSet() {
		ArrayList<Tile> tileSet = new ArrayList<Tile>();
		for (Tile t : fourPlayerTileSet()) {
			if (t.getSuit() != TileSuit.WANZU && t.getSuit() != TileSuit.PINZU) {
				tileSet.add(t);
			} else if (t.getValue().isTermHon()) {
				tileSet.add(t);
			}
		}
		Tile[] tileSetArray = new Tile[tileSet.size()];
		int i = 0;
		for (Tile t : tileSet)
			tileSetArray[i++] = t;
		return tileSetArray;
	}

	/**
	 * Returns the set of 34 unique tiles.
	 */
	public static Tile[] uniqueTileSet() {
		Tile[] tileSet = new Tile[34];
		int j = 0;
		for (TileSuit s : TileSuit.values()) {
			for (TileValue v : TileValue.values()) {
				if ((s == TileSuit.JIHAI && v.isJihai())
						|| (s != TileSuit.JIHAI && v.isCardinal())) {
					Tile tile = new Tile(s, v);
					tileSet[j] = tile;
					j++;
				}
			}
		}
		return tileSet;
	}

	/**
	 * Removes 'n' random tiles from the given tile set.
	 */
	public static Tile[] removeRandomTiles(Tile[] tileSet, int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			boolean removed = false;
			do {
				int r = rand.nextInt(tileSet.length);
				if (tileSet[r] != null) {
					tileSet[r] = null;
					removed = true;
				}
			} while (!removed);
		}
		Tile[] tiles = new Tile[tileSet.length - n];
		int i = 0;
		for (Tile t : tileSet)
			if (t != null)
				tiles[i++] = t;
		return tiles;
	}

}
