package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //request 에서 http 메세지 " 스타트라인 - 헤더 한칸 띄우고 메세지 바디가 들어감//
        //꺼내는 방법
        ServletInputStream inputStream = request.getInputStream(); //byte 코드를 꺼내옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//UTF-8이 거의 표준이기 때문에, 그리고 스트림을 편리하게 사용하게 해주는 스프링 기능

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
