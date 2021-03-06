package com.joaoh.betha;

import com.joaoh.betha.domain.*;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
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
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private OrdemDeServicoRepository ordemDeServicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BethaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//
		Estado est1 = new Estado(null, "Santa catarina");
		Estado est2 = new Estado(null, "Minas Gerais");
		Estado est3 = new Estado(null, "São Paulo");
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
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
		Cliente cli2 = new Cliente(null,"Tauan","123456789","tauan@gmail.com");
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		//
		//
		Endereco end1 = new Endereco(null,"Rua 1","13","Casa Azul","Santa Augusta","88805412",cid1, cli1);
		Endereco end2 = new Endereco(null,"Rua 2","1231","Casa Amarela","Pinheirinho","88805412",cid1, cli2);
		enderecoRepository.saveAll(Arrays.asList(end1));
		cli1.getEnderecos().add(end1);
		cli2.getEnderecos().add(end2);
		//
		//
		OrdemDeServico os1 = new OrdemDeServico(null, System.currentTimeMillis(), cli1, "Estragou o pc", EstadoAtendimento.ABERTA, "Computador DELL", "DELL", TipoEquipamento.ELETRONICO);
		OrdemDeServico os2 = new OrdemDeServico(null, System.currentTimeMillis(), cli2, "Quebrou retrovisor", EstadoAtendimento.CONLUIDA, "Corsa", "Chrevolet", TipoEquipamento.AUTOMOTIVO);
		ordemDeServicoRepository.saveAll(Arrays.asList(os1, os2));
		cli1.getOrdensDeServico().addAll(Arrays.asList(os1));
		cli2.getOrdensDeServico().addAll(Arrays.asList(os2));
		//
		//

	}

}
