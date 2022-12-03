package makeGame;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BInsertService;
import board.BListService;
import board.BUpdateService;
import board.BViewService;
import board.BViewService2;
import board.BoardService;

@MultipartConfig(
		maxFileSize = 10 * 1024 * 1024
		
	)

@WebServlet("*.make")
public class MakeGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	String viewPage = null;
    	
    	String uri = request.getRequestURI();
    	String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".make"));
    	System.out.println("현재 페이지는 " + com + "입니다.");
    	
    	if(com != null && com.equals("mBoard")) { 
    		MakeGameService service = new mBListService();
    		service.execute(request, response);
    		viewPage = "/WEB-INF/TeamProject/mBoard.jsp";
    	} else if(com != null && com.equals("mBoardWrite")) { 
    		viewPage = "/WEB-INF/TeamProject/mBoardWrite.jsp";
    	} else if(com != null && com.equals("mBoardView")) { 
    		MakeGameService service = new mBViewService2();
    		service.execute(request, response);
    		viewPage = "/WEB-INF/TeamProject/mBoardView.jsp";
    	} else if(com != null && com.equals("mBInsert")) { 
    		MakeGameService service = new mBInsertService();
    		service.execute(request, response);
    		viewPage = "mBoard.board";
    	} else if(com != null && com.equals("mBoardUpdate")) { 
    		MakeGameService service = new mBViewService();
    		service.execute(request, response);
    		viewPage = "/WEB-INF/TeamProject/mBoardUpdate.jsp";
    	} else if(com != null && com.equals("mBUpdate")) { 
    		MakeGameService service = new mBUpdateService();
    		service.execute(request, response);
    		viewPage = "/WEB-INF/TeamProject/mBoardView.board";
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
