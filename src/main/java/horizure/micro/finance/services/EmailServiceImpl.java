package horizure.micro.finance.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import horizure.micro.finance.entities.Mail;

@Service
public class EmailServiceImpl implements EmailService{

	private static Logger log = (Logger) LogManager.getLogger(EmailServiceImpl.class);
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
    private SpringTemplateEngine templateEngine;
	
	
	@Override
	public void sendSimpleMessage(String username,String to,String subject,String message,String redirection) {
		// TODO Auto-generated method stub
        log.info("Sending Email with Thymeleaf HTML Template Example");

        Mail mail = new Mail();
        mail.setFrom("coinsxspeed.micro.finance@gmail.com");
        mail.setTo(to);
        mail.setSubject(subject);

        Map<String, Object> model = new HashMap<>();
        model.put("name", username);
        model.put("location", "Tunisia");
        model.put("message", message);
        model.put("redirection", redirection);
        model.put("signature", "http://localhost:4200/");
        mail.setModel(model);
		try {
			this.sendSimpleMessage(mail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void sendSimpleMessage(Mail mail) throws MessagingException, IOException {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());

	        helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

	        Context context = new Context();
	        context.setVariables(mail.getModel());
	        String html = templateEngine.process("email", context);

	        helper.setTo(mail.getTo());
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	        emailSender.send(message);
	    }

}
