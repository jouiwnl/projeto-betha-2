package com.joaoh.betha;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.domain.Estado;
import com.joaoh.betha.domain.enums.TipoEquipamento;
import com.joaoh.betha.repositories.CidadeRepository;
import com.joaoh.betha.repositories.EquipamentoRepository;
import com.joaoh.betha.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BethaApplication implements CommandLineRunner {

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BethaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Equipamento e1 = new Equipamento(null, "Celular Samsung", TipoEquipamento.ELETRONICO,"Samsung");
		Equipamento e2 = new Equipamento(null, "LG K10", TipoEquipamento.ELETRONICO,"LG");

		equipamentoRepository.saveAll(Arrays.asList(e1, e2));

		Estado est1 = new Estado(null, "Santa catarina");
		Estado est2 = new Estado(null, "Minas Gerais");

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cidade cid1 = new Cidade(null, "Criciuma", est1);
		Cidade cid2 = new Cidade(null, "Belo Horizonte", est2);

		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		est1.getCidades().add(cid1);
		est2.getCidades().add(cid2);

	}

}
