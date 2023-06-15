package com.sislocacao.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.dto.ReciboSaidaDTO;
import com.sislocacao.api.services.ReciboService;

@RestController
@RequestMapping("/recibos")
public class ReciboResource {
	
	@Autowired
	private ReciboService reciboService;
	
	@PostMapping
	public ResponseEntity<ReciboSaidaDTO> salvaRecibo(@RequestBody ReciboEntradaDTO reciboEntradaDTO){
		return ResponseEntity.ok(reciboService.salvarRecibo(reciboEntradaDTO));
	}
	
	@GetMapping("/locacao/{locacaoId}")
	public ResponseEntity<List<ReciboSaidaDTO>> listarRecibos(@PathVariable final Long locacaoId){
		System.out.println("");
		return ResponseEntity.ok(reciboService.listarRecibos(locacaoId));
	}
}
