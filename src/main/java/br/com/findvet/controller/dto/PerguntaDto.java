package br.com.findvet.controller.dto;

import java.io.Serializable;

import br.com.findvet.modelo.Pergunta;

public class PerguntaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pergunta;
	
	public String getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public static PerguntaDto converter (Pergunta pergunta){
		PerguntaDto perguntaDto = null;
		if(pergunta != null) {
				perguntaDto = new PerguntaDto();
				perguntaDto.setPergunta(pergunta.getPergunta());
		}
		return perguntaDto;
	}

}
