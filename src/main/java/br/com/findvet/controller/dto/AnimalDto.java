package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.findvet.modelo.Animal;

public class AnimalDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String apelido;
	private String cor;
	private String sexo;
	private Date nascimento;
	private String sinal;
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
	
	public static List<AnimalDto> converter (List<Animal> animais){
		AnimalDto animalDto = new AnimalDto();
		List<AnimalDto> animaisDto = new ArrayList<>();
		if(!animais.isEmpty()) {
			for (Animal animal : animais) {
				animalDto.setId(animal.getId());
				animalDto.setApelido(animal.getApelido());
				animalDto.setCor(animal.getCor());
				animalDto.setNascimento(animal.getNascimento());
				animalDto.setNome(animal.getNome());;
				animalDto.setSexo(animal.getSexo());
				animalDto.setSinal(animal.getSinal());
				animaisDto.add(animalDto);
				animalDto = new AnimalDto();
			}
		}
		return animaisDto;
	}
	public static AnimalDto converter (Animal animal){
		AnimalDto animalDto = null;
		if(animal!=null) {
				animalDto = new AnimalDto();
				animalDto.setId(animal.getId());
				animalDto.setApelido(animal.getApelido());
				animalDto.setCor(animal.getCor());
				animalDto.setNascimento(animal.getNascimento());
				animalDto.setNome(animal.getNome());;
				animalDto.setSexo(animal.getSexo());
				animalDto.setSinal(animal.getSinal());
		}
		return animalDto;
	}

}
