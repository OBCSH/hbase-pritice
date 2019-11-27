package com.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//自定义全局过滤器，实现必须有token测查询参数才能放行转发
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    //过滤器要增强的代码
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("-----------------全局过滤器MyGlobalFilter---------------------");
        //从查询参数中去获取token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //判断token是否存在
        if(StringUtils.isBlank(token)){
            //没有权限
            //响应一个未授权的状态码
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

            //响应结束，直接返回，不再向下转发了。
            return exchange.getResponse().setComplete();
        }

        //放行效果
        return chain.filter(exchange);

//        return null;
    }

    @Override
    //全局过滤器的执行的顺序，值越小，越先执行
    public int getOrder() {
        return 0;
    }
}
