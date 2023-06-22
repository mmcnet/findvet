package br.com.findvet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.findvet.modelo.Bairro;
import br.com.findvet.modelo.Endereco;
import br.com.findvet.modelo.IdentificacaoEndereco;
import br.com.findvet.modelo.Pessoa;
import br.com.findvet.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BairroService bairroService;
	
	public void incluirEndereco(Endereco endereco, Pessoa pessoa) {
		Endereco adress = new Endereco();
		adress.setNomePrincipal(endereco.getNomePrincipal());
		adress.setNumero(endereco.getNumero());
		adress.setIdentificacaoEndereco(IdentificacaoEndereco.RESIDENCIAL);
		adress.setCep(endereco.getCep());
		adress.setPessoa(pessoa);
		adress.setComplemento(endereco.getComplemento());
		adress.setPrincipal(endereco.isPrincipal());
		adress.setTipoDeEndereco(endereco.getTipoDeEndereco());
		Bairro bairro = bairroService.listaBairroPorId(endereco.getBairro().getId());
		if(bairro!=null) {
			adress.setBairro(bairro);
			enderecoRepository.save(adress);
		}
		
	}
	
}
