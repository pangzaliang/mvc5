package z.y.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Servlet 容器启动的配置类,用于加载spring的配置类
 */
public class SpringMvcInit extends AbstractDispatcherServletInitializer {

    /**
     * 加载springMVC容器的配置类
     * @return AnnotationConfigWebApplicationContext
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        // 创建SpringMVC容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 加载配置类--SpringMvcConfig
        context.register(SpringMvcConfig.class);
        return context;
    }

    /**
     * 配置哪些请求要被拦截,归属SpringMVC处理
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        // return new String[0];
        // 拦截所有请求
        return new String[]{"/"};
    }

    /**
     * 加载Spring容器的配置类
     * @return null
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
