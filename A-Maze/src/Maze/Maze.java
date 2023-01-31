package Maze;

import java.util.ArrayList;

public class Maze {
	private int[][] arrs ;//0��ǽ  1��· 2����� 3���յ�
	private ArrayList<Point> path ;//��¼����·��
	private ArrayList<Point> pathFirst = new ArrayList<Point>();//��¼����·��
	private boolean judgeMaze = false;//�ж��Ƿ��Թ��Ƿ��г�·���оͷ���true
	
	public Maze(int[][] arrs){
		this.arrs = arrs;
	}
	
	
	
	//get����
	public int[][] getArrs() {
		return arrs;
	}
	
	public Point getStart(){//�ҵ���ʼλ��
		for(int i=0;i<arrs.length;i++){//iΪ�� jΪ��
			for(int j=0;j<arrs.length;j++){
				if(arrs[i][j] == 2){
					return new Point(i,j);
				}
			}
		}
		return null;
	}
	
	public Point getEnd(){//�ҵ�����λ��
		for(int i=0;i<arrs.length;i++){//iΪ�� jΪ��
			for(int j=0;j<arrs.length;j++){
				if(arrs[i][j] == 3){
					return new Point(i,j);
				}
			}
		}
		return null;
	}

	public ArrayList<Point> getPath(){
		return this.path;
	}

	public ArrayList<Point> getPathFirst(){
		return this.pathFirst;
	}

	public boolean getJudgeMaze(){
		return this.judgeMaze;
	}
	
	//�ж�path���Ƿ�����յ�
	public boolean judgeEnd(ArrayList<Point> path){
		if(path.size() == 0)
			return false;
		else if((getEnd().getX()==path.get(path.size()-1).getX())&&(getEnd().getY()==path.get(path.size()-1).getY())){
			return true;
		}else
			return false;
	}

	

	//	1��ջ
	public void mazeStack() {
		this.path = new ArrayList<Point>();//path:��¼�㷨�ߵ�·��
		Point start = getStart();//����һ��start������ȡ��ʼλ�õ����꣬start��Point���� Point���д洢x y��x y�Ƕ�ά��������꣬getStart�����������س�ʼ���� 
		LinkedStack<Point> ls = new LinkedStack<Point>();//ls1�д���������Point��i��j��         ����ջ����ʵ���Թ�
		ls.push(start);
		pathFirst.add(start);
		while(true){
			if(!ls.isEmpty()){
				int x = ls.peek().getX();//ȡ��ջ��Ԫ�ص�x��y
				int y = ls.peek().getY();
				if((x<arrs.length-1)&&(arrs[x+1][y] == 3) || (y<arrs[0].length-1)&&arrs[x][y+1] == 3
						|| x>0&&arrs[x-1][y] == 3 || y>0&&arrs[x][y-1] == 3){
					this.judgeMaze = true;//�ж��Ƿ��Թ��Ƿ��г�·���оͷ���true
					break;
				}
				if((x<arrs.length-1)&&(arrs[x+1][y] == 1)){//����
					ls.push(new Point(x+1,y));
					path.add(new Point(x+1,y));   //��¼����·��
					pathFirst.add(new Point(x+1,y));   //��¼����·��
					arrs[x+1][y] = 2;
					x++;
					continue;
				}
				if((y<arrs[0].length-1)&&arrs[x][y+1] == 1){//����
					ls.push(new Point(x,y+1));
					path.add(new Point(x,y+1));
					pathFirst.add(new Point(x,y+1));
					arrs[x][y+1] = 2;
					y++;
					continue;
				}			
				if(x>0&&arrs[x-1][y] == 1){//����
					ls.push(new Point(x-1,y));
					path.add(new Point(x-1,y));
					pathFirst.add(new Point(x-1,y));
					arrs[x-1][y] = 2;
					x--;
					continue;
				}			
				if(y>0&&arrs[x][y-1] == 1){//����
					ls.push(new Point(x,y-1));
					path.add(new Point(x,y-1));
					pathFirst.add(new Point(x,y-1));
					arrs[x][y-1] = 2;
					y--;
					continue;
				}
				ls.pop();
				pathFirst.remove(pathFirst.size()-1);
			}else
				break;
		}
	}
	
