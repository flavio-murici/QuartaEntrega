package com.recodeturismo.QuartaEntrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.recodeturismo.QuartaEntrega.servicos.ClienteServicos;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired 
	private ClienteServicos clienteServicos; 
	
	
	@GetMapping("/listarClientes")
	public  List<Cliente> listarclientes() {
	return  clienteServicos.getAllCliente();
	
	}

	
	@PostMapping("/save")
	public Cliente saveCliente (@RequestBody Cliente cliente) {
		return clienteServicos.saveCliente (cliente);
		
	}

	@PutMapping("/atualizar/{id}")
	 public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUpdate) {
		Cliente cliente = clienteServicos.getClienteById(id);
		cliente.setNome(clienteUpdate.getNome());
		cliente.setTelefone(clienteUpdate.getTelefone());
		cliente.setCpf(clienteUpdate.getCpf());
		cliente.setEmail(clienteUpdate.getEmail());
		
		return clienteServicos.updateCliente(id, cliente);
	
	}
	@DeleteMapping ("/deletar/{id}")
	public String deleteCliente(@PathVariable Long id) {
		clienteServicos.deleteCliente(id);
		return "redirect:/cliente";
		
		
	}
	
}
