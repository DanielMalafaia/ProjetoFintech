package br.com.fiap.projetofintech.entity;

import java.io.Serializable;

public class ProjetoFintech implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int instancia;
	
	public ProjetoFintech (int instancia) {
		super();	
		this.instancia = instancia;
	}
	
	public ProjetoFintech () {};

	public int getInstancia() {
		return instancia;
	}

	public void setInstancia(int instancia) {
		this.instancia = instancia;
	}

	public int getCdInstancia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
