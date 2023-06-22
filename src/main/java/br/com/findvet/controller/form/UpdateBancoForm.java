package br.com.findvet.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.findvet.controller.dto.BancoDto;
import br.com.findvet.modelo.Banco;
import br.com.findvet.repository.BancoRepository;

public class UpdateBancoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
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
	public BancoDto atualizar(Long id, BancoRepository bancoRepository) {
	    Banco banco = bancoRepository.findBancoById(id);
	    if(banco!=null) {
	    	  banco.setCodigo(codigo);
	    	  banco.setNome(nome);
	    }
	      
	        return BancoDto.converter(banco);
	}
}
