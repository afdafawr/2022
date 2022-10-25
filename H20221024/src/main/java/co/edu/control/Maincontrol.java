package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class Maincontrol implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session 정보가 있으면 main페이지로 이동
		//로그인페이지로 이동.		
		HttpSession session= req.getSession();
		String id = (String) session.getAttribute("id");
		if(id!=null) {		
		HttpUtil.forward(req, resp, "memberView/main.jsp");
		}else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}
	}

}
