package com.marble;

public class Four implements Block {

	@Override
	public String getDirection(String currDir) {
		switch (currDir) {
		case "up":
			return "down";
		case "down":
			return "left";
		case "left":
			return "right";
		case "right":
			return "up";
		}
		return currDir;
	}
}
