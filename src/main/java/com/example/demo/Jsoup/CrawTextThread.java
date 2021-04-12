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

public class CrawTextThread extends Thread{
    private static String P1="[^\\d\r\n]*?(\\d+)[^\r\n]*?(章)";
    private static String P2="[^\\d\r\n]*?(\\d+)[^\r\n]*?";
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

    @Override
    public void run() {
        String content;
        File file = new File(PATH+fileName+".txt");
        try {
            createFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String url : UrlList) {
            try {
                Document document = Jsoup.connect(url).timeout(6000).get();
                String title = document.select("h1").toString();
                content = document.select("#content").html();
                writeTxtFile(isContains(title),FileterHtml(content), file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static String FileterHtml(String str) {
        str=str.replaceAll("<br>", "");
        str=str.replaceAll("<h1>", "").replaceAll("</h1>", "");
        str=str.replaceAll("&nbsp;", "");
        return str.replaceAll(" ", "").replaceAll("<br>", "\r\n");

    }
    public static String isContains(String title){
        title=FileterHtml(title);
        String title2=title;
        String z="";
        if(title.indexOf("章）")>-1||title.indexOf("章)")>-1){
            title2=title.split("章）").length>0?title.split("章）")[0]:title.split("章\\)")[0];
            if(title.split("章）").length>1){
                String [] s=title.split("章）");
                for (int i=1;i<s.length;i++){
                    z=z+"章）"+s[i];
                }
            }else if(title.indexOf("章）")>-1){
                z=z+"章）";
            }
            if(title.split("章\\)").length>1){
                String [] s=title.split("章\\)");
                for (int i=1;i<s.length;i++){
                    z=z+"章\\)"+s[i];
                }
            }else if(title.indexOf("章\\)")>-1){
                z=z+"章\\)";
            }
        }
        String str=title2.trim().substring(0,1);
        if(!str.equals("第")){
            Pattern p=Pattern.compile(P1);
            Matcher m=p.matcher(title2);
            if (!m.find(0)) {
                Pattern p2=Pattern.compile(P2);
                Matcher m2=p2.matcher(title2);
                if (m2.find(0)) {
                    title="第"+m2.group(0).trim()+"章 "+title2.split(m2.group(1))[1].trim()+z;
                }
            }
        }
        return title;
    }
}