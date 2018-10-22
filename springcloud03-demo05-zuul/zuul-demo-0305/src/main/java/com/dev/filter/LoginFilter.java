package com.dev.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置过滤器，只需要继承zuulFilter即可，再实现拦截逻辑，拦截器时候生效等即可
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = ctx.getRequest();
        // 获取请求参数
        String token = request.getParameter("access-token");
        if(token == null || "".equals(token.trim())){//request中是否有access-token字段即可，实际应用会判断是否合法token
            // 拦截
            ctx.setSendZuulResponse(false);
            // 状态
            ctx.setResponseStatusCode(403);
        }else{
            System.out.println("已登录");
        }
        return null;
    }
}
