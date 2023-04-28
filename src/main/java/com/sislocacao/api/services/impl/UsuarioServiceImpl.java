package com.sislocacao.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sislocacao.api.mappers.EnderecoMapper;
import com.sislocacao.api.mappers.UsuarioMapper;
import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;
import com.sislocacao.api.model.entity.Endereco;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.respository.EnderecoRepository;
import com.sislocacao.api.respository.UsuarioRepository;
import com.sislocacao.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	UsuarioMapper usuarioMapper;
	
	@Autowired
	EnderecoMapper enderecoMapper;
	
	@Override
	@Transactional
	public UsuarioSaidaDTO salvar(UsuarioEntradaDTO usuarioEntradaDTO) {
		List<Endereco> enderecos = new ArrayList<>();
		
		usuarioEntradaDTO.getEnderecos().forEach(endereco -> {
			Endereco enderecoEntidade = enderecoMapper.enderecoDtoParaEnderecoEntidade(endereco);
			enderecos.add(enderecoEntidade);
		});
		
		Usuario usuario = usuarioMapper.usuarioDtoParaUsuarioEntidade(usuarioEntradaDTO, enderecos);

		return usuarioMapper.usuarioEntidadeParaUsuarioSaida(usuarioRepository.save(usuario));
	}

}
