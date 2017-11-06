package com.marble;

public class Health {
	public static int disAppeared;
	public static int[] operateHealth(int value){
		int [] ret = new int[2];
		int health = value % 10;
		value /= 10;
		ret[0] = value;
		--health;
		if(health==0){
			ret[1] = 0;
			disAppeared++;
		}else {
			ret[1] = value*10 + health;
		}
		return ret;
	}
}
