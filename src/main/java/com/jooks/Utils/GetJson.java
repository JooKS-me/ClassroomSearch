package com.jooks.Utils;

import com.jooks.entity.TimeSet;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetJson {

    public static String getJson(TimeSet timeSet, String cookies) {
        // TimeSet timeSet = new TimeSet(18, 5, 1);

        // 获取httpClinent
        CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        // 设置request配置
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setRedirectsEnabled(false).build();

        HttpPost httpPost = new HttpPost("http://jwxt.neuq.edu.cn/jwglxt/cdjy/cdjy_cxKxcdlb.html?doType=query&gnmkdm=N2155");
        httpPost.setConfig(requestConfig);

        // 装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("fwzt", "cx"));
        list.add(new BasicNameValuePair("xqh_id", "3D669E6DAB06A186E053AB14CECA64B4")); //学期号
        list.add(new BasicNameValuePair("xnm", "2020")); //学年名
        list.add(new BasicNameValuePair("xqm", "3")); //学期名
        list.add(new BasicNameValuePair("lh", "01")); //楼号，01表示工学馆
        list.add(new BasicNameValuePair("jyfs", "0"));
        list.add(new BasicNameValuePair("zcd", (new Double(Math.pow(2, timeSet.getZhouCiDan()-1))).toString())); //周次单 2^(周次-1)
        list.add(new BasicNameValuePair("xqj", timeSet.getXinQiJi().toString())); //星期几 周几就是数字几
        list.add(new BasicNameValuePair("jcd", (new Double(Math.pow(2, timeSet.getJieCiDan()-1))).toString())); //节次单 2^(节次-1)，可累加！
        list.add(new BasicNameValuePair("_search", "false"));
        list.add(new BasicNameValuePair("queryModel.showCount", "100"));
        list.add(new BasicNameValuePair("queryModel.currentPage", "1"));
        list.add(new BasicNameValuePair("queryModel.sortName", "cdbh"));
        list.add(new BasicNameValuePair("queryModel.sortOrder", "asc"));

        String strResult = "";
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(entity);
            // 设置请求头
            //httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.66");
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpPost.setHeader("Cookie", cookies);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse != null) {
                // System.out.println(httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                } else {
                    strResult = "Error: " + httpResponse.getStatusLine().toString();
                }
            }
            // System.out.println(strResult);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return strResult;
    }
}
