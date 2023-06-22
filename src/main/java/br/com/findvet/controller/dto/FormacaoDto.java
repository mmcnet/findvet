package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.findvet.modelo.Especialidade;
import br.com.findvet.modelo.Formacao;

public class FormacaoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String universidade;
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
	
	public static FormacaoDto converter (Formacao formacao){
		FormacaoDto formacaoDto = null;
		if(formacao != null) {
				formacaoDto = new FormacaoDto();
				formacaoDto.setDataFormacao(formacao.getDataFormacao());
				formacaoDto.setEspecialidade(formacao.getEspecialidade());
				formacaoDto.setGraduacao(formacao.getGraduacao());
				formacaoDto.setUniversidade(formacao.getUniversidade());
		}
		return formacaoDto;
	}


}
