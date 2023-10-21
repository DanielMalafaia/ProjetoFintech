package br.com.fiap.projetofintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.fiap.projetofintech.entity.Usuario;
import br.com.fiap.projetofintech.jdbc.ProjetoFintechDbManager;
import br.com.fiap.projetofintech.jdbc.TransacaoManager;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void gravar(Usuario usuario) {
		Connection conexao = TransacaoManager.iniciarTransacao();
		
		try {			
			pstmt = conexao.
	        		prepareStatement("INSERT INTO T_USUARIO " 
	        				          + " (CD_USUARIO, CD_INSTANCIA, NM_NOME, TX_EMAIL, TX_SENHA) " 
	                		          + " VALUES (SEQ_CD_USUARIO.NEXTVAL,  (SELECT MAX(CD_INSTANCIA) FROM T_PROJETO_FINTECH), ?, ?, ?)");
	        pstmt.setString(1, usuario.getNome());
	        pstmt.setString(2, usuario.getEmail());
	        pstmt.setString(3, usuario.getSenha());
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
	public List<Usuario> getAll() {
			// Cria uma lista de Usuarios
			List<Usuario> usuarios = new ArrayList<Usuario>();
			ResultSet rs = null;
			try {
				conexao = ProjetoFintechDbManager.obterConexao();
				pstmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
				rs = pstmt.executeQuery();
				
				//Percorre todos os registros encontrados
				while (rs.next()) {
					
					java.sql.Date data = rs.getDate("DT_VALIDADE");
					Calendar dtValidade = Calendar.getInstance();
					dtValidade.setTimeInMillis(data.getTime());
					//Cria um objeto Usuario com as informações encontradas
					Usuario usuario = new Usuario (rs.getInt("CD_USUARIO"), rs.getInt("CD_INSTANCIA"), rs.getString("TX_NOME"), rs.getString("TX_EMAIL"), rs.getString("TX_SENHA"));
					usuarios.add(usuario);
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
			return usuarios;
	}
}