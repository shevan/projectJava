package admin;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail
{
   public void sendMail(String sender, String recipient, String subject, String content)
   {
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", "localhost");
      Session session = Session.getDefaultInstance(properties);

      try
      {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(sender));
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