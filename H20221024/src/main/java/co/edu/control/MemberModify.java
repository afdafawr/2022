package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberModify implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVO vo = new MemberVO(id, pw, name, email);
		
		MemberService service = new MemberServiceImpl();
		service.modifyMember(vo);
		
		HttpUtil.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}

}
