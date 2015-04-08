package br.com.iba.estado;

import java.util.List;

public interface EstadoDao {

	public void salvar(Estado estado);

	public List<Estado> listar();

	public void excluir(Estado estado);

	public Estado pesquisar(String string);

	public void alterar(Estado estado);

	public Estado buscarPorId(Integer integer);
	
	public Estado carregar(Integer idEstado);


}
