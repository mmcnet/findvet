package br.com.findvet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public  class Cliente extends Pessoa implements Serializable {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Animal> animais;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Cartao> cartao;
	@Enumerated(EnumType.STRING)
	private StatusDoCliente status = StatusDoCliente.INDISPONIVEL;
	
	public Cliente() {
		
	}

	public List<Cartao> getCartao() {
		return cartao;
	}

	public void setCartao(List<Cartao> cartao) {
		this.cartao = cartao;
	}


	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	public void disponivel() {
		this.status  = this.status.disponivel();	
	}
	
	public void indisponivel() {
		this.status  = this.status.indisponivel();
	}


	
}
