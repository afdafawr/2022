package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.jdbc.Employee;

//Create Read Update Delete
public class BoardDAO extends DAO{
	
	// 글등록
	public void create(Board bor) {
		String sql = "insert into board(board_num,board_title,board_content"
				+ ",board_writer)values(" 
				+ bor.getNo()
				+ ", '" + bor.getTitle() + "'"
				+ ", '" + bor.getContent()+ "'"
				+ ", '" + bor.getWriter()+ "')";
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
	public void delete(int num) {
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from board where board_num="+num); //insert,delete,update
			System.out.println(r +"건 삭제 되었습니다");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//글수정
	public void update(Board bor) {
		String sql = "update board " //
				+ "set board_content = ?, " //
				+ "creation_date = sysdate" //
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bor.getContent());
			psmt.setInt(2, bor.getNo());			
			int r= psmt.executeUpdate();
			System.out.println(r+"건이 수정되었습니다");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//글 상세조회
	public Board getbor(int borId) {
		
		
		conn = getConnect();
		Board result = new Board();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where board_num = "+borId); // 하나 불러오겟다
			
			while(rs.next()) { //1번째 값을 불러와서
			int count = rs.getInt("cnt");
			 result = new Board(rs.getInt("board_num")
						,rs.getString("board_title")
						,rs.getString("board_content")
						,rs.getString("board_writer")
						,rs.getString("creation_date")
						,count);
			count++; 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return result;
	}
}
