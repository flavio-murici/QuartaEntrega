package com.recodeturismo.QuartaEntrega.servicos;

import java.util.List;

import com.recodeturismo.QuartaEntrega.model.Pacote;

public interface PacoteServicos {

	
	List<Pacote> getAllPacote();
	Pacote getPacoteById(Long id);
	Pacote savePacote(Pacote pacote);
	Pacote updatePacote(Long id,Pacote pacoteAtualizado);
	void deletePacote(Long id);
	
	
	
}
