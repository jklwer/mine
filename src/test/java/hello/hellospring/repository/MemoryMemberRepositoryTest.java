package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트가 끝날 때 마다 repository를 지워주는 코드를 넣어 테스트 엉킴을 방지해야 함

    @AfterEach   //메서드가 실행이 끝날 때 마다 동작하는 callback 메서드
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();//반환타입이 Optional일땐 get으로 값 꺼냄
        //System.out.println("result" + (result == member) );
        //Assertions.assertEquals(member, null);    //member와 result가 같은지 확인
        assertThat(member).isEqualTo(result);     //member와 result가 같은지 확인
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //spring1, spring2 멤버 회원 가입

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2); //회원수

    }

    //class level에서 동시에 여러개의 메서드를 테스트 할 수 있음
    //테스트 주도개발 : 테스트 클래스를 먼저 작성하여 검증먼저 하는 개발법 (tdd)
}
