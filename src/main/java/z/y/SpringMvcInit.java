package z.y;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import z.y.config.DataSourceConfig;
import z.y.config.SpringAOPConfig;
import z.y.config.SpringMvcConfig;

/**
 * Servlet 容器启动的配置类,用于加载spring的配置类
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 为根应用程序上下文指定@Configuration类和(或)@Component类
     * @return Class数组
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringMvcConfig.class, DataSourceConfig.class, SpringAOPConfig.class};
    }

    /**
     * Servlet 应用程序上下文的配置，如果所有配置都是通过根配置类指定的，则为null 。
     * @return Class数组
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    /**
     * 配置哪些请求要被拦截,归属SpringMVC处理
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        // 拦截所有请求
        return new String[]{"/"};
    }
}
