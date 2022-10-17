package boradPG;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO extends DAO{
	
//로그인
	public boolean check(String id, String pw){
		boolean chk = false;
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
			if(str.get(0).equals(id)&&str.get(1).equals(pw)) {
				System.out.println("로그인 성공");
				chk = true;
			}
		}catch(Exception e) {
			System.out.println("오류입니다");
			chk = false;
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
		String sql = "insert into Puser(user_id,user_pw,user_name)"
				+ "	values(?,?,?)";
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
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user2.getId());
			psmt.setString(2, user2.getPw());
			psmt.setString(3, user2.getUser());
			System.out.println(user2.getId()+"님 회원가입 완료");
			psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}		
		return false;
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
		System.out.println("글목록 연결성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Pboard_"+ me +" order by 1");
			while(rs.next()) { //1번째 값을 불러와서
				bor.add(new Board(rs.getInt("board_num"), 
						rs.getString("board_title"),
						rs.getString("board_content"),
						rs.getString("board_writer"),
						rs.getString("creation_date"),
						rs.getInt("cnt")));
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
							,rs.getInt("cnt"));
				}
				sql = "update Pboard_" + me +" set cnt = cnt+1 where board_num = " + borId;
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
}
