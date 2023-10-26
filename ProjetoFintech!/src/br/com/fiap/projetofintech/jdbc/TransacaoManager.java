package br.com.fiap.projetofintech.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TransacaoManager {
    public static Connection iniciarTransacao() {
        Connection conexao = ProjetoFintechDbManager.obterConexao();
        try {
            conexao.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public static void commitTransacao(Connection conexao) {
        try {
            conexao.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackTransacao(Connection conexao) {
        try {
            conexao.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void fecharConexao() {
		// TODO Auto-generated method stub
		
	}
}