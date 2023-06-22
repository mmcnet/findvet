package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.Cartao;
import br.com.findvet.modelo.ClientePessoaFisica;

public class ClienteDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private List<TelefoneDto> telefone;
	private List<EnderecoDto> enderecos;
	private List<Animal> animais;
	private List<Cartao> cartao;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<TelefoneDto> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<TelefoneDto> telefone) {
		this.telefone = telefone;
	}
	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	public List<Cartao> getCartao() {
		return cartao;
	}
	public void setCartao(List<Cartao> cartao) {
		this.cartao = cartao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public static List<ClienteDto> converter (List<ClientePessoaFisica> clientes){
		ClienteDto clienteDto = new ClienteDto();
		List<ClienteDto> clientesDto = new ArrayList<>();
		if(!clientes.isEmpty()) {
			for (ClientePessoaFisica cliente : clientes) {
				clienteDto.setId(cliente.getId());
				clienteDto.setNome(cliente.getNome());
				clienteDto.setEmail(cliente.getEmail());
				//clienteDto.setCartao(cliente.getCartao());;
				//clienteDto.setAnimais(cliente.getAnimais());
				clienteDto.setSenha(cliente.getSenha());
				clienteDto.setEnderecos(EnderecoDto.converter(cliente.getEnderecos()));
				clienteDto.setTelefone(TelefoneDto.converter(cliente.getTelefones()));
				clienteDto.setCpf(cliente.getCpf());
				clienteDto.setRg(cliente.getRg());
				clienteDto.setDataNascimento(cliente.getDataNascimento());
				clientesDto.add(clienteDto);
				clienteDto = new ClienteDto();
			}
		}
		return clientesDto;
	}
	public static ClienteDto converter (ClientePessoaFisica cliente){
		ClienteDto clienteDto = null;
		if(cliente != null) {
				clienteDto =  new ClienteDto();
				clienteDto.setId(cliente.getId());
				clienteDto.setNome(cliente.getNome());
				clienteDto.setEmail(cliente.getEmail());
				clienteDto.setSenha(cliente.getSenha());
				clienteDto.setEnderecos(EnderecoDto.converter(cliente.getEnderecos()));
				clienteDto.setTelefone(TelefoneDto.converter(cliente.getTelefones()));
				clienteDto.setCpf(cliente.getCpf());
				clienteDto.setRg(cliente.getRg());
				clienteDto.setDataNascimento(cliente.getDataNascimento());
		}
		return clienteDto;
	}
}
