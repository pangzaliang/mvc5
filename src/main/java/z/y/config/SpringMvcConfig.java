package z.y.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.power.common.constants.Charset;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceRegionHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SpringMVC配置类
 */
@EnableWebMvc
@Configuration
@ComponentScan("z.y.controller")
@ComponentScan("z.y.config")
@MapperScan("z.y.mapper")
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * fastJson消息转换器
     * @return FastJsonHttpMessageConverter
     */
    @Bean("fastJsonHttpMessageConverter")
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter () {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        return fastJsonHttpMessageConverter;
    }

    /**
     * ResourceRegion消息转换器
     * @return ResourceRegionHttpMessageConverter
     */
    @Bean("resourceRegionHttpMessageConverter")
    public ResourceRegionHttpMessageConverter resourceRegionHttpMessageConverter () {
        ResourceRegionHttpMessageConverter resourceRegionHttpMessageConverter = new ResourceRegionHttpMessageConverter();
        resourceRegionHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        return resourceRegionHttpMessageConverter;
    }

    /**
     * 配置HTTP消息转换器
     * @param converters HTTP消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.addAll(Arrays.asList(fastJsonHttpMessageConverter(), resourceRegionHttpMessageConverter()));
        converters.add(fastJsonHttpMessageConverter());
    }

    /**
     * 上传文件配置
     * @return CommonsMultipartResolver
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver () {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // 最大单次可上传100MB文件
        resolver.setMaxUploadSize(1024 * 1024 * 100);
        // 默认编码为UTF-8
        resolver.setDefaultEncoding(Charset.DEFAULT_CHARSET);
        return resolver;
    }

    /**
     * SQL会话工厂配置
     * @param dataSource 数据源
     * @return SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory (@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SQL数据源
     * @return 数据源
     */
    @Bean("dataSource")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:sqlite:src/main/resources/db/Chinook.db");
        hikariDataSource.setDriverClassName("org.sqlite.JDBC");
        return hikariDataSource;
    }
}
