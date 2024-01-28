package com.sislocacao.api.mappers;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.ImovelDTO;
import com.sislocacao.api.model.dto.ImovelEntradaDTO;
import com.sislocacao.api.model.entity.Imovel;
import com.sislocacao.api.model.entity.Usuario;

@Component
public class ImovelMapper {
	
	private final EnderecoMapper enderecoMapper;
	
	public ImovelMapper(final EnderecoMapper enderecoMapper) {
		this.enderecoMapper = enderecoMapper;
	}
	
	public ImovelDTO imovelEntidadeParaImovelDto(Imovel imovel) {
		ImovelDTO dto = new ImovelDTO();
		dto.setApelido(imovel.getApelido());
		dto.setDescricao(imovel.getDescricao());
		dto.setId(imovel.getId());
		dto.setValor(imovel.getValor());
		
		return dto;
	}

	public Imovel imovelDtoParaImovelEntidade(ImovelEntradaDTO imovelEntradaDTO, Usuario usuario) {
		Imovel imovel = new Imovel();
		
		if(imovelEntradaDTO.getId() != null) {
			imovel.setId(imovelEntradaDTO.getId());
		}
		
		imovel.setApelido(imovelEntradaDTO.getApelido());
		imovel.setDescricao(imovelEntradaDTO.getDescricao());
		imovel.setEndereco(enderecoMapper.enderecoDtoParaEnderecoEntidade(imovelEntradaDTO.getEndereco()));
		imovel.setGaragem(imovelEntradaDTO.getGaragem());
		imovel.setValor(imovelEntradaDTO.getValor());
		imovel.setUsuario(usuario);
		
		return imovel;
	}
}
