package makeGame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mBViewService2 implements MakeGameService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		MakeGameDto dto = new MakeGameDto();
		MakeGameDao dao = new MakeGameDao();

		int bview = dao.view(bnum);
		bview++;
		
		
		//6. BoardDao에 정의된 selectOne 메소드를 호출하여 원하는 레코드를 dto에 저장하시오.
		dao.viewUpdate(bview, bnum);
		dto = dao.selectOne(bnum);

		request.setAttribute("dto", dto);

	}

}
