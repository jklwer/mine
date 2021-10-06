package hello.hellospring.service;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//스프링 빈 직접 등록
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }   //MemberService 스프링빈에 등록, memberRepository 넣어주어야 함

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();    //memberRepository인터페이스의 구현체인 MemoryMemberRepository
        return new JdbcMemberRepository(dataSource);

    }

}
