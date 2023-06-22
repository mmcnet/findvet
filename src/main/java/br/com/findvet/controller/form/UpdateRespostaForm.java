package br.com.findvet.controller.form;

import java.io.Serializable;

import br.com.findvet.controller.dto.RespostaDto;
import br.com.findvet.modelo.Resposta;
import br.com.findvet.repository.RespostaRepository;

public class UpdateRespostaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean resposta;
	private String respostaTexto;
	private boolean ehTexto;
	
	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public String getRespostaTexto() {
		return respostaTexto;
	}

	public void setRespostaTexto(String respostaTexto) {
		this.respostaTexto = respostaTexto;
	}

	public boolean isEhTexto() {
		return ehTexto;
	}

	public void setEhTexto(boolean ehTexto) {
		this.ehTexto = ehTexto;
	}

	public RespostaDto atualizar(Long id, RespostaRepository respostaRepository) {
		Resposta resposta = respostaRepository.findByRespostaPorId(id);
	    if(resposta!=null) {
	    	resposta.setRespostaTexto(respostaTexto);
			resposta.setResposta(this.resposta);
			resposta.setEhTexto(ehTexto);
	    }
	      
	        return RespostaDto.converter(resposta);
	}

}
