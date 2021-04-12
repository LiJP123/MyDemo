package com.example.demo.Test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String title=" 066 寒月（第六章）";
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
        String P1="[^\\d\r\n]*?(\\d+)[^\r\n]*?(章)";
        String P2="[^\\d\r\n]*?(\\d+)[^\r\n]*?";
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
        System.out.println(title);
    }

}
