package app.myapp.board.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import app.myapp.board.biz.BoardSVC;

@RestController
@RequestMapping("/board")
public class BoardCTL {

	@Autowired
	private BoardSVC boardSVC;

	@RequestMapping("/view")
	public ModelAndView view(ModelAndView model, String page) {
		List<LinkedHashMap<String, Object>> list = getData(page);
		model.addObject("list", list);
		System.out.println(list.size());
		model.setViewName("board/board");
		return model;
	}

	private List<LinkedHashMap<String, Object>> getData(String page) {
		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
		LinkedHashMap<String, Object> map = null;
		int num = (Integer.parseInt(page) == 1 ? 1 : (Integer.parseInt(page) - 1) * 10);
//		for (int i = num; i < num + 10 + (num == 1 ? -1 : 0); i++) {
		for (int i = num; i < num + 1; i++) {

			// 1. 수집 대상 URL
			String url = "https://localhost/page/" + i;
			try {
				// 2. Connection 생성
				Connection conn = Jsoup.connect(url);

				// 3. HTML 파싱.
				Document html = conn.get(); // conn.post();

				// 4. 요소 탐색
				Elements contents = html.getElementsByClass("columns");
				for (int j = 0; j < contents.size(); j++) {
					Element content = contents.get(j); 
					map = new LinkedHashMap<String, Object>();

					Elements img = content.getElementsByTag("img");
					for (Element elm : img) {
						String href = elm.attr("src");
						System.out.println(href);
						map.put("img", href);
					}

					Elements title = content.getElementsByClass("title");
					for (Element elm : title) {
						String title1 = elm.text();
						System.out.println(title1);
						map.put("title", title1);
					}

					Elements date = content.getElementsByClass("subtitle");
					for (Element elm : date) {
						String date1 = elm.text();
						System.out.println(date1);
						map.put("date", date1);
					}

					Elements torrent = content.getElementsByClass("button");
					for (Element elm : torrent) {
						String date1 = elm.attr("href");
						if (date1.contains(".torrent")) {
							System.out.println(date1);
							map.put("downLink", date1);
						}
					}
					list.add(map);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return list;
	}
}
