package br.com.findvet.modelo;

public enum IdentificacaoEndereco {
COMERCIAL("Comercial"), RESIDENCIAL("Residêncial"), OUTROS("Outros");
	
private final String label;

private IdentificacaoEndereco (String label) {
	this.label = label;
}

public String getLabel() {
	return this.label;
}



}
