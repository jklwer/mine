package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //상속

    //회원가입
    public  Long join(Member member){
        //같은 이름의 회원 중복은 안됨
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())   //findByName의 결과는 Optional멤버이므로
                .ifPresent(m -> {   //중복이 있다면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


}
