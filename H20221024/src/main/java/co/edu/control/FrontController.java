package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet{
	
	Map<String, Command> control = new HashMap<>();
	@Override
	public void init() throws ServletException {
		control.put("/main.do", new Maincontrol());
		//추가
		control.put("/memberAddForm.do", new MemberAddForm());
		control.put("/memberAdd.do", new MemberAddControl());
		//수정
		control.put("/memberModifyForm.do", new MemberModifyForm());
		control.put("/memberModify.do", new MemberModify());
		//삭제
		control.put("/memberRemoveForm.do", new MemberReomveForm());
		control.put("/memberRemove.do", new MemberRemove());
		//상세보기
		control.put("/memberSearchForm.do", new MemberSearchForm());
		control.put("/memberSearch.do", new MemberSearch());
		//목록
		control.put("/memberList.do", new MemberList());
		//로그인관련
		control.put("/loginForm.do", new LoginForm());
		control.put("/login.do", new Login());
		control.put("/loginOut.do", new Logout());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
				
		Command command = control.get(path);
		command.exec(req, resp);
	}
	
}
