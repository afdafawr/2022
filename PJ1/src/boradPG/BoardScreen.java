package boradPG;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class BoardScreen extends JFrame implements ActionListener{
	
	//입력항목. 처리위한
	private String[] labels = {"글번호", "글제목", "글내용", "글쓴이", "글쓴날짜"};	
	private JTextField[] fields = new JTextField[5];
	
	//컨테이너 역할.
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;

	private JTable table;
	
	//이벤트 처리
	private JButton addBtn, delBtn, findBtn, initBtn;
	BoardDAO dao = new BoardDAO();
	List<BoardDAO> list; 
		
	public BoardScreen() {
		setTitle("게시판");
		setLayout(new BorderLayout(10,10));
		setSize(620,500);
		
		//top panel 추가
		topPanel = new JPanel(new GridLayout(6,2));
		for(int i=0; i<labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		//center panel 추가
		String[] header = {"글번호", "글제목", "글내용", "글쓴이", "글쓴날짜","조회수","공감"};	
		DefaultTableModel model = new DefaultTableModel(header,0);
		
		table = new JTable(model);

		centerPanel = new JScrollPane(table);
		
		//오른쪽 버튼
		rightPanel = new JPanel(new GridLayout(4,1));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");
		findBtn.addActionListener(this);
		
		
		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);
		
		add("North",topPanel);// 위쪽정보
		add("Center", centerPanel);
		add("East", rightPanel);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
//DB조회 후 table 에 결과를 반영
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//화면에 조회된 결과 잇으면..clear
		int allcount = model.getRowCount();
		List<BoardDAO> dao = new ArrayList<BoardDAO>();
		for(int i=0; i<allcount; i++) {
			model.removeRow(0);
		}
		
		String[] recode = new String[7];
		List<Board> list = new ArrayList<Board>();
		list=((BoardDAO) dao).allshow();
		
		for(int i=0; i<list.size(); i++) {
			recode[0] = String.valueOf(list.get(i).getNo());
			recode[1] = list.get(i).getTitle();
			recode[2] = list.get(i).getContent();
			recode[3] = list.get(i).getWriter();
			recode[4] = list.get(i).getDate();
			recode[5] = String.valueOf(list.get(i).getCnt());
			recode[6] = String.valueOf(list.get(i).getMind());
			model.addRow(recode);			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == addBtn) {
			
		}else if(src == delBtn) {
			
		}else if(src == findBtn) {
			searchData();
		}else if(src == initBtn) {
			
		}
	}
	
	public static void main(String[] args) {
		new BoardScreen();
	}

	
}
