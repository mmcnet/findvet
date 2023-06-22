package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.StatusDaConsulta;
import br.com.findvet.modelo.TipoDeConsulta;

public class ConsultaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataDaConsulta;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date horaDaConsulta;
	private TipoDeConsulta tipoDeConsulta;
	private StatusDaConsulta statusDaConsulta;
	private BigDecimal valor;
	private String sintoma;
	private String avaliacao;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
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
	public TipoDeConsulta getTipoDeConsulta() {
		return tipoDeConsulta;
	}
	public void setTipoDeConsulta(TipoDeConsulta tipoDeConsulta) {
		this.tipoDeConsulta = tipoDeConsulta;
	}
	public StatusDaConsulta getStatusDaConsulta() {
		return statusDaConsulta;
	}
	public void setStatusDaConsulta(StatusDaConsulta statusDaConsulta) {
		this.statusDaConsulta = statusDaConsulta;
	}
	public String getSintoma() {
		return sintoma;
	}
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public static List<ConsultaDto> converter (List<Consulta> consultas){
		ConsultaDto consultaDto = new ConsultaDto();
		List<ConsultaDto> consultasDto = new ArrayList<>();
		if(!consultas.isEmpty()) {
			for (Consulta consulta : consultas) {
				consultaDto.setAvaliacao(consulta.getAvaliacao());
				consultaDto.setDataDaConsulta(consulta.getDataDaConsulta());
				consultaDto.setHoraDaConsulta(consulta.getHoraDaConsulta());
				consultaDto.setSintoma(consulta.getSintoma());
				//consultaDto.setStatusDaConsulta(consulta.getStatusDaConsulta());
				consultaDto.setTipoDeConsulta(consulta.getTipoDeConsulta());
				consultaDto.setValor(consulta.getValor());
				consultasDto.add(consultaDto);
				consultaDto = new ConsultaDto();
			}
		}
		return consultasDto;
	}
	
	public static ConsultaDto converter (Consulta consulta){
		ConsultaDto consultaDto = null;
		if(consulta!=null) {
				consultaDto = new ConsultaDto();
				consultaDto.setAvaliacao(consulta.getAvaliacao());
				consultaDto.setDataDaConsulta(consulta.getDataDaConsulta());
				consultaDto.setHoraDaConsulta(consulta.getHoraDaConsulta());
				consultaDto.setSintoma(consulta.getSintoma());
				//consultaDto.setStatusDaConsulta(consulta.getStatusDaConsulta());
				consultaDto.setTipoDeConsulta(consulta.getTipoDeConsulta());
				consultaDto.setValor(consulta.getValor());
		}
		return consultaDto;
	}


}
