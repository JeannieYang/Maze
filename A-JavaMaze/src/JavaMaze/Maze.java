package JavaMaze;

import java.util.ArrayList;
import java.util.Stack;

public class Maze {
	private int[][] arrs ;//0：墙  1：路 2：起点 3：终点
	private ArrayList<Point> pathFirst = new ArrayList<Point>();//记录最佳路径
	private boolean judgeMaze = false;//判断是否迷宫是否有出路，有就返回true
	
	public Maze(int[][] arrs){
		this.arrs = arrs;
	}
	
	//get方法
	public int[][] getArrs() {
		return arrs;
	}
	
	public Point getStart(){//找到起始位置
		for(int i=0;i<arrs.length;i++){//i为行 j为列
			for(int j=0;j<arrs.length;j++){
				if(arrs[i][j] == 2){
					return new Point(i,j);
				}
			}
		}
		return null;
	}
	
	public Point getEnd(){//找到结束位置
		for(int i=0;i<arrs.length;i++){//i为行 j为列
			for(int j=0;j<arrs.length;j++){
				if(arrs[i][j] == 3){
					return new Point(i,j);
				}
			}
		}
		return null;
	}

	public ArrayList<Point> getPathFirst(){
		return this.pathFirst;
	}

	public boolean getJudgeMaze(){
		return this.judgeMaze;
	}
	
	//判断path中是否存在终点
	public boolean judgeEnd(ArrayList<Point> path){
		if(path.size() == 0)
			return false;
		else if((getEnd().getX()==path.get(path.size()-1).getX())&&(getEnd().getY()==path.get(path.size()-1).getY())){
			return true;
		}else
			return false;
	}
	
	//电脑走路径（栈）
	public void mazeStack() {
		Point start = getStart();//定义一个start用来获取起始位置的坐标，
		//start是Point类型 Point类中存储x y，x y是二维数组的坐标，getStart方法用来返回初始坐标 
		Stack<Point> ls = new Stack<Point>();//ls1中存放数组对象Point（i和j）         创建栈用来实现迷宫
		ls.push(start);
		pathFirst.add(start);
		while(true){
			if(!ls.isEmpty()){
				int x = ls.peek().getX();//取出栈顶元素的x和y
				int y = ls.peek().getY();
				if((x<arrs.length-1)&&(arrs[x+1][y] == 3) || (y<arrs[0].length-1)&&arrs[x][y+1] == 3
						|| x>0&&arrs[x-1][y] == 3 || y>0&&arrs[x][y-1] == 3){
					this.judgeMaze = true;//判断是否迷宫是否有出路，有就返回true
					break;
				}
				if((x<arrs.length-1)&&(arrs[x+1][y] == 1)){//向下
					ls.push(new Point(x+1,y));
					pathFirst.add(new Point(x+1,y));   //记录最佳路径
					arrs[x+1][y] = 2;
					x++;
					continue;
				}
				if((y<arrs[0].length-1)&&arrs[x][y+1] == 1){//向右
					ls.push(new Point(x,y+1));
					pathFirst.add(new Point(x,y+1));
					arrs[x][y+1] = 2;
					y++;
					continue;
				}			
				if(x>0&&arrs[x-1][y] == 1){//向上
					ls.push(new Point(x-1,y));
					pathFirst.add(new Point(x-1,y));
					arrs[x-1][y] = 2;
					x--;
					continue;
				}			
				if(y>0&&arrs[x][y-1] == 1){//向左
					ls.push(new Point(x,y-1));
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
}

//  输出确定路径后的数组（测试用）
//	public void outPut(){
//		for(int i=0;i<arrs.length;i++){
//			for(int j=0;j<arrs.length;j++){
//				System.out.print(arrs[i][j]+" ");		
//			}
//			System.out.println();
//		}
//	}
//}
