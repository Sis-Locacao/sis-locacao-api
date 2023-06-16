package com.sislocacao.api.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {

	@Query(value = "SELECT * FROM tb_recibos WHERE locacao_id = :locacaoId ORDER BY numero_recibo DESC LIMIT 1", nativeQuery = true)
	Recibo buscarUltimoReciboGerado(@Param("locacaoId") final Long locacaoId);

	@Query(value = "SELECT * FROM tb_recibos r WHERE r.usuario_id = :usuarioId AND r.locacao_id = :locacaoId", nativeQuery = true)
	Page<Recibo> findByUsuarioAndLocacao(@Param("usuarioId") Long usuarioId, @Param("locacaoId") Long locacaoId, Pageable pageRequest);
	
	@Query(value = "SELECT * FROM tb_recibos r WHERE r.id = :id AND r.locacao_id = :locacaoId", nativeQuery = true)
	Optional<Recibo> buscarReciboPorIdELocacao(@Param("id") Long reciboId, @Param("locacaoId") Long locacaoId);
}
