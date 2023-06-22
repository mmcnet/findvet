package br.com.findvet.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmailController {
	 @Autowired 
	 private JavaMailSender mailSender;

	    @RequestMapping(path = "/send", method = RequestMethod.GET)
	    public String sendMail() {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("Este E-mail veio do servidor findvet");
	        message.setTo("marcson@findvet.com.br");
	        message.setFrom("mmcnet@gmail.com");

	        try {
	            mailSender.send(message);
	            return "Email enviado com sucesso!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Erro ao enviar email.";
	        }
	    }
}
