package br.com.findvet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.FormacaoDto;
import br.com.findvet.controller.form.FormacaoForm;
import br.com.findvet.controller.form.UpdateFormacaoForm;
import br.com.findvet.modelo.Formacao;
import br.com.findvet.modelo.Parceiro;
import br.com.findvet.repository.FormacaoRepository;
import br.com.findvet.repository.ParceiroPessoaFisicaRepository;

@Service
public class FormacaoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FormacaoRepository formacaoRepository;
	@Autowired
	private ParceiroPessoaFisicaRepository parceiroPessoaFisicaRepository;
	
	public ResponseEntity<FormacaoDto> listarFormacaoPorParceiro(Long id){
		Formacao formacao =  formacaoRepository.findByFormacaoPorParceiro(id);
		FormacaoDto formacaoDto =  FormacaoDto.converter(formacao);
		if(formacaoDto!=null) {
			return ResponseEntity.ok(formacaoDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	public void cadastrar(FormacaoForm form) {
		Formacao formacao = form.converter();
		if(formacaoRepository.findByFormacaoPorParceiro(form.getParceiro_id())==null) {
			Parceiro parceiro = parceiroPessoaFisicaRepository.findParceiroId(form.getParceiro_id());
			formacao.setParceiro(parceiro);
			formacaoRepository.save(formacao);
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		if(formacaoRepository.findByFormacaoPorId(id)!=null) {
			formacaoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<FormacaoDto> atualizar(Long id, UpdateFormacaoForm form) {
		FormacaoDto formacao = form.atualizar(id,formacaoRepository);
		if(formacao!=null) {
			return ResponseEntity.ok(formacao);
		}
		return ResponseEntity.notFound().build();
	}
}
