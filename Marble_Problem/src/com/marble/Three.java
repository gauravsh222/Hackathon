package com.marble;

public class Three implements Block {

	@Override
	public String getDirection(String currDir) {
		switch (currDir) {
		case "up":
			return "left";
		case "down":
			return "up";
		case "left":
			return "right";
		case "right":
			return "down";
		}
		return currDir;
	}
}
