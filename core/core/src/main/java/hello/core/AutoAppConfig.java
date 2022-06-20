package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정정보
// 스프링빈을 자동으로 끌어올리기
@ComponentScan(
        // basePackages~를 지정하지 않으면 @ComponentScan을 붙인,, hello.core의 하위 패키지들을 다 탐색함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
/*        @Bean(name = "memoryMemberRepository")
          public MemberRepository memberRepository(){
              return new MemoryMemberRepository();
        }*/
}

