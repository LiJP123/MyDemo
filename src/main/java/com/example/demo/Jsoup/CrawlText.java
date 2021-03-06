package com.example.demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlText {

    /***
     * 获取文本
     *
     * @param autoDownloadFile
     *            自动下载文件
     * @param Multithreading
     *            多线程 默认false
     * @param Url
     *            网站链接
     * @throws IOException
     */
    public static void getText(boolean autoDownloadFile, boolean Multithreading, String Url,String fileName,boolean b) throws IOException {

        String rule = "abs:href";
        List<String> urlList = new ArrayList<String>();
        Document document = Jsoup.connect(Url)
                .timeout(4000)
                .ignoreContentType(true)
                .userAgent("Mozilla\" to \"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0)")
                .get();
        if(b){
            urlList.add(Url);
        }
        Elements urlNode = document.select("a[href$=.html]");
        if(Url.indexOf(".html")>-1) {
            String url2 = null;
            for (Element element : urlNode) {
                Elements aStr = element.getElementsByTag("a");
                if (aStr.text().equals("下一章")) {
                    urlList.add(element.attr(rule));
                    url2 = element.attr(rule);
                    CrawTextThread.run(urlList,fileName);
                    break;
                }
            }
            if (url2 != null) {
                getText(true, true, url2, fileName,false);
            }
        }else{
            for (Element element : urlNode) {
                urlList.add(element.attr(rule));
            }
            CrawTextThread.run(urlList,fileName);
        }
    }
    public static void main( String[] args )
    {
        try {
            CrawlText.getText(true, true, "http://www.biquges.com/52_52642/25585323.html","大奉打更人",true);
//            CrawlText.getText(true, true, "https://www.biqumo.com/0_530/4158303.html","0_530");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}