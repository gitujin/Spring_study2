package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
/*@RequiredArgsConstructor*/
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; // 멤버 리포지토리에서 멤버를 찾아야함
    private final DiscountPolicy discountPolicy;

    // @Autowired  생성자 하나라서 생략, 롬복이라는 라이브러리 적용 -> @RequiredArgsConstructor이 자동으로 생성해줌
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에 회원 넘기기

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 주문 반환
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
