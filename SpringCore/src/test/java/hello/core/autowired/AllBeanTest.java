package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);

        int fixDiscount = discountService.discount(member, 20000, "fixDiscountPolicy");
        Assertions.assertThat(fixDiscount).isEqualTo(1000);

        int rateDiscount = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscount).isEqualTo(2000);
    }


    static class DiscountService {
        private final Map<String, DiscountPolicy> map;
        private final List<DiscountPolicy> list;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> map, List<DiscountPolicy> list) {
            this.map = map;
            this.list = list;
            System.out.println("map = " + map);
            System.out.println("list = " + list);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy policy = map.get(discountCode);
            return policy.discount(member, price);
        }
    }
}
