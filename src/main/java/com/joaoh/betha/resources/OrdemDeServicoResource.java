package com.joaoh.betha.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.dto.OrdemDeServicoDTO;
import com.joaoh.betha.dto.OrdemDeServicoNewDTO;
import com.joaoh.betha.services.OrdemDeServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/ordens")
public class OrdemDeServicoResource {

    @Autowired
    OrdemDeServicoService service;

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrdemDeServicoDTO>> findAll() {
        List<OrdemDeServico> list = service.findAll();
        List<OrdemDeServicoDTO> listDto = list.stream().map(obj -> new OrdemDeServicoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<OrdemDeServico>> findPageOrdens(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
    Page<OrdemDeServico> list = service.findPage(page, linesPerPage, orderBy, direction); 
    return ResponseEntity.ok().body(list);

    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody OrdemDeServicoNewDTO objDto) {
        OrdemDeServico obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    /*
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody OrdemDeServicoNewDTO objDto, @PathVariable Integer id) {
		OrdemDeServicoNewDTO obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
    */

    
    


}
