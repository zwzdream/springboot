package profile.com.dept.config;

import profile.com.dept.pojo.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author WH1707008
 * @date 2018/7/19 14:30
 * Description:
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestBean(){
           return new TestBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("from production profile");
    }
}
