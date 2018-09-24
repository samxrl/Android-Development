package com.API;

/**
 * Created by iamxr on 18/9/20.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GetHL {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY ="bec067ce9ccee0e76da2d1b5eccc0f66";

    //汇率
    public  static double data5; //英镑
    public  static double data3; //港币
    public  static double data1; //美元
    public  static double data16; //瑞士法郎
    public  static double data9; //新加坡元
    public  static double data13; //瑞典克朗
    public  static double data12; //丹麦克朗
    public  static double data10; //挪威克朗
    public  static double data4; //日元
    public  static double data7; //加拿大元
    public  static double data6; //澳大利亚元
    public  static double data2; //欧元
    public  static double data18; //澳门元
    public  static double data17; //新台币
    public  static double data21; //韩国元


    public static double getData5() {
        getRequest1();
        return data5;
    }

    public static double getData3() {
        return data3;
    }

    public static double getData1() {
        return data1;
    }

    public static double getData16() {
        return data16;
    }

    public static double getData9() {
        return data9;
    }

    public static double getData13() {
        return data13;
    }

    public static double getData12() {
        return data12;
    }

    public static double getData10() {
        return data10;
    }

    public static double getData4() {
        return data4;
    }

    public static double getData7() {
        return data7;
    }

    public static double getData6() {
        return data6;
    }

    public static double getData2() {
        return data2;
    }

    public static double getData18() {
        return data18;
    }

    public static double getData17() {
        return data17;
    }

    public static double getData21() {
        return data21;
    }

    //1.人民币牌价
    public static void getRequest1(){
        String result =null;
        String url ="http://web.juhe.cn:8080/finance/exchange/rmbquot";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key
        params.put("type","0");//两种格式(0或者1,默认为0)

        try {
            result =net(url, params, "GET");
            JSONObject object = new JSONObject(result);
            if(object.getInt("error_code")==0){

                JSONArray jsonArray = object.getJSONArray("result");
                JSONObject object2 = jsonArray.getJSONObject(0);

                JSONObject rate5 = object2.getJSONObject("data5");
                data5 = rate5.getDouble("bankConversionPri");
                JSONObject rate3 = object2.getJSONObject("data3");
                data3 = rate3.getDouble("bankConversionPri");
                JSONObject rate1 = object2.getJSONObject("data1");
                data1 = rate1.getDouble("bankConversionPri");
                JSONObject rate16 = object2.getJSONObject("data16");
                data16 = rate16.getDouble("bankConversionPri");
                JSONObject rate9 = object2.getJSONObject("data9");
                data9 = rate9.getDouble("bankConversionPri");
                JSONObject rate13 = object2.getJSONObject("data13");
                data13 = rate13.getDouble("bankConversionPri");
                JSONObject rate12 = object2.getJSONObject("data12");
                data12 = rate12.getDouble("bankConversionPri");
                JSONObject rate10 = object2.getJSONObject("data10");
                data10 = rate10.getDouble("bankConversionPri");
                JSONObject rate4 = object2.getJSONObject("data4");
                data4 = rate4.getDouble("bankConversionPri");
                JSONObject rate7 = object2.getJSONObject("data7");
                data7 = rate7.getDouble("bankConversionPri");
                JSONObject rate6 = object2.getJSONObject("data6");
                data6 = rate6.getDouble("bankConversionPri");
                JSONObject rate2 = object2.getJSONObject("data2");
                data2 = rate2.getDouble("bankConversionPri");
                JSONObject rate18 = object2.getJSONObject("data18");
                data18 = rate18.getDouble("bankConversionPri");
                JSONObject rate17 = object2.getJSONObject("data17");
                data17 = rate17.getDouble("bankConversionPri");
                JSONObject rate21 = object2.getJSONObject("data21");
                data21 = rate21.getDouble("bankConversionPri");

                System.out.println(object.get("result"));

            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2.外汇汇率
    public static void getRequest2(){
        String result =null;
        String url ="http://web.juhe.cn:8080/finance/exchange/frate";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key
        params.put("type","");//两种格式(0或者1,默认为0)

        try {
            result =net(url, params, "GET");
            JSONObject object = new JSONObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                    out.writeBytes(urlencode(params));
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}


