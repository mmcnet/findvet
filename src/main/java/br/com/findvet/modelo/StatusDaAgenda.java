package br.com.findvet.modelo;

import br.com.findvet.exceptions.EstadoException;

public enum StatusDaAgenda {
	
		ABERTA {
			@Override
			public StatusDaAgenda fechada() throws EstadoException {
				return StatusDaAgenda.FECHADA;
			}
			
		},
		FECHADA {
			@Override
			public StatusDaAgenda aberta() throws EstadoException {
				return StatusDaAgenda.ABERTA;
			}
		};
		
		
	
		public StatusDaAgenda fechada() throws EstadoException {
			throw new EstadoException("Não é possivel passar para o estado finalizada");
		}
		
		public StatusDaAgenda aberta() throws EstadoException {
			throw new EstadoException("Não é possivel passar para o estado aberta");
		}
		
		
}
