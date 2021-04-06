package com.example.demo.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {

        String math = "^(([\\u2E80-\\uFE4F](?![\\u3000-\\u303F]))+)$";
        String name = "顑";
        System.out.println(name.matches(math));

    }
    class tes{
        private LocalDateTime dateTime;
    }
    public static boolean isNumber(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNumeric(String str) {
        //Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");//这个也行
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static String str_isxdigit(String str1) {
        String REGEX ="[^(0-9).]";
        return Pattern.compile(REGEX).matcher(str1).replaceAll("").trim();
    }

    public static String lineToHump(String str) {
        Pattern linePattern = Pattern.compile("_(\\w)");
        //str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String getTime(Date date, DateFormat formatter) {
        return formatter.format(date);
    }

    public static String dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                      TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return test.getTime(new Date(targetTime), formatter);
    }

    public static String dealDateFormat(String oldDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date result;
        result = df.parse(oldDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(result);
    }

    public static void test2(List list1, List list2) {
        list1.retainAll(list2);
        System.out.println(list1);
    }

    public static boolean isChineseStr(String str) {
        Pattern pattern = Pattern.compile("/^[a-zA-Z0-9_]{0,}$/");
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }

    public static List<user> removeDupliById(List<user> persons) {
        Set<user> personSet = new TreeSet<>((o1, o2) -> o1.getFileType().compareTo(o2.getFileType()));
        personSet.addAll(persons);
        return new ArrayList<>(personSet);
    }

    static class user {
        private String id;
        private String fileType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        @Override
        public String toString() {
            return "user{" +
                    "id='" + id + '\'' +
                    ", fileType='" + fileType + '\'' +
                    '}';
        }
    }
   /* private String dealDateFormat(String s) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        try {
            return df.parse(s).toInstant().atZone(ZoneId.of("GMT+8")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            logger.error("工作流日期转换异常{}",s);
            e.printStackTrace();
        }
        return s;
    }*/

}
