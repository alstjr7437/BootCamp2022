package signUp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CashUpdate implements SignUpService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
  		int cash = Integer.parseInt(request.getParameter("cash"));
		String email = (String) session.getAttribute("email");

		ProfileDao dao = new ProfileDao();
		dao.cashUpdate(email, cash);

	}

}
