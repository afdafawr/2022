package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	@Override
	public BoardVO insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.searchBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> pageList(int page) {
		
		return dao.pageList(page);
	}

	
	
	//페이지. 전체건수 /10개씩, 검색결과 전체건수/10개씩
	
	
}