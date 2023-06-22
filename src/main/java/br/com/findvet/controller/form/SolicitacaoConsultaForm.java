package br.com.findvet.controller.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.SolicitacaoConsulta;

public class SolicitacaoConsultaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="yyyy-MM-dd") @NotNull
	private Date dataDaConsulta;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm") @NotNull
	private Date horaDaConsulta;
	private BigDecimal valorEstimado;
	private Long cliente_id;
	private Long parceiro_id;
	private Long animal_id;
	private String sintoma;
	
	
	
	public Date getDataDaConsulta() {
		return dataDaConsulta;
	}



	public void setDataDaConsulta(Date dataDaConsulta) {
		this.dataDaConsulta = dataDaConsulta;
	}



	public Date getHoraDaConsulta() {
		return horaDaConsulta;
	}



	public void setHoraDaConsulta(Date horaDaConsulta) {
		this.horaDaConsulta = horaDaConsulta;
	}



	public BigDecimal getValorEstimado() {
		return valorEstimado;
	}



	public void setValorEstimado(BigDecimal valorEstimado) {
		this.valorEstimado = valorEstimado;
	}



	public Long getCliente_id() {
		return cliente_id;
	}



	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}



	public Long getParceiro_id() {
		return parceiro_id;
	}



	public void setParceiro_id(Long parceiro_id) {
		this.parceiro_id = parceiro_id;
	}



	public Long getAnimal_id() {
		return animal_id;
	}



	public void setAnimal_id(Long animal_id) {
		this.animal_id = animal_id;
	}



	public String getSintoma() {
		return sintoma;
	}



	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}



	


	public SolicitacaoConsulta converter() {
		SolicitacaoConsulta solicitacao = new SolicitacaoConsulta();
		solicitacao.setDataDaConsulta(dataDaConsulta);
		solicitacao.setHoraDaConsulta(horaDaConsulta);
		solicitacao.setSintoma(sintoma);
		solicitacao.setValorEstimado(valorEstimado);
		//solicitacao.setStatus(statusSolicitacao);
		return solicitacao;
	}

	

}
