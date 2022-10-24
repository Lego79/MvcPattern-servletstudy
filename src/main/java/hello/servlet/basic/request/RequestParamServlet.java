package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1. 파라미터 전송기능
//http://localhost:8080/request-param?username=hello&age=20

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> {
                    System.out.println(paramName + "=" + request.getParameter(paramName));
                });

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수의 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);

        }

        response.getWriter().write("ok");

        //중복 파라미터와 단일파라이머의 경우 거의 단일 파라미터를 사용한다
        // 중복을 사용해야 할 경우가 있을때는 어떤값이 중복인지 생각하고 getParameterValues를 사용하는 구나 하는 것을 기억해 두고
        //실제로는 단일 파라미터를 사용해서 혼선이 없도록 하는 것이 좋다


    }
}
