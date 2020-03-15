package com.qinglin.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

//要使用过滤器就要加上注解
@Component
public class LogFilter extends ZuulFilter {

    //这个方法用于选择过滤器的类型
    @Override
    public String filterType()
    {
        return FilterConstants.ERROR_TYPE;
    }

    /***
     *
     * 用于指定过滤器执行的顺序(因为我们可能会使用到多个过滤器)
     * 数值越小,优先级越高
     */

    @Override
    public int filterOrder()
    {
        return 1;
    }

    /***
     * 是否要使用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter()
    {
        return true;
    }


    /***
     * 这里是过滤器要执行的run方法(这里写过滤的代码)
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException
    {
        System.out.println("我来自自定义的异常的过滤器");
        return null;
    }
}
