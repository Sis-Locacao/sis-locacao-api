package com.sislocacao.api.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.EnderecoDTO;
import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;
import com.sislocacao.api.model.entity.Endereco;
import com.sislocacao.api.model.entity.Usuario;

@Component
public class UsuarioMapper {
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	
	public Usuario usuarioDtoParaUsuarioEntidade(UsuarioEntradaDTO usuarioEntradaDTO, List<Endereco> enderecos) {
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioEntradaDTO.getId());
		usuario.setNome(usuarioEntradaDTO.getNome());
		usuario.setCpf(usuarioEntradaDTO.getCpf());
		usuario.setEmail(usuarioEntradaDTO.getEmail());
		usuario.setNacionalidade(usuarioEntradaDTO.getNacionalidade());
		usuario.setRg(usuarioEntradaDTO.getRg());
		usuario.setEmail(usuarioEntradaDTO.getEmail());
		usuario.setSenha(usuarioEntradaDTO.getSenha());
		
		usuario.getEnderecos().clear();
		
		usuario.setEnderecos(enderecos);
		
		return usuario;
	}
	
	public UsuarioSaidaDTO usuarioEntidadeParaUsuarioSaida(Usuario usuario) {
		UsuarioSaidaDTO usuarioSaida = new UsuarioSaidaDTO();
		
		usuarioSaida.setId(usuario.getId());
		usuarioSaida.setNacionalidade(usuarioSaida.getNacionalidade());
		usuarioSaida.setNome(usuario.getNome());
		
		List<EnderecoDTO> enderecos = new ArrayList<>();
		
		usuario.getEnderecos().forEach(endereco->{
			EnderecoDTO end = enderecoMapper.enderecoEntidadeParaEnderecoSaida(endereco);
			enderecos.add(end);
		});
		
		usuarioSaida.setEnderecos(enderecos);
		
		return usuarioSaida;
	}
}
