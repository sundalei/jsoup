package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Sample4 {
	public static void main(String[] args) {
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();
		
		String text = doc.body().text();
		String linkHref = link.attr("href");
		String linkText = link.text();
		
		String linkOutHtml = link.outerHtml();
		String linkInnerHtml = link.html();
		System.out.println(linkInnerHtml);
	}
}
