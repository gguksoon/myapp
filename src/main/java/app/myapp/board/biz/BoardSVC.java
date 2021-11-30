package app.myapp.board.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.myapp.board.mapper.BoardMPR;

@Service
public class BoardSVC {

	@Autowired
	private BoardMPR boardMPR;
}
