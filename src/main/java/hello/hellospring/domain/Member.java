package hello.hellospring.domain;

public class Member {
    //요구사항
    //아이디 식별자 필요
    //이름이 있음

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
