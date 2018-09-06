package httptest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {

    public static void testHttpClientPost() throws IOException {
        //定义uri
        String uri = "http://daka.hzy.ink/api/save";
        //需要传入的参数
        Map<String, String> map = new HashMap<String, String>();

        map.put("name", "zz");
        map.put("Distance", "100");
        map.put("date", "2018-08-30");

//        map.put("city", "上海");
//        map.put("dfc", "1");
//        map.put("charset", "utf-8");
        String encoding = "utf-8";
        //创建默认的httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求对象
        HttpPost httpPost = new HttpPost(uri);
        //装填请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, encoding);
        urlEncodedFormEntity.setContentEncoding("UTF-8");
        //设置参数到请求对象中
        httpPost.setEntity(urlEncodedFormEntity);

        System.out.println("请求地址：" + uri);
        System.out.println("请求参数：" + list.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        httpPost.setHeader("Accept", "application/json, text/plain, */*");
        httpPost.setHeader("Origin", "http://daka.hzy.ink");
        httpPost.setHeader("Referer", "http://daka.hzy.ink/");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        //获取所有的请求头信息
        Header[] allHeaders = response.getAllHeaders();
        for (Header allHeader : allHeaders) {
            System.out.println(allHeader.toString());
        }
        //获取结果实体
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            System.out.println("响应体："+EntityUtils.toString(entity, encoding));
        }
        // 关流
        EntityUtils.consume(entity);
        response.close();

    }

    public static void main(String[] args) throws IOException {
        testHttpClientPost();
    }

}
