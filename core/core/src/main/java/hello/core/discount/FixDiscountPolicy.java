package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        // 등급이 VIP여야 할인이 된다.
        if(member.getGrade() == Grade.VIP){ //enum 타입은 == 써야함
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
