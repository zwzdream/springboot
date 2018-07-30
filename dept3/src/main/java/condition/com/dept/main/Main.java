package condition.com.dept.main;

import condition.com.dept.config.ConditionConfig;
import condition.com.dept.service.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WH1707008
 * @date 2018/7/19 15:31
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService=context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")
        +"系统下的列表命令为："+listService.showListCmd());
    }
}
