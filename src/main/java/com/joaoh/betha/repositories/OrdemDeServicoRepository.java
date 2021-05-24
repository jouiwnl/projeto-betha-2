package com.joaoh.betha.repositories;


import com.joaoh.betha.domain.OrdemDeServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Integer>{

}
