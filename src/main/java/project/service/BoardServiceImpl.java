package project.service;

import java.util.List;

import project.dao.BoardDao;
import project.entilty.Board;

public class BoardServiceImpl implements BoardService {
	private BoardDao bDao = new BoardDao();

	@Override
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		query = "%" + query + "%";
		List<Board> list = bDao.getBoardList(field, query, COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public Board getBoard(int bid) {
		return bDao.getBoard(bid);
	}

	@Override
	public int getBoardCount(String field, String query) {
		return bDao.getBoardCount(field, query);
	}

	@Override
	public void insertBoard(Board board) {
		bDao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int bid) {
		bDao.deleteBoard(bid);
	}

	@Override
	public void increaseViewCount(int bid) {
		bDao.increaseCount("view", bid);
	}

	@Override
	public void increaseReplyCount(int bid) {
		bDao.increaseCount("reply", bid);
	}

}