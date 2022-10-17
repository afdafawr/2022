package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ComponentExam2 extends JFrame{
	
	public ComponentExam2() {
		setTitle("입력필드 UI");
		setSize(350, 150);
		Dimension lblDim = new Dimension(50,16);
		
		setLayout(new BorderLayout());
			
		JPanel center = new JPanel();
		JPanel bottom = new JPanel();
		
		
		JLabel idLbl = new JLabel("id");
		idLbl.setPreferredSize(lblDim);
		JLabel pwLbl = new JLabel("password");
		pwLbl.setPreferredSize(lblDim);
		JTextField idTxt = new JTextField(23); // 크기지정
		JPasswordField pwTxt = new JPasswordField(23);
		
		center.add(idLbl);
		center.add(idTxt);
		center.add(pwLbl);
		center.add(pwTxt);
		
		
		JButton btn = new JButton("확인");		
		bottom.add(btn);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		new ComponentExam2();
	}
}
