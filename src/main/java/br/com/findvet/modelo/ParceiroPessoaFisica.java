package br.com.findvet.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ParceiroPessoaFisica extends Parceiro{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String rg;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datanascimento;
	private String crmv;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@ManyToMany
    @JoinTable(name="parceiro_bairro", joinColumns=
    {@JoinColumn(name="parceiro_id")}, inverseJoinColumns=
    {@JoinColumn(name="bairro_id")})
    private List<Bairro> bairrosAtendidos;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getCrmv() {
		return crmv;
	}
	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public List<Bairro> getBairrosAtendidos() {
		return bairrosAtendidos;
	}
	public void setBairrosAtendidos(List<Bairro> bairrosAtendidos) {
		this.bairrosAtendidos = bairrosAtendidos;
	}
	
	
}
