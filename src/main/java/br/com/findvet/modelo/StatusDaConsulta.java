package br.com.findvet.modelo;

import br.com.findvet.exceptions.EstadoException;

public enum StatusDaConsulta {
//OCORRENDO,ABERTA,FINALIZADA,CANCELADA
	ABERTA {
		@Override
		public StatusDaConsulta ocorrendo() throws EstadoException {
			return StatusDaConsulta.OCORRENDO;
		}
		@Override
		public StatusDaConsulta cancelada() throws EstadoException {
			return StatusDaConsulta.CANCELADA;
		}
	},
	OCORRENDO {
		@Override
		public StatusDaConsulta finalizada() throws EstadoException {
			return StatusDaConsulta.FINALIZADA;
		}
	},
	FINALIZADA {
		@Override
		public StatusDaConsulta finalizada() throws EstadoException {
			return StatusDaConsulta.FINALIZADA;
		}

	},CANCELADA {
		@Override
		public StatusDaConsulta cancelada() throws EstadoException {
			return StatusDaConsulta.CANCELADA;
		}
	};

	
	
	public StatusDaConsulta ocorrendo() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado ocorrendo");
	}

	public StatusDaConsulta cancelada() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado cancelada");
	}

	public StatusDaConsulta finalizada() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado finalizada");
	}
	
	public StatusDaConsulta aberta() throws EstadoException {
		throw new EstadoException("Não é possivel passar para o estado aberta");
	}
	
	
}
