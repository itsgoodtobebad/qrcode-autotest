package com.itsgoodtobebad.qrcode.mock;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Liliangxi on 2017/10/9.
 */
public class NotifyHandler extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        String body = "";
        String inputLine;
        BufferedReader br = request.getReader();
        while((inputLine = br.readLine()) != null ){
            body += inputLine;
        }

        System.out.println("receive message: " + body);

        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        // Inform jetty that this request has now been handled
        request.setHandled(true);
    }
}
