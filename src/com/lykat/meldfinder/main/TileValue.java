package com.lykat.meldfinder.main;

public enum TileValue {
	II(1), RYAN(2), SAN(3), SUU(4), UU(5), SIX(6), CHII(7), PAA(8), CHUU(9), TON(
			10), NAN(11), SHAA(12), PEI(13), HAKU(14), HATSU(15), CHUN(16);

	private final int value;

	TileValue(int value) {
		this.value = value;
	}

	public boolean isJihai() {
		return this.value >= 10;
	}

	public boolean isCardinal() {
		return !isJihai();
	}

	public boolean isTermHon() {
		return isJihai() || this.value == 1 || this.value == 9;
	}

	public int getInt() {
		return this.value;
	}

	@Override
	public String toString() {
		if (this.isJihai()) {
			switch (this) {
			case TON:
				return "Ton";
			case NAN:
				return "Nan";
			case SHAA:
				return "Shaa";
			case PEI:
				return "Pei";
			case HAKU:
				return "Haku";
			case HATSU:
				return "Hatsu";
			case CHUN:
				return "Chun";
			default:
				return "null";
			}
		} else {
			return "" + this.value;
		}
	}

}