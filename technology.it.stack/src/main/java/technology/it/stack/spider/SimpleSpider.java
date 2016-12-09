package technology.it.stack.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class SimpleSpider {

	public static Document demo(String url){
		Document d=null;
		try {
			d = Jsoup.connect(url).timeout(5 * 1000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static void main(String[] args) {
		Document d=SimpleSpider.demo("http://www.fob001.cn/jxjh.htm?name=JIN+XIU+HE&s=search&ac=a");
		Elements eles=d.select("tr>:contains(004N)");
		if(eles.size()>0){
			for(Element e:eles){
				System.out.println(e.parent().select("td").get(0).text());
				System.out.println(e.parent().select("td").get(1).text());
				System.out.println(e.parent().select("td").get(2).text());
				System.out.println(e.parent().select("td").get(3).text());
			}
		}
		

	/*	for(Node node:nodes){
			System.out.println(node.outerHtml());
			System.out.println(node.nodeName());
		}*/

		
	}

}
