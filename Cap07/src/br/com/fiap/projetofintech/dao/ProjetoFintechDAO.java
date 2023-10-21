package br.com.fiap.projetofintech.dao;

import java.util.List;

import br.com.fiap.projetofintech.entity.ProjetoFintech;

public interface ProjetoFintechDAO {
	
	void gravar(ProjetoFintech projetofintech);
	
	List<ProjetoFintech> getAllProjetos();

}