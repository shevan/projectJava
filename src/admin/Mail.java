package admin;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail
{
   public static void sendMail(String recipient, String subject, String content)
   {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");      
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("stua2014@gmail.com", "stuahogent");
            }
        });
        
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stua2014@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject(subject);
            message.setContent(content, "text/html" );

            Transport.send(message);
        } catch (MessagingException mex)
        {
           mex.printStackTrace();
        }
    }
}