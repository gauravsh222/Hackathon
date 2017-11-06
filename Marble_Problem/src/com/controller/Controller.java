package com.controller;

import com.service.HealthService;

public class Controller {

	public static int findDisapperedBlocks(int[][] arr, String dir, int row, int col) {
		Traversal t = new Traversal(row, col, arr);
		while (true) {
			if ("up".equalsIgnoreCase(dir)){
				dir = t.up();
			} else if ("down".equalsIgnoreCase(dir)){
				dir = t.down();
			} else if ("left".equalsIgnoreCase(dir)){
				dir = t.left();
			} else if ("right".equalsIgnoreCase(dir)){
				dir = t.right();
			}
			else{
				break;
			}
		}
		return  HealthService.disAppeared;
	}

}
