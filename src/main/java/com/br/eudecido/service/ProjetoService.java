package com.br.eudecido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Comentario;
import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.repository.ComentarioRepository;
import com.br.eudecido.repository.ProjetoRepository;
import com.br.eudecido.repository.ReacaoRepository;

@Service
public class ProjetoService {

	private String sucesso = "secesso";
	private String erro = "erro";

	@Autowired
	private ProjetoRepository repositoryProjeto;

	@Autowired
	private ReacaoRepository repositoryReacao;

	@Autowired
	private ComentarioRepository repositoryComentario;

	// Parte Projeto

	public String salvar(Projeto projeto) {
		repositoryProjeto.save(projeto);
		return sucesso;
	}

	public String excluir(Integer id) {
		Projeto projeto = repositoryProjeto.findById(id);
		if (projeto != null) {
			repositoryProjeto.delete(id);
			return sucesso;
		}
		return erro;
	}

	public List<Projeto> listar() {
		return repositoryProjeto.findAll();
	}

	public List<Projeto> listarPorUsuario(Politico politico) {
		return repositoryProjeto.findByPolitico(politico);
	}

	public List<Projeto> listarPorNome(String nome) {
		return repositoryProjeto.findByNomeContainingIgnoreCase(nome);
	}

	public Projeto buscarPorId(Integer id) {
		Projeto projeto = repositoryProjeto.findById(id);
		if (projeto != null) {
			return projeto;
		}
		return null;
	}

	public Projeto buscarPorIdNotLazy(Integer id) {
		Projeto projeto = repositoryProjeto.findByIdNotLazy(id);
		if (projeto != null) {
			return projeto;
		}
		return null;
	}

	// Parte Reacao

	public String salvarReacao(Reacao reacao) {
		repositoryReacao.save(reacao);
		return sucesso;
	}

	public String excluirReacao(Integer id) {
		Reacao reacao = repositoryReacao.findById(id);
		if (reacao != null) {
			repositoryReacao.delete(id);
			return sucesso;
		}
		return erro;
	}

	// Parte Comentario

	public String salvarComentario(Comentario comentario) {
		repositoryComentario.save(comentario);
		return sucesso;
	}

	public String excluirComentario(Integer id) {
		Comentario comentario = repositoryComentario.findById(id);
		if (comentario != null) {
			repositoryComentario.delete(id);
			return sucesso;
		}
		return erro;
	}
}
