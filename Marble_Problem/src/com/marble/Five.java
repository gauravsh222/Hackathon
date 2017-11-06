package com.marble;

public class Five implements Block {

	@Override
	public String getDirection(String currDir) {
		switch (currDir) {
		case "up":
			return "down";
		case "down":
			return "up";
		case "left":
			return "right";
		case "right":
			return "left";
		}
		return currDir;
	}
}
