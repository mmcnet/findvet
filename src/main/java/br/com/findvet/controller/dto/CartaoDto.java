package br.com.findvet.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Cartao;
import br.com.findvet.modelo.TipoBandeiraCartao;

public class CartaoDto {
	
	private String nome;
	private String numeroDoCartao;
	private String dataValidade;
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
	
	public static List<CartaoDto> converter (List<Cartao> cartoes){
		CartaoDto cartaoDto = new CartaoDto();
		List<CartaoDto> cartoesDto = new ArrayList<>();
		if(!cartoes.isEmpty()) {
			for (Cartao cartao : cartoes) {
				cartaoDto.setBandeira(cartao.getBandeira());
				cartaoDto.setCodigoSeguranca(cartao.getCodigoSeguranca());
				cartaoDto.setDataValidade(cartao.getDataValidade());
				cartaoDto.setNome(cartao.getNome());
				cartaoDto.setNumeroDoCartao(cartao.getNumeroDoCartao());
				cartoesDto.add(cartaoDto);
				cartaoDto = new CartaoDto();
			}
		}
		return cartoesDto;
	}
	
	public static CartaoDto converter (Cartao cartao){
		CartaoDto cartaoDto =null;
		if(cartao!=null) {
				cartaoDto = new CartaoDto();
				cartaoDto.setBandeira(cartao.getBandeira());
				cartaoDto.setCodigoSeguranca(cartao.getCodigoSeguranca());
				cartaoDto.setDataValidade(cartao.getDataValidade());
				cartaoDto.setNome(cartao.getNome());
				cartaoDto.setNumeroDoCartao(cartao.getNumeroDoCartao());
			}
		
		return cartaoDto;
	}
}
