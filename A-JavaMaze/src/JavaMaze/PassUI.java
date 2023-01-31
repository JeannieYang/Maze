package JavaMaze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PassUI extends JFrame {

	private JPanel contentPane;
	private Random r = new Random();
//
//	int[][] arrs;
	int[][] arrsOld;
	public int[][] randomMaze(int length){
		int[][] arrs;
		int[][] arrsOld;
//		int count=0;
		do{
//			count++;
			arrs = new int[length][length];
			arrsOld = new int[length][length];
			int row1 = r.nextInt(length);//随机生成起点坐标
			int column1 = 0;
			arrs[row1][column1] = 2;
			arrsOld[row1][column1] = 2;
			int row2 = r.nextInt(length);//随机生成终点坐标
			int column2 = length-1;
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
	
//	public int[][] getRandomMaze(){
//		this.randomMaze(5);
//		return arrsOld;
//	}
	
	public boolean judgeMaze(int[][] a){//判断随机迷宫是否有死路  有死路返回false
		Maze m =new Maze(a);
		m.mazeStack();
		if(m.getJudgeMaze())
			return true;
		else
			return false;
	}

	public PassUI() {
//		File file = new File("G:/deposit.txt");
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader(file));
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			if(!(br.readLine() == null)){
//				Object[] options ={ "继续游戏", "退出" };  
//				int m = JOptionPane.showOptionDialog(null, "您上次玩到第"+"", "提示",
//				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//				//继续游戏：0   退出：1
//				if(m == 1){
//					dispose();
//				}else{
//					new PassUI().setVisible(true);
//				}
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);//窗体居中显示
		setTitle("欢迎来到迷宫游戏！");
		
		JLabel lblNewLabel = new JLabel("\u5173\u5361");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.DARK_GRAY);
		
		JButton btnNewButton_1 = new JButton("第一关");
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(5)).setVisible(true);
				dispose();
			}
		});
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("第二关");
		btnNewButton_2.setForeground(Color.GREEN);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(10)).setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("第三关");
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(15)).setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("第四关");
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(20)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("第五关");
		btnNewButton_5.setForeground(Color.GREEN);
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(25)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("第六关");
		btnNewButton_6.setForeground(Color.GREEN);
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				new MazeUI(randomMaze(30)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("第七关");
		btnNewButton_7.setForeground(Color.GREEN);
		btnNewButton_7.setBackground(Color.DARK_GRAY);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new MazeUI(randomMaze(35)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("第八关");
		btnNewButton_8.setForeground(Color.GREEN);
		btnNewButton_8.setBackground(Color.DARK_GRAY);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				new MazeUI(randomMaze(40)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("第九关");
		btnNewButton_9.setForeground(Color.GREEN);
		btnNewButton_9.setBackground(Color.DARK_GRAY);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new MazeUI(randomMaze(45)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_9.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("第十关");
		btnNewButton_10.setForeground(Color.GREEN);
		btnNewButton_10.setBackground(Color.DARK_GRAY);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(randomMaze(50)).setVisible(true);
				dispose();
			}
		});
		btnNewButton_10.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel.add(btnNewButton_10);
	}
}
