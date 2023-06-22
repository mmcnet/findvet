package br.com.findvet.controller.dto;

import java.io.Serializable;

import br.com.findvet.modelo.Ficha;

public class FichaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public static FichaDto converter (Ficha ficha){
		FichaDto fichaDto = null;
		if(ficha != null) {
				fichaDto =  new FichaDto();
				fichaDto.setTitulo(ficha.getTitulo());
		}
		return fichaDto;
	}
}
