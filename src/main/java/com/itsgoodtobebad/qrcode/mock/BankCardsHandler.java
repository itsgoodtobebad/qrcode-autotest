package com.itsgoodtobebad.qrcode.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsgoodtobebad.qrcode.response.BankCardsPostResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liliangxi on 2017/9/21.
 */
public class BankCardsHandler extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        String method = request.getMethod();
        if("POST".equals(method)){
            BankCardsPostResponse rsp = new BankCardsPostResponse();

            BankCardsPostResponse.BankCardInfo bankCardInfo = rsp.getBankCardInfo();
            bankCardInfo.setBankCardID(317);                 // 银行卡ID，平台内部隐藏格式
            bankCardInfo.setBankCardNo("6225****0691");      // 银行卡号，带*号隐藏格式
            bankCardInfo.setBankCardRef("123456");           // 银行卡卡号内部统一标识
            bankCardInfo.setBankCardType(1);                 // 银行卡类型 1-借记卡 2-贷记卡
            bankCardInfo.setBankName("招商银行");            // 银行名称
            bankCardInfo.setIconCode("1031");                // icon图标编码
            bankCardInfo.setBankCode("40021");               // 银行机构代码
            bankCardInfo.setCardUseable(1);                  // 银行卡是否可用 1-可用 0-不可用
            rsp.setBankCardInfo(bankCardInfo);

            rsp.setIsNewCard(1);                             // 是否新卡 1-是 0-否
            rsp.setNeedSMSVerification(0);                   // 是否需要短信验证，0-不需要验证 1-需要验证
            // rsp.setServiceToken("12345");                 // 业务授权令牌，用户后续流程

            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            ObjectMapper mapper = new ObjectMapper();
            httpServletResponse.getWriter().println(mapper.writeValueAsString(rsp));

            // Inform jetty that this request has now been handled
            request.setHandled(true);
        }else if("DELETE".equals(method)){

        }
    }
}
