package com.example.demo.Test;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        //1.定义格式
      /*  DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //2.把字符串转成localDate
        LocalDate localDate = LocalDate.now();

        //3.定义格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        //4.把 2019-01-01  转成  2019/01/01
        String format = localDate.format(dtf);
        System.out.println(format);*/
        // 获取当前LocalDate
//        LocalDate localDate1 = LocalDate.now();
//        System.out.println("localDate1:"+localDate1);
//        // localDate1加五天
//        LocalDate localDate2 = localDate1.plusDays(5);
//        System.out.println("localDate2："+localDate2);

        // localDate2减一天
//        LocalDate minusDays = localDate2.minusDays(1);
//        System.out.println("localDate2减一天："+minusDays);

        // 比较localDate1与localDate2，结果返回localDate1-localDate2的值
//        int i = localDate1.compareTo(localDate2);
//        System.out.println("localDate1与localDate2比较大小："+ i);
//        // 判断localDate1是否在localDate2之前，返回布尔值
//        boolean before = localDate1.isBefore(localDate2);
//        System.out.println("判断localDate1是否在localDate2之前："+before);
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse("9999-12-31", df);
//        LocalDate localDate2 = LocalDate.parse("2099-12-31", df);
//        LocalDate localDate3 = LocalDate.parse("2199-12-31", df);
//        System.out.println(localDate.isAfter(localDate2));
//        System.out.println(localDate.isBefore(localDate2));
//        System.out.println(localDate2.isAfter(localDate));
//        System.out.println(localDate2.isBefore(localDate));
//        BigDecimal d=new BigDecimal(5);
//        BigDecimal d2=new BigDecimal(0);
//        BigDecimal d3=new BigDecimal(-1);
//        System.out.println(d.compareTo(BigDecimal.ZERO));
//        System.out.println(d2.compareTo(BigDecimal.ZERO));
//        System.out.println(d3.compareTo(BigDecimal.ZERO));
//        if(d2.compareTo(BigDecimal.ZERO)<=0){
//            System.out.println(111);
//        }
//
//        String [] types={"11259009","11259010","11259011","11284000"};
//        if ( Arrays.binarySearch(types,"123123")<0) {
//            System.out.println("111");
//        }
//        System.out.println("2222");

//        String approveTime= LocalDateTime.now().toString();
//
//        List<String> tables=new ArrayList<String>(){{
//            add("omDisiNote");
//            add("omGrant");
//            add("omOrderRetPay");
//            add("omGrantAcct");
//            add("omOrderFinance");
//            add("omOptionOfferPro");
//            add("omOrderOffer");
//            add("omOrderCarbase");
//            add("omOrderSidecar");
//            add("omSleepRetSet");
//        }};
//        List<String>strs=new ArrayList<String>(){{
//            add("omDisiNote");
//            add("sdfsdfsdf");
//            add("omGrant");
//            add("omOrderRetPay");
//        }};
//
//
//        System.out.println(Collections.disjoint(strs,tables));
//        for(String  o1 :strs){
//            if(!tables.contains(o1)){
//                // 不包含
//                System.out.println(o1);
//            }else{
//                // 包含
//                System.out.println(o1);
//            }
//        }
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
