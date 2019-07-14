package com.jin;


import com.google.common.collect.Lists;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import com.sun.security.ntlm.NTLMException;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Server> serverList =
                Lists.newArrayList(new Server("localhost", 8081),
                        new Server("localhost", 8082));
        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
                .buildFixedServerListLoadBalancer(serverList);
        for (int i = 0; i < 5; i++) {
            String result = LoadBalancerCommand.<String>builder()
                    .withLoadBalancer(loadBalancer).build()
                    .submit(new ServerOperation<String>() {
                        @Override
                        public Observable<String> call(Server server) {
                            try {
                                String addr = "http://" + server.getHost() + ":" +
                                        server.getPort() + "/house/hello";
                                System.out.println("调用地址:" + addr);

                                URL url = new URL(addr);
                                HttpURLConnection conn=
                                        (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("GET");
                                conn.connect();
                                InputStream in =conn.getInputStream();
                                byte[] arr=new byte[in.available()];
                                in.read(arr);
                                return Observable.just(new String(arr));
                            } catch (Exception e) {
                                e.printStackTrace();
                                return Observable.error(e);
                            }

                        }
                    }).toBlocking().first();
            System.out.println("调用结果：" + result);

        }


    }
}

