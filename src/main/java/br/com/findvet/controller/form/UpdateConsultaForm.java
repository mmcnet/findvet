package br.com.findvet.controller.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.controller.dto.ConsultaDto;
import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.StatusDaConsulta;
import br.com.findvet.repository.ConsultaRepository;

public class UpdateConsultaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="yyyy-MM-dd") @NotNull
	private Date dataDaConsulta;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm") @NotNull
	private Date horaDaConsulta;
	private BigDecimal valor;
	private StatusDaConsulta statusDaConsulta;
	@NotNull @NotEmpty
	private String sintoma;
	
	
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
	public ConsultaDto atualizar(Long id, ConsultaRepository consultaRepository) {
	    Consulta consulta = (Consulta) consultaRepository.findConsultaId(id);
	    if(consulta!=null) {
	    	 consulta.setDataDaConsulta(dataDaConsulta);
	    	 consulta.setHoraDaConsulta(horaDaConsulta);
	    	 consulta.setSintoma(sintoma);
	    	 consulta.setValor(valor);
	    }
	      
	        return ConsultaDto.converter(consulta);
	}

}
