package br.com.findvet.controller.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.StatusDaConsulta;
import br.com.findvet.modelo.TipoDeConsulta;

public class ConsultaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="yyyy-MM-dd") @NotNull
	private Date dataDaConsulta;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm") @NotNull
	private Date horaDaConsulta;
	private TipoDeConsulta tipoDeConsulta;
	private StatusDaConsulta statusDaConsulta;
	@NotNull @NotEmpty
	private String sintoma;
	private BigDecimal valor;
	private String avaliacao;
	@NotNull
	private Long id_cliente;
	@NotNull
	private Long id_animal;
	@NotNull
	private Long id_parceiro;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Long getId_animal() {
		return id_animal;
	}
	public void setId_animal(Long id_animal) {
		this.id_animal = id_animal;
	}
	public Long getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Long id_parceiro) {
		this.id_parceiro = id_parceiro;
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
	
	public Consulta converter() {
		Consulta consulta = new Consulta();
		consulta.setAvaliacao(avaliacao);
		consulta.setDataDaConsulta(dataDaConsulta);
		consulta.setHoraDaConsulta(horaDaConsulta);
		consulta.setSintoma(sintoma);
		consulta.setTipoDeConsulta(tipoDeConsulta);
		consulta.setValor(valor);
		return consulta;
	}

}
