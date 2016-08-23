package technology.it.stack.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SimpleSpider {

	public static Document demo(String url){
		Document d=null;
		try {
			d = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static void main(String[] args) {
		Document d=SimpleSpider.demo("http://www.baidu.com");
		Elements eles=d.getElementsByTag("a");
		for(int i=0;i<eles.size();i++){
			Element e=eles.get(i);
			System.out.println(e.text()+" -------链接:"+e.attr("href"));
		}
		System.out.println(d.getElementsByTag("a"));
		
	}

}
