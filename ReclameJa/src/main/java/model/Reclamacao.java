package model;

public class Reclamacao {
	private Long idReclamacao;
	private Long idCliente;
	private String descricao;

	public Reclamacao(Long idReclamacao, Long idCliente, String descricao) {
		super();
		this.idReclamacao = idReclamacao;
		this.idCliente = idCliente;
		this.descricao = descricao;
	}

	public Long getIdReclamacao() {
		return idReclamacao;
	}

	public void setIdReclamacao(Long idReclamacao) {
		this.idReclamacao = idReclamacao;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
