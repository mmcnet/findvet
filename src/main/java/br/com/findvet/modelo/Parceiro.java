package br.com.findvet.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToOne;


@Entity
public class Parceiro extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Lob
	private byte[] foto;
	@Enumerated(EnumType.STRING)
	private StatusDoParceiro status;
	@OneToOne
	private Conta conta;
	private BigDecimal valor;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public StatusDoParceiro getStatus() {
		return status;
	}
	public void setStatus(StatusDoParceiro status) {
		this.status = status;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public void disponivel() {
		this.status  = this.status.disponivel();	
	}
	public void solicitado() {
		this.status  = this.status.solicitado();
	}
	public void ocupado() {
		this.status  = this.status.ocupado();
	}
	public void indisponivel() {
		this.status  = this.status.indisponivel();
	}
	
}
