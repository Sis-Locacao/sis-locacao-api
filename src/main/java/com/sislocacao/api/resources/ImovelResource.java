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

import com.sislocacao.api.model.dto.ImovelDTO;
import com.sislocacao.api.model.dto.ImovelEntradaDTO;
import com.sislocacao.api.services.ImovelService;

@RestController
@RequestMapping("/imoveis")
public class ImovelResource {
	
	@Autowired
	private ImovelService imovelService;
	
	@PostMapping
	public ResponseEntity<ImovelDTO> salvar(@RequestBody final ImovelEntradaDTO inquilino){
		return ResponseEntity.status(HttpStatus.CREATED).body(imovelService.salvar(inquilino));
	}
	
	@GetMapping
	public ResponseEntity<List<ImovelDTO>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(imovelService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ImovelDTO> buscarPorId(@PathVariable final Long id){
		return ResponseEntity.status(HttpStatus.OK).body(imovelService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id){
		imovelService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ImovelDTO> atualizar(@RequestBody final ImovelEntradaDTO inquilino, @PathVariable final Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(imovelService.atualizar(id, inquilino));
	}
}
