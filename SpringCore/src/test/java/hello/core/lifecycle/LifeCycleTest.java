package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class LifeCycleTest {

    @Test
    void beanCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        BeanLifeCycle bean = ac.getBean(BeanLifeCycle.class);

        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public BeanLifeCycle beanLifeCycle(){
            BeanLifeCycle bean = new BeanLifeCycle();
            bean.setUrl("http://beanLifeCycle.dev");
            return bean;
        }
    }
}
