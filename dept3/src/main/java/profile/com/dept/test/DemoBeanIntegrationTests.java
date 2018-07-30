package profile.com.dept.test;

import profile.com.dept.config.ProfileConfig;
import profile.com.dept.pojo.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WH1707008
 * @date 2018/7/19 14:35
 * SpringJUnit4ClassRunner在JUnit环境下提供Spring TestContext Framework的功能
 * ContextConfiguration用来加载配置ApplicationContext，其中classes属性用来加载配置类
 * ActiveProfiles用来声明活动的profile
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject(){
            String expected="from production profile";
            String actual=testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
