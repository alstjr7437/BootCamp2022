package cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signUp.ProfileDao;
import signUp.SInsertService;
import signUp.SignUpService;

@WebServlet("*.cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	String viewPage = null;
    	
    	String uri = request.getRequestURI();
    	String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".cart"));
    	System.out.println("현재 페이지는 " + com + "입니다.");

    	if(com != null && com.equals("cart")) { 
    		viewPage = "/WEB-INF/TeamProject/cart.jsp";
    	} else if(com != null && com.equals("Cpay")) { 
    		CartService service = new Cpay();
    		int sum = Integer.parseInt(request.getParameter("sum"));
    		ProfileDao dao2 = new ProfileDao();
    		HttpSession session = request.getSession();
    		String smail = (String) session.getAttribute("email");
    		int credit = dao2.cashView(smail);
    		service.execute(request, response);
    		if(credit >= sum) {
        		viewPage = "/WEB-INF/TeamProject/cart.cart?error=0";
    		} else {
        		viewPage = "/WEB-INF/TeamProject/cart.cart?error=1";
    		}
    	}
    	
    	
    	RequestDispatcher rd = request.getRequestDispatcher(viewPage);
    	rd.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
