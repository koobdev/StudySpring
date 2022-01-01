package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest {

    @Test
    void SingletonWithPrototype(){
        ConfigurableApplicationContext ac =
                new AnnotationConfigApplicationContext(PrototypeBean.class, SingletonBean.class);

//        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
//        prototypeBean1.addCount();
//        int count1 = prototypeBean1.getCount();
//        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
//        prototypeBean2.addCount();
//        int count2 = prototypeBean2.getCount();

//        Assertions.assertThat(count1).isEqualTo(1);
//        Assertions.assertThat(count2).isEqualTo(1);

        SingletonBean singleton1 = ac.getBean(SingletonBean.class);
        int logic1 = singleton1.logic();

        SingletonBean singleton2 = ac.getBean(SingletonBean.class);
        int logic2 = singleton2.logic();

        Assertions.assertThat(logic1).isEqualTo(1);
        Assertions.assertThat(logic2).isEqualTo(1);
    }

//    @RequiredArgsConstructor
    static class SingletonBean{
//        private final PrototypeBean prototypeBean;

        @Autowired
        private ObjectProvider<PrototypeBean> objectProvider;

        public int logic(){
            PrototypeBean prototypeBean = objectProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            this.count++;
        }
        public int getCount(){
            return this.count;
        }
    }
}
