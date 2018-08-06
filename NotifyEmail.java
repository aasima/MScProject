
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * 
 * @author Aasima Pathan
 *
 */
public class NotifyEmail {

	private String username;
	private String to;
	private String from;
	private final String password = "Project1";

	
	/** 
	 * Constructor for an email
	 * @param username
	 * @param to
	 * @param from
	 */
	public NotifyEmail(String username, String to, String from) {
		
		this.username = username;
		this.to = to;
		this.from = from;
;
	}	
	
	public void send(){
		

	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "25");

	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(from, password);
		   }
	         });

	      try {

		   Message email = new MimeMessage(session);
		
		   email.setFrom(new InternetAddress(from));
		
		   email.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   email.setSubject("Changes have been made to your form");
	
		   email.setText("Dear " + username + ", \nChanges have been made to your form " );

		   Transport.send(email);

		   JOptionPane.showMessageDialog(null, "Message sent to Administrator.");

	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   
		
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	
	
}