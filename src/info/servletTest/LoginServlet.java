package info.servletTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		// �����l��ݒ�
		String name = "�Q�X�g���[�U�[";
		String status = "���O�C�����s";
		request.setCharacterEncoding("windows-31J"); 

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// ID�ƃp�X���[�h�̃`�F�b�N
		if(id.equals("id") && pass.equals("password")) {
			name = "JP";
			status = "����";
		}else if(id.equals("") && pass.equals("")) {
			name = "noname";
			status = "������";
		}
		// status��login�ɓn��
		request.setAttribute("login", status);

		// �Z�b�V�����ɖ��O��ێ�
		HttpSession session = request.getSession(true);
		session.setAttribute("name",name);

		// result.jsp���Ăяo��
		request.getRequestDispatcher("/result.jsp").forward(request,response);
	}
}
