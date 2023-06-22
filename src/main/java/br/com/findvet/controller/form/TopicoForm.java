package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.Topico;

public class TopicoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String nome;
	private Long ficha_id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getFicha_id() {
		return ficha_id;
	}
	public void setFicha_id(Long ficha_id) {
		this.ficha_id = ficha_id;
	}
	public Topico converter() {
		Topico topico = new Topico();
		topico.setNome(nome);
		return topico;
	}


}
