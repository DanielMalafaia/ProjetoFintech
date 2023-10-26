package br.com.fiap.projetofintech.dao;

import java.util.List;

import br.com.fiap.projetofintech.entity.Usuario;

public interface UsuarioDAO {
	
	void gravar(Usuario usuario);
	
	List<Usuario> getAll();

}
