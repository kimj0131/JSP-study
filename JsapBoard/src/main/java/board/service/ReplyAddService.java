package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.ReplyDAO;
import board.dto.ReplyDTO;

public class ReplyAddService implements Service{
	
	private static ReplyAddService instance = new ReplyAddService();
	
	ReplyDAO dao = new ReplyDAO();
	
	public static ReplyAddService getInstance() {
		return instance;
	}
	
	private ReplyAddService() {
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		try {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			
			ReplyDTO dto = new ReplyDTO();
			
			dto.setBoard_id(board_id);
			dto.setReply_content(request.getParameter("reply_content"));
			dto.setReply_password(request.getParameter("reply_password"));
			dto.setReply_writer(request.getParameter("reply_writer"));
			
			dao.add(dto);
			
			return "redirect::/detail?board_id=" + board_id;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect::/";
		}
		
	}

}
