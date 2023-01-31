package JavaMaze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//public class MazeUI extends JFrame  implements KeyListener {
public class MazeUI extends JFrame {
	private JPanel contentPane;
	private int[][] arrsOld;
	private int moveX;
	private int moveY;

	public MazeUI(int[][] arrs) {
		this.arrsOld = copy(arrs);
		Maze m = new Maze(arrs);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 798);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		setTitle("欢迎来到迷宫游戏！");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		int x = m.getArrs().length;
		int y = m.getArrs()[0].length;
		panel_1.setLayout(new GridLayout(x,y));
		JButton[][] b = new JButton[x][y];
		for(int i=0;i<x;i++){//通过用maze中返回的二维数组来构造迷宫，迷宫本身是一个按钮数组，如果是0则为白，1为深灰，2为黄，3为红。
			for(int j=0;j<y;j++){
				b[i][j] = new JButton();
				if(m.getArrs()[i][j]==2)
					b[i][j].setBackground(Color.YELLOW);
				else if(m.getArrs()[i][j]==0)
					b[i][j].setBackground(Color.WHITE);
				else if(m.getArrs()[i][j]==1)
					b[i][j].setBackground(Color.DARK_GRAY);
				else 
					b[i][j].setBackground(Color.RED);
				panel_1.add(b[i][j]);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton b_stack = new JButton("帮助");
		b_stack.setFont(new Font("微软雅黑", Font.BOLD, 19));
		b_stack.setBackground(Color.DARK_GRAY);
		b_stack.setForeground(Color.PINK);
		b_stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.mazeStack();
				new DynamicMove(m,b).start();
			}
		});
		panel.setLayout(new GridLayout(0, 9, 0, 0));
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("第"+arrs.length/5+"关");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("查看");
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("G:/deposit.txt");
                Maze m = new Maze(arrsOld);
                PassUI p = new PassUI();
                BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					System.out.println(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//					JOptionPane.showMessageDialog(null, "您上次玩到第");  
//					if(br.readLine() == null){
//						System.out.println("您还未有游戏记录！");
//					}else{
//						System.out.println(br.readLine());
//						System.out.println("您上次玩到"+br.read()));
			}
		});
		btnNewButton_4.setForeground(Color.PINK);
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 19));
		panel.add(btnNewButton_4);
	
		panel.add(b_stack);
		
		JButton b_back = new JButton("返回");
		b_back.setFont(new Font("微软雅黑", Font.BOLD, 19));
		b_back.setBackground(Color.DARK_GRAY);
		b_back.setForeground(Color.PINK);
		b_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PassUI().setVisible(true);
				dispose();
			}
		});
		panel.add(b_back);
		
		moveX = m.getStart().getX();
		moveY = m.getStart().getY();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setForeground(Color.DARK_GRAY);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
			JButton btnNewButton = new JButton("\u2190");//左移
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(moveY>0&&(m.getArrs()[moveX][moveY-1]!=0)){
						b[moveX][moveY-1].setBackground(Color.yellow);
						b[moveX][moveY].setBackground(Color.DARK_GRAY);
						moveY--;
						if(m.getArrs()[moveX][moveY]==3){
							tip();
						}
					}
				}
			});
			btnNewButton.setForeground(new Color(255, 182, 193));
			btnNewButton.setFont(new Font("宋体", Font.BOLD, 27));
			btnNewButton.setBackground(Color.DARK_GRAY);
			panel_2.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u2191");//上移
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if((moveX>0)&&m.getArrs()[moveX-1][moveY]!=0){
						b[moveX-1][moveY].setBackground(Color.yellow);
						b[moveX][moveY].setBackground(Color.DARK_GRAY);
						moveX--;
						if(m.getArrs()[moveX][moveY]==3){
							tip();
						}
					}
				}
			});
			btnNewButton_1.setForeground(new Color(255, 182, 193));
			btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 27));
			btnNewButton_1.setBackground(Color.DARK_GRAY);
			panel_2.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("\u2193");//下移
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if((moveX<arrs.length-1)&&(m.getArrs()[moveX+1][moveY]!=0)){
						b[moveX+1][moveY].setBackground(Color.yellow);
						b[moveX][moveY].setBackground(Color.DARK_GRAY);
						moveX++;
						if(m.getArrs()[moveX][moveY]==3){
							tip();
						}
					}
				}
			});
			btnNewButton_2.setForeground(new Color(255, 182, 193));
			btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 27));
			btnNewButton_2.setBackground(Color.DARK_GRAY);
			panel_2.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("\u2192");//右移
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if((moveY<arrs[0].length-1)&&m.getArrs()[moveX][moveY+1]!=0){
						b[moveX][moveY+1].setBackground(Color.yellow);
						b[moveX][moveY].setBackground(Color.DARK_GRAY);
						moveY++;
						if(m.getArrs()[moveX][moveY]==3){
							tip();
						}
					}
				}
			});
			btnNewButton_3.setForeground(new Color(255, 182, 193));
			btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 27));
			btnNewButton_3.setBackground(Color.DARK_GRAY);
			panel_2.add(btnNewButton_3);
		
			

	}
	
	public int[][] copy(int[][] arrs){//深拷贝初始迷宫数组：浅拷贝只是地址赋给他，这时指向的已经是改变完的数组了
		int[][] copy = new int[arrs.length][arrs[0].length];
		for(int i=0;i<copy.length;i++){
			for(int j=0;j<copy.length;j++){
				copy[i][j] = arrs[i][j];
			}
		}
		return copy;
	}
	
	public class WindowListenerKnow extends JFrame{
		public WindowListenerKnow(){
			this.setBounds(300, 100, 400, 400);
		this.setTitle("我是测试【x】按钮关闭方法的");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	@Override
	protected void processWindowEvent(WindowEvent e){
		//这里需要对进来的WindowEvent进行判断，因为，不仅会有窗口关闭的WindowEvent进来，还可能有其他的WindowEvent进来
		if(e.getID() == WindowEvent.WINDOW_CLOSING){
			int option = JOptionPane.showConfirmDialog(null, "您当前未保存，是否存档？", "Tip", JOptionPane.OK_CANCEL_OPTION);
	        if(option == JOptionPane.OK_OPTION){
                System.out.println("存档成功！");
                //文件部分
                File file = new File("G:/deposit.txt");
                Maze m = new Maze(arrsOld);
                PassUI p = new PassUI();
                try {
        			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        			bw.write("您上次玩到第"+arrsOld.length/5+"关");//保存关卡
        			bw.newLine();
//        			String s = String.valueOf(p.getRandomMaze());
//        			bw.write(s);
//        			FileOutputStream fos = new FileOutputStream("G:/deposit.txt");
//        			for(int i=0;i<m.getArrs().length;i++){
//        				for(int j=0;j<m.getArrs().length;j++){
//        					fos.write(m.getArrs()[i][j]+"\t");
//        				}
//        				fos.write("\r\n");
//        			}
//        			fos.write(moveX);
//        			fos.write(moveY);
//        			fos.write(p.randomMaze(moveX));
//        			fos.close();
//        			bw.write(m.getPathFirst().get(moveY));
        			bw.flush();
        			bw.close();
        			dispose();       		 
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                
           
            }else{
        	    System.exit(0);//退出     //用户选择不退出本程序，因此可以继续留在本窗口
            }
	    }else{
		    super.processWindowEvent(e);
	    }
	}
	
	public void tip(){//到达终点是否继续游戏
		Object[] options ={ "继续游戏", "结束游戏" };  
		int m = JOptionPane.showOptionDialog(null, "恭喜你到达终点！", "",
		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		//继续游戏：0   结束游戏：1
//		System.out.println(m);
		if(m == 0){
			new PassUI().setVisible(true);
			dispose();
		}else{
			System.exit(0);//退出
		}
	}
	
	//文件部分
//	public void deposit(){
//		this.arrsOld = copy(arrs);
//		Maze m = new Maze(arrs);
//		File file = new File("G:/deposit.txt");
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
////			bw.write("", moveX,moveY);
//			bw.write("第"+arrsOld.length/5+"关");
//			bw.write(m.getArrs());
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			bw.flush();
//			bw.close();
//			br.close();
//			dispose();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
	



