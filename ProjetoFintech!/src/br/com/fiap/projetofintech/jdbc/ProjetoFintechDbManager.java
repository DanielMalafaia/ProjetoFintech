package br.com.fiap.projetofintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjetoFintechDbManager {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection obterConexao() {
        Connection conexao = threadLocal.get();
        if (conexao == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM98112",
                    "fiap23");
                conexao.setAutoCommit(false); // Desativa o autocommit
                threadLocal.set(conexao);
            } catch (Exception e) {
                System.err.println("Erro ao se conectar");
                e.printStackTrace();
            }
        }
        return conexao;
    }

    public static void commitTransacao() {
        Connection conexao = threadLocal.get();
        if (conexao != null) {
            try {
                conexao.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollbackTransacao() {
        Connection conexao = threadLocal.get();
        if (conexao != null) {
            try {
                conexao.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fecharConexao() {
        Connection conexao = threadLocal.get();
        if (conexao != null) {
            try {
                conexao.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}