package com.example.demo.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;

/**
 * @author: lihui
 * @date: 2020-07-17
 */
@Slf4j
public class HttpMain {
    public static void main(String[] args) throws IOException {
        Request request = Request.Get("https://www.baidu.com/");
        Response response = request.connectTimeout(20000).socketTimeout(20000).execute();
        HttpResponse httpResponse = response.returnResponse();
        int code = httpResponse.getStatusLine().getStatusCode();
        String content = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
        log.info("http code : {}", code);
        log.info("response content {}", content);
    }
}
