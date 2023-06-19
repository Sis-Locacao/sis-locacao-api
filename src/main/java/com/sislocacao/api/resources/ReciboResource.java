package com.sislocacao.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<ReciboSaidaDTO> salvaRecibo(@RequestBody ReciboEntradaDTO reciboEntradaDTO) {
		return ResponseEntity.ok(reciboService.salvarRecibo(reciboEntradaDTO));
	}

	@GetMapping("/locacao/{locacaoId}")
	public ResponseEntity<Page<ReciboSaidaDTO>> findPage(@PathVariable Long locacaoId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage) {
		Page<ReciboSaidaDTO> list = reciboService.listarRecibos(locacaoId, page, linesPerPage);
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/{reciboId}")
	public ResponseEntity<ReciboSaidaDTO> atualizarRecibo(@PathVariable Long reciboId, @RequestBody ReciboEntradaDTO reciboEntradaDTO) {
		reciboEntradaDTO.setId(reciboId);
		ReciboSaidaDTO recibo = reciboService.atualizarRecibo(reciboEntradaDTO);
		return ResponseEntity.ok().body(recibo);
	}
}
