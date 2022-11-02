package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//            String viewPath = "/WEB-INF/views/new-form.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 이 경로로 이동할것
//            dispatcher.forward(request,response); //servlet에서 jsp를 호출

//        MyView myView = new MyView("/WEB-INF/views/new-form.jsp"); //경로만 입력
//        return myView;

        //-> ctrl + art + N - inline 기능, 한줄로 합쳐짐

        //경로만 입력
        return new MyView("/WEB-INF/views/new-form.jsp");

    }
}
