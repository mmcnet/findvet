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
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nomePrincipal;
	private String complemento;
	private String cep;
	private String numero;
	@OneToOne(fetch = FetchType.LAZY,targetEntity = Bairro.class)
	@JoinColumn(name = "bairro_id", nullable = false,referencedColumnName = "id")
	private Bairro bairro;
	@Enumerated(EnumType.STRING)
	private IdentificacaoEndereco identificacaoEndereco;
	@Enumerated(EnumType.STRING)
	private TipoDeEndereco tipoDeEndereco;
	private boolean principal;
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "pessoa_id",nullable = true)
	private Pessoa pessoa;

	public IdentificacaoEndereco getIdentificacaoEndereco() {
		return identificacaoEndereco;
	}
	public void setIdentificacaoEndereco(IdentificacaoEndereco identificacaoEndereco) {
		this.identificacaoEndereco = identificacaoEndereco;
	}
	public TipoDeEndereco getTipoDeEndereco() {
		return tipoDeEndereco;
	}
	public void setTipoDeEndereco(TipoDeEndereco tipoDeEndereco) {
		this.tipoDeEndereco = tipoDeEndereco;
	}
	public String getNomePrincipal() {
		return nomePrincipal;
	}
	public void setNomePrincipal(String nomePrincipal) {
		this.nomePrincipal = nomePrincipal;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public boolean isPrincipal() {
		return principal;
	}
	public void setPrincipal(boolean principal) {
		this.principal = principal;
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
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identificacaoEndereco == null) ? 0 : identificacaoEndereco.hashCode());
		result = prime * result + ((nomePrincipal == null) ? 0 : nomePrincipal.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + (principal ? 1231 : 1237);
		result = prime * result + ((tipoDeEndereco == null) ? 0 : tipoDeEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identificacaoEndereco != other.identificacaoEndereco)
			return false;
		if (nomePrincipal == null) {
			if (other.nomePrincipal != null)
				return false;
		} else if (!nomePrincipal.equals(other.nomePrincipal))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (principal != other.principal)
			return false;
		if (tipoDeEndereco != other.tipoDeEndereco)
			return false;
		return true;
	}
		
}
