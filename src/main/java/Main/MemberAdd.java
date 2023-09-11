package Main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MemberDao;
import Db.DBAction;
import Dto.Userinfo;

/**
 * Servlet implementation class MemberAdd
 */
@WebServlet("/MemberAdd")
public class MemberAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String age = request.getParameter("age");
				String sex = request.getParameter("sex");
				String Email = request.getParameter("Email");
				
				
				Userinfo userinfo = new Userinfo();
				userinfo.setId(id);
				userinfo.setPw(pw);
				userinfo.setName(name);
				userinfo.setAddress(address);
				userinfo.setAge(Integer.parseInt(age));
				userinfo.setSex(sex);
				userinfo.setEmail(Email);				
				
	}

}
