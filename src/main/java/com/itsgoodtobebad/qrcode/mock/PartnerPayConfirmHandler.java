package com.itsgoodtobebad.qrcode.mock;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liliangxi on 2017/9/26.
 */
public class PartnerPayConfirmHandler extends AbstractHandler {

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        // 打印headers
        //httpServletRequest.getHeaders()


        // 打印消息体


        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        String data = "{\"code\":\"0000\",\"content\":{\"serviceToken\":\"token123\"},\"message\":\"成功\"}";
        httpServletResponse.getWriter().println(data);

        // Inform jetty that this request has now been handled
        request.setHandled(true);
    }
}
