package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.findvet.modelo.Conta;
import br.com.findvet.modelo.Especialidade;
import br.com.findvet.modelo.ParceiroPessoaFisica;
import br.com.findvet.modelo.StatusDoParceiro;

public class ParceiroDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private List<TelefoneDto> telefones;
	private List<EnderecoDto> enderecos;
	private byte[] foto;
	private StatusDoParceiro status;
	private Conta conta;
	private String cpf;
	private String rg;
	private BigDecimal valor;
	private Date datanascimento;
	private String crmv;
	private Especialidade especialidade;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
	public List<TelefoneDto> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneDto> telefones) {
		this.telefones = telefones;
	}
	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
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
	public static List<ParceiroDto> converter (List<ParceiroPessoaFisica> parceiros){
		ParceiroDto parceiroDto = new ParceiroDto();
		List<ParceiroDto> parceirosDto = new ArrayList<>();
		if(!parceiros.isEmpty()) {
			for (ParceiroPessoaFisica parceiro : parceiros) {
				dadosDoParceiro(parceiroDto, parceiro);
				parceirosDto.add(parceiroDto);
				parceiroDto = new ParceiroDto();
			}
		}
		return parceirosDto;
	}
	public static ParceiroDto converter (ParceiroPessoaFisica parceiro){
		ParceiroDto parceiroDto = null;
		if(parceiro!=null) {
				parceiroDto = new ParceiroDto();
				dadosDoParceiro(parceiroDto, parceiro);
		}
		return parceiroDto;
	}
	private static void dadosDoParceiro(ParceiroDto parceiroDto, ParceiroPessoaFisica parceiro) {
		parceiroDto.setId(parceiro.getId());
		parceiroDto.setNome(parceiro.getNome());
		parceiroDto.setEmail(parceiro.getEmail());
		parceiroDto.setSenha(parceiro.getSenha());
		parceiroDto.setEnderecos(EnderecoDto.converter(parceiro.getEnderecos()));
		parceiroDto.setTelefones(TelefoneDto.converter(parceiro.getTelefones()));
		parceiroDto.setCpf(parceiro.getCpf());
		parceiroDto.setRg(parceiro.getRg());
		parceiroDto.setDatanascimento(parceiro.getDatanascimento());
		parceiroDto.setValor(parceiro.getValor());
		parceiroDto.setStatus(parceiro.getStatus());
		parceiroDto.setCrmv(parceiro.getCrmv());
		parceiroDto.setEspecialidade(parceiro.getEspecialidade());
	}
}
