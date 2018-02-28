package com.itsgoodtobebad.qrcode.mock;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * Created by Liliangxi on 2017/8/12.
 */
public class EmbeddedJettyServer {

    private Server server;
    private int port = 8888;

    public EmbeddedJettyServer(int port) {
        this.port = port;
    }

    public void start() throws Exception{
        server = new Server(port);

        ContextHandler smsVarificationHandler = new ContextHandler("/walletapi/1.0/smsVerification");
        smsVarificationHandler.setHandler(new SmsVarificationHandler());

        ContextHandler bankCardsHandler = new ContextHandler("/walletapi/2.0/bankCards");
        bankCardsHandler.setAllowNullPathInfo(true);
        bankCardsHandler.setHandler(new BankCardsHandler());

        ContextHandler partnerPayConfirmHandler = new ContextHandler("/verifyPinConfirm");
        partnerPayConfirmHandler.setHandler(new PartnerPayConfirmHandler());

        ContextHandler notifyHandler = new ContextHandler("/notify");
        notifyHandler.setHandler(new NotifyHandler());

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.addHandler(smsVarificationHandler);
        contexts.addHandler(bankCardsHandler);
        contexts.addHandler(partnerPayConfirmHandler);
        contexts.addHandler(notifyHandler);

        server.setHandler(contexts);

        server.start();
        //server.join();
    }

    public void stop(){
        try{
            server.stop();
        }catch (Exception e){

        }

    }


}
