package ru.team55.mes_eds_admin.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Configuration
@EnableJpaRepositories("ru.team55.mes_eds_admin.repository")
@EnableTransactionManagement
@ComponentScan("ru.team55.mes_eds_admin")
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

    @Resource
    private Environment env;

    private Properties getProperties(String propName) {
        try {

            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream(propName);
            properties.load(is);
            return properties;

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("не найден файл "+propName);
        }
    }

    //@Autowired
    //private  DataSource dataSource; //если из другого конфига

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));

        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter());
        em.setJpaProperties(getProperties("hibernate.properties"));

        return em;
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();

        //todo разобраться что бы не писать спагетти
        //пока подразумавается строка
        //ds.setConnectionProperties(getProperties("db.properties"));


        ds.setUrl(env.getRequiredProperty("db.url"));
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));

        //разобраться с каждым параметром
        ds.setInitialSize(Integer.valueOf(env.getRequiredProperty("db.initialSize")));
        ds.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.minIdle")));
        ds.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
        ds.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
        ds.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.minEvictableIdleTimeMillis")));
        ds.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("db.testOnBorrow")));
        ds.setValidationQuery(env.getRequiredProperty("db.validationQuery"));


        return ds;
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManagerAnotherName(){
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }



}
