package com.sislocacao.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;
import com.sislocacao.api.services.InquilinoService;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoResource {
	
	@Autowired
	private InquilinoService inquilinoService;
	
	@PostMapping
	public ResponseEntity<InquilinoDTO> salvar(@RequestBody final InquilinoEntradaDTO inquilino){
		return ResponseEntity.status(HttpStatus.CREATED).body(inquilinoService.salvar(inquilino));
	}
	
	@GetMapping
	public ResponseEntity<List<InquilinoDTO>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(inquilinoService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InquilinoDTO> buscarPorId(@PathVariable final Long id){
		return ResponseEntity.status(HttpStatus.OK).body(inquilinoService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id){
		inquilinoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InquilinoDTO> atualizar(@RequestBody final InquilinoEntradaDTO inquilino, @PathVariable final Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(inquilinoService.atualizar(id, inquilino));
	}
}
