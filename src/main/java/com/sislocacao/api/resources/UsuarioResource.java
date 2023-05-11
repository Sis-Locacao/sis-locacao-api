package com.sislocacao.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;
import com.sislocacao.api.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioSaidaDTO> salvar(@RequestBody final UsuarioEntradaDTO usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<UsuarioSaidaDTO> atualizar(@RequestBody final UsuarioEntradaDTO usuario, @PathVariable final Long usuarioId){
		usuario.setId(usuarioId);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
	}
}
