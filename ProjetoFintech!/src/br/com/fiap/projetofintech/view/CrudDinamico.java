package br.com.fiap.projetofintech.view;
  
import java.sql.Connection;

import br.com.fiap.projetofintech.dao.*;
import br.com.fiap.projetofintech.entity.ProjetoFintech;
import br.com.fiap.projetofintech.entity.Usuario;
import br.com.fiap.projetofintech.jdbc.TransacaoManager;

  
public class CrudDinamico {
  
public static void main(String[] args) {
	   	  
		ProjetoFintechDAO pfdao = new ProjetoFintechDAOImpl();
		UsuarioDAO dao = new UsuarioDAOImpl();   		
	    Connection conexao = TransacaoManager.iniciarTransacao();

	    try {
			ProjetoFintech projetofintech = new ProjetoFintech();		
			pfdao.gravar(projetofintech);
			
			int cdInstancia = projetofintech.getCdInstancia();
		
	    	Usuario usuario = new Usuario();
	    	usuario.setNome("Daniel Malafaia");
	    	usuario.setEmail("rm98112@fiap.com.br");
	    	usuario.setSenha("senha123");
	    	usuario.setCdInstancia(cdInstancia);
	    	dao.gravar(usuario);	    	
	    	
	    	Usuario usuario2 = new Usuario();
	    	usuario2.setNome("Daniel Pinheiro");
	    	usuario2.setEmail("rm98113@fiap.com.br");
	    	usuario2.setSenha("senha124");
	    	usuario2.setCdInstancia(cdInstancia);
	    	dao.gravar(usuario2);


	    	Usuario usuario3 = new Usuario();
	    	usuario3.setNome("Bruna Basso");
	    	usuario3.setEmail("rm98123@fiap.com.br");
	    	usuario3.setSenha("senha224");
	    	usuario3.setCdInstancia(cdInstancia);
	    	dao.gravar(usuario3);

	    	Usuario usuario4 = new Usuario();
	    	usuario4.setNome("Gabriel Barbosa");
	    	usuario4.setEmail("rm92113@fiap.com.br");
	    	usuario4.setSenha("senhx124");
	    	usuario4.setCdInstancia(cdInstancia);
	    	dao.gravar(usuario4);
	    	
	    	Usuario usuario5 = new Usuario();
	    	usuario5.setNome("Arthur Oliveira");
	    	usuario5.setEmail("dm98113@fiap.com.br");
	    	usuario5.setSenha("penha124");
	    	usuario5.setCdInstancia(cdInstancia);
	    	dao.gravar(usuario5);
	
	    	System.out.println("Os usuarios foram gravados");
	    	System.out.println(" ");
		} catch (Exception e) {
	        TransacaoManager.rollbackTransacao(conexao);
	        e.printStackTrace();
		} finally {
	        TransacaoManager.fecharConexao();
	}
    	dao.getAll();
  }
}
