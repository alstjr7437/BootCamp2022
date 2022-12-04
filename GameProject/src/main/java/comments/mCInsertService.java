package comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class mCInsertService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				HttpSession session = request.getSession();
				//클라이언트에서 전달된 데이터
				int cocode = (int)session.getAttribute("mnum");
				String cobcode = (String)session.getAttribute("email");
				String cotag = (String)request.getParameter("cotag");
				
				//dao 및 dto 전달 후 인서트하기
				CommentsDao dao = new CommentsDao();
				CommentsDto dto = new CommentsDto(0, cobcode, cocode, cotag, null, 2);
				dao.insert(dto);


	}

}
