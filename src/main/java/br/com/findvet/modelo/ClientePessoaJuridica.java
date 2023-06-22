package br.com.findvet.modelo;

import javax.persistence.Entity;
@Deprecated
@Entity
public class ClientePessoaJuridica extends Cliente{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String razaoSocial;
	String cnpj;
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
