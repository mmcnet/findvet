package br.com.findvet.controller.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.StatusDaAgenda;

public class AgendaForm {
	private Long parceiro;
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date data;
	private int qdtDeAtendimento;
	private StatusDaAgenda status;
	private String mensagem;
	public Long getParceiro() {
		return parceiro;
	}
	public void setParceiro(Long parceiro) {
		this.parceiro = parceiro;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQdtDeAtendimento() {
		return qdtDeAtendimento;
	}
	public void setQdtDeAtendimento(int qdtDeAtendimento) {
		this.qdtDeAtendimento = qdtDeAtendimento;
	}
	public StatusDaAgenda getStatus() {
		return status;
	}
	public void setStatus(StatusDaAgenda status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
