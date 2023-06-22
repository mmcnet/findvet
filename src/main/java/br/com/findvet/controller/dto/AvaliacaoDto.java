package br.com.findvet.controller.dto;

import java.io.Serializable;

import br.com.findvet.modelo.Avaliacao;

public class AvaliacaoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int satisfacao;
	private boolean gostouDoServico;
	private String Comentario;
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
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	public static AvaliacaoDto converter (Avaliacao avaliacao){
		AvaliacaoDto avaliacaoDto = null;
		if(avaliacao != null) {
				avaliacaoDto = new AvaliacaoDto();
				avaliacaoDto.setComentario(avaliacao.getComentario());
				avaliacaoDto.setGostouDoServico(avaliacao.isGostouDoServico());
				avaliacaoDto.setSatisfacao(avaliacao.getSatisfacao());
		}
		return avaliacaoDto;
	}
	
}
