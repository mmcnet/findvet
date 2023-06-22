package br.com.findvet.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.ContaDto;
import br.com.findvet.controller.form.ContaForm;
import br.com.findvet.controller.form.UpdateContaForm;
import br.com.findvet.modelo.Conta;
import br.com.findvet.repository.BancoRepository;
import br.com.findvet.repository.ContaRepository;

@Service
public class ContaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private BancoRepository bancoRepository;
	@Autowired
	private ParceiroService parceiroService;
	@Autowired
	private ContaRepository contaRepository;
	
	
	public List<ContaDto> getContaPorParceiro(Long id){
		List<Conta> conta = contaRepository.findByContaPorParceiro(id);
		return ContaDto.converter(conta);
	}
	
	public void cadastrar(ContaForm form) {
		Conta conta = form.converter();
		conta.setParceiro(parceiroService.listaParceirosPorId(form.getId_parceiro()));
		conta.setBanco(bancoRepository.findBancoById(form.getId_banco()));
		if(conta!=null) {
			contaRepository.save(conta);
		}
	}
	public ResponseEntity<?> remover(Long id){
		if(contaRepository.findContaPorId(id)!=null) {
			contaRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<ContaDto> atualizar(Long id, UpdateContaForm form) {
		ContaDto conta = form.atualizar(id,contaRepository);
		if(conta!=null) {
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.notFound().build();
	}
}
