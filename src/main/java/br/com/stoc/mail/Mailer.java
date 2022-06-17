package br.com.stoc.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailer {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviar(Mensagem mensagem) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom(mensagem.getRemetente());
		simpleMailMessage.setTo((String[])mensagem.getDestinatarios()
				 .toArray((Object[])new String[mensagem.getDestinatarios().size()]));
		simpleMailMessage.setSubject(mensagem.getAssunto());
		simpleMailMessage.setText(mensagem.getCorpo());
		
		this.javaMailSender.send(simpleMailMessage);	
	}
}
