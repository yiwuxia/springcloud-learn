package com.jin.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * @Description TODO
 * @Author lijin
 * @Date 2019/7/25 13:44
 * @Version 1.0
 **/
public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        final URI originalUri=request.getURI();
        String serviceName=originalUri.getHost();
        System.out.println("自定义拦截器");
        return execution.execute(request,body);
    }
}
