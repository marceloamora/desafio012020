package br.com.desafio.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.Mensagem;

@Service
@Component
public class EnviarEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviarMensagem(Mensagem mensagem) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mensagem.getRemetente());
		simpleMailMessage.setTo(mensagem.getDestinatarios()
				.toArray(new String[mensagem.getDestinatarios().size()]));
		simpleMailMessage.setSubject(mensagem.getAssunto());
		simpleMailMessage.setText(mensagem.getCorpo());
		
		javaMailSender.send(simpleMailMessage);
		
	}

}
