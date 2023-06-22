package br.com.findvet.modelo;

import br.com.findvet.exceptions.EstadoException;

public enum StatusDoParceiro {
	INDISPONIVEL {
		@Override
		public StatusDoParceiro disponivel() throws EstadoException {
			return StatusDoParceiro.DISPONIVEL;
		}
	},
	DISPONIVEL {
		@Override
		public StatusDoParceiro solicitado() throws EstadoException {
			return StatusDoParceiro.SOLICITADO;
		}

		@Override
		public StatusDoParceiro indisponivel() throws EstadoException {
			return StatusDoParceiro.INDISPONIVEL;
		}
	},
	SOLICITADO {
		@Override
		public StatusDoParceiro indisponivel() throws EstadoException {
			return StatusDoParceiro.INDISPONIVEL;
		}
		@Override
		public StatusDoParceiro ocupado() throws EstadoException {
			return StatusDoParceiro.OCUPADO;
		}

	},OCUPADO {
		@Override
		public StatusDoParceiro indisponivel() throws EstadoException {
			return StatusDoParceiro.INDISPONIVEL;
		}
		
		@Override
		public StatusDoParceiro disponivel() throws EstadoException {
			return StatusDoParceiro.DISPONIVEL;
		}
	};

	
	
	public StatusDoParceiro indisponivel() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado indisponível");
	}

	public StatusDoParceiro disponivel() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado disponível");
	}

	public StatusDoParceiro solicitado() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado solicitado");
	}
	
	public StatusDoParceiro ocupado() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado ocupado");
	}
	
	
}
