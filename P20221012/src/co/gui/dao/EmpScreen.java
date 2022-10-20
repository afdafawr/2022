package co.gui.dao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
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

public class EmpScreen extends JFrame implements ActionListener,MouseListener{
	
	//입력항목. 처리위한	
	private String[] labels = {"사원번호", "이름", "성씨", "이메일", "입사일자", "직무"};	
	private JTextField[] fields = new JTextField[6];
	
	//컨테이너 역할.
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;
	
	private JTable table; // 데이터를 테이블형식으로 보여주게하는애
	
	//이벤트 처리
	private JButton addBtn, delBtn, findBtn, initBtn; 
	
	EmpDAO dao = new EmpDAO();
	List<EmployeeVO> list;
	
	public EmpScreen() {
		setTitle("사원정보 관리화면");
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
		String[] header = {"사원번호", "이름", "성씨", "이메일", "입사일자", "직무"};	
		DefaultTableModel model = new DefaultTableModel(header,0);
		
		table = new JTable(model);
		table.addMouseListener(this);

		centerPanel = new JScrollPane(table);
		
		//오른쪽 버튼
		rightPanel = new JPanel(new GridLayout(4,1));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);
		
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
	//end of EmpScreen();
	
	//DB조회 후 table 에 결과를 반영
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//화면에 조회된 결과 잇으면..clear
		int allcount = model.getRowCount();
		
		for(int i=0; i<allcount; i++) {
			model.removeRow(0);
		}
		
		String[] recode = new String[6];
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list = dao.empList(new EmployeeVO(Integer.parseInt(fields[0].getText()), fields[1].getText(), fields[2].getText(), fields[3].getText(), fields[4].getText(), fields[5].getText()));
		for(int i=0; i<list.size(); i++) {
			recode[0] = String.valueOf(list.get(i).getEmployeeId());
			recode[1] = list.get(i).getFirstName();
			recode[2] = list.get(i).getLastName();
			recode[3] = list.get(i).getEmail();
			recode[4] = list.get(i).getHireDate();
			recode[5] = list.get(i).getJobId();
			model.addRow(recode);			
		}
	}
	//삭제를 위한메소드
	public void removeData() {

		int selectedRow = table.getSelectedRow(); // 선택된 row를 반환
		if(selectedRow <0) {
			return;
		}		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int empId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
		
		dao.deleteEmp(empId);
		
		model.removeRow(selectedRow); //화면삭제.
	}
//추가를 위한 메소드
	public void addData() {
		String[] record = new String[6];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for(int i=0; i<fields.length; i++) {
		record[i] = fields[i].getText();
		}
		EmployeeVO emp = new EmployeeVO(0, record[1], record[2], record[3], record[4], record[5]);
		
		dao.insertEmp(emp);
		record[0] = String.valueOf(emp.getEmployeeId());
		
		model.addRow(record);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//addBtn,delBtn,findBtn....
		Object src = e.getSource();
		if(src == addBtn) {
			addData();
		}else if(src == delBtn) {
			removeData();
		}else if(src == findBtn) {
			searchData();
		}else if(src == initBtn) {
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
				
	}
	// end of actionPerformed(actionEvent e)
	
	//프로그램의 시작
	public static void main(String[] args) {
		new EmpScreen();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
