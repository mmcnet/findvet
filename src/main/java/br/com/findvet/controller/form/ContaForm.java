package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.Conta;
import br.com.findvet.modelo.TipoDeConta;

public class ContaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String numero;
	@NotNull @NotBlank
	private char digitoVerificador;
	private TipoDeConta tipoDeConta;
	@NotNull @NotBlank
	private String codigoAgencia;
	@NotNull @NotBlank
	private char digitoDaAgencia;
	@NotNull
	private Long id_parceiro;
	@NotNull
	private Long id_banco;
	
	
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
	public Long getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Long id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	public Long getId_banco() {
		return id_banco;
	}
	public void setId_banco(Long id_banco) {
		this.id_banco = id_banco;
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
	public Conta converter() {
		Conta conta = new Conta();
		conta.setDigitoVerificador(digitoVerificador);
		conta.setNumero(numero);
		conta.setTipoDeConta(tipoDeConta);
		conta.setCodigoAgencia(codigoAgencia);
		conta.setDigitoDaAgencia(digitoDaAgencia);
		return conta;
	}
	

}
