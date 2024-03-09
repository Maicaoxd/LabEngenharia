package model;

public class Consumidor {
	private Long idConsumidor;
	private Long CPF;
	private String nome;

	public Consumidor(Long idConsumidor, Long cpf, String nome) {
		super();
		this.idConsumidor = idConsumidor;
		CPF = cpf;
		this.nome = nome;
	}

	public Long getIdConsumidor() {
		return idConsumidor;
	}

	public void setIdConsumidor(Long idConsumidor) {
		this.idConsumidor = idConsumidor;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
