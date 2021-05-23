package org.maksu;

import org.apache.commons.mail.util.MimeMessageParser;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GmailInbox {

    public String readLastMail(String email , String password) {

        Properties props = new Properties();

        try {
            props.load(new FileInputStream(new File("/Users/mustafaaksu/Desktop/selenium-design-practice/src/main/resources/smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", email , password);

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();

            Message[] messages = inbox.getMessages();

            String mailContent = readHtmlContent((MimeMessage) messages[messageCount-1]) ;

            inbox.close(true);
            store.close();

            return mailContent ;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
    }

}

    private String readHtmlContent(MimeMessage message) throws Exception {
        return new MimeMessageParser(message).parse().getHtmlContent();
    }

    private String readPlainContent(MimeMessage message) throws Exception {
        return new MimeMessageParser(message).parse().getPlainContent();
    }

}
