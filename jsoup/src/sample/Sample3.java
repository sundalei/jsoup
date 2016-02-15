package sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sample3 {
	public static void main(String[] args) {
		try {
			NetWorkSetter.setNetwork();
			Document doc = Jsoup.connect("http://www.infoq.com/news/").get();
			
			File newsFolder = new File(System.getProperty("user.dir"), "news");
			if(newsFolder.exists()) {
				File[] newsFileList = newsFolder.listFiles();
				for(File file : newsFileList) {
					file.delete();
				}
			} else {
				newsFolder.mkdir();
			}
			
			Elements newsElements = doc.getElementsByClass("news_type_block");
			Element newsElement = newsElements.get(0);
			Element newsTitle = newsElement.getElementsByTag("h2").get(0);
			getNewsContent(newsTitle, newsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getNewsContent(Element newsTitle, File newsFolder) {
		String href = newsTitle.getElementsByTag("a").get(0).attr("abs:href");
		int index = href.lastIndexOf("/");
		String title = href.substring(index + 1);
		
		File newsFile = new File(newsFolder, title + ".txt");
		try {
			newsFile.createNewFile();
			String content = getNewsContent_sub(href);
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(newsFile), "utf-8");
			osw.write(content);
			osw.flush();
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getNewsContent_sub(String href) {
		try {
			StringBuilder builder = new StringBuilder();
			Document doc = Jsoup.connect(href).get();
			
			Element newsTitle = doc.select("div[id=content] >h1").get(0);
			String title = newsTitle.html();
			builder.append(title).append("\n");
			builder.append("\n");
			
			Elements content = doc.select("div.text_info");
			Elements p = content.select("p");
			for(Element p1 : p) {
				String pContent = p1.text();
				builder.append(pContent).append("\n");
				builder.append("\n");
			}
			
			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
