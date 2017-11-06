package com.controller;

import com.service.Health;


public class Client {
	public String dir;
	public static int [][] arr = new int[][]{{0,0,31,0,0},{51,31,0,0,0},{0,0,42,31,32},{0,0,21,0,0},{0,12,0,0,32}};
	
	public static void main(String[] args) {
		System.out.println("Total Disappeared blocks : " + Controller.findDisapperedBlocks(arr, "up", 4, 1));
	}
}
