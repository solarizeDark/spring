package ru.fedusiv.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@org.springframework.context.annotation.Configuration
@MapperScan("ru.fedusiv.mappers")
public class MyBatisConfig {

    @Autowired
    private HikariDataSource hikariDataSource;

    @Bean
    public DataSourceTransactionManager transactionManager()
    {
        return new DataSourceTransactionManager(hikariDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception
    {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hikariDataSource);
        return sessionFactory.getObject();
    }

}
