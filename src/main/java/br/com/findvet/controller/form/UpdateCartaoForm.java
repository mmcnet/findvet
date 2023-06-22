package br.com.findvet.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.CartaoDto;
import br.com.findvet.modelo.Cartao;
import br.com.findvet.modelo.TipoBandeiraCartao;
import br.com.findvet.repository.CartaoRepository;

public class UpdateCartaoForm {
	@NotNull @NotBlank 
	private String nome;
	@NotNull @NotBlank 
	private String numeroDoCartao;
	@NotNull @NotBlank 
	private String dataValidade;
	@NotNull @NotBlank 
	private String codigoSeguranca;
	private TipoBandeiraCartao bandeira;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public TipoBandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(TipoBandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public CartaoDto atualizar(Long id, CartaoRepository cartaoRepository) {
	    Cartao cartao =  cartaoRepository.findByCartaoPorId(id);
	    if(cartao!=null) {
	    	 cartao.setBandeira(bandeira);
	    	 cartao.setCodigoSeguranca(codigoSeguranca);
	    	 cartao.setDataValidade(dataValidade);
	    	 cartao.setNome(nome);
	    	 cartao.setNumeroDoCartao(numeroDoCartao);
	    }
	      
	        return CartaoDto.converter(cartao);
	}

}
