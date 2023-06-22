package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.BancoDto;
import br.com.findvet.controller.form.BancoForm;
import br.com.findvet.controller.form.UpdateBancoForm;
import br.com.findvet.modelo.Banco;
import br.com.findvet.repository.BancoRepository;

@Service
public class BancoService {
	@Autowired
	private BancoRepository bancoRepository;
	
	
	public List<BancoDto> listarBancos(){
		List<Banco> bancos = bancoRepository.findAll();
		return BancoDto.converter(bancos);
	}
	
	public void cadastrar(BancoForm form) {
		Banco banco = form.converter();
		//banco = bancoRepository.findByNome(form.getNome()));
		if(banco!=null) {
			bancoRepository.save(banco);
		}
	}
	public ResponseEntity<?> remover(Long id){
		if(bancoRepository.findBancoById(id)!=null) {
			bancoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<BancoDto> atualizar(Long id, UpdateBancoForm form) {
		BancoDto bancoDto = form.atualizar(id,bancoRepository);
		if(bancoDto!=null) {
			return ResponseEntity.ok(bancoDto);
		}
		return ResponseEntity.notFound().build();
	}
}
