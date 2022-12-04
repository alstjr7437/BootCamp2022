package makeGame;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class mBInsertService implements MakeGameService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");

	      //7. insertForm 에서 입력한 subject, content, writer 를 받아와 알맞는 변수에 입력하세요.
	      String mtitle = request.getParameter("mtitle");
	      String mtag = request.getParameter("mtag");
	      HttpSession session = request.getSession();
	      String mfile = null;
	      String mwriter = (String)session.getAttribute("email");
	      String dir = null;
	      
	      String contentType = request.getContentType();
	      if(contentType != null && contentType.startsWith("multipart/")) {
	    	  dir = request.getServletContext().getRealPath("/game");
	    	  System.out.println(dir);
	      }
	      File f = new File(dir);
	      if(!f.exists())
	    	  f.mkdir();
	      
	      Collection<Part> parts = request.getParts();
		  System.out.println(parts);
	      for(Part p : parts) {
	    	  System.out.println("hello1");
	    	  if(p.getHeader("Content-Disposition").contains("filename=")) {
	        	  System.out.println("hello2");
	    		  if(p.getSize() > 0) {
	    	    	  System.out.println("hello3");
	    	    	  mfile = p.getSubmittedFileName();
	    			  String filepath = dir + File.separator + mfile;
	    			  System.out.println(filepath);
	    			  p.write(filepath);
	    			  p.delete();
	    		  }
	    	  }
	      }
	      
	      MakeGameDto dto = new MakeGameDto(0, mtitle, mtag, mfile, mwriter, 0, null); 
	      MakeGameDao dao = new MakeGameDao();
	      dao.insert(dto);

	}

}
