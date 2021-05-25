package com.joaoh.betha.repositories;


import java.util.List;

import com.joaoh.betha.domain.OrdemDeServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Integer>{

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Query("SELECT obj FROM OrdemDeServico obj WHERE obj.cliente.id = :clienteId ORDER BY obj.id")
	public List<OrdemDeServico> findOrdens(@Param("clienteId") Integer cliente_id);
}
