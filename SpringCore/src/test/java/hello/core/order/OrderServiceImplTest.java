package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void OrderTest(){
        MemoryMemberRepository repository = new MemoryMemberRepository();
        Member member = new Member(1L, "member1", Grade.VIP);
        repository.save(member);

        OrderServiceImpl orderService = new OrderServiceImpl(repository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "member1", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}