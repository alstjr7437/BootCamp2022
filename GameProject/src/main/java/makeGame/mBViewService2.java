package makeGame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mBViewService2 implements MakeGameService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		
		MakeGameDto dto = new MakeGameDto();
		MakeGameDao dao = new MakeGameDao();

		int mview = dao.view(mnum);
		mview++;
		
		
		//6. BoardDao에 정의된 selectOne 메소드를 호출하여 원하는 레코드를 dto에 저장하시오.
		dao.viewUpdate(mview, mnum);
		dto = dao.selectOne(mnum);

		request.setAttribute("dto", dto);

	}

}
