package hello.hellospring.service;

import hello.hellospring.domain.Member;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    //clear 필요
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){   //테스트 실행할 때 마다 MemoryMemberRepository 생성, MemberService에 그것을 넣음
                                // -> service와 servicetest는 같은 MemoryMemberRepository사용
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach   //메서드가 실행이 끝날 때 마다 동작하는 callback 메서드
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {   //테스트의 메서드명은 한글로 변경도 가능 , 빌드시에도 실제 코드에 포함되지 않음
        //given : 이런 상황이 주어졌을 떄(이러한 데이터 기반)
        Member member = new Member();
        member.setName("hello");

        //when : 이것을 실행했을 때(검증할 것)
        Long saveId = memberService.join(member);

        //then : 그러면 이러한 결과가 나옴(검증부)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //중복회원에 대한 예외동작 검증
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));   //뒷 로직 실행시 IllegalStateException예외 발생

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);    //validateDuplicateMember에 의해 예외처리 예상
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.0");    //메세지 다를시 에러
        }
        */

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}