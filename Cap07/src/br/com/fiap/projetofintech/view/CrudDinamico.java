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
	    
	    // esse crud dinamico vai popular as tabelas T_PROJETO_FINTECH e T_USUARIO, que foram recem criadas, estão vazias. cd_instancia é chave estrangeira entre as tabelas, por isso nao pode ter 2 usuarios com mesmo cd_instancia
	    // preciso que esse crud dinamico chame a função getAll e retorne todos os usuarios
	    // preciso corrigir o motivo de todos os usuarios estarem sendo estanciados com mesmo cd_instancia

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
	    	
	    	TransacaoManager.commitTransacao(conexao);
	
	    	System.out.println("O usuario foi gravado");
		} catch (Exception e) {
	        // Em caso de erro, fazer rollback e tratar a exceção
	        TransacaoManager.rollbackTransacao(conexao);
	        e.printStackTrace();
		} finally {
	        // Fechar a conexão
	        TransacaoManager.fecharConexao();
	}
  }
}
