package br.com.findvet.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.findvet.modelo.PessoaTemporaria;

public class PessoaTemporariaForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty
	private String telefone;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public PessoaTemporaria converter() {
		PessoaTemporaria pessoa = new PessoaTemporaria();
		dadosDaPessoa(pessoa);
		return pessoa;
	}
	private void dadosDaPessoa(PessoaTemporaria pessoa) {
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setTelefone(telefone);
	}
}
