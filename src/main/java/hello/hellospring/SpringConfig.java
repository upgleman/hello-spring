package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /*
    DB 연동
    */
//    private final DataSource dataSource;
    /*
    JPA 연동
     */
//    private final EntityManager em;
    /*
    생성자를 통한 DI
     */
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    /*
    Spring JPA
     */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
    /*
    Spring JPA
     */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    @Bean
    public void memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);

    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

}
