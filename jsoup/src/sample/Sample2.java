package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class Sample2 {
	public static void main(String[] args) {
		String html = "<html><head><title>First parse</title></head>"
				  + "<body><p>Parsed HTML into a doc.</p><div class='comments'>"
				  + "<a href='#'>comments</a></div><span>One</span>"
				  + "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p></body></html>";
		Document doc = Jsoup.parse(html);
		doc.select("div.comments a").attr("rel", "nofollow");
		Element div = doc.select("div").first();
		div.html("<p>lorem ipsum</p>");
		div.prepend("<p>First</p>");
		div.append("<p>Last</p>");
		Element span = doc.select("span").first(); 
		span.wrap("<li><a href='http://example.com/'></a></li>");
		
		String unsafe = "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
		String safe = Jsoup.clean(unsafe, Whitelist.basic());
		Cleaner cleaner = new Cleaner(Whitelist.basic());
		cleaner.clean(doc);
		System.out.println(doc);
	}
}
