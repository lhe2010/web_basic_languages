package crawling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingEx02 {

	public static void main(String[] args) {
		
		try {
			String url = "https://news.naver.com/main/factcheck/main.nhn";
			Connection conn = Jsoup.connect(url);
		
			Document html = conn.get();
			
			ArrayList<String> titles = new ArrayList<String>();
			ArrayList<String> results = new ArrayList<String>();
			ArrayList<String> urls = new ArrayList<String>();
			
			Elements bodies = html.getElementsByClass("fact_lst _factcheck_body");
			
			for (Element body : bodies) {
				for (Element section : body.getElementsByClass("info_area")) {
					System.out.println(section.getElementsByClass("txt").text());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
