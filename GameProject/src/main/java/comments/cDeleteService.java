package comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cDeleteService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//언어 설정
		request.setCharacterEncoding("utf-8");
		//클라이언트에서 전달된 데이터
		int conum = Integer.parseInt(request.getParameter("conum"));
		
		//dao 및 dto 전달 후 인서트하기
		CommentsDao dao = new CommentsDao();
		dao.commentsDelete(conum);

	}

}
