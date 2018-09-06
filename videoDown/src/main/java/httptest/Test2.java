package httptest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static boolean httpPostWithJson(JSONObject jsonObj, String url, String appId) {
        boolean isSuccess = false;

        HttpPost post = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();

//            log.info();

            post = new HttpPost(url);
            // 构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Connection", "keep-alive");
            post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            post.setHeader("Origin", "http://daka.hzy.ink");

            System.out.println("实体:" + jsonObj.toString());

            // 构建消息实体
//            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
            List<NameValuePair> list = new ArrayList();
            list.add(new BasicNameValuePair("distance", "100"));
            list.add(new BasicNameValuePair("name", "zz"));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
            System.out.println("实体3:" + entity.toString());
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            System.out.println(post.toString());
            System.out.println("实体2:" + post.getEntity());


            HttpResponse response = httpClient.execute(post);
            System.out.println("相应：" + response.getEntity().toString());

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("请求失败!");
                isSuccess = false;
            } else {
                int retCode = 0;
                String sessendId = "";
                // 返回码中包含retCode及会话Id
                for (Header header : response.getAllHeaders()) {
                    if (header.getName().equals("retcode")) {
                        retCode = Integer.parseInt(header.getValue());
                    }
                    if (header.getName().equals("SessionId")) {
                        sessendId = header.getValue();
                    }
                }
                System.out.println("retCode:" + retCode);

                if (0 != retCode) {
                    // 日志打印
                    isSuccess = false;
                } else {
                    isSuccess = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        } finally {
            if (post != null) {
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("distance", "100");
        json.put("name", "100");
        String url = "http://daka.hzy.ink/api/save";
        httpPostWithJson(json, url, "");

    }
}
