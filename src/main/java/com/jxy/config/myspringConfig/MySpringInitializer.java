package com.jxy.config.myspringConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Auther: jxy
 * @Date: 2019/3/6 11:17
 * @Description:
 */
public class MySpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MyRootConfig.class};
    }
    //Web配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyWebConfig.class};
    }
    //映射DispatchServlet到/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
