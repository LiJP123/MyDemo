package com.example.demo.Jsoup;

import java.util.Map;

public class ChineseNumToArabicNumUtil {
    private static Integer result = 0;
    // HashMap
    private static Map<String, Integer> unitMap = new java.util.HashMap<String, Integer>();
    private static Map<String, Integer> numMap = new java.util.HashMap<String, Integer>();

    // 字符串分离
    private static String stryi = new String();
    private static String stryiwan = new String();
    private static String stryione = new String();
    private static String strwan = new String();
    private static String strone = new String();

    /**
     * 将汉字中的数字转换为阿拉伯数字
     *
     * @param chnStr
     * @return
     */
    public static void ChangeChnString(String chnStr) {
        // unit
        unitMap.put("十", 10);
        unitMap.put("百", 100);
        unitMap.put("千", 1000);
        unitMap.put("万", 10000);
        unitMap.put("亿", 100000000);
        // num
        numMap.put("零", 0);
        numMap.put("一", 1);
        numMap.put("二", 2);
        numMap.put("两", 2);
        numMap.put("三", 3);
        numMap.put("四", 4);
        numMap.put("五", 5);
        numMap.put("六", 6);
        numMap.put("七", 7);
        numMap.put("八", 8);
        numMap.put("九", 9);

        // 去零
        for (int i = 0; i < chnStr.length(); i++) {
            if ('零' == (chnStr.charAt(i))) {
                chnStr = chnStr.substring(0, i) + chnStr.substring(i + 1);
            }
        }
        // 分切成三部分
        int index = 0;
        boolean yiflag = true;
        boolean yiwanflag = true; //亿字节中存在万
        boolean wanflag = true;
        for (int i = 0; i < chnStr.length(); i++) {
            if ('亿' == (chnStr.charAt(i))) {
                // 存在亿前面也有小节的情况
                stryi = chnStr.substring(0, i);
                if (chnStr.indexOf('亿' + "") > chnStr.indexOf('万' + "")) {
                    stryi = chnStr.substring(0, i);
                    for (int j = 0; j < stryi.length(); j++) {
                        if ('万' == (stryi.charAt(j))) {
                            yiwanflag = false;
                            stryiwan = stryi.substring(0, j);
                            stryione = stryi.substring(j + 1);
                        }
                    }
                }
                if(yiwanflag){//亿字节中没有万，直接赋值
                    stryione = stryi;
                }
                index = i + 1;
                yiflag = false;// 分节完毕
                strone = chnStr.substring(i + 1);

            }
            if ('万' == (chnStr.charAt(i)) && chnStr.indexOf('亿' + "") < chnStr.indexOf('万' + "")) {
                strwan = chnStr.substring(index, i);
                strone = chnStr.substring(i + 1);
                wanflag = false;// 分节完毕
            }
        }
        if (yiflag && wanflag) {// 没有处理
            strone = chnStr;
        }
    }

    // 字符串转换为数字
    public static Integer chnStrToNum(String str) {
        Integer strreuslt = 0;
        Integer value1 = 0;
        Integer value2 = 0;
        Integer value3 = 0;
        if (str.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            char bit = str.charAt(i);
            // 数字
            if (numMap.containsKey(bit + "")) {
                value1 = numMap.get(bit + "");
                if (i == str.length() - 1) {
                    strreuslt += value1;
                }

            }
            // 单位
            else if (unitMap.containsKey(bit + "")) {
                value2 = unitMap.get(bit + "");
                if (value1 == 0 && value2 == 10L) {
                    value3 = 1 * value2;
                } else {
                    value3 = value1 * value2;
                    // 清零避免重复读取
                    value1 = 0;
                }
                strreuslt += value3;
            }
        }
        return strreuslt;
    }

    // 组合数字
    public static Integer ComputeResult(String chnStr) {
        ChangeChnString(chnStr);
        Integer stryiwanresult = chnStrToNum(stryiwan);
        Integer stryioneresult = chnStrToNum(stryione);
        Integer strwanresult = chnStrToNum(strwan);
        Integer stroneresult = chnStrToNum(strone);
        result = (stryiwanresult + stryioneresult) * 100000000 + strwanresult * 10000 + stroneresult;
        // 重置
        stryi = "";
        strwan = "";
        strone = "";
        return result;
    }

    /**
     * 将数字转换为中文数字
     *
     * @param chineseNum
     * @return
     */
    public static String arabicNumToChineseNum(String chineseNum) {
        String[] s1 = {"零", "一", "二","两", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String result = "";
        int n = chineseNum.length();
        for (int i = 0; i < n; i++) {
            int num = chineseNum.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                result += s1[num] + s2[n - 2 - i];
            } else {
                result += s1[num];
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(arabicNumToChineseNum("32342342"));
        System.out.println(ComputeResult("二千零二"));
    }
}
