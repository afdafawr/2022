package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class Logout implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate(); // 웹브라우저에 있는 세션 파괴.
		
		HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");		
		
	}

}
