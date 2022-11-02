package hello.servlet.web.frontcontroller.v3;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.boot.Banner;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age")); //스트링 값으로 오기때문에 파스인트로 형변환

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
        return mv;

    }
}
