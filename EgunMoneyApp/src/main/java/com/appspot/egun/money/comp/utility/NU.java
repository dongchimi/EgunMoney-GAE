package com.appspot.egun.money.comp.utility;

public class NU {
	
	public static int getInt(String str) {
		int i = -1;
		try {
			i = Integer.valueOf(str);
		} catch (NumberFormatException e) {
		}
		
		return i;
	}
}
