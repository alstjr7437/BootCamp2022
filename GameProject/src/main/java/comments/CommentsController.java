package comments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BListService;
import board.BoardService;

@WebServlet("*.cmt")
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	String viewPage = null;
    	
    	String uri = request.getRequestURI();
    	String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".cmt"));
    	
    	if(com != null && com.equals("CInsert")) { 
    		CommentsService service = new CInsertService();
    		service.execute(request, response);
    		HttpSession session = request.getSession();
    		int bnum = (int)session.getAttribute("bnum");	
    		viewPage = "boardView.board?bnum="+bnum;
    	} else if(com != null && com.equals("mCInsert")) { 
    		CommentsService service = new mCInsertService();
    		service.execute(request, response);
    		HttpSession session = request.getSession();
    		int mnum = (int)session.getAttribute("mnum");	
    		viewPage = "mBoardView.make?mnum="+mnum;
    	} else if(com != null && com.equals("cDelete")) { 
    		CommentsService service = new cDeleteService();
    		service.execute(request, response);
    		HttpSession session = request.getSession();
    		int bnum = (int)session.getAttribute("bnum");	
    		viewPage = "boardView.board?bnum="+bnum;
    	}  else if(com != null && com.equals("mCDelete")) { 
    		CommentsService service = new cDeleteService();
    		service.execute(request, response);
    		HttpSession session = request.getSession();
    		int mnum = (int)session.getAttribute("mnum");	
    		viewPage = "mBoardView.make?mnum="+mnum;
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
