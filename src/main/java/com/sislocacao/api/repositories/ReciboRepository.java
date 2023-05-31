package com.sislocacao.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.dto.ReciboSaidaDTO;
import com.sislocacao.api.model.entity.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {

//	@Query("SELECT\r\n"
//			+ "    recibo.id,\r\n"
//			+ "    recibo.data_inicio AS dataInicio,\r\n"
//			+ "    recibo.data_fim as dataFim,\r\n"
//			+ "    recibo.numero_recibo as numeroRecibo,\r\n"
//			+ "    recibo.valor_agua as valorAgua,\r\n"
//			+ "    recibo.valor_energia as valorEnergia,\r\n"
//			+ "    recibo.total_juros as totalJuros,\r\n"
//			+ "    recibo.total_recibo as totalRecibo,\r\n"
//			+ "    recibo.total_por_extenso as totalPorExtenso\r\n"
//			+ "FROM\r\n"
//			+ "    recibo\r\n"
//			+ "WHERE\r\n"
//			+ "    recibo.locacao_id = :locacaoId\r\n"
//			+ "    AND recibo.numero_recibo = (\r\n"
//			+ "        SELECT\r\n"
//			+ "            MAX(r.numero_recibo)\r\n"
//			+ "        FROM\r\n"
//			+ "            recibo r\r\n"
//			+ "        WHERE\r\n"
//			+ "            r.locacao_id = :locacaoId\r\n"
//			+ "    )")
//	public Optional<ReciboSaidaDTO> recuperaUltimoReciboPorLocacao(@Param("locacaoId")final Long locacaoId);
}
