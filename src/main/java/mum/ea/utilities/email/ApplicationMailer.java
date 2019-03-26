package mum.ea.utilities.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class ApplicationMailer {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage preconfMessage;
	
	
	//method to send compose and send the message
	
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	
	//method send a pre-configurred message
	
	public void sendPreConfigMail(String message) {
		SimpleMailMessage mailMessage=new SimpleMailMessage(preconfMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
}
