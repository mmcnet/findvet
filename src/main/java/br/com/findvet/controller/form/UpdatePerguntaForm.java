package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.PerguntaDto;
import br.com.findvet.modelo.Pergunta;
import br.com.findvet.repository.PerguntaRepository;

public class UpdatePerguntaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank @NotNull
	private String pergunta;
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public PerguntaDto atualizar(Long id, PerguntaRepository perguntaRepository) {
		Pergunta listaPergunta= perguntaRepository.findByPerguntaPorId(id);
	    if(listaPergunta!=null) {
	    	  listaPergunta.setPergunta(pergunta);
	    }
	      
	        return PerguntaDto.converter(listaPergunta);
	}

}