    //	2������
	public void mazeQueue(){
		this.path = new ArrayList<Point>();//path:��¼�㷨�ߵ�·��
		Point start = getStart();//����һ��start������ȡ��ʼλ�õ����꣬start��Point���� Point���д洢x y��x y�Ƕ�ά��������꣬getStart�����������س�ʼ���� 
		LinkedQueue<Point> ls = new LinkedQueue<Point>();//ls1�д���������Point��x��y��                 ������������ʵ���Թ�
		ls.add(start);//��start���������������           ��ӣ�����
		while(true){
			if(!ls.isEmpty()){
				int x = ls.peek().getX();//ȡ����ͷԪ�ص�x��y
				int y = ls.peek().getY();
				if((x<arrs.length-1)&&(arrs[x+1][y] == 3) || (y<arrs[0].length-1)&&arrs[x][y+1] == 3
					|| x>0&&arrs[x-1][y] == 3 || y>0&&arrs[x][y-1] == 3){//�����ж����������Ƿ���Ԫ����3	
					break;
				}
				if((x<arrs.length-1)&&(arrs[x+1][y] == 1)){//����
					ls.add(new Point(x+1,y));
					path.add(new Point(x+1,y));
					arrs[x+1][y] = 2;
					x++;
					continue;
				}
				if((y<arrs[0].length-1)&&arrs[x][y+1] == 1){//����
					ls.add(new Point(x,y+1));
					path.add(new Point(x,y+1));
					arrs[x][y+1] = 2;
					y++;
					continue;
				}			
				if(x>0&&arrs[x-1][y] == 1){//����
					ls.add(new Point(x-1,y));
					path.add(new Point(x-1,y));
					arrs[x-1][y] = 2;
					x--;
					continue;
				}			
				if(y>0&&arrs[x][y-1] == 1){//����
					ls.add(new Point(x,y-1));
					path.add(new Point(x,y-1));
					arrs[x][y-1] = 2;
					y--;
					continue;
				}
				ls.poll();//����
			}else
				break;
		}
	}
	
	//	3���ݹ�
	public void mazeRecursion(){
		this.path = new ArrayList<Point>();//path:��¼�㷨�ߵ�·��
		Point start = getStart();//����һ��start������ȡ��ʼλ�õ����꣬start��Point���� Point���д洢x y��x y�Ƕ�ά��������꣬getStart�����������س�ʼ���� 
		int x = start.getX();
		int y = start.getY();
		arrs[x][y] = 1;
		this.mazeRecursion(x, y);	//++x=1
	}
	public void mazeRecursion(int x,int y){
		if((x>=0&&x<arrs.length)&&(y>=0&&y<arrs.length)&&(arrs[x][y] == 1)){
			if(!judgeEnd(path)){//�ж��߹���·���������յ�
				arrs[x][y] = 2;
				path.add(new Point(x,y));
				mazeRecursion(++x,y);//++x=2�������±���
				x--;//x--=1���ʧ�ܣ��ͻ��ˣ��ٵ��õݹ��㷨��x��++y�������ұ���
				mazeRecursion(x,++y);
				y--;
				mazeRecursion(--x,y);
				x++;
				mazeRecursion(x,--y);
				y++;
			}
		}else if((x>=0&&x<arrs.length)&&(y>=0&&y<arrs.length)&&(arrs[x][y] == 3)){
			path.add(new Point(x,y));//return null,�����˴εݹ飬������һ�εݹ�
			return;
		}else{
			return;//��������������Ҳ�ǽ����˴εݹ飬������һ�εݹ�
		}	
	}
//	public boolean judgeEnd(ArrayList<Point> path){
//		if(path.size() == 0)
//			return false;
//		else if((getEnd().getX()==path.get(path.size()-1).getX())&&(getEnd().getY()==path.get(path.size()-1).getY())){
//			return true;
//		}else
//			return false;
//	}
}

//  ���ȷ��·��������飨�����ã�
//	public void outPut(){
//		for(int i=0;i<arrs.length;i++){
//			for(int j=0;j<arrs.length;j++){
//				System.out.print(arrs[i][j]+" ");		
//			}
//			System.out.println();
//		}
//	}
//}
