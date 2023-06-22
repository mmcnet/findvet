package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.Pergunta;

public class PerguntaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank @NotNull
	private String pergunta;
	@NotNull
	private Long topico_id;
	public String getPergunta() {
		return pergunta;
	}
	
	public Long getTopico_id() {
		return topico_id;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public void setTopico_id(Long topico_id) {
		this.topico_id = topico_id;
	}
	public Pergunta converter() {
		Pergunta pergunta = new Pergunta();
		pergunta.setPergunta(this.pergunta);
		return pergunta;
	}

	

}
