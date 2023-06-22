package br.com.findvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.findvet.controller.form.FaleConoscoForm;
import br.com.findvet.service.FaleConoscoService;

@Controller
public class FaleConoscoController {
	 @Autowired 
	 private JavaMailSender mailSender;
	 @Autowired 
	 private FaleConoscoService faleService;
	    
	    @RequestMapping(path = "/faleconosco", method = RequestMethod.POST)
	    public String faleConosco(FaleConoscoForm form) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("Oi sou "+form.getNome()+" e gostaria de fazer o seguinte comentário: "+form.getComentario());
	        message.setTo("marcson@findvet.com.br");
	        message.setFrom(form.getEmail());
	        message.setSubject("FORMULÁRIO FALE CONOSCO: SITE DA FINDVET");

	        try {
	        	faleService.cadastrar(form);
	            mailSender.send(message);
	            return "redirect:/";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "redirect:/";
	        }
	    }
}
