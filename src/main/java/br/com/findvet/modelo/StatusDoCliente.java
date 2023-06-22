package br.com.findvet.modelo;

import br.com.findvet.exceptions.EstadoException;

public enum StatusDoCliente {
	INDISPONIVEL {
		@Override
		public StatusDoCliente disponivel() throws EstadoException {
			return StatusDoCliente.DISPONIVEL;
		}
	},
	DISPONIVEL {
		@Override
		public StatusDoCliente indisponivel() throws EstadoException {
			return StatusDoCliente.INDISPONIVEL;
		}
	};
	
	public StatusDoCliente indisponivel() throws EstadoException {
		throw new EstadoException("Não é possivel passar para indisponível");
	}

	public StatusDoCliente disponivel() throws EstadoException {
		throw new EstadoException("Não é possivel passar para disponivel");
	}

}
