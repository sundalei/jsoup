package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Sample3 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.infoq.com/news/").get();
			Elements cards = doc.getElementsByClass("card__title");
			cards.forEach(card -> getNewsContent(card.child(0)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getNewsContent(Element newsTitle) {
		String title = newsTitle.attr("title");
		System.out.println(title);
	}
}
