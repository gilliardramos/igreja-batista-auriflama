package br.com.iba.estado;

import java.util.List;

import br.com.iba.util.DAOFactory;

public class EstadoRN {

	private EstadoDao estadoDao;

	public EstadoRN() {
		this.estadoDao = DAOFactory.criaEstadoDao();
	}

	public void salvar(Estado e1) {
		this.estadoDao.salvar(e1);
	}

	public List<Estado> listar() {
		return this.estadoDao.listar();
	}

	public void excluir(Estado estado) {
		this.estadoDao.excluir(estado);
	}

	public Estado pesquisar(String string) {
		return this.estadoDao.pesquisar(string);
	}

	public Estado buscarPorId(Integer id) {
		return this.estadoDao.buscarPorId(id);
	}

	public void alterar(Estado estado) {
		this.estadoDao.alterar(estado);
	}

	public Estado carregar(Integer id) {
		return this.estadoDao.carregar(id);
	}
}
