package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Create Read Update Delete
public class BoardDAO extends DAO{
	
	// 글등록
	public void create(Board bor,String user) {
		
		System.out.println(bor);
		String sql = "insert into board(board_num,board_title,board_content,board_writer)\r\n"
				+ "values (" + bor.getNo() 
				+", '" + bor.getTitle()
				+"' , '" + bor.getContent()
				+"' , '" + user
				+"')";
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
	//글 전체목록
	public List<Board> read() {
		List<Board> bor = new ArrayList<>();
		conn = getConnect();
		System.out.println("글목록 연결성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by 1");
			while(rs.next()) { //1번째 값을 불러와서
				bor.add(new Board(rs.getInt("board_num"), 
						rs.getString("board_title"),
						rs.getString("board_content"),
						rs.getString("board_writer"),
						rs.getString("creation_date"),
						rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return bor;
	}
	//삭제
	public void delete(int num,String user) {
		conn = getConnect();
		String name = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where board_writer = '"+user+"'");
			while(rs.next()) { //1번째 값을 불러와서
				name = rs.getString("board_writer");
			}
			if(name.equals(user)) {
			int r = stmt.executeUpdate("delete from board where board_num="+num); //insert,delete,update
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
	//글수정
	public void update(Board bor,String user) {
		conn = getConnect();
		String name = null;
		String sql = "update board set board_content = ?," //
				+ "creation_date = sysdate" //
				+ " where board_num = ?";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where board_num = '"+user+"'");
			while(rs.next()) { //1번째 값을 불러와서
				name = rs.getString("board_writer");
				break;
			}
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bor.getContent());
			psmt.setInt(2, bor.getNo());
			if(name.equals(user)) {
			int r= psmt.executeUpdate();
			System.out.println(r+"건이 수정되었습니다");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	//글 상세조회
	public Board getbor(int borId) {
		conn = getConnect();
		Board result = new Board();
		try {
			stmt = conn.createStatement();
			String sql = "select * from board where board_num = " + borId;
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
			sql = "update board set cnt = cnt+1 where board_num = " + borId;
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return result;
	}
	public boolean check(String id, String pw) {
		boolean chk = false;
		conn = getConnect();
		List<String> str = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user_table where id = '"+ id +"'"); // 하나 불러오겟다
			while(rs.next()) { //1번째 값을 불러와서
			str.add(rs.getString("id"));
			str.add(rs.getString("passwd"));
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
	public void reply(int num,String writer,String content) {
		conn = getConnect();
		String bonum = null;
		String sql = "insert into reply(rep_seq,board_num,rep_content,rep_writer,creation_date)\r\n"
				+ "values("
				+ "reply_seq.nextval, ?, ?, ?,sysdate)";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where board_num = '"+num+"'");
			while(rs.next()) { //1번째 값을 불러와서
				bonum = rs.getString("board_num");
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, writer);
			psmt.setString(3, content);
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
	public List<Reply> rpshow(int borid) {
		List<Reply> list = new ArrayList<>();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from reply where board_num = " + borid);
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
}
