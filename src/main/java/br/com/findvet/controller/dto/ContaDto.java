package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Conta;
import br.com.findvet.modelo.TipoDeConta;

public class ContaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero;
	private char digitoVerificador;
	private TipoDeConta tipoDeConta;
	private String codigoAgencia;
	private char digitoDaAgencia;
	
	
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
	
	public static List<ContaDto> converter (List<Conta> contas){
		ContaDto contaDto = new ContaDto();
		List<ContaDto> contasDto = new ArrayList<>();
		if(!contas.isEmpty()) {
			for (Conta conta : contas) {
				contaDto.setDigitoVerificador(conta.getDigitoVerificador());
				contaDto.setNumero(conta.getNumero());
				contaDto.setTipoDeConta(conta.getTipoDeConta());
				contasDto.add(contaDto);
				contaDto = new ContaDto();
			}
		}
		return contasDto;
	}
	
	public static ContaDto converter (Conta conta){
		ContaDto contaDto  = null;
		if(conta!=null) {
				contaDto = new ContaDto();
				contaDto.setDigitoVerificador(conta.getDigitoVerificador());
				contaDto.setNumero(conta.getNumero());
				contaDto.setTipoDeConta(conta.getTipoDeConta());
				contaDto.setCodigoAgencia(conta.getCodigoAgencia());
				contaDto.setDigitoDaAgencia(conta.getDigitoDaAgencia());
			}
		return contaDto;
	}

}
