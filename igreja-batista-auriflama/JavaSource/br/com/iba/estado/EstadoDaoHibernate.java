package br.com.iba.estado;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class EstadoDaoHibernate implements EstadoDao {

	private Session sessao;

	@Override
	public void salvar(Estado estado) {
		this.sessao.save(estado);
	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listar() {
		Criteria lista = sessao.createCriteria(Estado.class);
		return lista.list();
	}

	@Override
	public void excluir(Estado estado) {
		this.sessao.delete(estado);
	}

	@Override
	public void alterar(Estado estado) {
		this.sessao.update(estado);
	}

	@Override
	public Estado buscarPorId(Integer id) {
		Query consultaId = this.sessao
				.createQuery("from Estado as e where e.id_estado = :id_estado");
		consultaId.setInteger("id_estado", id);
		return (Estado) consultaId.uniqueResult();
	}

	@Override
	public Estado pesquisar(String string) {
		Query consultaNome = this.sessao
				.createQuery("from Estado c where c.nome_estado like :estado");
		consultaNome.setString("estado", "%" + string + "%");
		return (Estado) consultaNome.uniqueResult();
	}

	@Override
	public Estado carregar(Integer estado) {
		String string = Integer.toString(estado);
		Query consultaNome = this.sessao
				.createQuery("from Estado c where c.id_estado like :id_estado");
		consultaNome.setString("id_estado", "%" + string + "%");
		return (Estado) consultaNome.uniqueResult();
	}

}
