package br.com.findvet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.findvet.controller.dto.TokenDto;
import br.com.findvet.controller.form.LoginForm;
import br.com.findvet.service.ClienteService;
import br.com.findvet.service.ConsultaService;
import br.com.findvet.service.ParceiroService;
import br.com.findvet.service.SolicitacaoConsultaService;
import br.com.findvet.service.TokenService;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private ParceiroService parceiro;
	@Autowired
	private ClienteService cliente;
	
	@Autowired
	private SolicitacaoConsultaService solicitacao;
	
	@Autowired
	private ConsultaService consulta;
	


	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			//parceiro.indisponivel(dadosLogin.getName());
			//cliente.indisponivel(dadosLogin.getName());
			consulta.ocorrendo((long) 42);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
