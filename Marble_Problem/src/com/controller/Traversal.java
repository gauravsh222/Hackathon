package com.controller;

import com.marble.Block;
import com.marble.Five;
import com.marble.Four;
import com.marble.One;
import com.marble.Three;
import com.marble.Two;
import com.service.HealthService;

public class Traversal {
	
	private int row;
	private int col;
	private int[][] arr;
	public Traversal(int row, int col, int[][] arr){
		this.row=row;
		this.col=col;
		this.arr=arr;
	}

	public String up(){
		boolean flag = true;
		for(row=row; row>=0; row--){
			System.out.println(arr[row][col]);
			if(arr[row][col] != 0){
				int [] val = HealthService.operateHealth(arr[row][col]);
				//Getting block object 
				Block block = getBlock(val[0]);
				arr[row][col] = val[1];
				String dir = block.getDirection("up");
				adjustPointer(dir);
				return dir;
			}
			if(row == 0 && flag) {
				row=0;
				flag=false;
			}
		}
		return "";
	}
	
	public String down(){
		boolean flag = true;
		for(row=row; row<arr.length; row++){
			System.out.println(arr[row][col]);
			if(arr[row][col] != 0){
				int [] val = HealthService.operateHealth(arr[row][col]);
				//Getting block object 
				Block block = getBlock(val[0]);
				arr[row][col] = val[1];
				String dir = block.getDirection("up");
				adjustPointer(dir);
				return dir;
			}
			if(row == arr.length-1 && flag) {
				row=0;
				flag=false;
			}
		}
		return "";
	}
	public String left(){
		boolean flag = true;
		for(col=col; col>=0; col--){
			System.out.println(arr[row][col]);
			if(arr[row][col] != 0){
				int [] val = HealthService.operateHealth(arr[row][col]);
				//Getting block object 
				Block block = getBlock(val[0]);
				arr[row][col] = val[1];
				String dir = block.getDirection("up");
				adjustPointer(dir);
				return dir;
			}
			if(col == 0 && flag) {
				col=arr.length-1;
				flag=false;
			}
		}
		return "";
	}
	
	public String right(){
		boolean flag = true;
		for(col=col; col<arr.length; col++){
			System.out.println(arr[row][col]);
			if(arr[row][col] != 0){
				int [] val = HealthService.operateHealth(arr[row][col]);
				//Getting block object 
				Block block = getBlock(val[0]);
				arr[row][col] = val[1];
				String dir = block.getDirection("up");
				adjustPointer(dir);
				return dir;
			}
			if(col == arr.length-1 && flag) {
				col=0;
				flag=false;
			}
		}
		return "";
	}
	
	private void adjustPointer(String dir) {
		switch (dir) {
		case "up":
			row = (arr.length-1)-((row+1)%arr.length);
			break;
		case "down":
			row = (row+1)%arr.length;
			break;
		case "left":
			col = arr.length-1-((col+1)%arr.length);
			break;
		case "right":
			col = (col+1)%arr.length;
			break;
		}
	}
		
	private Block getBlock(int block) {
		if(1 == block){
			return new One();
		} else if(2 == block){
			return new Two();
		} else if(3 == block) {
			return new Three();
		} else if(4 == block) {
			return new Four();
		}else if(5 == block) {
			return new Five();
		}
		return null;
	}
}
