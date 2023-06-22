package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.Cartao;
import br.com.findvet.modelo.ClientePessoaFisica;
import br.com.findvet.modelo.Endereco;
import br.com.findvet.modelo.IdentificacaoEndereco;
import br.com.findvet.modelo.Telefone;
import br.com.findvet.modelo.TipoDeEndereco;

public class ClienteForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty @Length(min = 8)
	private String senha;
	@NotNull @NotEmpty
	private String cpf;
	@NotNull @NotEmpty
	private String rg;
	private Date dataNascimento;
	private Endereco endereco = new Endereco();
	private EnderecoForm enderecoForm = new EnderecoForm();
	private List<Animal> animais;
	private List<Cartao> cartao;
	//Dados de telefdone
	private String telefoneCelular;
	private String telefoneResidencial;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private TelefoneForm telefoneForm = new TelefoneForm();
	// Dados de Endereço
	private String nomeEndereco;
	private String complementoEndereco;
	private String cep;
	private String numeroEndereco;
	private Long bairro_id;
	private IdentificacaoEndereco identificacaoEndereco;
	private TipoDeEndereco tipoDeEndereco;
	private boolean isprincipal;
	
	
	
	
	
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
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public ClientePessoaFisica converter() {
		ClientePessoaFisica cliente = new ClientePessoaFisica();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setRg(rg);
		carregarTelefoneForm();
		telefones = telefoneForm.converter();
		carregarEnderecoForm();
		endereco = enderecoForm.converter();
		return cliente;
	}
	private void carregarTelefoneForm() {
		this.telefoneForm.setTelefoneCelular(this.telefoneCelular);
		this.telefoneForm.setTelefoneResidencial(this.telefoneResidencial);
	}
	private void carregarEnderecoForm() {
		enderecoForm.setCep(cep);
		enderecoForm.setComplementoEndereco(complementoEndereco);
		enderecoForm.setIdentificacaoEndereco(identificacaoEndereco);
		enderecoForm.setIsprincipal(isprincipal);
		enderecoForm.setNomeEndereco(nomeEndereco);
		enderecoForm.setNumeroEndereco(numeroEndereco);
		enderecoForm.setBairro_id(bairro_id);
		enderecoForm.setTipoDeEndereco(tipoDeEndereco);
	}
}
