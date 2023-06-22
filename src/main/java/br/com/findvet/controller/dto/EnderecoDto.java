package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Endereco;
import br.com.findvet.modelo.IdentificacaoEndereco;
import br.com.findvet.modelo.TipoDeEndereco;

public class EnderecoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomeEndereco;
	private String complementoEndereco;
	private String cep;
	private String numeroEndereco;
	private Long bairro_id;
	private IdentificacaoEndereco identificacaoEndereco;
	private TipoDeEndereco tipoDeEndereco;
	private boolean isprincipal;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static List<EnderecoDto> converter (List<Endereco> enderecos){
		EnderecoDto enderecoDto = new EnderecoDto();
		List<EnderecoDto> enderecosDto = new ArrayList<>();
		if(!enderecos.isEmpty()) {
			for (Endereco endereco : enderecos) {
				enderecoDto.setId(endereco.getId());
				enderecoDto.setCep(endereco.getCep());
				enderecoDto.setComplementoEndereco(endereco.getComplemento());
				enderecoDto.setBairro_id(endereco.getBairro().getId());
				enderecoDto.setIdentificacaoEndereco(endereco.getIdentificacaoEndereco());
				enderecoDto.setIsprincipal(endereco.isPrincipal());
				enderecoDto.setNomeEndereco(endereco.getNomePrincipal());
				enderecoDto.setNumeroEndereco(endereco.getNumero());
				enderecoDto.setTipoDeEndereco(endereco.getTipoDeEndereco());
				enderecosDto.add(enderecoDto);
				enderecoDto = new EnderecoDto();
			}
		}
		return enderecosDto;
	}

}
