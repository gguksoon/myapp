package app.myapp.board.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.myapp.board.biz.BoardSVC;

@RestController
@RequestMapping("/board")
public class BoardCTL {

	@Autowired
	private BoardSVC boardSVC;
}
