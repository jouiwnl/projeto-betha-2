package com.joaoh.betha.resources;

import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.services.EquipametoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoResource {

    @Autowired
    EquipametoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Equipamento>> findAll() {
        List<Equipamento> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Equipamento> find (@PathVariable Integer id) {
        Equipamento obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
