package mum.ea.mail;

import mum.ea.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
public class EaMailSender {
    private static final String LOGO = "templates/logo.jpg";
    private static final String LOGO_MIME = "image/jpg";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendMail(MailDto mailDto) {
        try {
            Context thymeContext = new Context(new Locale("en"));
            thymeContext.setVariable("name", mailDto.getName());
            // thymeContext.setVariable("order", new Locale("en"));

            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setSubject(mailDto.getSubject());

            message.setTo(mailDto.getTo());

            String htmlContent = this.templateEngine.process(mailDto.getTemplate(), thymeContext);
            message.setText(htmlContent, true);

            message.addInline("logo", new ClassPathResource(LOGO), LOGO_MIME);

            this.mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
