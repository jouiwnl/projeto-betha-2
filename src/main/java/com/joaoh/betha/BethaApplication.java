package com.joaoh.betha;

import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.domain.enums.TipoEquipamento;
import com.joaoh.betha.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BethaApplication implements CommandLineRunner {

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BethaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Equipamento e1 = new Equipamento(null, "Celular Samsung", TipoEquipamento.ELETRONICO,"Samsung");
		Equipamento e2 = new Equipamento(null, "LG K10", TipoEquipamento.ELETRONICO,"LG");

		equipamentoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
