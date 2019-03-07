package com.wyj.alipay.springboot.sbbase.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.*;

import java.io.IOException;

/**
 * 另外官网还提供了 同步异步、多请求异步、线程池大小、统一配置、log的配置、授权、加密请求等等
 * Author: wyj
 * Date: 2019/2/12
 */
public class EsClient {



    public static void main(String[] args) throws IOException {
        RestClient client = buildClient();
        requestExample1(client);
        requestExample2(client);

        // 一定记着 close
        client.close();
    }

    private static RestClient buildClient() {

        RestClientBuilder clientBuilder = RestClient.builder(
                new HttpHost("localhost", 9200, "http")
        );

        Header[] defaultHeaders = new Header[]{
                new BasicHeader("Content-Type", "application/json, charset=utf-8")
        };
        // 设置默认header，每个请求都会带上该请求头
        clientBuilder.setDefaultHeaders(defaultHeaders);

        // 设置最长重试时间
        clientBuilder.setMaxRetryTimeoutMillis(10*1000);


        /*
        Set the node selector to be used to filter the nodes the client will send requests to among
        the ones that are set to the client itself. This is useful for instance to prevent sending
        requests to dedicated master nodes when sniffing is enabled. By default the client sends
        requests to every configured node.
        大概的意思就是说：
        设置要用的Node Selector用来筛选client send request的目标node。
        SKIP_DEDICATED_MASTERS 用来在监听节点打开的时候，防止发送request到 专用的master node。
        默认client 会发送request 到每一个配置了的node
         */
        clientBuilder.setNodeSelector(NodeSelector.ANY);

        // 设置失败监听
        clientBuilder.setFailureListener(new RestClient.FailureListener(){
            @Override
            public void onFailure(Node node) {
                System.out.println("es failed. node:"+node+", \njson node:"+ JSON.toJSONString(node));
            }
        });

        // 可以修改 request timeouts, authentication, 或者其他的 org.apache.http.client.config.RequestConfig.Builder 允许修改的
        clientBuilder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setSocketTimeout(10 * 1000);
            return requestConfigBuilder;
        });

        // 可以修改 encrypted communication over ssl, 或者其他的 org.apache.http.impl.nio.client.HttpAsyncClientBuilder 允许修改的
        clientBuilder.setHttpClientConfigCallback(httpClientBuilder -> {
            return httpClientBuilder;
        });

        return clientBuilder.build();
    }

    private static void requestExample1(RestClient client) {
        Request request = new Request("GET", "/bank/account/1");
        try {
            Response response = client.performRequest(request);
            if (response != null &&
                    response.getStatusLine().getStatusCode() == 200) {
                JSONObject responseBody = JSON.parseObject(EntityUtils.toString(response.getEntity()));
                System.out.println("responseBody:"+responseBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void requestExample2(RestClient client) {
        Request request = new Request("GET", "/bank/_search");
        JSONObject requestBody = new JSONObject();
        JSONObject bodyTmp;
        bodyTmp = new JSONObject();
        bodyTmp.put("match_all", new JSONObject());
        requestBody.put("query", bodyTmp);
        requestBody.put("from", 0);
        requestBody.put("size", 5);
        JSONArray bodyTmpAry = new JSONArray();
        bodyTmp = new JSONObject();
        bodyTmp.put("account_number", "asc");
        bodyTmpAry.add(bodyTmp);
        requestBody.put("sort", bodyTmpAry);
        bodyTmpAry = new JSONArray();
        bodyTmpAry.add("account_number");
        bodyTmpAry.add("balance");
        requestBody.put("_source", bodyTmpAry);

        System.out.println("requestBody:"+requestBody.toJSONString());

        request.addParameter("pretty", "true");
        request.setEntity(new NStringEntity(requestBody.toJSONString(), ContentType.APPLICATION_JSON));

        // 异步请求
        client.performRequestAsync(request, new ResponseListener() {
            @Override
            public void onSuccess(Response response) {
                if (response != null && response.getStatusLine().getStatusCode() == 200) {

                    try {
                        JSONObject responseBody = JSON.parseObject(EntityUtils.toString(response.getEntity()));
                        System.out.println("responseBody:"+responseBody.toJSONString());
                    } catch (IOException e) {
                        System.out.println("解析response 错误");
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Exception exception) {
                System.out.println("异步请求出现错误");
                exception.printStackTrace();
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
