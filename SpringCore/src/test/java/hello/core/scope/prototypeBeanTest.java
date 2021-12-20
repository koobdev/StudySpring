package hello.core.scope;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.annotation.Annotation;

public class prototypeBeanTest {

    @Test
    void prototypeBeanFind(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean1 = " + protoTypeBean1);
        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);

        ac.close();
    }


    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        public void init(){
            System.out.println("protoTypeBean.init");
        }

        @PreDestroy
        public void close(){
            System.out.println("protoTypeBean.close");
        }
    }
}
