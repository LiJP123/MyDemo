package com.example.demo.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
       /* Calendar now = Calendar.getInstance();
        System.out.println("年：" + now.get(Calendar.YEAR));
        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));
        System.out.println("日：" + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + now.get(Calendar.MINUTE));
        System.out.println("秒：" + now.get(Calendar.SECOND));
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + sdf.format(d));*/
        //System.out.printf(String.valueOf(isChineseStr("SDFSDF2342SFSD-")));
       /* String str = "当前时间sdfsSDF234-SDFS";
        if (str.getBytes().length == str.length()) {
            System.out.println("无汉字");
        }else {
            System.out.println("有汉字");
        }*/
       /* String s = "2020-01-09T10:22:54.098+0000";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        try {
            System.out.println(df.parse(s).toInstant().atZone(ZoneId.of("GMT+8")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
     /*  List list=null;
        System.out.println(list.size());*/

//        try {
//            System.out.println(test.dateTransformBetweenTimeZone(new Date(dealDateFormat(s)), formatter, srcTimeZone, destTimeZone));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
       /* LocalDate nowNew = LocalDate.now();
        if (LocalDate.parse("2020-02-01").isAfter(nowNew)) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }
        if (LocalDate.parse("2020-02-01").isBefore(nowNew)) {
            System.out.println(3);
        }else {
            System.out.println(4);
        }
        System.out.println(LocalDate.parse("2020-02-01").compareTo(nowNew));
        System.out.println(LocalDate.parse("2020-02-03").compareTo(nowNew));
        System.out.println(LocalDate.parse("2020-02-04").compareTo(nowNew));*/
        /*String s=lineToHump("engine_code");
        System.out.println(s);*/
        /*String s="11129002,";
        String s1[]=s.split(",");
        System.out.println(s1.length);*/
        /*System.out.println(!"".equals(""));*/
        /*JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8080/test/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects = new Object[0];
        try {
            objects = client.invoke("getUser", "411001");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出调用结果
        System.out.println("*****" + objects[0].toString());*/
      /*  String s="{\n" +
                "    \"HEAD\":{\n" +
                "        \"bizTransactionId\":\"TA_MDM.CLM_SYC_1235_20200407105656\",\n" +
                "        \"count\":\"1\",\n" +
                "        \"consumer\":\"1\",\n" +
                "        \"sevlevel\":\"1\",\n" +
                "        \"account\":\"1\",\n" +
                "        \"password\":\"1\"\n" +
                "    },\n" +
                "    \"LIST\":[\n" +
                "        {\n" +
                "            \"OutSysID\":\"1\",\n" +
                "            \"OutSysName\":\"1\",\n" +
                "            \"OutSysDataID\":\"1\",\n" +
                "            \"MDMID\":\"\",\n" +
                "            \"CS_Type\":\"1\",\n" +
                "            \"CS_SubType\":\"1\",\n" +
                "            \"agent_code\":\"\",\n" +
                "            \"agent_name\":\"欧豪汽车销售服务（沈阳）有限公司\",\n" +
                "            \"Title\":\"1\",\n" +
                "            \"CS_CertiType\":\"5\",\n" +
                "            \"orgcode\":\"91210114MA0U4MLXXC\",\n" +
                "            \"open_bank\":\"\",\n" +
                "            \"bank_account\":\"\",\n" +
                "            \"BankCountry\":\"\",\n" +
                "            \"BankCode\":\"\",\n" +
                "            \"CNAPS\":\"1\",\n" +
                "            \"simple_name\":\"欧豪汽车\",\n" +
                "            \"reg_date\":\"2017-05-10\",\n" +
                "            \"CompanyType\":\"\",\n" +
                "            \"name\":\"武晓亮\",\n" +
                "            \"reg_capital_amt\":\"200\",\n" +
                "            \"busi_start_date\":\"\",\n" +
                "            \"busi_end_date\":\"\",\n" +
                "            \"structure\":\"\",\n" +
                "            \"Country\":\"CN\",\n" +
                "            \"created_by\":\"wanggang11\",\n" +
                "            \"Cbusiness\":\"JR01\",\n" +
                "            \"Caccgroup\":\"D201\",\n" +
                "            \"BillingTelephone\":\"\",\n" +
                "            \"CRiskLevel\":\"Y001\",\n" +
                "            \"WarnReason\":\"\",\n" +
                "            \"CS_State\":\"0\",\n" +
                "            \"province_id\":\"21\",\n" +
                "            \"city_id\":\"2101\",\n" +
                "            \"country_id\":\"210102\",\n" +
                "            \"reg_addr\":\"辽宁省沈阳市于洪区旺港街201号13门\",\n" +
                "            \"CS_addr_state\":\"0\",\n" +
                "            \"ContactType\":\"05\",\n" +
                "            \"cust_name\":\"武晓亮\",\n" +
                "            \"mobile_no\":\"15611901613\",\n" +
                "            \"CS_legal_state\":\"0\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";*/
       /* com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(s, Map.class);
            System.out.println(map);

            String jsonString =  mapper.writeValueAsString(map);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

       /*String ss="￥325000.00";
        System.out.println(isNumber(ss.replace("￥","")));
       if(!isNumeric(ss)){
           System.out.println(str_isxdigit(ss));
       }else{
           System.out.println(ss);
       }*/
      /* String ss="ZCOM201942274;ZCOM201911599;ZCOM201913361;ZCOM201911393;ZCOM201911991;ZCOM201942079;ZCOM201911508;ZCOM201913308;ZCOM201911384;ZCOM201911823;ZCOM201911630;ZCOM201913271;ZCOM201911342;ZCOM201911625;ZCOM201937091;ZCOM201911503;ZCOM201911023;ZCOM201911619;ZCOM201926835;ZCOM201911496;ZCOM201912820;ZCOM201942705;ZCOM201911614;ZCOM201920686;ZCOM201911486;ZCOM201912558;ZCOM201910108;ZCOM201942584;ZCOM201911609;ZCOM201913368;ZCOM201911402;ZCOM201912043;ZCOM201909077;ZCOM201942287;ZCOM201911601;ZCOM201913363;ZCOM201911397;ZCOM201912003;ZCOM201942143;ZCOM201911595;ZCOM201913358;ZCOM201911387;ZCOM201911825;ZCOM201911632;ZCOM201911505;ZCOM201913300;ZCOM201911372;ZCOM201911819;ZCOM201911627;ZCOM201937615;ZCOM201911094;ZCOM201911622;ZCOM201937063;ZCOM201911500;ZCOM201912830;ZCOM201911616;ZCOM201924952;ZCOM201911489;ZCOM201912571;ZCOM201910720;ZCOM201942646;ZCOM201911611;ZCOM201913541;ZCOM201911424;ZCOM201912054;ZCOM201909245;ZCOM201942411;ZCOM201911604;ZCOM201913365;ZCOM201911399;ZCOM201912020;ZCOM201911807;ZCOM201942180;ZC";
        System.out.println(ss.length());*/
       /* SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(443025573);
        System.out.println(dateStr );*/
        /*SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long time = dateformat.parse("2019-04-17 14:54:38").getTime();
            System.out.println(String.valueOf(time).substring(4, 13));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

           /* String result =java.net.URLDecoder.decode("\"https%3A%2F%2Fobs.ca-sinfusi.com%2Fhwobs%2Flambda%2F45ed5a9bbfb24d8ab1c47f8a5b8c30c0.png%3FAWSAccessKeyId%3D4IFTBL1TTL7DCDF3FHKF%26Expires%3D1599625953%26x-image-process%3Dimage%252Fresize%252Cm_lfit%252Ch_4096%252Cw_4096%252Fquality%252Cq_100%26Signature%3Dvljt%252FWWsxF8PqJNGaQ2%252F8XmubWo%253D\"");
            System.out.println(result);*/
//           com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//           String ss="{\"data\":[{\"historyOverDueJson\":{\"msg\":\"征信查询中\",\"excFlag\":\"10001000\"},\"name\":\"孙浩\",\"currentOverDueJson\":{\"$ref\":\"$.data[0].historyOverDueJson\"},\"idNo\":\"33100219441028309X\",\"overdueCase\":\"11483000\"}]}";
//        try {
//            Map map=objectMapper.readValue(ss, Map.class);
//            System.out.println(map);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String s1="27eb5eef57844fd6b979064a1c616138pdf";
//        String s2 = s1.substring(s1.lastIndexOf(".")+1);
//        System.out.println(s2);
//        System.out.println(s1.lastIndexOf("."));


//        Calendar cal1 = Calendar.getInstance();
//        String times1 = new SimpleDateFormat("yyyy/MM/dd").format(cal1.getTime());
//        String times2 = new SimpleDateFormat("HHmmss").format(cal1.getTime());
//        System.out.println(times1);
//        System.out.println(times2);
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
