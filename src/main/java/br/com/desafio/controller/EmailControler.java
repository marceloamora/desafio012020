package br.com.desafio.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.business.EnviarEmail;
import br.com.desafio.dto.Mensagem;


@RestController
@RequestMapping("api/v1/email")
public class EmailControler {
	
	@Autowired
    private EnviarEmail enviaEmail;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<?> enviarMensagem(){
		String valor = "JOAo MARCELO BEBE";
		String texto = String.format("Teste de Envio de Email enviado por : %s", valor); 
		
		Mensagem mensagem = new Mensagem("Joao Fernando <joao@gmail.com>", Arrays.asList("Marcelo <marcelo.amora@gmail.com>"), "Teste Email", texto);
		
		enviaEmail.enviarMensagem(mensagem);
		return ResponseEntity.ok().body("Enviado com sucesso");
	}

}
