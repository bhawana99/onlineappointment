package sis.com.util.db;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SisEmailUtil {

 private static	final String senderEmailUser = "generate.otp.hospital@gmail.com";
 private static final String password = "Otp12345678";
 
 private static Properties emailProperty;
 
   static  {
	  emailProperty = new Properties();
	  emailProperty.put("mail.smtp.auth", "true");
	  emailProperty.put("mail.smtp.starttls.enable", "true");
	  emailProperty.put("mail.smtp.host", "smtp.gmail.com");
	  emailProperty.put("mail.smtp.port", "587");
	}
	
	private static Session getEmailSession() {
		 Session email_session = Session.getInstance(emailProperty,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmailUser, password);
					}
				  });
		return email_session;
	} 
	
	
public static boolean sendMessage(String toEmails,String subject,String msg) {
try {
	Session email_session =  getEmailSession();
	Message message = new MimeMessage(email_session);
	message.setFrom(new InternetAddress(senderEmailUser));
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmails));
	
	message.setSubject(subject);
	message.setText(msg);
	System.out.println("message sending....");
	Transport.send(message);
	System.out.println("message sent ");
	return true;

} catch (MessagingException e) {
	System.err.print(e.getMessage());
	e.printStackTrace();
}
	  
	 
	 return false;
 }	
  

	 
}
