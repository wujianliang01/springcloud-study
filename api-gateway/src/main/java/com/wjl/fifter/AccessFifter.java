package com.wjl.fifter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WuJianLiang
 * @Date: Created in 2018-01-05 15:13
 * @Description: 网关路由器
 **/

public class AccessFifter extends ZuulFilter {


    /**
     * @Author:WuJianLiang
     * @Description: 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为 pre，代表会在请求被路由之前执行。
     * @Date: Created in 15:20 2018/1/5
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @Author:WuJianLiang
     * @Description: 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     * @Date: Created in 15:20 2018/1/5
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @Author:WuJianLiang
     * @Description: 判断该过滤器是否需要被执行。这里我们直接返回了 true，因此该过滤器对所有请求都会生效。
     * @Date: Created in 15:20 2018/1/5
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @Author:WuJianLiang
     * @Description: 过滤器的具体逻辑。启动访问 localhost:2016/eureka-client/disconver?accessToken=123
     * @Date: Created in 15:21 2018/1/5
     */
    @Override
    public Object run() {

        final RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send{" + request.getMethod() + "} request to{" + request.getRequestURL().toString() + "}");

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            System.out.println("access token is empty .......");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            return null;
        }

        System.out.println("is ok ....");
        return null;
    }
}
