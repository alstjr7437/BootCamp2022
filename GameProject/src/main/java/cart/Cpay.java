package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signUp.ProfileDao;

public class Cpay implements CartService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결제 처리. 해당 유저의 장바구니를 비워줌
		request.setCharacterEncoding("utf-8");

		CartDao dao = new CartDao();
		
		ProfileDao dao2 = new ProfileDao();
		HttpSession session = request.getSession();
		String smail = (String) session.getAttribute("email");
		int sum = Integer.parseInt(request.getParameter("sum"));
		
		int credit = dao2.cashView(smail);
		
		if(credit >= sum) {
			dao.payClearCart(smail, sum);
			dao2.cashUpdate2(smail, sum);
		} else {
			return;
		}
		

	}
}
