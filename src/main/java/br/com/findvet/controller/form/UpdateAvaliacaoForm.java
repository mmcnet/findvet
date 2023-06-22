package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.AvaliacaoDto;
import br.com.findvet.modelo.Avaliacao;
import br.com.findvet.repository.AvaliacaoRepository;

public class UpdateAvaliacaoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private int satisfacao;
	@NotNull
	private boolean gostouDoServico;
	@NotNull @NotBlank
	private String comentario;
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
	public AvaliacaoDto atualizar(Long id, AvaliacaoRepository avaliacaoRepository) {
		Avaliacao avaliacao = avaliacaoRepository.findByAvaliacaoPorId(id);
	    if(avaliacao!=null) {
	    	  avaliacao.setComentario(comentario);
	    	  avaliacao.setGostouDoServico(gostouDoServico);
	    	  avaliacao.setSatisfacao(satisfacao);
	    }
	    return AvaliacaoDto.converter(avaliacao);
	}
}
