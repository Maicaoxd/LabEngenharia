package com.reclamegeral.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends Usuario {

	private String nomeFantasia;
	private String sobre;

	@OneToMany(mappedBy = "empresa")
	private Set<Reclamacao> reclamacoes;

	public Empresa() {
	}

	public Empresa(String nomeFantasia, String sobre, Set<Reclamacao> reclamacoes) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.sobre = sobre;
		this.reclamacoes = reclamacoes;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public Set<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(Set<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	@Override
	public String toString() {
		return "Empresa [nomeFantasia=" + nomeFantasia + ", sobre=" + sobre + ", reclamacoes=" + reclamacoes + "]"
				+ "\n" + super.toString();
	}

}
