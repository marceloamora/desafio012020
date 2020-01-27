package br.com.desafio;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.desafio.business.EnviarEmail;
import br.com.desafio.dto.Mensagem;

public class EnviarEmailTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(EnviarEmailTest.class.getPackage().getName());
		EnviarEmail enviar = applicationContext.getBean(EnviarEmail.class);
		String valor = "JOAo MARCELO BEBE";
		String texto = String.format("Teste de Envio de Email enviado por : %s", valor); 
		
		Mensagem mensagem = new Mensagem("Joao Fernando <joao@gmail.com>", Arrays.asList("Marcelo <marcelo.amora@gmail.com>"), "Teste Email", texto);
		
		enviar.enviarMensagem(mensagem);
		applicationContext.close();
		System.out.println("fim");

	}

}
