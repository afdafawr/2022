package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SmsScreen extends JFrame{
	
	Dimension lbl1 = new Dimension(150,15);
	Dimension lbl2 = new Dimension(45,15);
	
	JPanel center, bottom;
	JLabel toLbl, fromLbl ,contentLbl;
	JTextField toTxt, fromTxt;
	JTextArea contentTxt;
	JButton send, cancel;
	
	SmsApp app = new SmsApp();
	
	public SmsScreen() {
		setTitle("문자 보내기");
		setSize(340,300);
		
		center = new JPanel();
		bottom = new JPanel();
		
		setLayout(new BorderLayout());
//label..
		toLbl = new JLabel("수신 번호");
		fromLbl = new JLabel("발신 번호");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl1);
		
		contentLbl.setPreferredSize(lbl2);
//textfield..
		toTxt = new JTextField(11);
		fromTxt = new JTextField(11);
		contentTxt = new JTextArea(10,25);
//button
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
//container setting
		center.add(toLbl);
		center.add(toTxt);
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		bottom.add(send);
		bottom.add(cancel);
//container 배치
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if(src ==send) {
				String to = toTxt.getText();
				String from = fromTxt.getText(); //
				String content = contentTxt.getText();
				
				app.sendSms(to, from, content);
				JOptionPane.showMessageDialog(null,  "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				fromTxt.setText("");
				toTxt.setText("");
				contentTxt.setText("");
			}else if(src == cancel) {
				System.out.println("취소 버튼 actionPerformed.");	
			}
		}
		
	}
	public static void main(String[] args) {
		new SmsScreen();
	}
}
