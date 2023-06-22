package br.com.findvet.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Telefone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String numeroDotelefone;
	@Enumerated(EnumType.STRING)
	private TipoDeTelefone tipoDeTelefone;
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "pessoa_id",nullable = true)
	private Pessoa pessoa;

	
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
	public Long getId() {
		return id;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroDotelefone == null) ? 0 : numeroDotelefone.hashCode());
		result = prime * result + ((tipoDeTelefone == null) ? 0 : tipoDeTelefone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroDotelefone == null) {
			if (other.numeroDotelefone != null)
				return false;
		} else if (!numeroDotelefone.equals(other.numeroDotelefone))
			return false;
		if (tipoDeTelefone != other.tipoDeTelefone)
			return false;
		return true;
	}
	
	
	

}
