package br.com.findvet.controller.form;

import java.io.Serializable;

import br.com.findvet.modelo.Resposta;

public class RespostaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean resposta;
	private String respostaTexto;
	private boolean ehTexto;
	private Long pergunta_id;
	
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
	public Long getPergunta_id() {
		return pergunta_id;
	}
	public void setPergunta_id(Long pergunta_id) {
		this.pergunta_id = pergunta_id;
	}
	
	public Resposta converter() {
		Resposta resposta = new Resposta();
		resposta.setRespostaTexto(respostaTexto);
		resposta.setResposta(this.resposta);
		resposta.setEhTexto(ehTexto);
		return resposta;
	}
}
