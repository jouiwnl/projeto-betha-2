package com.joaoh.betha.resources;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.services.ClienteService;
import com.joaoh.betha.services.OrdemDeServicoService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService service;

    @Autowired
    OrdemDeServicoService ordemService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find (@PathVariable Integer id) {
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/ordensDeServico", method=RequestMethod.GET)
    public ResponseEntity<List<OrdemDeServico>> findAllOrdemServico() {
        List<OrdemDeServico> obj = ordemService.findAll();
        return ResponseEntity.ok().body(obj);
    }
    


}