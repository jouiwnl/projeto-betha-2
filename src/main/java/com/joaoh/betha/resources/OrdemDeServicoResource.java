package com.joaoh.betha.resources;

import com.joaoh.betha.services.OrdemDeServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ordens")
public class OrdemDeServicoResource {

    @Autowired
    OrdemDeServicoService service;
}
