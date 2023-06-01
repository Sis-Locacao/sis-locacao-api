package com.sislocacao.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {

	@Query(value = "SELECT * FROM tb_recibos WHERE locacao_id = :locacaoId ORDER BY numero_recibo DESC LIMIT 1", nativeQuery = true)
	Recibo buscarUltimoReciboGerado(@Param("locacaoId") final Long locacaoId);

}
