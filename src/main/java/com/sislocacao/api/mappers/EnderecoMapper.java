package com.sislocacao.api.mappers;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.EnderecoDTO;
import com.sislocacao.api.model.entity.Endereco;

@Component
public class EnderecoMapper {

	public Endereco enderecoDtoParaEnderecoEntidade(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		
		endereco.setId(enderecoDTO.getId());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());
		
		return endereco;
	}
	
	public EnderecoDTO enderecoEntidadeParaEnderecoSaida(Endereco endereco) {
		EnderecoDTO enderecoSaida = new EnderecoDTO();
		
		enderecoSaida.setId(endereco.getId());
		enderecoSaida.setCep(endereco.getCep());
		enderecoSaida.setCidade(endereco.getCidade());
		enderecoSaida.setEstado(endereco.getEstado());
		enderecoSaida.setNumero(endereco.getNumero());
		enderecoSaida.setRua(endereco.getRua());
		
		return enderecoSaida;
	}
}
