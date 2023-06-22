package br.com.findvet.controller.form;

import br.com.findvet.modelo.FaleConosco;

public class FaleConoscoForm {

	private String nome;
	private String email;
	private String comentario;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public FaleConosco converter() {
		FaleConosco fale = new FaleConosco();
		fale.setNome(nome);
		fale.setEmail(email);
		fale.setComentario(comentario);
		return fale;
	}
}
