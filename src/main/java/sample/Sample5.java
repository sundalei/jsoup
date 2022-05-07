package sample;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Sample5 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://jsoup.org").get();
			Element link = doc.select("a").first();
			String relHref = link.attr("href");
			String absHref = link.attr("abs:href");
			System.out.println(absHref);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
