package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.Especialidade;
import br.com.findvet.modelo.Formacao;

public class FormacaoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String universidade;
	@NotNull @NotBlank
	private String graduacao;
	@JsonFormat(pattern="yyyy-MM-dd") @NotNull
	private Date dataFormacao;
	private Especialidade especialidade;
	@NotNull
	private Long parceiro_id;
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
	public Long getParceiro_id() {
		return parceiro_id;
	}
	public void setParceiro_id(Long parceiro_id) {
		this.parceiro_id = parceiro_id;
	}
	public Formacao converter() {
		Formacao formacao = new Formacao();
		formacao.setDataFormacao(dataFormacao);
		formacao.setEspecialidade(especialidade);
		formacao.setGraduacao(graduacao);
		formacao.setUniversidade(universidade);
		return formacao;
	}
	

}
