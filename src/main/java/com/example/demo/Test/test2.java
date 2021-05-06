package com.example.demo.Test;


import com.example.demo.Jsoup.ConvertUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
//        String P1="[^\\d\r\n]*?(\\d+)[^\r\n]*?(章)";
        String P1 = "[^\\d\r\n]*?(\\d+)[^\r\n]*?";
        String title = "毒毒1518章出人意料";

        String str = title.trim().substring(0, 1);
        if (!str.equals("第")) {
            Pattern p = Pattern.compile(P1);
            Matcher m = p.matcher(title);
            if (m.find(0)) {
                Integer arabic=null;
                try{
                    arabic=Integer.valueOf(m.group(0).trim());
                }catch (Exception e){
                    arabic=Integer.valueOf(m.group(1).trim());
                }
                System.out.println(m.group(0));
                String str2 = ConvertUtil.getChineseFromArabic(arabic);
                Integer i = ConvertUtil.getArabicFromChinese(str2);
                System.out.println(title.indexOf(i.toString())+i.toString().length());
                title = title.trim().substring(title.indexOf(i.toString()) + i.toString().length()+1);
                title = "第" + i + "章 " + title;
            }
        }
        System.out.println(title);
    }

}
