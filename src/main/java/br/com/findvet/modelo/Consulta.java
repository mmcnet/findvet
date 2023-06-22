package br.com.findvet.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Consulta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataDaConsulta;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date horaDaConsulta;
	private BigDecimal valor;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parceiro_id", nullable = false)
	private Parceiro parceiro;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_id", nullable = false)
	private Animal animal;
	@Enumerated(EnumType.STRING)
	private TipoDeConsulta tipoDeConsulta;
	@Enumerated(EnumType.STRING)
	private StatusDaConsulta status = StatusDaConsulta.ABERTA;
	private String sintoma;
	private String avaliacao;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public StatusDaConsulta getStatus() {
		return status;
	}
	public void setStatus(StatusDaConsulta status) {
		this.status = status;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Parceiro getParceiro() {
		return parceiro;
	}
	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public TipoDeConsulta getTipoDeConsulta() {
		return tipoDeConsulta;
	}
	public void setTipoDeConsulta(TipoDeConsulta tipoDeConsulta) {
		this.tipoDeConsulta = tipoDeConsulta;
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
//	public Anamnese getFicha() {
//		return anamnese;
//	}
//	public void setFicha(Anamnese ficha) {
//		this.anamnese = ficha;
//	}
	
	public Long getId() {
		return id;
	}
	public void aberta() {
		this.status  = this.status.aberta();	
	}
	public void ocorrendo() {
		this.status  = this.status.ocorrendo();
	}
	public void finalizada() {
		this.status  = this.status.finalizada();
	}
	public void cancelada() {
		this.status  = this.status.cancelada();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaConsulta == null) ? 0 : dataDaConsulta.hashCode());
		result = prime * result + ((horaDaConsulta == null) ? 0 : horaDaConsulta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sintoma == null) ? 0 : sintoma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (dataDaConsulta == null) {
			if (other.dataDaConsulta != null)
				return false;
		} else if (!dataDaConsulta.equals(other.dataDaConsulta))
			return false;
		if (horaDaConsulta == null) {
			if (other.horaDaConsulta != null)
				return false;
		} else if (!horaDaConsulta.equals(other.horaDaConsulta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sintoma == null) {
			if (other.sintoma != null)
				return false;
		} else if (!sintoma.equals(other.sintoma))
			return false;
		return true;
	}
	
	
}
