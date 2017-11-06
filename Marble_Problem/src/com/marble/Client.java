package com.marble;

public class Client {
	public String dir;
	public static int [][] arr = new int[][]{{0,0,31,0,0},{51,31,0,0,0},{0,0,42,31,32},{0,0,21,0,0},{0,12,0,0,32}};
	
	public static void main(String[] args) {
		initialize("up", 4, 1);
	}
	
	private static void initialize(String dir, int row, int col) {
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
		System.out.println("Total Disappeared blocks : " + Health.disAppeared);
	}
}
