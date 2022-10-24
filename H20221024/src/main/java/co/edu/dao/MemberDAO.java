package co.edu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	// 조회 후 수정
	public void searchAndupdate() {
		
	}	
	
	//추가, 수정, 삭제, 한건조회, 목록...
	
//입력
	public void memberInsert(MemberVO vo) {
		
		String sql = "insert into members(id,passwd,name,email) "
				+ "values (?,?,?,?)";
		conn= getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	public MemberVO membersearch(String id) { //1건보기
		MemberVO mem = new MemberVO();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			String sql = "select * from user where id = '" + id + "'";
			rs = stmt.executeQuery(sql); // 하나 불러오겟다	
			while(rs.next()) { //1번째 값을 불러와서
				psmt = conn.prepareStatement(sql);
				mem = new MemberVO(rs.getString("id"),
								rs.getString("passwd"),
								rs.getString("name"),
								rs.getString("email"));
			}
			mem.toString();
	        } catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return mem;
	}
	
//업뎃	
	public void memberUpdate(MemberVO vo) {
		conn = getConnect();
		String name = null;
		String sql = "update members set id = ?," //
				+ "passwd = ? , name = ? , email = ?" //
				+ " where id = '" + vo.getId() + "'";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			int rs = psmt.executeUpdate();
			System.out.println(rs+"건 수정되었습니다");
			}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	public void memberDelete(String id) {
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = '" + id + "'");
			
			while(rs.next()) { //1번째 값을 불러와서
				String name = rs.getString("board_writer");
			}
				stmt.executeUpdate("delete from user where id='" + id + "'");
		} catch (Exception e) {
			System.out.println("지울수 없습니다");
		}finally {
			disconnect();
		}
	}
	
	public List<MemberVO> memberList(){ //목록보기
		List<MemberVO> mem = new ArrayList<MemberVO>();
		
		conn = getConnect();
		System.out.println("글목록 연결성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM\r\n"
					+ "(SELECT * FROM Pboard_G UNION SELECT * FROM Pboard_F UNION SELECT * FROM Pboard_Q)");
			while(rs.next()) { //1번째 값을 불러와서
				mem.add(new MemberVO(rs.getString("id"),
						rs.getString("passwd"),
						rs.getString("name"),
						rs.getString("email")));
			}
			System.out.println("==================================================================================================");
			for(MemberVO b : mem) {
				System.out.println(b);
			}
		
		
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}	
		return mem;
	}
}
