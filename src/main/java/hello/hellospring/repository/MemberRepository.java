package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //회원이 저장소에 저장됨

    Optional<Member> findById(Long id); //id로 회원 조회하는 기능
    Optional<Member> findByName(String name);
    //Optional : null 반환시 Optional로 감싸서 반환, java8
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트 반환

}
