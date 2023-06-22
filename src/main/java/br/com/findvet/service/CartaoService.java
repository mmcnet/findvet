package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.CartaoDto;
import br.com.findvet.controller.form.CartaoForm;
import br.com.findvet.controller.form.UpdateCartaoForm;
import br.com.findvet.modelo.Cartao;
import br.com.findvet.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private ClienteService clienteService;
	
	public List<CartaoDto> listarCartaoPorCliente(Long id){
		List<Cartao> cartoes = cartaoRepository.findByCartaoPorCliente(id);
		return CartaoDto.converter(cartoes);
	}
	
	public void cadastrar(CartaoForm form) {
		Cartao cartao = form.converter();
		cartao.setCliente(clienteService.listaClientePorId(form.getId_cliente()));
		if(cartao!=null) {
			cartaoRepository.save(cartao);
		}
	}
	public ResponseEntity<?> remover(Long id){
		if(cartaoRepository.findByCartaoPorId(id)!=null) {
			cartaoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<CartaoDto> atualizar(Long id, UpdateCartaoForm form) {
		CartaoDto cartao = form.atualizar(id,cartaoRepository);
		if(cartao!=null) {
			 return ResponseEntity.ok(cartao);
		}
		return ResponseEntity.notFound().build();
	}
}
