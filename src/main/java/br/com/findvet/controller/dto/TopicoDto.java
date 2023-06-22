package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.ParceiroPessoaFisica;
import br.com.findvet.modelo.Topico;

public class TopicoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static TopicoDto converter (Topico topico){
		TopicoDto topicoDto = new TopicoDto();
		if(topico != null) {
				topicoDto.setNome(topico.getNome());
				topicoDto = new TopicoDto();
		}
		return topicoDto;
	}
	public static List<TopicoDto> converter (List<Topico> topicos){
		TopicoDto topicoDto = new TopicoDto();
		List<TopicoDto> topicosDto = new ArrayList<>();
		if(!topicos.isEmpty()) {
			for (Topico topico : topicos) {
				topicoDto.setNome(topico.getNome());
				topicosDto.add(topicoDto);
				topicoDto = new TopicoDto();
			}
		}
		return topicosDto;
	}

}
