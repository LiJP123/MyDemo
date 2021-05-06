package com.example.demo.Jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawTextThread{
    private static String P1="[^\\d\r\n]*?(\\d+)[^\r\n]*?";
    List<String> UrlList;
    String fileName;

    public CrawTextThread(List<String> urlList,String fileName) {
        this.UrlList = urlList;
        this.fileName = fileName;
    }

    public static String PATH = "src\\main\\java\\com\\example\\demo\\Jsoup\\";

    /**
     * 创建文件
     *
     * @param fileName
     * @return
     */
    public static void createFile(File fileName) throws Exception {
        try {
            if (!fileName.exists()) {
                fileName.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeTxtFile(String title,String content, File fileName) throws Exception {
        RandomAccessFile mm = null;
        FileOutputStream o = null;
        try {
            System.out.println("title:"+title);
            o = new FileOutputStream(fileName,true);
            o.write("\r\n".getBytes());// 写入一个换行
            o.write(title.getBytes("UTF-8"));
            o.write("\r\n".getBytes());// 写入一个换行
            o.write(content.getBytes("UTF-8"));
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mm != null) {
                mm.close();
            }
        }
    }

    public static void run(List<String> urlList,String fileName) {
        String content;
        File file = new File(PATH+fileName+".txt");
        try {
            createFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String url : urlList) {
            try {
                Document document = Jsoup.connect(url).timeout(6000).get();
                String title2 = document.select("h1").toString();
                content = document.select("#content").html();
                String title =isContains(title2);
                if(title.trim().substring(0,1).equals("第")&&title.indexOf("章")>-1){
                    Integer t=ConvertUtil.getArabicFromChinese(title.substring(1,title.indexOf("章")));
                    if(t>0){
                        try{
                            title="第 "+t+title.substring(title.indexOf(" 章"));
                        }catch (Exception e){
                            title=FileterHtml(title2);
                        }
                    }
                }
                writeTxtFile(title,FileterHtml(content), file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static String FileterHtml(String str) {
        str=str.replaceAll("<br> \n", "");
        str=str.replaceAll("<br>", "");
        str=str.replaceAll("<p>", "");
        str=str.replaceAll("</p>", "");
        str=str.replaceAll("<h1>", "").replaceAll("</h1>", "");
        str=str.replaceAll("&nbsp;", "");
        return str.replaceAll(" ", "");

    }
    public static String isContains(String title){
        title=FileterHtml(title);
        if(!title.trim().substring(0,1).equals("第")){
            Pattern p = Pattern.compile(P1);
            Matcher m = p.matcher(title);
            if (m.find(0)) {
                Integer arabic=null;
                boolean b=false;
                try{
                    arabic=Integer.valueOf(m.group(0).trim());
                }catch (Exception e){
                    arabic=Integer.valueOf(m.group(1).trim());
                    b=true;
                }
                String str2 = ConvertUtil.getChineseFromArabic(arabic);
                Integer i = ConvertUtil.getArabicFromChinese(str2);
                title = title.trim().substring(title.trim().indexOf(i.toString())+(i.toString().length()+(title.indexOf(".")>-1||b?1:0)));
                title = "第 " + i + " 章 " + title;
            }
        }
        return title;
    }
}