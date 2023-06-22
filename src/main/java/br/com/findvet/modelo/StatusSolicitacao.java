package br.com.findvet.modelo;

import br.com.findvet.exceptions.EstadoException;

public enum StatusSolicitacao {
	APROVADA {
		@Override
		public StatusSolicitacao aprovada() throws EstadoException {
			throw new EstadoException("Esta solicitação já foi aprovada");
		}
	},
	CANCELADA {
		@Override
		public StatusSolicitacao cancelada() throws EstadoException {
			throw new EstadoException("Esta solicitação já foi cancelada");
		}
	},
	ABERTA {
		@Override
		public StatusSolicitacao aberta() throws EstadoException {
			return StatusSolicitacao.ABERTA;
		}
		@Override
		public StatusSolicitacao aprovada() throws EstadoException {
			return StatusSolicitacao.APROVADA;
		}
		@Override
		public StatusSolicitacao cancelada() throws EstadoException {
			return StatusSolicitacao.CANCELADA;
		}
	};
	public StatusSolicitacao aprovada() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado aprovado");
	}

	public StatusSolicitacao cancelada() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado cancelado");
	}

	public StatusSolicitacao aberta() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado aberto");
	}
}
