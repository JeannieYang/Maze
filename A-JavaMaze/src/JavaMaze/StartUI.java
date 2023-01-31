package JavaMaze;

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
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class StartUI extends JFrame {
	private JPanel contentPane;

	public StartUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u5F00\u59CB");//自动
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PassUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBounds(197, 181, 120, 42);
		contentPane.add(btnNewButton_1);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setForeground(Color.ORANGE);
		textPane.setFont(new Font("宋体", Font.BOLD, 27));
		textPane.setText("\u6B22\u8FCE\u6765\u5230\u8FF7\u5BAB\u5C0F\u6E38\u620F\uFF01");
		textPane.setBounds(123, 73, 300, 70);
		contentPane.add(textPane);
		this.setLocationRelativeTo(null);
		setTitle("Maze 1.0");
	
		
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
