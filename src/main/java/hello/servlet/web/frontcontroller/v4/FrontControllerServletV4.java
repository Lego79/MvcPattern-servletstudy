package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")// *을 사용하면 하위에 어떤 url이 들어와도 무조건 이 컨트롤러가 호출 됨
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();  //매핑정보 - url, 키는 url, 어떤 url 이ㅣ 들어오면 controller 인터페이스 호출

    public FrontControllerServletV4() { //매핑정보 생성할때 미리 담아놓는다, 서블릿 생성될 떄

        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v2/members/members", new MemberListControllerV3());



    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println("FrontControllerServletV2.service");

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);

        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        //parammap을 넘겨줘야한다
        Map<String, String> paramMap = createParamMap(request); //ctrl art m - 메서드 추출
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();//논리이름, new-form
        MyView view = new MyView("/WEB-INF/view" + viewName + ".jsp");

        view.render(mv.getModel(), request, response);

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String ,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()// 전부 조회
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
