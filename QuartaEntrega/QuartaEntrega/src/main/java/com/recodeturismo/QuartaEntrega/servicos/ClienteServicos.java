package com.recodeturismo.QuartaEntrega.servicos;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.recodeturismo.QuartaEntrega.model.Cliente;

public interface ClienteServicos {

	
	List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long id);
		
	Cliente updateCliente(Long id,Cliente clienteAtualizado);
	
	void deleteCliente(Long id);

	Cliente saveCliente(Cliente cliente);

	List<Objects> findAllRels();

	void addRelationship(Long pacoteId, Long clienteId);

	
	
	
}