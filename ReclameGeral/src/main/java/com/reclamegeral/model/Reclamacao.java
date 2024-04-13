package com.reclamegeral.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reclamacao")
public class Reclamacao {

	private String texto;
	private LocalDateTime dataHora;
	private boolean hasReply;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@ManyToOne
	private Categoria categoria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reclamacao")
	private Set<Resposta> respostas;

	public Reclamacao() {
	}

	public Reclamacao(String texto, LocalDateTime dataHora, boolean hasReply, Long id, Pessoa pessoa, Empresa empresa,
			Categoria categoria, Set<Resposta> respostas) {
		super();
		this.texto = texto;
		this.dataHora = dataHora;
		this.hasReply = hasReply;
		this.id = id;
		this.pessoa = pessoa;
		this.empresa = empresa;
		this.categoria = categoria;
		this.respostas = respostas;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isHasReply() {
		return hasReply;
	}

	public void setHasReply(boolean hasReply) {
		this.hasReply = hasReply;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}

	@Override
	public String toString() {
		return "Reclamacao [texto=" + texto + ", dataHora=" + dataHora + ", hasReply=" + hasReply + ", id=" + id
				+ ", pessoa=" + pessoa.getNome() + ", empresa=" + empresa.getNomeFantasia() + ", categoria=" + categoria.getNome() + ", respostas="
				+ respostas + "]";
	}

}
