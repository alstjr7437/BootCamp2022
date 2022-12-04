package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	      
  		int bnum = Integer.parseInt(request.getParameter("bnum"));
  	
  		BoardDao dao = new BoardDao();
  	
  		dao.delete(bnum);

	}

}
