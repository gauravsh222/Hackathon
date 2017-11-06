package com.marble;

public class Two implements Block {

	@Override
	public String getDirection(String currDir) {
		switch (currDir) {
		case "up":
			return "right";
		case "down":
			return "up";
		case "left":
			return "down";
		case "right":
			return "left";
		}
		return currDir;
	}

}
