package com.joaoh.betha.repositories;

import com.joaoh.betha.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{

}
