package z.y.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据源配置
 */
@MapperScan("z.y.mapper") //扫描Mapper文件
@Configuration
@EnableTransactionManagement // 开启事务管理器
public class DataSourceConfig {

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
        hikariDataSource.setJdbcUrl("jdbc:sqlite:" + getClass().getClassLoader().getResource("db/Chinook.db"));
        hikariDataSource.setDriverClassName("org.sqlite.JDBC");
        return hikariDataSource;
    }

    /**
     * 事务管理器
     * @param dataSource 数据源
     * @return TransactionManager
     */
    @Bean
    public TransactionManager transactionManager (@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
