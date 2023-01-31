package Maze;

import java.awt.Color;

import javax.swing.JButton;

public class DynamicMove extends Thread{//定义一个动态移动的线程类，传进来一个maze对象和按钮数组，根据path让对应坐标的按钮颜色变成黄色，每次变成黄色前让线程停止500ms实现动态效果
	private Maze m;
	private JButton[][] b;
	public DynamicMove(Maze m,JButton[][] b){
		this.m = m;
		this.b = b;
	}
	public void move(JButton[][] b,int x,int y){
		try{
			Thread.sleep(100);
		}catch(Exception e){
			System.out.println(e);
		}
			b[x][y].setBackground(Color.YELLOW);
	}
	public void run(){
		for(int i=0;i<m.getPath().size();i++)
			move(b,m.getPath().get(i).getX(),m.getPath().get(i).getY());
	}
}
