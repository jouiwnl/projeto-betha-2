package com.joaoh.betha;

import com.joaoh.betha.domain.*;
import com.joaoh.betha.domain.enums.TipoEquipamento;
import com.joaoh.betha.repositories.*;
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

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BethaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//
		Estado est1 = new Estado(null, "Santa catarina");
		Estado est2 = new Estado(null, "Minas Gerais");
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		//
		//
		Cidade cid1 = new Cidade(null, "Criciuma", est1);
		Cidade cid2 = new Cidade(null, "Belo Horizonte", est2);
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		est1.getCidades().add(cid1);
		est2.getCidades().add(cid2);
		//
		//
		Cliente cli1 = new Cliente(null,"João Henrique","988457865","jou.098olo@gmail.com");
		clienteRepository.saveAll(Arrays.asList(cli1));
		//
		//
		Equipamento e1 = new Equipamento(null, "Celular Samsung", TipoEquipamento.ELETRONICO,"Samsung", cli1);
		Equipamento e2 = new Equipamento(null, "LG K10", TipoEquipamento.ELETRONICO,"LG", cli1);
		equipamentoRepository.saveAll(Arrays.asList(e1, e2));
		cli1.getEquipamentos().addAll(Arrays.asList(e1, e2));
		//
		//
		Endereco end1 = new Endereco(null,"Rua 1","13","Casa Azul","Santa Augusta","88805412",cid1, cli1);
		enderecoRepository.saveAll(Arrays.asList(end1));
		cli1.getEnderecos().add(end1);


	}

}
