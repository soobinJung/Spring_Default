package hello.core.order;

import hello.core.mamber.Grade;
import hello.core.mamber.Member;
import hello.core.mamber.MemberService;
import hello.core.mamber.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OederServiceImpl();

    @Test
    void createOrder () {
        Long memberId = 1L;
        Member member = new Member( memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
