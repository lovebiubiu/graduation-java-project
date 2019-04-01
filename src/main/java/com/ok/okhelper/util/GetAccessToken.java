package com.ok.okhelper.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EnableScheduling
@Configuration
@Component
public class GetAccessToken {
    public static String AccessToken = "";
    public static String appid = "wx6c5bb2f06fc668a1";
    public static String secret = "36fc113e02787719583360f8e2b4363a";
    public static String url = "https://api.weixin.qq.com/cgi-bin/token";
    public static String grantType = "client_credential";
    Logger log = LoggerFactory.getLogger(this.getClass());
    //获取accessToken定时任务
    @Scheduled(cron = "0 */40 * * * * ")
    public void getAccessToken() {
        log.info("———————————————定时获取AccessToken———————————————");
        String requestUrl=url+"?grant_type="+grantType+"&appid="+appid+"&secret="+secret;
        AccessToken = doPost(requestUrl,"");
        log.info("AccessToken:"+AccessToken);
    }

    public static String doPost(String requestUrl , String param) {
        String res = null;
        HttpURLConnection connection = null;

        try {
            URL url = new URL(requestUrl);
            //通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("GET");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);


            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            connection.connect();
            //获取返回的字符
            InputStream inputStream = connection.getInputStream();
            int size =inputStream.available();
            byte[] bs =new byte[size];
            inputStream.read(bs);
            String message=new String(bs,"UTF-8");
            JSONObject obj = JSONObject.parseObject(message);      //json格式化处理为object
            res = obj.getString("access_token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getQr(String scene) throws IOException {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("scene",scene);
        params.put("path","pages/entry/entry");
        params.put("width",200);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+AccessToken);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        String body = JSON.toJSONString(params);
        //System.out.println("body:"+body);
        StringEntity entity;
        entity = new StringEntity(body);
        entity.setContentType("image/png");

        httpPost.setEntity(entity);
        HttpResponse response;

        response = httpClient.execute(httpPost);
        InputStream inputStream = response.getEntity().getContent();
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        try {
            while ((ch = inputStream.read()) != -1) {
                bytestream.write(ch);
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] program = bytestream.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String binary = encoder.encodeBuffer(program).trim();
        getQr__2(scene);
        //System.out.println("binary:"+binary);
        return binary;
    }
    public static void getQr__2(String scene){
        try {
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+AccessToken);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            paramJson.put("path", "pages/entry/entry");
            paramJson.put("width", 430);
            paramJson.put("scene",scene);
            /**
             * line_color生效
             * paramJson.put("auto_color", false);
             * JSONObject lineColor = new JSONObject();
             * lineColor.put("r", 0);
             * lineColor.put("g", 0);
             * lineColor.put("b", 0);
             * paramJson.put("line_color", lineColor);
             * */

            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            OutputStream os = new FileOutputStream(new File("F:/temp_img/"+scene+".png"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
