package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.Ficha;

public class FichaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String titulo;
	@NotNull
	private Long consulta_id;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getConsulta_id() {
		return consulta_id;
	}
	public void setConsulta_id(Long consulta_id) {
		this.consulta_id = consulta_id;
	}
	public Ficha converter() {
		Ficha ficha = new Ficha();
		ficha.setTitulo(titulo);
		return ficha;
	}

}
