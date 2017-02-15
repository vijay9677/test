package com.nacre.online_assesment.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author vijay kumar P
 * @Description:This class using for sending mails to students
 */
public class MailApi implements Serializable {

	/**
	 * @author vijay kumar p
	 * @param list
	 *            which contains emails for sending information about company
	 * @param str2
	 *            which contains details about the company
	 * @throws AddressException
	 *             occurs when giving wrong emailId
	 * @throws MessagingException
	 *             occures when mail sending failed
	 */
	public void sendMail(List<String> list, String str2) throws AddressException, MessagingException {

		// here iterating the list for getting emails
		for (String str : list) {
			System.out.println("-----------------------------");
			// form email address
			final String fromEmail = "2vijay1245@gmail.com"; // requires valid
																// gmail id
			// from email pwd
			final String password = "chandurthi123"; // correct password for
														// gmail id
			// to email id
			final String toEmail = str; // can be any email id

			// required properties of mail api
			// creating properties object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
			props.put("mail.smtp.port", "587"); // TLS Port
			props.put("mail.smtp.auth", "true"); // enable authentication
			props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

			// create Authenticator object to pass in Session.getInstance
			// argument
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			System.out.println("Mail Check 2");

			message.setSubject("you are eligible for following job");
			message.setText(str2);

			System.out.println("Mail Check 3");

			Transport.send(message);
			System.out.println("Mail Sent");
			// return retrivedPwd;
		}
	}

	public static void main(String[] args) throws AddressException, MessagingException {

		MailApi a = new MailApi();

	}

}
