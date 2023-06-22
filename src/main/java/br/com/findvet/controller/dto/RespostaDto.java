package br.com.findvet.controller.dto;

import java.io.Serializable;

import br.com.findvet.modelo.Resposta;

public class RespostaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean resposta;
	private String respostaTexto;
	private boolean EhTexto;

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
		return EhTexto;
	}
	public void setEhTexto(boolean ehTexto) {
		EhTexto = ehTexto;
	}
	public static RespostaDto converter (Resposta resposta){
		RespostaDto respostaDto = null;
		if(resposta != null) {
				respostaDto = new RespostaDto();
				respostaDto.setEhTexto(resposta.isEhTexto());
				respostaDto.setResposta(resposta.isResposta());
				respostaDto.setRespostaTexto(resposta.getRespostaTexto());
		}
		return respostaDto;
	}
}
