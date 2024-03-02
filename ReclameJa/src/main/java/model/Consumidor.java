package model;

import java.time.LocalDateTime;

public class Consumidor {
	private int idConsumidor;
	private String CPF;
	private String nome;
	private LocalDateTime dataNascimento;
	private String estado;
	private String cidade;
	private boolean genero;
	private String contato;
	private String email;
	private String senha;

	public Consumidor(int idConsumidor, String cPF, String nome, LocalDateTime dataNascimento, String estado,
			String cidade, boolean genero, String contato, String email, String senha) {
		super();
		this.idConsumidor = idConsumidor;
		CPF = cPF;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.estado = estado;
		this.cidade = cidade;
		this.genero = genero;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
	}

	public int getIdConsumidor() {
		return idConsumidor;
	}

	public void setIdConsumidor(int idConsumidor) {
		this.idConsumidor = idConsumidor;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

}
