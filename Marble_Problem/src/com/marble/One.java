package com.marble;

public class One implements Block {

	@Override
	public String getDirection(String currDir) {
		switch (currDir) {
		case "up":
			return "down";
		case "down":
			return "right";
		case "left":
			return "up";
		case "right":
			return "left";
		}
		return currDir;
	}
}
