package boradPG;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoardDAO extends DAO{
	Scanner scn = new Scanner(System.in);
//로그인
	public boolean check(String id, String pw){
		boolean chk = true;
		conn = getConnect();
		List<String> str = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Puser where user_id = '"+ id +"'"); // 하나 불러오겟다
			while(rs.next()) { //1번째 값을 불러와서
			str.add(rs.getString("user_id"));
			str.add(rs.getString("user_pw"));
			}
			System.out.println(str.get(0));
			System.out.println(str.get(1));
			if(str.get(0).equals(id) && str.get(1).equals(pw)) {
				System.out.println("로그인 성공");
				chk = false;
			}
		}catch(Exception e) {
			System.out.println("오류입니다");
			chk = true;
		}
		finally {
			disconnect();
		}		
		return chk;
	}

//회원가입
	public boolean sign(User user2) {
		boolean chk = false;
		List<String> ids = new ArrayList<>();
		String sql = "insert into Puser(user_id,user_pw,user_tel,user_mail)"
				+ "	values(?,?,?,?)";
		conn = getConnect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Puser");
			
			while(rs.next()) { //1번째 값을 불러와서
			ids.add(rs.getString("user_id"));
			}
			System.out.println(user2.getId());
			System.out.println(user2.getPw());
			System.out.println(user2.getUser());
			System.out.println(user2.getMail());
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user2.getId());
			psmt.setString(2, user2.getPw());
			psmt.setString(3, user2.getUser());
			psmt.setString(4, user2.getMail());
			System.out.println(user2.getId()+"님 회원가입 완료");
			psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}		
		return true;
	}
