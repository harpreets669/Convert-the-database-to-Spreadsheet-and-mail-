package beans;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autherization extends Authenticator
{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() 
	{
		// create object of password-authetication class
		PasswordAuthentication pa = new PasswordAuthentication
				("email","password");
		return pa;
	}
}
