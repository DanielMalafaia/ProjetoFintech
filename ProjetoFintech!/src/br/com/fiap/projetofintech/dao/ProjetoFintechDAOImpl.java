package br.com.fiap.projetofintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.projetofintech.entity.ProjetoFintech;
import br.com.fiap.projetofintech.jdbc.ProjetoFintechDbManager;
import br.com.fiap.projetofintech.jdbc.TransacaoManager;

public class ProjetoFintechDAOImpl implements ProjetoFintechDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;	
	
	@Override
	public void gravar(ProjetoFintech projetofintech) {
		Connection conexao = TransacaoManager.iniciarTransacao();
		
		try {
			pstmt = conexao.
	        		prepareStatement("INSERT INTO T_PROJETO_FINTECH " 
	        				          + " (CD_INSTANCIA) " 
	                		          + " VALUES (SEQ_CD_INSTANCIA.NEXTVAL)");
	        pstmt.executeUpdate();
		} catch (SQLException e) {
			TransacaoManager.commitTransacao(conexao);
			e.printStackTrace();
		} finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
		
	@Override
	public List<ProjetoFintech> getAllProjetos() {
			List<ProjetoFintech> projetos = new ArrayList<ProjetoFintech>();
			ResultSet rs = null;
			try {
				conexao = ProjetoFintechDbManager.obterConexao();
				pstmt = conexao.prepareStatement("SELECT * FROM T_PROJETO_FINTECH");
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ProjetoFintech projeto = new ProjetoFintech (rs.getInt("CD_INSTANCIA"));
					projetos.add(projeto);
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					rs.close();
					conexao.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return projetos;
	}
}
