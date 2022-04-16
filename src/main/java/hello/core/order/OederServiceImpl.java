package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.mamber.Member;
import hello.core.mamber.MemberRepository;
import hello.core.mamber.MemoryMemberRepository;
import hello.core.discount.FixDiscountPolicy;

public class OederServiceImpl implements OrderService {

    public final MemberRepository memberRepository = new MemoryMemberRepository();
    public final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
