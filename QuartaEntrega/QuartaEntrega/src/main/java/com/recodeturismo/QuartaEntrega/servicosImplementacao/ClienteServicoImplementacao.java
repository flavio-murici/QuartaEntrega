package com.recodeturismo.QuartaEntrega.servicosImplementacao;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recodeturismo.QuartaEntrega.model.Cliente;
import com.recodeturismo.QuartaEntrega.model.Pacote;
import com.recodeturismo.QuartaEntrega.repositories.ClienteRepository;
import com.recodeturismo.QuartaEntrega.repositories.PacoteRepository;
import com.recodeturismo.QuartaEntrega.servicos.ClienteServicos;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicoImplementacao implements ClienteServicos{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente getClienteById(Long id) {
		
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
 
	}

	@Override
	public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		if (clienteExistente != null) {
			clienteExistente.setNome(clienteAtualizado.getNome());
			clienteExistente.setTelefone(clienteAtualizado.getTelefone());
			clienteExistente.setEmail(clienteAtualizado.getEmail());
			clienteExistente.setCpf(clienteAtualizado.getCpf());
			
		
		return clienteRepository.save(clienteExistente);
	} else {
		throw new RuntimeException("Cliente com ID" + id + "não encontrado.");
	}
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
		
		
	}

	

	@Override
	public void addRelationship(Long pacoteId, Long clienteId) {
		Cliente cliente  = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("ID: " + clienteId + "Not Found"));;
		Pacote pacote = pacoteRepository.findById(pacoteId).orElseThrow(() -> new RuntimeException("ID: " + pacoteId + "Not Found"));;
		if(pacote != null && cliente != null) {
            pacote.getClientes().add(pacote);
            cliente.getPacotes().add(cliente);//aqui está com erro ainda não identifiquei.

            pacoteRepository.save(pacote);
            clienteRepository.save(cliente);
		}
	}

	@Override
	public List<Objects> findAllRels() {
		
		return null;
	}

}
