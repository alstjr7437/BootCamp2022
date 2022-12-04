package makeGame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mBUpdateService implements MakeGameService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	      
  		int mnum = Integer.parseInt(request.getParameter("mnum"));
  		String mtitle = request.getParameter("mtitle");
  		String mtag = request.getParameter("mtag");
  	
  		MakeGameDao dao = new MakeGameDao();

  		dao.update(mnum, mtitle, mtag);		
      
	}

}
