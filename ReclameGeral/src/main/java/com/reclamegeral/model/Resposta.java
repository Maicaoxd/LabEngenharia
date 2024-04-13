package com.reclamegeral.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String texto;
	private LocalDateTime dataHora;

	@ManyToOne
	@JoinColumn(name = "reclamacao_id")
	private Reclamacao reclamacao;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario autor;

	public Resposta() {
	}

	public Resposta(Long id, String texto, LocalDateTime dataHora, Reclamacao reclamacao, Usuario autor) {
		super();
		this.id = id;
		this.texto = texto;
		this.dataHora = dataHora;
		this.reclamacao = reclamacao;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Reclamacao getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(Reclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", texto=" + texto + ", dataHora=" + dataHora + ", reclamacao="
				+ reclamacao.getId() + ", autor=" + autor.getNome() + "]";
	}

}
