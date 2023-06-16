package com.sislocacao.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sislocacao.api.exceptions.impl.AuthorizationException;
import com.sislocacao.api.exceptions.impl.DataIntegrityViolationException;
import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.mappers.EnderecoMapper;
import com.sislocacao.api.mappers.UsuarioMapper;
import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;
import com.sislocacao.api.model.entity.Endereco;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.repositories.EnderecoRepository;
import com.sislocacao.api.repositories.UsuarioRepository;
import com.sislocacao.api.security.UserSS;
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

//		validaUsuario(usuarioEntradaDTO);

		usuarioEntradaDTO.getEnderecos().forEach(endereco -> {
			Endereco enderecoEntidade = enderecoMapper.enderecoDtoParaEnderecoEntidade(endereco);
			enderecos.add(enderecoEntidade);
		});

		Usuario usuario = usuarioMapper.usuarioDtoParaUsuarioEntidade(usuarioEntradaDTO, enderecos);

		return usuarioMapper.usuarioEntidadeParaUsuarioSaida(usuarioRepository.save(usuario));
	}

	private void validaUsuario(UsuarioEntradaDTO usuarioEntradaDTO) {
		// verifica se existe um usuario com o rg
		Optional<Usuario> usuarioRg = usuarioRepository.findByRg(usuarioEntradaDTO.getRg());

		if (usuarioRg.isPresent()) {
			throw new DataIntegrityViolationException("Já existe um usuário cadastrado com esse RG");
		}

		// verifica se existe um usuario com o cpf
		Optional<Usuario> findByCpf = usuarioRepository.findByCpf(usuarioEntradaDTO.getCpf());

		if (findByCpf.isPresent()) {
			throw new DataIntegrityViolationException("Já existe um usuário cadastrado com esse CPF");
		}

		// verifica se existe um usuario com o email
		Optional<Usuario> findByEmail = usuarioRepository.findByEmail(usuarioEntradaDTO.getEmail());

		if (findByEmail.isPresent()) {
			throw new DataIntegrityViolationException("Já existe um usuário cadastrado com esse e-mail");
		}
	}

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Usuario validaUsuarioAutenticado() {
		// valida usuário autenticado
		UserSS user = authenticated();

		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		return usuarioRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

	}
}
