package br.com.findvet.controller.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.Conta;
import br.com.findvet.modelo.Endereco;
import br.com.findvet.modelo.Especialidade;
import br.com.findvet.modelo.IdentificacaoEndereco;
import br.com.findvet.modelo.ParceiroPessoaFisica;
import br.com.findvet.modelo.StatusDoParceiro;
import br.com.findvet.modelo.Telefone;
import br.com.findvet.modelo.TipoDeEndereco;

public class ParceiroForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty @Length(min = 8)
	private String senha;
	@NotNull
	private BigDecimal valor;
	private StatusDoParceiro status;
	private Conta conta;
	@NotNull @NotEmpty @CPF
	private String cpf;
	@NotNull @NotEmpty
	private String rg;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datanascimento;
	private String crmv;
	private Especialidade especialidade;
	
	//Dados de telefone
	private List<Telefone> telefones = new ArrayList<Telefone>();
	@NotNull @NotEmpty 
	private String telefoneCelular;
	private String telefoneResidencial;
	private TelefoneForm telefoneForm = new TelefoneForm();
	
	// Dados de Endereço
	private Endereco endereco = new Endereco();
	private EnderecoForm enderecoForm = new EnderecoForm();
	@NotNull @NotEmpty
	private String nomeEndereco;
	@NotNull @NotEmpty
	private String complementoEndereco;
	@NotNull @NotEmpty
	private String cep;
	@NotNull @NotEmpty
	private String numeroEndereco;
	private Long bairro_id;
	
	private IdentificacaoEndereco identificacaoEndereco;
	
	private TipoDeEndereco tipoDeEndereco;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	private boolean isprincipal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public StatusDoParceiro getStatus() {
		return status;
	}
	public void setStatus(StatusDoParceiro status) {
		this.status = status;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
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
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getCrmv() {
		return crmv;
	}
	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
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
	public TelefoneForm getTelefoneForm() {
		return telefoneForm;
	}
	public void setTelefoneForm(TelefoneForm telefoneForm) {
		this.telefoneForm = telefoneForm;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public EnderecoForm getEnderecoForm() {
		return enderecoForm;
	}
	public void setEnderecoForm(EnderecoForm enderecoForm) {
		this.enderecoForm = enderecoForm;
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
	
	public Long getBairro_id() {
		return bairro_id;
	}
	public void setBairro_id(Long bairro_id) {
		this.bairro_id = bairro_id;
	}
	public ParceiroPessoaFisica converter() {
		ParceiroPessoaFisica parceiro = new ParceiroPessoaFisica();
		dadosDoParceiro(parceiro);
		carregarTelefoneForm();
		telefones = telefoneForm.converter();
		carregarEnderecoForm();
		endereco = enderecoForm.converter();
		return parceiro;
	}
	private void dadosDoParceiro(ParceiroPessoaFisica parceiro) {
		parceiro.setNome(nome);
		parceiro.setEmail(email);
		parceiro.setSenha(senha);
		parceiro.setCpf(cpf);
		parceiro.setDatanascimento(datanascimento);
		parceiro.setRg(rg);
		parceiro.setValor(valor);
		parceiro.setCrmv(crmv);
		parceiro.setEspecialidade(especialidade);
		parceiro.setStatus(status);
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
