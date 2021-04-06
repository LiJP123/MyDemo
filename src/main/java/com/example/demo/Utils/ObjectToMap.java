package com.example.demo.Utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectToMap {

    public static void main(String[] args){
       /* String s="{\n" +
                "  \"fileName\" : \"04d53704-7620-45ea-a8e5-d0a6407e01db.jpg\",\n" +
                "  \"ecmCode\" : \"CLS_XS_GR_LDZRBZS(53edc7f0-f51d-47da-b5db-9e073a3f00c8)\",\n" +
                "  \"relationId\" : \"FTAUMAN201926653\",\n" +
                "  \"busiStageCode\" : \"OM_DDLC\"\n" +
                "}";
        System.out.println(s.length());*/
        Map map =new HashMap();
        String s="{\"data_list\":[{\"page_number\":0,\"single_data_list\":[{\"name\":\"车主\",\"value\":\"辽宁万德物流运输有限公司\",\"key\":\"car_owner\"},{\"name\":\"车牌号\",\"value\":\"辽MQ857挂\",\"key\":\"car_no\"},{\"name\":\"车架号\",\"value\":\"LB99L40C9K1JTM238\",\"key\":\"vin_code\"},{\"name\":\"盖章\",\"value\":\"yes\",\"key\":\"licensing_authority_seal\"},{\"name\":\"登记证编号\",\"value\":\"210013057177\",\"key\":\"sign_page_num\"},{\"name\":\"切片\",\"value\":\"d880dc787a1c4403808a1e9393b9a4d0.jpg\",\"key\":\"image\"}]}]}";
        map.put("resJson", s);

        ObjectMapper objectMapper2 =new ObjectMapper();
        try {
            String a=objectMapper2.writeValueAsString(map);
            test(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* List<Integer> numbers = new ArrayList<>(100000000);
        System.out.println("开始在准备数据");
        for (int i = 0; i < 100000000; i++) {
            numbers.add(i);
        }
        System.out.println("结束在准备数据");

        long begin = System.currentTimeMillis();
        System.out.println("处理开始");
        Integer tmpList = numbers.stream().filter(value -> value % 2 == 0).reduce(Integer::max).get();
        System.out.println(tmpList + "处理结束:" + (System.currentTimeMillis() - begin));*/
    }
    private static Set knowledgeIsRepeat(List<Map> orderList) {
        Set<Map> set = new TreeSet<Map>(new Comparator<Map>() {
            public int compare(Map a, Map b) {
                return a.get("companyCode").toString().compareTo(b.get("companyCode").toString());
            }
        });
        set.addAll(orderList);
        return set;
    }
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        TreeMap<String, Object> map = new TreeMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (key.equals("class")) {
                    continue;
                }
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }

        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    private static void  test(String json){
        try {
            ObjectMapper objectMapper =new ObjectMapper();
            Map<String,Object> map = objectMapper.readValue(json,Map.class);
            //ocr返回报文处理
            String resJson = (String) map.get("resJson");
            if (resJson != null) {
                Map<String, Object> resJonMap = objectMapper.readValue(resJson, Map.class);
                List dataList = (List) resJonMap.get("data_list");

                ///将返回的json串解析 重新组合json返回
                Map<String, Object> resultMap = new HashMap<String, Object>();
                if (dataList != null && dataList.size() > 0) {
                    for (int x = 0; x < dataList.size(); x++) {
                        Map lMap = (LinkedHashMap) dataList.get(x);
                        List sdList = (List) lMap.get("single_data_list");
                        System.out.println(getObsFileId(sdList));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private static String getObsFileId(List sdList){
        String obsFileId=null;
        if (sdList != null && sdList.size()>0){
            for (int i=0;i<sdList.size();i++){
                Map<String,Object> params = (Map) sdList.get(i);
                if (params.containsValue("image")){
                    obsFileId=(String) params.get("value");
                    break;
                }
            }
        }
        return obsFileId;
    }
}
