package br.com.iba.cidade;


import java.util.List;

import br.com.iba.util.DAOFactory;



public class CidadeRN {

	private CidadeDao cidadeDao;

	public CidadeRN() {
		this.cidadeDao = DAOFactory.criaCidadeDao();
	}

	public void salvar(Cidade e1) {
		this.cidadeDao.salvar(e1);
		
	}

	public List<Cidade> listar() {
		return this.cidadeDao.listar();
	}
	
	public List<Cidade> listarCidadePorEstado(Integer estado) {
		return this.cidadeDao.listarCidadePorEstado(estado);
	}
	

	public void excluir(Cidade cidade) {
		this.cidadeDao.excluir(cidade);
		
	}

	public Cidade pesquisar(String string) {
		return this.cidadeDao.pesquisar(string);
	}

	public void alterar(Cidade cidade) {
	 this.cidadeDao.alterar(cidade);
		
	}	
	
	public Cidade carregar(Integer id) {
		return this.cidadeDao.carregar(id);
	}
	

	}

