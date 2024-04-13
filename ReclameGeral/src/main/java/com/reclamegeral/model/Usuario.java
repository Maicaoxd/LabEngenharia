package com.reclamegeral.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cpfCnpj;
	private LocalDate nascimento;
	private String nome;
	private String estado;
	private String cidade;
	private String telefone;
	private String email;
	private String senha;

	public Usuario() {
	}

	public Usuario(Long id, Long cpfCnpj, LocalDate nascimento, String nome, String estado, String cidade,
			String telefone, String email, String senha) {
		super();
		this.id = id;
		this.cpfCnpj = cpfCnpj;
		this.nascimento = nascimento;
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cpfCnpj=" + cpfCnpj + ", nascimento=" + nascimento + ", nome=" + nome
				+ ", estado=" + estado + ", cidade=" + cidade + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + "]";
	}

}
