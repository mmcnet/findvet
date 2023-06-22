package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.AnimalDto;
import br.com.findvet.controller.form.AnimalForm;
import br.com.findvet.controller.form.UpdateAnimalForm;
import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.ClientePessoaFisica;
import br.com.findvet.repository.AnimalRepository;

@Service
public class AnimalService {
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<AnimalDto> listaAnimalCliente(ClientePessoaFisica cliente){
		List<Animal> animal = animalRepository.findByCliente(cliente);
		return AnimalDto.converter(animal);
	}
	
	public Animal listaAnimalPorId(Long id){
		Animal animal = animalRepository.findAnimalId(id);
		return animal;
	}
	
	public void cadastrar(AnimalForm form, ClientePessoaFisica cliente) {
		Animal animal = (Animal) form.converter();
		animal.setCliente(cliente);
		animalRepository.save(animal);
		animal = animalRepository.findByNome(animal.getNome());
		if(animal!=null) {
			animalRepository.save(animal);
		}
	}
	public ResponseEntity<?> remover(Long id){
		if(animalRepository.findAnimalId(id)!=null) {
			animalRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<AnimalDto> atualizar(Long id, UpdateAnimalForm form) {
		AnimalDto animal = form.atualizar(id, animalRepository);
		if(animal!=null) {
			return ResponseEntity.ok(animal);
		}
		 return ResponseEntity.notFound().build();
	}

	
}
