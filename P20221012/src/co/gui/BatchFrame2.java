package co.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BatchFrame2 extends JFrame{
	
	private static final String MarginBorder = null;

	public BatchFrame2() {
		setTitle("BorderLayout 관리자");
		setSize(300,250);
		
		setLayout(new BorderLayout(10,10)); //10,10이 여백관리하는곳.
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top);
		add("West", left);
		add("East", right);
		add("Center", center);
		add("South", bottom);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 윈도우 가운데 띄우기
	}
	
	public static void main(String[] args) {
		new BatchFrame2();
	}
}
