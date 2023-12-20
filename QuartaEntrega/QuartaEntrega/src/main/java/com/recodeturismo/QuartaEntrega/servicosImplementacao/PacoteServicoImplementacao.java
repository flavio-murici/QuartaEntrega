	package com.recodeturismo.QuartaEntrega.servicosImplementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recodeturismo.QuartaEntrega.model.Pacote;
import com.recodeturismo.QuartaEntrega.repositories.PacoteRepository;
import com.recodeturismo.QuartaEntrega.servicos.PacoteServicos;

import jakarta.transaction.Transactional;

@Service
public class PacoteServicoImplementacao implements PacoteServicos{
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	@Override
	public List<Pacote> getAllPacote() {
		return pacoteRepository.findAll();
	}

	@Override
	@Transactional
	public Pacote getPacoteById(Long id) {
		
		return pacoteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pacote savePacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	@Override
	public Pacote updatePacote(Long id, Pacote pacoteAtualizado) {
		Pacote pacoteExistente = pacoteRepository.findById(id).orElse(null);
		if (pacoteExistente != null) {
			pacoteExistente.setNome(pacoteAtualizado.getNome());
			pacoteExistente.setDescricao(pacoteAtualizado.getDescricao());
			pacoteExistente.setValor(pacoteAtualizado.getValor());
			
		return pacoteRepository.save(pacoteExistente);
	} else {
		throw new RuntimeException("Pacote com ID" + id + "não encontrado.");
	}
	}

	@Override
	public void deletePacote(Long id) {
		pacoteRepository.deleteById(id);
		
		
	}

}
