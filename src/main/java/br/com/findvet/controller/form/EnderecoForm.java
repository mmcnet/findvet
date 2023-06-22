package br.com.findvet.controller.form;

import java.io.Serializable;

import br.com.findvet.modelo.Bairro;
import br.com.findvet.modelo.Endereco;
import br.com.findvet.modelo.IdentificacaoEndereco;
import br.com.findvet.modelo.TipoDeEndereco;

public class EnderecoForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeEndereco;
	private String complementoEndereco;
	private String cep;
	private String numeroEndereco;
	private Long bairro_id;
	private IdentificacaoEndereco identificacaoEndereco;
	private TipoDeEndereco tipoDeEndereco;
	private boolean isprincipal;
	Endereco endereco = new Endereco();
	Bairro bairro = new Bairro();
	
	public String getNomeEndereco() {
		return nomeEndereco;
	}
	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}
	public String getComplementoEndereco() {
		return complementoEndereco;
	}
	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	public Long getBairro_id() {
		return bairro_id;
	}
	public void setBairro_id(Long bairro_id) {
		this.bairro_id = bairro_id;
	}
	public IdentificacaoEndereco getIdentificacaoEndereco() {
		return identificacaoEndereco;
	}
	public void setIdentificacaoEndereco(IdentificacaoEndereco identificacaoEndereco) {
		this.identificacaoEndereco = identificacaoEndereco;
	}
	public TipoDeEndereco getTipoDeEndereco() {
		return tipoDeEndereco;
	}
	public void setTipoDeEndereco(TipoDeEndereco tipoDeEndereco) {
		this.tipoDeEndereco = tipoDeEndereco;
	}
	public boolean isIsprincipal() {
		return isprincipal;
	}
	public void setIsprincipal(boolean isprincipal) {
		this.isprincipal = isprincipal;
	}	
	public Endereco converter() {
		bairro.setId(bairro_id);
		endereco.setCep(cep);
		endereco.setComplemento(complementoEndereco);
		endereco.setBairro(bairro);
		endereco.setIdentificacaoEndereco(identificacaoEndereco);
		endereco.setNomePrincipal(nomeEndereco);
		endereco.setNumero(numeroEndereco);
		endereco.setPrincipal(isprincipal);
		endereco.setTipoDeEndereco(tipoDeEndereco);
		
		return endereco;
		
	}	
}
