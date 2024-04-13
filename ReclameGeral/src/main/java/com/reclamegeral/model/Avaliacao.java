package com.reclamegeral.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float pontuacao;
	private boolean isResolved;
	private LocalDateTime dtAvaliacao;

	@OneToOne
	@JoinColumn(name = "reclamacao_id")
	private Reclamacao reclamacao;

	public Avaliacao() {
	}

	public Avaliacao(Long id, float pontuacao, boolean isResolved, LocalDateTime dtAvaliacao, Reclamacao reclamacao) {
		super();
		this.id = id;
		this.pontuacao = pontuacao;
		this.isResolved = isResolved;
		this.dtAvaliacao = dtAvaliacao;
		this.reclamacao = reclamacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public LocalDateTime getDtAvaliacao() {
		return dtAvaliacao;
	}

	public void setDtAvaliacao(LocalDateTime dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}

	public Reclamacao getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(Reclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", pontuacao=" + pontuacao + ", isResolved=" + isResolved + ", dtAvaliacao="
				+ dtAvaliacao + ", reclamacao=" + reclamacao.getId() + "]";
	}

}
