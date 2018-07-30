package condition.com.dept.config;

import condition.com.dept.conditionimpl.LinuxCondition;
import condition.com.dept.conditionimpl.WindowsCondition;
import condition.com.dept.service.ListService;
import condition.com.dept.service.impl.LinuxListServiceImpl;
import condition.com.dept.service.impl.WindowsListServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author WH1707008
 * @date 2018/7/19 15:21
 * Description:
 */
@Configuration
public class ConditionConfig {
    /**
     * 通过@Conditional注解，符合Windows条件则实例化windowsListService
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListServiceImpl();
    }

    /**
     * 通过@Conditional注解，符合Linux条件则实例化linuxListService
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListServiceImpl();
    }


}
