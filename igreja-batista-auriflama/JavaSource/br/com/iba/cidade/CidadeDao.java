package br.com.iba.cidade;

import java.util.List;

public interface CidadeDao {

	public void salvar(Cidade cidade);

	public List<Cidade> listar();

	public void excluir(Cidade cidade);

	public Cidade pesquisar(String string);

	public void alterar(Cidade cidade);

	public Cidade carregar(Integer idCidade);

	public List<Cidade> listarCidadePorEstado(Integer estado);

}
