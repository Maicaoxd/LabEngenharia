package com.reclamegeral.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@OneToMany(mappedBy = "categoria")
	private Set<Reclamacao> reclamacoes;

	public Categoria() {
	}

	public Categoria(Long id, String nome, Set<Reclamacao> reclamacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.reclamacoes = reclamacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(Set<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", reclamacoes=" + reclamacoes + "]";
	}

}
