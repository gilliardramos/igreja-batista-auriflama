package br.com.iba.pessoa;

import java.util.List;
import br.com.iba.util.DAOFactory;

public class PessoaRN {

	private PessoaDao pessoaDao;

	public PessoaRN() {
		this.pessoaDao = DAOFactory.criaPessoaDao();
	}

	public void salvar(Pessoa pessoa) {
		Integer id_pessoa = pessoa.getId_pessoa();
		if (id_pessoa == null || id_pessoa == 0) {
			pessoa.getPermissao().add("ROLE_USUARIO");
			this.pessoaDao.salvar(pessoa);

		} else {
			this.pessoaDao.alterar(pessoa);
		}

	}

	public void alterar(Pessoa pessoa) {
		this.pessoaDao.alterar(pessoa);

	}

	public void excluir(Pessoa pessoa) {
		this.pessoaDao.excluir(pessoa);

	}

	public Pessoa carregar(Integer id_pessoa) {
		return this.pessoaDao.carregar(id_pessoa);
	}

	public Pessoa buscarPorEmail(String email) {
		return this.pessoaDao.buscarPorEmail(email);
	}

	public List<Pessoa> listar() {
		return this.pessoaDao.listar();
	}

}
