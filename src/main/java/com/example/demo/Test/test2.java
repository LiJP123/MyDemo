package com.example.demo.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {

        String s=" 005 心志";
        System.out.println(isContains(s));
    }
    public static String isContains(String title){
        String str=title.trim().substring(0,1);
        if(!str.equals("第")){
            String regex="[^\\d\r\n]*?(\\d+)[^\r\n]*?(章)";
            Pattern p=Pattern.compile(regex);
            Matcher m=p.matcher(title);
            if (!m.find(0)) {
                String regex2="[^\\d\r\n]*?(\\d+)[^\r\n]*?";
                Pattern p2=Pattern.compile(regex2);
                Matcher m2=p2.matcher(title);
                if (m2.find()) {
                    title="第"+m2.group(0).trim()+"章 "+title.split(m2.group(1))[1].trim();
                }
            }
        }
        return title;
    }
}
