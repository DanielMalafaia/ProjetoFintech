package br.com.fiap.projetofintech.entity;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int usuario;
	private int instancia;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario (int usuario, int instancia, String nome, String email, String senha) {
		super();
		this.usuario = usuario;
		this.instancia = instancia;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {};
	
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getInstancia() {
		return instancia;
	}
	public void setInstancia(int instancia) {
		this.instancia = instancia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCdInstancia(int cdInstancia) {
		// TODO Auto-generated method stub	
	}

}
