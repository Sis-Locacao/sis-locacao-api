package com.sislocacao.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.services.LocacaoService;

@RestController
@RequestMapping("/locacoes")
public class LocacaoResource {
	
	@Autowired
	private LocacaoService locacaoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarLocacao(@PathVariable final Long id){
		return ResponseEntity.ok(locacaoService.buscarLocacaoPorId(id));
	}
}
