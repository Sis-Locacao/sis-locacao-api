package com.sislocacao.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.services.ReciboService;

@RestController
@RequestMapping("/recibos")
public class ReciboResource {
	
	@Autowired
	private ReciboService reciboService;
	
	@PostMapping
	public ResponseEntity<?> salvaRecibo(@RequestBody ReciboEntradaDTO reciboEntradaDTO){
		reciboService.salvarRecibo(reciboEntradaDTO);
		return ResponseEntity.ok(null);
	}
}
