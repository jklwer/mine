package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링 컨테이너에서 객체 생성하여 관리
            //스프링 빈 등록법 : (컴포넌트 스캔/자동 의존관계 설정 -> 스프링 컨테이너에 스프링빈으로 등록하여 사용)
            //스프링이 스프링 컨테이너에 스프링 빈 등록시 기본으로 싱글톤으로 등록하여 공유 (메모리 절약)
public class MemberController {

    private final MemberService memberService;  //new로 생성하지 않고 스프링에 등록해서 사용

    @Autowired  //컨트롤러와 memberService와 연결시켜줌 (스프링 컨테이너에서 멤버서비스 가져옴)
    public MemberController(MemberService memberService) {
        this.memberService = memberService; //의존관계 주입(dependency injection)- 생성자 주입
    }

    //보통 조회는 get, 등록은 post 방식을 많이 이용

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";    //회원가입 끝나면 홈으로 redirect
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //멤버들 다 가져옴
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
