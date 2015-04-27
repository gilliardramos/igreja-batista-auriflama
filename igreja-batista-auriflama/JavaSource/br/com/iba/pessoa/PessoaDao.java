package br.com.iba.pessoa;

import java.util.List;

public interface PessoaDao {

	public void salvar(Pessoa pessoa);

	public void alterar(Pessoa pessoa);

	public void excluir(Pessoa pessoa);

	public Pessoa carregar(Integer id_pessoa);

	public Pessoa buscarPorEmail(String email);

	public List<Pessoa> listar();

}
