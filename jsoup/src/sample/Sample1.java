package sample;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Sample1 {
	public static void main(String[] args) {
		try {
			NetWorkSetter.setNetwork();
			Document doc = Jsoup.connect("http://www.infoq.com/news/").get();
			System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
