package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView  {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //view 를 만드는 행위 자체를 렌더링 한다고 생각하자

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response); // 실제 렌더링 시키기



    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        modelToRequestAttribute(model).forEach((key, value) -> request.setAttribute(key, value); //람다 셋 어트리뷰ㅜ트ㅜ로 키 밸류값 담기
        //model 에 있는 데이타를 requestattribute로 바꾼다
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response); // 실제 렌더링 시키기

    }

    private Map<String, Object> modelToRequestAttribute(Map<String, Object> model) {
        return model;
    }
}
