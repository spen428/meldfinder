package com.lykat.meldfinder.main;

import java.util.ArrayList;

public class Meld {

	private final Tile[] tiles;
	private final MeldType type;

	public Meld(Tile[] tiles, MeldType type) {
		super();
		this.tiles = tiles;
		this.type = type;
	}

	public Meld(ArrayList<Tile> meld, MeldType type) {
		super();
		Tile[] tiles = new Tile[meld.size()];
		int i = 0;
		for (Tile t : meld)
			tiles[i++] = t;
		this.tiles = tiles;
		this.type = type;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public MeldType getType() {
		return type;
	}

	/**
	 * Returns true if the this meld contains a tile of the same suit and value
	 * as the given tile.
	 */
	public boolean containsSimilar(Tile tile) {
		for (Tile t : this.tiles)
			if (t.isSimilar(tile))
				return true;
		return false;
	}

	/**
	 * Returns true if the this meld shares the same tile instance as the given
	 * meld.
	 */
	public boolean containsIdentical(Meld meld) {
		Tile[] t1 = this.tiles, t2 = meld.getTiles();
		for (int i = 0; i < t1.length; i++)
			for (int j = i; j < t2.length; j++)
				if (i != j && t1[i] == t2[j])
					return true;
		return false;
	}

	/**
	 * Returns true if any of the given melds share the same tile instance.
	 */
	public static boolean containsIdentical(Meld... melds) {
		for (int i = 0; i < melds.length; i++)
			for (int j = i; j < melds.length; j++)
				if (i != j && containsIdentical(melds[i], melds[j]))
					return true;
		return false;
	}

}
