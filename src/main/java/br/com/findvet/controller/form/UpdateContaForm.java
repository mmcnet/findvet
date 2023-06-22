package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.ContaDto;
import br.com.findvet.modelo.Conta;
import br.com.findvet.modelo.TipoDeConta;
import br.com.findvet.repository.ContaRepository;

public class UpdateContaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotBlank
	private String numero;
	@NotNull @NotBlank
	private char digitoVerificador;
	@NotNull @NotBlank
	private String codigoAgencia;
	@NotNull @NotBlank
	private char digitoDaAgencia;
	private TipoDeConta tipoDeConta;
	
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
	public ContaDto atualizar(Long id, ContaRepository contaRepository) {
		Conta conta = contaRepository.findContaPorId(id);
	    if(conta!=null) {
	    	 conta.setDigitoVerificador(digitoVerificador);
	    	 conta.setNumero(numero);
	    	 conta.setTipoDeConta(tipoDeConta);
	    	 conta.setCodigoAgencia(codigoAgencia);
	 		 conta.setDigitoDaAgencia(digitoDaAgencia);
	    }
	    return ContaDto.converter(conta);
	}

}
