package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.ClienteDto;
import br.com.findvet.modelo.ClientePessoaFisica;
import br.com.findvet.repository.ClientePessoaFisicaRepository;

public class UpdateClienteForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty
	private String cpf;
	@NotNull @NotEmpty
	private String rg;
	
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
	
	public ClienteDto atualizar(String cpf, ClientePessoaFisicaRepository clienteRepository) {
		ClientePessoaFisica cliente = new ClientePessoaFisica();
	    cliente = clienteRepository.findByCpf(cpf);
	   if(cliente!=null) {
	    	  cliente.setNome(nome);
		      cliente.setRg(rg);
		      cliente.setEmail(email);
		      cliente.setCpf(cpf);
	    }
	   
	        return ClienteDto.converter(cliente);
	}

}
