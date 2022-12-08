package common;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling {

	public static void main(String[] args) throws IOException {
		String url = "http://data.krx.co.kr/contents/MDC/MDI/mdiLoader/index.cmd?menuId=MDC0201010105";
		Document doc = Jsoup.connect(url).get();
		//  > div:nth-child(1)
		Elements elem = doc.select("div.CI-MDI-CONTENT-SCROLL");
		System.out.println(doc);
		System.out.println(elem);
		/*for(Element e : elem.select("span.title")) {
			
			System.out.println(e.text());
			
		}*/
		
	}
	
	
}
