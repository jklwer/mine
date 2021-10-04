package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    //웹 어플리케이션에서 /hello에 요청이 오면 이 밑에 있는 메서드 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; //resources/template에 있는 hello 뷰리졸버가 찾아줌
    }


    @GetMapping("hello-mvc")    //ResponseBody매핑 없으면 뷰리졸버에게 바로 보냄
    public String helloMvc(@RequestParam("name") String name, Model model) { //외부에서 전달받은 파라미터 name
        model.addAttribute("name", name);   //파라미터로 받은 String name 을 넘겨봄
        return "hello-template";    //hello-template 으로 감
    }

    @GetMapping("hello-string")
    @ResponseBody   //http통신 프로토콜의 응답 body를 뜻함, 그 body부에 return값을 직접 넣는다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
        //템플릿엔진과의 차이 : view가 없음 (소스를 보면 html태그를 확인할 수 없음)
        //템플릿 엔진은 view를 조작하는 방식,api방식은 데이터를 그대로 내려주는 방식
    }

    @GetMapping("hello-api")    //api 방식
    @ResponseBody   //HttpMessageConverter가 동작 -> 단순문자열이면 StringConverter, 객체면 JsonConverter동작
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);    //파라미터로 넘어온 name넣기
        return hello;   //문자가 아닌 객체
    }   //결과는 json방식으로 출력(키와 밸류로 이루어진 구조 )


    static class Hello{
        private String name;    //key는 name

        public String getName() {   //command + n : getter/setter
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //자바빈규약, property 방식
    }

    //1. 정적 컨텐츠 : 파일을 그대로 내려줌
    //2. mvc/ template engine : template engine을 mvc방식으로 쪼개 설계된 html을 렌더링 해서 그걸 보여줌
    //3. api : 객체를 반환 , HttpMessageConverter를 통해 json에

}