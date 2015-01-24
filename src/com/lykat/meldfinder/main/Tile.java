package com.lykat.meldfinder.main;

import java.util.ArrayList;

public class Tile {

	private final TileSuit suit;
	private final TileValue value;

	public Tile(TileSuit suit, TileValue value) {
		super();
		this.suit = suit;
		this.value = value;
	}

	public TileSuit getSuit() {
		return this.suit;
	}

	public TileValue getValue() {
		return this.value;
	}

	public boolean isJihai() {
		return this.value.isJihai();
	}

	public boolean isCardinal() {
		return !this.isJihai();
	}

	public boolean isTermHon() {
		return this.value.isTermHon();
	}

	/**
	 * Returns true if the given ArrayList contains a tile with the same suit
	 * and value as the given tile.
	 */
	public boolean containsSimilar(ArrayList<Tile> tiles) {
		for (Tile t : tiles)
			if (this.isSimilar(t))
				return true;
		return false;
	}

	/**
	 * Returns true if the given Tile array contains a tile with the same suit
	 * and value as the given tile.
	 */
	public boolean containsSimilar(Tile[] tiles) {
		for (Tile t : tiles)
			if (this.isSimilar(t))
				return true;
		return false;
	}

	/**
	 * Returns true if the tile shares the same suit and the same value.
	 */
	public boolean isSimilar(Tile tile) {
		return (this.suit == tile.getSuit() && this.value == tile.value);
	}

	/**
	 * Returns true if the tile shares the same suit and has a value that is
	 * adjacent to this tile's in sequence.
	 */
	public boolean isAdjacent(Tile tile) {
		if (this.suit == tile.getSuit()) {
			int diff = Math.abs(this.value.getInt() - tile.getValue().getInt());
			return (diff == 1);
		}
		return false;
	}

	@Override
	public String toString() {
		return value.toString() + suit.toString();
	}

}