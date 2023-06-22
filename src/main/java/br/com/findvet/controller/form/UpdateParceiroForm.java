package br.com.findvet.controller.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.findvet.controller.dto.ParceiroDto;
import br.com.findvet.modelo.ParceiroPessoaFisica;
import br.com.findvet.repository.ParceiroPessoaFisicaRepository;

public class UpdateParceiroForm {
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @CPF
	private String cpf;
	@NotNull @NotEmpty
	private String rg;
	@NotNull @NotEmpty
	private BigDecimal valor;
	private Date datanascimento;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	public ParceiroDto atualizar(String cpf, ParceiroPessoaFisicaRepository parceiroRepository) {
		ParceiroPessoaFisica parceiro = parceiroRepository.findByCpf(cpf);
	    if(parceiro!=null) {
	    	  parceiro.setNome(nome);
		      parceiro.setRg(rg);
		      parceiro.setDatanascimento(datanascimento);
		      parceiro.setCpf(cpf);
		      parceiro.setValor(valor);
	    }
	      
	        return ParceiroDto.converter(parceiro);
	}
	
	
}
