package co.edu.service;

import java.util.List;

import co.edu.vo.MemberVO;

//CRUD 기능.
public interface MemberService {
	public void addMember(MemberVO vo); // 추가
	public void modifyMember(MemberVO vo);
	public void removeMember(String id);
	public MemberVO findMember(String id);
	public List<MemberVO> memberList();	
}
