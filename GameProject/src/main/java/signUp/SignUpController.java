package signUp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.sign")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	String viewPage = null;
    	
    	String uri = request.getRequestURI();
    	String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".sign"));
    	System.out.println(com);

    	if(com != null && com.equals("index")) { 
    		viewPage = "/TeamProject/IntroductionPage.jsp";
    	} else if(com != null && com.equals("signup")) { 
    		viewPage = "/TeamProject/signup.jsp";
    	} else if(com != null && com.equals("login")) { 
    		viewPage = "/TeamProject/login.jsp";
    	} else if(com != null && com.equals("insert")) { 
    		SignUpService service = new SInsertService();
    		service.execute(request, response);
    		viewPage = "/TeamProject/login.sign";
    	} else if(com != null && com.equals("LoginCheck")) { 
    		SignUpService service = new LoginCheckService();
    		service.execute(request, response);
    		String Page = (String)request.getAttribute("Login");
    		viewPage = Page;
    	} else if(com != null && com.equals("MainPage")) { 
    		viewPage = "/TeamProject/MainPage.jsp";
    	} else if(com != null && com.equals("profile")) { 
    		viewPage = "/TeamProject/profile.jsp";
    	} else if(com != null && com.equals("profilemodify")) { 
    		viewPage = "/TeamProject/profilemodify.jsp";
    	} else if(com != null && com.equals("profileUpdate")) { 
    		SignUpService service = new ProfileUpdate();
    		service.execute(request, response);
    		viewPage = "/TeamProject/profile.sign";
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
