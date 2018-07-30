package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author WH1707008
 * @date 2018/7/26 10:59
 * Description:
 * Spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement 开启事务支持后，
 * 然后在访问数据库的Service方法上添加注解 @Transactional 便可。
 * 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />： @EnableTransactionManagement
 */
@SpringBootApplication
@EnableTransactionManagement
public class App {

    /**
     * 关于事务管理器，不管是JPA还是JDBC等都实现自接口 PlatformTransactionManager
     * 如果你添加的是 spring-boot-starter-jdbc 依赖，框架会默认注入 DataSourceTransactionManager 实例。
     * 如果你添加的是 spring-boot-starter-data-jpa 依赖，框架会默认注入 JpaTransactionManager 实例。
     * <p>
     * 你可以在启动类中添加如下方法，Debug测试，就能知道自动注入的是 PlatformTransactionManager 接口的哪个实现类
     */
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 在main方法进行启动我们的应用程序
         */
        SpringApplication.run(App.class, args);
    }


}
