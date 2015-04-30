import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;


public class EmailSending {

	public static void send() throws EmailException{
		 EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("/home/kal0ian/Downloads/azbW3zq_460sa_v1.gif");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("John");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("ceckoclient", "941224kk"));
		  email.setSSLOnConnect(true);
		  email.addTo("ceckoclient@gmail.com", "John Doe");
		  email.setFrom("ceckoclient@gmail.com", "Me");
		  email.setSubject("The picture");
		  email.setMsg("Here is the picture you wanted");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();

	}
	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		EmailSending.send();
	}

}
