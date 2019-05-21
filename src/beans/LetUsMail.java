package beans;
import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class LetUsMail
{
	public static void main(String[] args) 
	{
		try 
		{
		// create object of properties to provide info about
		// smtp server
		Properties p = new Properties();
		
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port","587");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth","true");

		
		// create object of authenticator subclass
		Autherization auth = new Autherization();
		
		// get object of session
		Session session = Session.getInstance(p, auth);
		
		// create a message for this session
		MimeMessage message = new MimeMessage(session);
		
		//
		String rcvr = "harpreets669@gmail.com"; 
		
		// convert the email id of rcvr into interner-address
		InternetAddress rcvrAddress = new InternetAddress(rcvr);
		
		
		
		
		// specify the person who will get this message
		message.addRecipient(Message.RecipientType.TO,rcvrAddress);
		
		// set the subject and text for this message
		message.setSubject("Mind B-Low-Ing");
		
		// create some body part
		MimeBodyPart part1 = new MimeBodyPart();
		// store a message in this body part
		part1.setContent("<b><i>"
				+ "<font style = 'color : red'>\r\n" + 
				"hello beedu log attachments ye rahe, abe neeche dekh\r\n" + 
				"</font>","text/html");
	
		MimeBodyPart part2 = new MimeBodyPart();
		// attach a file with this part
		File file1 = new File("E:/java and sql/APACHE POI/Dept-Emp DB/Database.xlsx");
		part2.attachFile(file1);
		
		
		
		// create object of multipart
		MimeMultipart multipart = new MimeMultipart();
		
		// store all the body parts inside myultipart
		// 1 by 1
		multipart.addBodyPart(part1);
		multipart.addBodyPart(part2);
	
		
		// store the multipart inside message
		message.setContent(multipart);
		
		// send this message to the rcvr actually
		Transport.send(message);
		
		System.out.println("..done, email sent");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
