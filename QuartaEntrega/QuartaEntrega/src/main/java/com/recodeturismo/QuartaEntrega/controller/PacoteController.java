package com.recodeturismo.QuartaEntrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recodeturismo.QuartaEntrega.model.Cliente;
import com.recodeturismo.QuartaEntrega.model.Pacote;
import com.recodeturismo.QuartaEntrega.servicos.PacoteServicos;


@RestController
@RequestMapping("/pacote")
public class PacoteController {

	
	@Autowired 
	private PacoteServicos pacoteServicos; 
	
	
	@GetMapping("/listarPacotes")
	public  List<Pacote> listarpacote() {
	return  pacoteServicos.getAllPacote();
	
	}
	
	@PostMapping("/save")
	public Pacote savePacote ( @RequestBody Pacote pacote) {
		return pacoteServicos.savePacote (pacote);
	}
	
	@PutMapping ("/atualizarpacote/{id}")
	 public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteUpdate) {
		Pacote pacote = pacoteServicos.getPacoteById(id);
		pacote.setNome(pacoteUpdate.getNome());
		pacote.setDescricao(pacoteUpdate.getDescricao());
		pacote.setValor(pacoteUpdate.getValor());
		
		return pacoteServicos.updatePacote(id, pacote);
		
	
	}
	@DeleteMapping ("/deletar/{id}")
	public void deletePacote(@PathVariable Long id) {
		pacoteServicos.deletePacote(id);
		
		
	}
	
}
