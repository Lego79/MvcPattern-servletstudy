package hello.servlet.web.sprintmvc.v1;

import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@Component
//@RequestMapping // 클래스 레벨에 사용가능
public class SpringMemberFormControllerV1 {

    @RequestMapping("/spring/v1/members/new-form")
    public ModelView process() {
        return new ModelAndView("new-form");
    }

}
