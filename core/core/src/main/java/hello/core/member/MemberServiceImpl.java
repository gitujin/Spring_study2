package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //회원가입하고 회원을 찾으려면 MemberRepository 인터페이스가 필요
    //하지만 인터페이스만 가지고 있으면 Nullpoint 오류가 나기 때문에 MemoryMemberRepository를 넣어준다.

    private final MemberRepository memberRepository; //인터페이스.

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) { //생성자
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member); // join에서 save를 호출하면 다형성에 의해 MemoryMemberRepository에 있는 save가 호출된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
