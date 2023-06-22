package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Telefone;
import br.com.findvet.modelo.TipoDeTelefone;

public class TelefoneDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String numeroDotelefone;
	private TipoDeTelefone tipoDeTelefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroDotelefone() {
		return numeroDotelefone;
	}
	public void setNumeroDotelefone(String numeroDotelefone) {
		this.numeroDotelefone = numeroDotelefone;
	}
	public TipoDeTelefone getTipoDeTelefone() {
		return tipoDeTelefone;
	}
	public void setTipoDeTelefone(TipoDeTelefone tipoDeTelefone) {
		this.tipoDeTelefone = tipoDeTelefone;
	}
	
	public static List<TelefoneDto> converter (List<Telefone> telefones){
		TelefoneDto dto = new TelefoneDto();
		List<TelefoneDto> telefoneDtos = new ArrayList<TelefoneDto>();
		for (Telefone telefone : telefones) {
			dto.setId(telefone.getId());
			dto.setNumeroDotelefone(telefone.getNumeroDotelefone());
			dto.setTipoDeTelefone(telefone.getTipoDeTelefone());
			telefoneDtos.add(dto);
			dto = new TelefoneDto();
		}
		return telefoneDtos;
	}
	

    

}
