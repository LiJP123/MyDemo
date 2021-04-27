package com.example.demo.Test;


import com.example.demo.Jsoup.ConvertUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
//        String P1="[^\\d\r\n]*?(\\d+)[^\r\n]*?(章)";
        String P1 = "[^\\d\r\n]*?(\\d+)[^\r\n]*?";
        String title = " 066 寒月（第六章）";

        String str = title.trim().substring(0, 1);
        if (!str.equals("第")) {
            Pattern p = Pattern.compile(P1);
            Matcher m = p.matcher(title);
            if (m.find(0)) {
                String str2 = ConvertUtil.getChineseFromArabic(Integer.valueOf(m.group(0).trim()));
                Integer i = ConvertUtil.getArabicFromChinese(str2);
                title = title.trim().substring(title.indexOf(i.toString()) + 1);
                title = "第" + i + "章 " + title;
            }
        }
        System.out.println(title);
    }

}
