/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebproject.configuration;

import com.mycompany.testwebproject.mybatisMappers.TestMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/**
 *
 * @author piratXus
 */
@Configuration
@MapperScan("com.mycompany.testwebproject.mybatisMappers")
public class DataConfig  {
    
    @Bean
    public BasicDataSource dataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf8");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setTypeAliasesPackage("com.mycompany.testwebproject.dao.type");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com/mycompany/testwebproject/persistence/*.xml)"));
        return sqlSessionFactory.getObject();
    }

    @Bean
    public MapperFactoryBean<TestMapper> testMapper() throws Exception {
        MapperFactoryBean<TestMapper> factoryBean = new MapperFactoryBean<>(TestMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }
}
