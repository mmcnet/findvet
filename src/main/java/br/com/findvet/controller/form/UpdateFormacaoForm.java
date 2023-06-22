package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.FormacaoDto;
import br.com.findvet.modelo.Especialidade;
import br.com.findvet.modelo.Formacao;
import br.com.findvet.repository.FormacaoRepository;

public class UpdateFormacaoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String universidade;
	@NotNull @NotBlank
	private String graduacao;
	private Date dataFormacao;
	private Especialidade especialidade;
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	public String getGraduacao() {
		return graduacao;
	}
	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}
	
	public Date getDataFormacao() {
		return dataFormacao;
	}
	public void setDataFormacao(Date dataFormacao) {
		this.dataFormacao = dataFormacao;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public FormacaoDto atualizar(Long id, FormacaoRepository formacaoRepository) {
		Formacao formacao = formacaoRepository.findByFormacaoPorId(id);
	    if(formacao!=null) {
	    	  formacao.setDataFormacao(dataFormacao);
	    	  formacao.setEspecialidade(especialidade);
	    	  formacao.setGraduacao(graduacao);
	    	  formacao.setUniversidade(universidade);
	    }
	      
	        return FormacaoDto.converter(formacao);
	}
	


}
