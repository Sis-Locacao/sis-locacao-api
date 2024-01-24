package com.sislocacao.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;
import com.sislocacao.api.services.InquilinoService;

@RestController
@RequestMapping("/inquilino")
public class InquilinoResource {
	
	@Autowired
	private InquilinoService inquilinoService;
	
	@PostMapping
	public ResponseEntity<InquilinoDTO> salvar(@RequestBody final InquilinoEntradaDTO inquilino){
		return ResponseEntity.status(HttpStatus.CREATED).body(inquilinoService.salvarInquilino(inquilino));
	}
}
