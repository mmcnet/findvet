package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.SolicitacaoConsulta;
import br.com.findvet.modelo.StatusSolicitacao;

public class SolicitacaoConsultaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataDaConsulta;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date horaDaConsulta;
	private StatusSolicitacao statusDaSolicitacao;
	private BigDecimal valorEstimado;
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
	public StatusSolicitacao getStatusDaSolicitacao() {
		return statusDaSolicitacao;
	}
	public void setStatusDaSolicitacao(StatusSolicitacao statusDaSolicitacao) {
		this.statusDaSolicitacao = statusDaSolicitacao;
	}
	public BigDecimal getValorEstimado() {
		return valorEstimado;
	}
	public void setValorEstimado(BigDecimal valorEstimado) {
		this.valorEstimado = valorEstimado;
	}
	public String getSintoma() {
		return sintoma;
	}
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	

	public static List<SolicitacaoConsultaDto> converter (List<SolicitacaoConsulta> solicitacoes){
		SolicitacaoConsultaDto solicitacaoDto = new SolicitacaoConsultaDto();
		List<SolicitacaoConsultaDto> solicitacoesDto = new ArrayList<>();
		if(!solicitacoes.isEmpty()) {
			for (SolicitacaoConsulta solicitacao : solicitacoes) {
				carregarSolicitacaoConsulta(solicitacaoDto, solicitacao);
				solicitacoesDto.add(solicitacaoDto);
				solicitacaoDto = new SolicitacaoConsultaDto();
			}
		}
		return solicitacoesDto;
	}
	private static void carregarSolicitacaoConsulta(SolicitacaoConsultaDto solicitacaoDto,
			SolicitacaoConsulta solicitacao) {
		solicitacaoDto.setDataDaConsulta(solicitacao.getDataDaConsulta());
		solicitacaoDto.setHoraDaConsulta(solicitacao.getHoraDaConsulta());
		solicitacaoDto.setSintoma(solicitacao.getSintoma());
		solicitacaoDto.setValorEstimado(solicitacao.getValorEstimado());
		solicitacaoDto.setStatusDaSolicitacao(solicitacao.getStatus());
	}
	
	public static SolicitacaoConsultaDto converter (SolicitacaoConsulta solicitacao){
		SolicitacaoConsultaDto solicitacaoDto = null;
		if(solicitacao!=null) {
				solicitacaoDto = new SolicitacaoConsultaDto();
				carregarSolicitacaoConsulta(solicitacaoDto, solicitacao);
		}
		return solicitacaoDto;
	}

}
