package com.reclamegeral.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.RespostaDAO;
import com.reclamegeral.model.Reclamacao;
import com.reclamegeral.model.Resposta;
import com.reclamegeral.model.Usuario;

public class RespostaController {
	private RespostaDAO respostaDao = new RespostaDAO();

	public void inserirResposta(Resposta resposta) {
		respostaDao.salvar(resposta);
	}

	public List<Resposta> pesquisarTodos() {
		return respostaDao.listarTodos();
	}

	public Resposta pesquisarUmResposta(Long id) {
		return respostaDao.buscarPorId(id);
	}

	public void apagar(Resposta resposta) {
		respostaDao.remover(resposta);
	}

	public void atualizar(Resposta resposta) {
		respostaDao.atualizar(resposta);
	}

	public void exibirRespostas(List<Resposta> respostas) {
		StringBuilder sb = new StringBuilder();
		for (Resposta resposta : respostas) {
			sb.append(resposta.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Respostas:\n" + sb.toString(), "Respostas",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Resposta obterDadosResposta() {
		String texto = JOptionPane.showInputDialog(null, "Digite o texto da resposta:");
		LocalDateTime dataHora = LocalDateTime.now();

		try {
			Long idReclamacao = Long.parseLong(
					JOptionPane.showInputDialog(null, "Digite o ID da reclamação correspondente à resposta:"));
			ReclamacaoController reclamacaoController = new ReclamacaoController();
			Reclamacao reclamacao = reclamacaoController.pesquisarUmReclamacao(idReclamacao); // Obter a reclamação
																								// correspondente ao ID

			Long idAutor = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID do usuário autor da resposta:"));
			UsuarioController usuarioController = new UsuarioController();
			Usuario autor = usuarioController.pesquisarUmUsuario(idAutor); // Obter o usuário autor correspondente ao ID

			// Validar se os objetos foram encontrados
			if (reclamacao == null) {
				throw new IllegalArgumentException("Reclamação com o ID fornecido não encontrada.");
			}
			if (autor == null) {
				throw new IllegalArgumentException("Autor com o ID fornecido não encontrado.");
			}

			Resposta resposta = new Resposta();
			resposta.setTexto(texto);
			resposta.setDataHora(dataHora);
			resposta.setReclamacao(reclamacao);
			resposta.setAutor(autor);
			
			reclamacao.setHasReply(true);
			reclamacaoController.atualizar(reclamacao);
			
			return resposta;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID inválido. Certifique-se de digitar um número válido.");
			return null; // Retorna null em caso de erro
		}
	}

	public Resposta atualizarDadosResposta(Resposta respostaParaAtualizar, Resposta dadosAtualizados) {
		respostaParaAtualizar.setTexto(dadosAtualizados.getTexto());
		respostaParaAtualizar.setDataHora(dadosAtualizados.getDataHora());
		respostaParaAtualizar.setReclamacao(dadosAtualizados.getReclamacao());
		respostaParaAtualizar.setAutor(dadosAtualizados.getAutor());

		return respostaParaAtualizar;
	}

}
