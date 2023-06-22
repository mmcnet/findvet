package br.com.findvet.controller.dto;

import java.util.Date;

import br.com.findvet.modelo.StatusDaAgenda;

public class AgendaDto {
	
	private Date data;
	private int qdtDeAtendimento;
	private StatusDaAgenda status;
	private String mensagem;
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
