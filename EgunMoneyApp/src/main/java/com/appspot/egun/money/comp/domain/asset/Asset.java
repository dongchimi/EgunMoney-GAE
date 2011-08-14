package com.appspot.egun.money.comp.domain.asset;
/**
 * ÀÚ»ê
 */
public abstract class Asset implements Comparable<Asset> {
	
	private int displaySequence = 0;
	
	@Override
	public int compareTo(Asset o) {
		if (this.displaySequence > o.displaySequence) return 1;
		if (this.displaySequence < o.displaySequence) return -1;
		return 0;
	}
}