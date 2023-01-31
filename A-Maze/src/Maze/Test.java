package Maze;

public class Test {//¿ÉÉ¾³ıµÄ²âÊÔÀà
	public static void main(String[] args) {
		int[][] arrs = {
				{2,0,1,0},
				{1,1,1,0},
				{0,1,0,3},
				{1,1,1,1}
				};
		Maze m =new Maze(arrs);
		m.mazeQueue();
		System.out.println(m.getPath());
	}
}
