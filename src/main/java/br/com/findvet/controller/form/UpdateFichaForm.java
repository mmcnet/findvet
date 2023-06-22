package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.FichaDto;
import br.com.findvet.modelo.Ficha;
import br.com.findvet.repository.FichaRepository;

public class UpdateFichaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String titulo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public FichaDto atualizar(Long id, FichaRepository fichaRepository) {
		Ficha ficha = fichaRepository.findByFichaPorId(id);
	    if(ficha!=null) {
	    	  ficha.setTitulo(titulo);
	    }
	      
	        return FichaDto.converter(ficha);
	}

}
