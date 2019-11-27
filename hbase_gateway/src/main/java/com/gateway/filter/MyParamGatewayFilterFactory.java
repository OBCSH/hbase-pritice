package com.gateway.filter;
//自定义局部过滤器，在控制台输出配置文件中指定名称的请求参数的值。
//注意：类名有规则：XxxGatewayFilterFactory，即类名必须是以GatewayFilterFactory结尾的，Xxx随便写。

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//自定义局部过滤器，在控制台输出配置文件中指定名称的请求参数的值。
//注意：类名有规则：XxxGatewayFilterFactory，即类名必须是以GatewayFilterFactory结尾的，Xxx随便写。
@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {

    public MyParamGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    //网关增强的逻辑代码
    public GatewayFilter apply(Config config) {
        System.out.println("===经过了MyParamGatewayFilterFactory局部过滤器====");

        return (exchange, chain) -> {
            //获取请求对象
            ServerHttpRequest request = exchange.getRequest();
            //判断，如果请求的查询参数中，有包含路由配置中的参数，则打印出来
            if (request.getQueryParams().containsKey(config.param)) {
                request.getQueryParams().get(config.param)
                        .forEach(value -> System.out.printf("----------局部过滤器输出的-----%s = %s-----%n",
                                config.param, value));
            }
            //相当于放行，继续调用下一个过滤器
            return chain.filter(exchange);
        };

//        return null;
    }


    //定义参数名字的字段
    public static final String PARAM_NAME = "param";


    @Override
    //字段顺序
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }

    //配置类
    public static class Config {

        private String param;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

    }
}
