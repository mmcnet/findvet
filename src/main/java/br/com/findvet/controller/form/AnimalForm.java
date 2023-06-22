package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.modelo.Animal;

public class AnimalForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty
	private String nome;
	private String apelido;
	@NotNull @NotEmpty
	private String cor;
	@NotNull @NotEmpty
	private String sexo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date nascimento;
	private String sinal;
	@NotNull @NotEmpty @CPF
	private String cpf;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getSinal() {
		return sinal;
	}
	public void setSinal(String sinal) {
		this.sinal = sinal;
	}
	public Animal converter() {
		Animal animal = new Animal();
		animal.setApelido(apelido);
		animal.setCor(cor);
		animal.setNascimento(nascimento);
		animal.setNome(nome);
		animal.setSexo(sexo);
		animal.setSinal(sinal);
		return animal;
	}

}
