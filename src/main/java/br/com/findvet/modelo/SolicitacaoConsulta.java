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
public class SolicitacaoConsulta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataDaConsulta;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date horaDaConsulta;
	private BigDecimal valorEstimado;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parceiro_id", nullable = false)
	private Parceiro parceiro;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_id", nullable = false)
	private Animal animal;
	private String sintoma;
	@Enumerated(EnumType.STRING)
	private StatusSolicitacao status = StatusSolicitacao.ABERTA;
	
	public Long getId() {
		return id;
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
	public BigDecimal getValorEstimado() {
		return valorEstimado;
	}
	public void setValorEstimado(BigDecimal valorEstimado) {
		this.valorEstimado = valorEstimado;
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
	public String getSintoma() {
		return sintoma;
	}
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	public StatusSolicitacao getStatus() {
		return status;
	}
	public void setStatus(StatusSolicitacao status) {
		this.status = status;
	}
	public void aprovada() {
		this.status  = this.status.aprovada();	
	}
	public void cancelada() {
		this.status  = this.status.cancelada();
	}
	public void aberta() {
		this.status  = this.status.aberta();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataDaConsulta == null) ? 0 : dataDaConsulta.hashCode());
		result = prime * result + ((horaDaConsulta == null) ? 0 : horaDaConsulta.hashCode());
		result = prime * result + ((parceiro == null) ? 0 : parceiro.hashCode());
		result = prime * result + ((sintoma == null) ? 0 : sintoma.hashCode());
		result = prime * result + ((valorEstimado == null) ? 0 : valorEstimado.hashCode());
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
		SolicitacaoConsulta other = (SolicitacaoConsulta) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
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
		if (parceiro == null) {
			if (other.parceiro != null)
				return false;
		} else if (!parceiro.equals(other.parceiro))
			return false;
		if (sintoma == null) {
			if (other.sintoma != null)
				return false;
		} else if (!sintoma.equals(other.sintoma))
			return false;
		if (valorEstimado == null) {
			if (other.valorEstimado != null)
				return false;
		} else if (!valorEstimado.equals(other.valorEstimado))
			return false;
		return true;
	}
}
