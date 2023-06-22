package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.ClienteDto;
import br.com.findvet.controller.form.ClienteForm;
import br.com.findvet.controller.form.UpdateClienteForm;
import br.com.findvet.modelo.Cliente;
import br.com.findvet.modelo.ClientePessoaFisica;
import br.com.findvet.modelo.Telefone;
import br.com.findvet.repository.ClientePessoaFisicaRepository;
import br.com.findvet.security.EncodedSha1;

@Service
public class ClienteService {
	
	@Autowired
	private ClientePessoaFisicaRepository clienteRepository;
	@Autowired
	private TelefoneService telefoneService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private PerfilService perfilService;
	
	
	
	public ClienteDto listaCliente(String cpf){
		ClientePessoaFisica cliente = clienteRepository.findByCpf(cpf);
		return ClienteDto.converter(cliente);
	}
	
	public ClientePessoaFisica listaClientePorId(Long id){
		ClientePessoaFisica cliente = clienteRepository.findClienteId(id);
		return cliente;
	}
	
	public ResponseEntity<?> cadastrar(ClienteForm form) {
		ClientePessoaFisica cliente = (ClientePessoaFisica) form.converter();
		cliente.setSenha(new EncodedSha1().encode(cliente.getSenha()));
		cliente.setPerfis(perfilService.localizarPerfilPorNome("CLIENTE"));
		clienteRepository.save(cliente);
		cliente = clienteRepository.findByCpf(cliente.getCpf());
		if(cliente!=null) {
			if(!form.getTelefones().isEmpty()){
				addTelefone(form.getTelefones(),cliente);
			}
			if(form.getEndereco()!=null) {
				enderecoService.incluirEndereco(form.getEndereco(),cliente);
			}
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public void addTelefone(List<Telefone> telefones, Cliente cliente) {
		telefoneService.setTelefone(telefones,  cliente);
	}
	
	public ClientePessoaFisica listaClientesPorCpf(String cpf){
		return clienteRepository.findByCpf(cpf);
	}
	public ResponseEntity<?> remover(Long id){
		if(clienteRepository.findClienteId(id)!=null) {
			clienteRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<ClienteDto> atualizar(String cpf, UpdateClienteForm form) {
		
			 ClienteDto cliente = form.atualizar(cpf,clienteRepository);
			 if(cliente!=null) {
				 return ResponseEntity.ok(cliente);
			 }
			 return ResponseEntity.notFound().build();
	}
	public ClientePessoaFisica buscarCliente (String email) {
		ClientePessoaFisica cliente = clienteRepository.findByEmail(email);
	    if(cliente!=null) {
	    	 return cliente;
	    }
	     return null;
	}
	public void disponivel(String email) {
		ClientePessoaFisica cliente = buscarCliente(email);
		cliente.disponivel();
		updateStatusParceiro(cliente);
		
	}

	private void updateStatusParceiro(ClientePessoaFisica cliente) {
		clienteRepository.save(cliente);
	}
	public void indisponivel(String email) {
		ClientePessoaFisica cliente = buscarCliente(email);
		cliente.indisponivel();
		updateStatusParceiro(cliente);
	}

}
