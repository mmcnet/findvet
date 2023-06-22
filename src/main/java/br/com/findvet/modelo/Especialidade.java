package br.com.findvet.modelo;

public enum Especialidade {
	CLINICA("Clínica Médica"),ACUPUNTURA("Acupuntura"),DERMATOLOGIA("Dermatologia"),ONCOLOGIA("Oncologia"),
	PATOLOGIA("Patologia"),MEDICINA("Medicina Veterinária Intensiva"),CIRURGIA("Cirurgia"),ANESTESIOLOGIA("Anestesiologia"),HOMEOPATIA("Homeopatia");
	
	private final String label;

	private Especialidade (String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}


}
