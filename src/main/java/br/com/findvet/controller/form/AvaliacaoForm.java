package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.Avaliacao;

public class AvaliacaoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private int satisfacao;
	@NotNull
	private boolean gostouDoServico;
	@NotNull @NotBlank
	private String comentario;
	private Long consulta_id;
	public int getSatisfacao() {
		return satisfacao;
	}
	public void setSatisfacao(int satisfacao) {
		this.satisfacao = satisfacao;
	}
	public boolean isGostouDoServico() {
		return gostouDoServico;
	}
	public void setGostouDoServico(boolean gostouDoServico) {
		this.gostouDoServico = gostouDoServico;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Long getConsulta_id() {
		return consulta_id;
	}
	public void setConsulta_id(Long consulta_id) {
		this.consulta_id = consulta_id;
	}
	
	public Avaliacao converter() {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComentario(comentario);
		avaliacao.setSatisfacao(satisfacao);
		avaliacao.setGostouDoServico(gostouDoServico);
		return avaliacao;
	}


}
