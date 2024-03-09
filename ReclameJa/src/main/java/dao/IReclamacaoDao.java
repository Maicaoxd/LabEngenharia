package dao;

import java.util.List;

import model.Reclamacao;

public interface IReclamacaoDao {

	public void inserir(Reclamacao reclamacao);

	public void atualizar(long id, Reclamacao reclamacao);

	public void remover(long id);

	public List<Reclamacao> listar();

	public List<Reclamacao> pesquisarCPF(String cpfReclamacao);

	public Reclamacao pesquisarNome(String nomeReclamacao);

}
