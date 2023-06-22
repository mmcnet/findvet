package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Telefone;
import br.com.findvet.modelo.TipoDeTelefone;

public class TelefoneForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private String telefoneCelular;
	private String telefoneResidencial;
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	
	public List<Telefone> converter() {
		Telefone telCel = new Telefone();
		telCel.setNumeroDotelefone(telefoneCelular);	
		telCel.setTipoDeTelefone(TipoDeTelefone.CELULAR);
		this.telefones.add(telCel);
		Telefone telRes = new Telefone();
		telRes.setNumeroDotelefone(telefoneResidencial);
		telRes.setTipoDeTelefone(TipoDeTelefone.RESIDÊNCIAL);
		this.telefones.add(telRes);
		return this.telefones;
		
	}
}
