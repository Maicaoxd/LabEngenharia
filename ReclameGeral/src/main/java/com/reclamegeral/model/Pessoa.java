package com.reclamegeral.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa extends Usuario {

	private String genero;
	private boolean isBlackList;

	@OneToMany(mappedBy = "pessoa")
	private Set<Reclamacao> reclamacoes;

	public Pessoa() {
	}

	public Pessoa(String genero, boolean isBlackList, Set<Reclamacao> reclamacoes) {
		super();
		this.genero = genero;
		this.isBlackList = isBlackList;
		this.reclamacoes = reclamacoes;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isBlackList() {
		return isBlackList;
	}

	public void setBlackList(boolean isBlackList) {
		this.isBlackList = isBlackList;
	}

	public Set<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(Set<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	@Override
	public String toString() {
		return "Pessoa [genero=" + genero + ", isBlackList=" + isBlackList + ", reclamacoes=" + reclamacoes + "]" + "\n"
				+ super.toString();
	}

}
