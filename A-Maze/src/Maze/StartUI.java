package Maze;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class StartUI extends JFrame {
	private JPanel contentPane;
	private Random r = new Random();

	/**
	 * Launch the application.
	 */
	public int[][] randomMaze(int length){
		int[][] arrs;
		int[][] arrsOld;
//		int count=0;
		do{
//			count++;
			arrs = new int[length][length];
			arrsOld = new int[length][length];
			int row1 = r.nextInt(length);//随机生成起点坐标
			int column1 = r.nextInt(length);
			arrs[row1][column1] = 2;
			arrsOld[row1][column1] = 2;
			int row2 = r.nextInt(length);//随机生成终点坐标
			int column2 = r.nextInt(length);
			arrs[row2 ][column2] = 3;
			arrsOld[row2 ][column2] = 3;
			for(int i=0;i<length;i++){
				for(int j=0;j<length;j++){
					if((arrs[i][j]==2)||(arrs[i][j]==3))
						continue;
					else{
						arrs[i][j] = r.nextInt(2);
						arrsOld[i][j] = arrs[i][j];
					}
				}
			}
		}while(!judgeMaze(arrs));//当迷宫是死路的时候，就重新生成迷宫
//		System.out.println(count);
		return arrsOld;
	}
	
	public boolean judgeMaze(int[][] a){//判断随机迷宫是否有死路  有死路返回false
		Maze m =new Maze(a);
		m.mazeStack();
		if(m.getJudgeMaze())
			return true;
		else
			return false;
	}

	/**
	 * Create the frame.
	 */
	public StartUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("欢迎来到迷宫游戏！");
		
		JButton btnNewButton = new JButton("10*10");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 25));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.GREEN);
		//btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int[][] arrs = {
//						{2,0,1,0},
//						{1,1,1,0},
//						{0,1,1,3},
//						{0,1,0,1}
//						};
				new MazeUI(randomMaze(10)).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(123, 40, 199, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("50x50");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int[][] arrs = {
//						{2,0,1,0,1,0,0,1},
//						{1,1,1,1,0,1,0,0},
//						{0,1,0,1,1,0,1,3},
//						{1,1,1,1,0,1,1,0},
//						{1,0,1,0,1,1,0,0},
//						{1,0,1,0,1,0,1,0},
//						{0,0,1,1,1,0,1,1},
//						{0,1,1,0,1,1,1,0},
//						};
				new MazeUI(randomMaze(50)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(123, 146, 199, 56);
		contentPane.add(btnNewButton_1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUI frame = new StartUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
