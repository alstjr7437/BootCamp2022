package makeGame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mBUpdateService implements MakeGameService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	      
  		int bnum = Integer.parseInt(request.getParameter("bnum"));
  		String btitle = request.getParameter("btitle");
  		String btag = request.getParameter("btag");
  	
  		MakeGameDao dao = new MakeGameDao();
  	
  		dao.update(bnum, btitle, btag);		
      
	}

}
