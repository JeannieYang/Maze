package Maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;

public class MazeUI extends JFrame {

	private JPanel contentPane;
	private int[][] arrsOld;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MazeUI(int[][] arrs) {
		this.arrsOld = copy(arrs);
		Maze m = new Maze(arrs);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		
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
		//创建三个按钮，按哪个按钮就实现哪个算法
		JButton b_recursion = new JButton("递归");
		b_recursion.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_recursion.setBackground(Color.DARK_GRAY);
		b_recursion.setForeground(Color.GREEN);
		b_recursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				m.mazeRecursion();
				new DynamicMove(m,b).start();
			}
		});
		panel.add(b_recursion);
		
		JButton b_stack = new JButton("栈");
		b_stack.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_stack.setBackground(Color.DARK_GRAY);
		b_stack.setForeground(Color.GREEN);
		b_stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.mazeStack();
				new DynamicMove(m,b).start();
			}
		});
		panel.add(b_stack);
		
		JButton b_queue = new JButton("队列");
		b_queue.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_queue.setBackground(Color.DARK_GRAY);
		b_queue.setForeground(Color.GREEN);
		b_queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.mazeQueue();
				new DynamicMove(m,b).start();
			}
		});
		panel.add(b_queue);
		
		JButton b_first = new JButton("最简洁路径");
		b_first.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_first.setBackground(Color.DARK_GRAY);
		b_first.setForeground(Color.GREEN);
		b_first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.mazeStack();
				for(int i=0;i<m.getPathFirst().size();i++)
					b[m.getPathFirst().get(i).getX()][m.getPathFirst().get(i).getY()].setBackground(Color.YELLOW);
			}
		});
		panel.add(b_first);
		
		JButton b_refresh = new JButton("刷新");
		b_refresh.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_refresh.setBackground(Color.DARK_GRAY);
		b_refresh.setForeground(Color.GREEN);
		b_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MazeUI(arrsOld).setVisible(true);
				dispose();
			}
		});
		panel.add(b_refresh);
		
		JButton b_back = new JButton("返回");
		b_back.setFont(new Font("微软雅黑", Font.BOLD, 18));
		b_back.setBackground(Color.DARK_GRAY);
		b_back.setForeground(Color.GREEN);
		b_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartUI().setVisible(true);
				dispose();
			}
		});
		panel.add(b_back);
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
}
