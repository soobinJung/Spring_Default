package hello.core.order;

import hello.core.mamber.Grade;
import hello.core.mamber.Member;
import hello.core.mamber.MemberService;
import hello.core.mamber.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OederServiceImpl();

        Long memberId = 1L;
        Member member = new Member( memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
    }
}
