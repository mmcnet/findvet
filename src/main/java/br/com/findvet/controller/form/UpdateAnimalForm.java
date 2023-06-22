package br.com.findvet.controller.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.findvet.controller.dto.AnimalDto;
import br.com.findvet.modelo.Animal;
import br.com.findvet.repository.AnimalRepository;

public class UpdateAnimalForm implements Serializable{

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
	
	public AnimalDto atualizar(Long id, AnimalRepository animalRepository) {
		Animal animal = animalRepository.findAnimalId(id);
	    if(animal!=null) {
	    	if(!apelido.isBlank()&&!apelido.isEmpty()) {
	    		animal.setApelido(apelido);
	    	}
	    	if(!cor.isBlank()&&!cor.isEmpty()) {
	    		animal.setCor(cor);
	    	} 
	    	if(nascimento!=null) {
	    		animal.setNascimento(nascimento);
	    	} 
	    	if(!nome.isBlank()&&!nome.isEmpty()) {
	    		animal.setNome(nome);
	    	} 
	    	if(!sexo.isBlank()&&!sexo.isEmpty()) {
	    		animal.setSexo(sexo);
	    	} 
	    	if(!sinal.isBlank()&&!sinal.isEmpty()) {
	    		animal.setSinal(sinal);
	    	}  
	    }
	      
	        return AnimalDto.converter(animal);
	}

}
