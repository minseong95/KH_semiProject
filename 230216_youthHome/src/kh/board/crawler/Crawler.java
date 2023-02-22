package kh.board.crawler;

import java.util.Iterator;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	public static void main(String[] args) {
		String url = "https://soco.seoul.go.kr/youth/bbs/BMSR00015/list.do?menuNo=400008";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select("table.boardTable");
		Element elemtBody = element.select("tbody").get(0);
		
		System.out.println("--------------------------------");
		
		System.out.println(elemtBody);
		
		System.out.println("--------------------------------");
	}

}
