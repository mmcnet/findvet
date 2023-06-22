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
public class Avaliacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int satisfacao;
	private boolean gostouDoServico;
	private String Comentario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consulta_id", nullable = false)
	private Consulta consulta;
	public int getSatisfacao() {
		return satisfacao;
	}
	public void setSatisfacao(int satisfacao) {
		this.satisfacao = satisfacao;
	}
	public boolean isGostouDoServico() {
		return gostouDoServico;
	}
	public void setGostouDoServico(boolean gostouDoServico) {
		this.gostouDoServico = gostouDoServico;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comentario == null) ? 0 : Comentario.hashCode());
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + (gostouDoServico ? 1231 : 1237);
		result = prime * result + satisfacao;
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
		Avaliacao other = (Avaliacao) obj;
		if (Comentario == null) {
			if (other.Comentario != null)
				return false;
		} else if (!Comentario.equals(other.Comentario))
			return false;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (gostouDoServico != other.gostouDoServico)
			return false;
		if (satisfacao != other.satisfacao)
			return false;
		return true;
	}
	
	
}
