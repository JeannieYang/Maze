package Maze;

import java.awt.Color;

import javax.swing.JButton;

public class DynamicMove extends Thread{//����һ����̬�ƶ����߳��࣬������һ��maze����Ͱ�ť���飬����path�ö�Ӧ����İ�ť��ɫ��ɻ�ɫ��ÿ�α�ɻ�ɫǰ���߳�ֹͣ500msʵ�ֶ�̬Ч��
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
