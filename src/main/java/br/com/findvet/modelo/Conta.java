package br.com.findvet.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private char digitoVerificador;
	private String codigoAgencia;
	private char digitoDaAgencia;
	@OneToOne(fetch = FetchType.LAZY,targetEntity = Banco.class)
	@JoinColumn(name = "banco_id", nullable = false,referencedColumnName = "id")
	private Banco banco;
	@OneToOne(fetch = FetchType.LAZY,targetEntity = Parceiro.class)
	@JoinColumn(name = "parceiro_id", nullable = false,referencedColumnName = "id")
	private Parceiro parceiro;
	@Enumerated(EnumType.STRING)
	private TipoDeConta tipoDeConta;
	
	// ********** Métodos ***********
	
	
	public Banco getBanco() {
		return banco;
	}
	public String getCodigoAgencia() {
		return codigoAgencia;
	}
	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}
	public char getDigitoDaAgencia() {
		return digitoDaAgencia;
	}
	public void setDigitoDaAgencia(char digitoDaAgencia) {
		this.digitoDaAgencia = digitoDaAgencia;
	}
	public Parceiro getParceiro() {
		return parceiro;
	}
	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public char getDigitoVerificador() {
		return digitoVerificador;
	}
	public void setDigitoVerificador(char digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	public TipoDeConta getTipoDeConta() {
		return tipoDeConta;
	}
	public void setTipoDeConta(TipoDeConta tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}
	public Long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + digitoVerificador;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Conta other = (Conta) obj;
		if (digitoVerificador != other.digitoVerificador)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
	
}
