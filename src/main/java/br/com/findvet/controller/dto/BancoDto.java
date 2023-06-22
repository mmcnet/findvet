package br.com.findvet.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.findvet.modelo.Banco;

public class BancoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String codigo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public static List<BancoDto> converter (List<Banco> bancos){
		BancoDto bancoDto = new BancoDto();
		List<BancoDto> bancosDto = new ArrayList<>();
		if(!bancos.isEmpty()) {
			for (Banco banco : bancos) {
				bancoDto.setCodigo(banco.getCodigo());
				bancoDto.setNome(banco.getNome());
				bancosDto.add(bancoDto);
				bancoDto = new BancoDto();
			}
		}
		return bancosDto;
	}
	
	public static BancoDto converter (Banco banco){
		BancoDto bancoDto = null;
		if(banco!=null) {
			bancoDto = new BancoDto();
				bancoDto.setCodigo(banco.getCodigo());
				bancoDto.setNome(banco.getNome());
			}
		return bancoDto;
	}

}
