package com.ok.okhelper.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ok.okhelper.pojo.po.News;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpClient {


        public static String doPost(String requestUrl , String method) {
                String res="";
                try {
                        URL url = new URL(requestUrl);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod(method);// 提交模式
                        // conn.setConnectTimeout(10000);//连接超时 单位毫秒
                        // conn.setReadTimeout(2000);//读取超时 单位毫秒
                        // 发送POST请求必须设置如下两行
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        // 获取URLConnection对象对应的输出流
                        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                        // flush输出流的缓冲
                        printWriter.flush();
                        //开始获取数据
                        BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
                        int len;
                        byte[] arr = new byte[1024];
                        while ((len = bis.read(arr)) != -1) {
                                //将读取的字节转为字符串对象
                                String chunk = new String(arr, 0, len);
                               // System.out.println(chunk);
                                res+=chunk;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return res;
        }
        public static void main(String[] args) {
                String url = "http://api.tianapi.com/nba/?key=345fd9f07e15937b2ff3559bd8e7a92c&num=50";
                String res = HttpClient.doPost(url,"POST");
                JSONObject jsonObject = JSONObject.parseObject(res);
                String res2 = jsonObject.getString("newslist");
                JSONArray jsonArray = JSONArray.parseArray(res2);

                List<News> list = new ArrayList<>();
                for(int i = 0 ;i<jsonArray.size();i++){
                        JSONObject temp = jsonArray.getJSONObject(i);
                        News newstemp = new News(Long.toString(UidUtil.getInstance().nextId()),temp.getString("picUrl"),temp.getString("ctime"),temp.getString("description"),temp.getString("title"),temp.getString("url"));
                        list.add(newstemp);
                }
                System.out.println(list);

        }
}
