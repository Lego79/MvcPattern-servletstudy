package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

}