package br.com.findvet.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Resposta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private boolean resposta;
	private String respostaTexto;
	private boolean EhTexto;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pergunta_id", nullable = false)
	private Pergunta pergunta;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ficha_id", nullable = false)
	private Ficha ficha;
	
	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public String getRespostaTexto() {
		return respostaTexto;
	}

	public void setRespostaTexto(String respostaTexto) {
		this.respostaTexto = respostaTexto;
	}

	public boolean isEhTexto() {
		return EhTexto;
	}

	public void setEhTexto(boolean ehTexto) {
		EhTexto = ehTexto;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (EhTexto ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result + (resposta ? 1231 : 1237);
		result = prime * result + ((respostaTexto == null) ? 0 : respostaTexto.hashCode());
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
		Resposta other = (Resposta) obj;
		if (EhTexto != other.EhTexto)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (resposta != other.resposta)
			return false;
		if (respostaTexto == null) {
			if (other.respostaTexto != null)
				return false;
		} else if (!respostaTexto.equals(other.respostaTexto))
			return false;
		return true;
	}
	
}
