package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.TopicoDto;
import br.com.findvet.modelo.Topico;
import br.com.findvet.repository.TopicoRepository;

public class UpdateTopicoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TopicoDto atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.findByTopicoPorId(id);
	    if(topico!=null) {
	    	  topico.setNome(nome);
	    }
	      
	        return TopicoDto.converter(topico);
	}


}
