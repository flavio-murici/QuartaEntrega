package com.recodeturismo.QuartaEntrega.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recodeturismo.QuartaEntrega.ClientePacoteDTO.ClientePacoteDTO;
import com.recodeturismo.QuartaEntrega.servicos.ClienteServicos;

@RestController
@RequestMapping("/clientepacote")
public class ClientePacoteController {
	
private ClienteServicos cs;	

@PostMapping("/addclientepacote")
	public ResponseEntity<String> addRelationship(@RequestBody ClientePacoteDTO cpDTO){
	
	cs.addRelationship (cpDTO.getPacoteId(), cpDTO.getClienteId());
	
	return new ResponseEntity<>("Relationship criate", HttpStatus.CREATED);
	
	
	
	
}

	@GetMapping("/findallrels")
	public List <Objects> getAllRels(){
		return cs.findAllRels();
		
	}
	
	
	
	
	
	
}