//게시판 출력
	public List<Board> show(String id,int menu) {
		List<Board> bor = new ArrayList<>();
		String me = "";
		if(menu==1) {
			me = "G"; // 1번일때 공지사항
		}else if(menu==2) {
			me = "F"; // 2번일때 자유게시판
		}else if(menu==3) {
			me = "Q"; // 3번일떄 건의사항
		}
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Pboard_"+ me +" order by 1");
			if(menu==4) {
				
			}
			while(rs.next()) { //1번째 값을 불러와서
				bor.add(new Board(rs.getInt("board_num"), 
						rs.getString("board_title"),
						rs.getString("board_content"),
						rs.getString("board_writer"),
						rs.getString("creation_date"),
						rs.getInt("cnt"),
						rs.getInt("mind")));
			}
			for(Board b : bor) {
				System.out.println(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return bor;
	}
//글 상세조회
		public Board getbor(int borId,int menu) {
			conn = getConnect();
			String me = "";
			if(menu==1) {
				me = "G"; // 1번일때 공지사항
			}else if(menu==2) {
				me = "F"; // 2번일때 자유게시판
			}else if(menu==3) {
				me = "Q"; // 3번일떄 건의사항
			}
			
			Board result = new Board();
			try {
				stmt = conn.createStatement();
				String sql = "select * from Pboard_"+me+" where board_num = " + borId;
				rs = stmt.executeQuery(sql); // 하나 불러오겟다	
				while(rs.next()) { //1번째 값을 불러와서
				psmt = conn.prepareStatement(sql);
		        result = new Board(rs.getInt("board_num")
							,rs.getString("board_title")
							,rs.getString("board_content")
							,rs.getString("board_writer")
							,rs.getString("creation_date")
							,rs.getInt("cnt")
							,rs.getInt("mind"));
				}
				sql = "update Pboard_"+me+" set cnt = cnt+1 where board_num = " + borId;
				psmt = conn.prepareStatement(sql);
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}		
			return result;
		}
//글쓰기
		public void write(Board bor,String id,int menu) {
			String me = null;
			if(menu==1) {
				me = "G"; // 1번일때 공지사항
			}else if(menu==2) {
				me = "F"; // 2번일때 자유게시판
			}else if(menu==3) {
				me = "Q"; // 3번일떄 건의사항
			}
			String sql = "insert into Pboard_" +me +" (board_num,board_title,board_content,board_writer)\r\n"
					+ "values (board_num.nextval,"  
					+" '"+ bor.getTitle() + "', "
					+"'"+ bor.getContent() + "', "
					+"'"+ id+"')";
			System.out.println(sql);
			conn= getConnect();
			try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건이 입력되었습니다");
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally {
				disconnect();
			}
		}
//댓글보기
		public List<Reply> rpshow(int borid) {

			List<Reply> list = new ArrayList<>();
			conn = getConnect();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from Preply where board_num = " + borid);
				while(rs.next()) { //1번째 값을 불러와서
					list.add(new Reply(rs.getInt("rep_seq"),
							rs.getInt("board_num"),
							rs.getString("rep_content"),
							rs.getString("rep_writer"),
							rs.getString("creation_date")
							));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return list;
		}
//댓글달기
		public void reply(int num,String writer,String content,int menu) {
			String me = null;
			if(menu==1) {
				me = "G"; // 1번일때 공지사항
			}else if(menu==2) {
				me = "F"; // 2번일때 자유게시판
			}else if(menu==3) {
				me = "Q"; // 3번일떄 건의사항
			}
			conn = getConnect();
			String bonum = null;
			String sql = "insert into Preply(rep_seq,board_num,rep_content,rep_writer,creation_date)\r\n"
					+ "values("
					+ "Preply_seq.nextval, ?, ?, ?,sysdate)";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from Pboard_"+me +" where board_num = '"+num+"'");
				while(rs.next()) { //1번째 값을 불러와서
					bonum = rs.getString("board_num");
				}
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, num);
				psmt.setString(2, content);
				psmt.setString(3, writer);
				if(num==Integer.parseInt(bonum)) {
				System.out.println("댓글이 추가되었습니다");
				
				psmt.executeUpdate();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				disconnect();
			}
		}
//글삭제
		public void delete(int menu, int num,String user) {
			String me = null;
			String name = null;
			if(menu==1) {
				me = "G"; // 1번일때 공지사항
			}else if(menu==2) {
				me = "F"; // 2번일때 자유게시판
			}else if(menu==3) {
				me = "Q"; // 3번일떄 건의사항
			}
			conn = getConnect();
			try {
				stmt = conn.createStatement();
				if(menu==4) {
					rs = stmt.executeQuery("SELECT * FROM Pboard_G where board_num = '"+num
							+"' UNION SELECT * FROM Pboard_F where board_num = '"+ num
							+"' UNION SELECT * FROM Pboard_Q where board_num = '"+ num +"'");
				}else {
					rs = stmt.executeQuery("select * from Pboard_"+ me +" where board_num = '"+num+"'");
				}
				while(rs.next()) { //1번째 값을 불러와서
					name = rs.getString("board_writer");
				}if(menu==4 && user.equals("hr")) {
					int r = stmt.executeUpdate("delete from Pboard_G where board_num="+num);
					r = r + stmt.executeUpdate("delete from Pboard_F where board_num="+num);
					r = r + stmt.executeUpdate("delete from Pboard_Q where board_num="+num);
					System.out.println(r + "건 삭제 되었습니다.");
				}else if(name.equals(user) || user.equals("hr")) {
					int r = stmt.executeUpdate("delete from Pboard_"+me+" where board_num="+num); //insert,delete,update
					System.out.println(r +"건 삭제 되었습니다");
					}
				else {
					System.out.println("지울수 없습니다");
				}
			} catch (Exception e) {
				System.out.println("지울수 없습니다");
			}finally {
				disconnect();
			}
		}
// 한번에 출력
	public List<Board> allshow(){
		List<Board> bor = new ArrayList<Board>();
		conn = getConnect();
		System.out.println("글목록 연결성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM\r\n"
					+ "(SELECT * FROM Pboard_G UNION SELECT * FROM Pboard_F UNION SELECT * FROM Pboard_Q)");
			while(rs.next()) { //1번째 값을 불러와서
				bor.add(new Board(rs.getInt("board_num"), 
						rs.getString("board_title"),
						rs.getString("board_content"),
						rs.getString("board_writer"),
						rs.getString("creation_date"),
						rs.getInt("cnt"),
						rs.getInt("mind")));
			}
			System.out.println("==================================================================================================");
			for(Board b : bor) {
				System.out.println(b);
			}
			System.out.println("==================================================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return bor;
	}
//수정
	public void update(Board bor,String user,int menu) {
		String me = null;
		if(menu==1) {
			me = "G"; // 1번일때 공지사항
		}else if(menu==2) {
			me = "F"; // 2번일때 자유게시판
		}else if(menu==3) {
			me = "Q"; // 3번일떄 건의사항
		}
		conn = getConnect();
		String name = null;
		String sql = "update Pboard_" + me +" set board_content = ?," //
				+ "creation_date = sysdate" //
				+ " where board_num = ?";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Pboard_"+me+" where board_num = '"+bor.getNo()+"'");
			while(rs.next()) { //1번째 값을 불러와서
				name = rs.getString("board_writer");
				break;
			}
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bor.getContent());
			psmt.setInt(2, bor.getNo());
			if(menu==1) {
				if(user.equals("hr")) {
					int r= psmt.executeUpdate();
					System.out.println(r+"건이 수정되었습니다");
			}
			}
			else if(name.equals(user)||user.equals("hr")){ 
					int r= psmt.executeUpdate();
					System.out.println(r+"건이 수정되었습니다");
			}
			else {
					System.out.println("관리자가 아닙니다!!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
//공감	
	public void mind(int no,String chk,int menu) {
		conn = getConnect();
		System.out.println(chk);
		
		int mind = 0;
		String sql = null;
		String me = null;
		if(menu==1) {
			me = "G"; // 1번일때 공지사항
		}else if(menu==2) {
			me = "F"; // 2번일때 자유게시판
		}else if(menu==3) {
			me = "Q"; // 3번일떄 건의사항
		}		
		if(chk.toUpperCase().equals("Y")) {
		sql = "update Pboard_" + me + " set mind = mind + 1 where board_num = " + no;
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Pboard_" + me +" where board_num = '"+ no+"'");
			while(rs.next()) { //1번째 값을 불러와서
				psmt = conn.prepareStatement(sql);
				mind = rs.getInt("mind");
				break;
			}
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
			mind++;
			System.out.println("좋아요 수 :" + mind);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	
		}
//관리자의 가리기
	public void blind(int num) {
	conn = getConnect();
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM Pboard_G where board_num = '"+num
					+"' UNION SELECT * FROM Pboard_F where board_num = '"+ num
					+"' UNION SELECT * FROM Pboard_Q where board_num = '"+ num +"'");
		
			int r = stmt.executeUpdate("update Pboard_G set board_content = '관리자에 의해 삭제된 글입니다' where board_num = '"+num +"'");
			r = r + stmt.executeUpdate("update Pboard_F set board_content = '관리자에 의해 삭제된 글입니다' where board_num = '"+num +"'");
			r = r + stmt.executeUpdate("update Pboard_Q set board_content = '관리자에 의해 삭제된 글입니다' where board_num = '"+num +"'");
			System.out.println(r + "건 블라인드 처리되었습니다.");
	
	} catch (Exception e) {
		System.out.println("지울수 없습니다");
	}finally {
		disconnect();
	}
	}
//파일 만들기
	public void BoardDbToFile() {
		
		try {
		FileWriter fw = new FileWriter("c:/Temp/BoardFile.txt");
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.allshow();
		
		for(Board emp : list) {
			int no = emp.getNo();
			String name = emp.getTitle();
			String content = emp.getContent();
			String writer = emp.getWriter();
			String date = emp.getDate();
			fw.write("글번호 " +no +" 글 제목 : "+ name+" 글 내용 : " + content+" 글쓴이 : " + writer+" 글쓴날짜 : "+ date + "\n");	
		}
		System.out.println("파일로 저장 완료!!");
		fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

}
//비번찾기
	public void searchpw(String id) {
		Random random = new Random();		//랜덤 함수 선언
		int createNum = 0;  			//1자리 난수
		String ranNum = ""; 			//1자리 난수 형변환 변수
        	int letter    = 6;			//난수 자릿수:6
		String resultNum = "";  		//결과 난수
		
		for (int i=0; i<letter; i++) { 
            		
			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
		}	
        System.out.println(resultNum);
		
		conn = getConnect();
		MailApp mapp = new MailApp();
		SmsApp app = new SmsApp();
		String pw = "";
		String tel = "";
		String mail = "";
		//from 보내는사람
		String sql = "select * from Puser where user_id = '" + id + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //1번째 값을 불러와서
				pw = rs.getString("user_pw");
				tel = rs.getString("user_tel");
				mail = rs.getString("user_mail");
			}
//		app.sendSms(tel, "01045765728", resultNum);
		mapp.sendMail("dodgo12@gmail.com", mail, "인증번호 발급", resultNum);
		System.out.println("가입하신 메일로 인증번호가 발송되었습니다.");
		System.out.println("발급된 인증번호를 입력하세요");
		String checknum = scn.nextLine();
		if(checknum.equals(resultNum)) {
			System.out.println("비밀번호를 재설정합니다.");
			System.out.println("재설정할 비밀번호를 입력해주세요");
			String cgpw = scn.nextLine();
			sql = "update Puser set user_pw = '" + cgpw + "'";
			stmt.executeUpdate(sql);
			System.out.println("비밀번호가 변경되었습니다");
		}
			System.out.println(pw);
			System.out.println(tel);
			
//			app.sendSms(tel, "01045765728", pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 // 하나 불러오겟다	
	}
//아디찾기	
	public void searchid(String mail) {
		conn = getConnect();
		String id = null;
		String sql = "select * from Puser where user_mail = '" + mail + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //1번째 값을 불러와서
				id = rs.getString("user_id");
			}
			System.out.println("아이디는 " +id + " 입니다.");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
