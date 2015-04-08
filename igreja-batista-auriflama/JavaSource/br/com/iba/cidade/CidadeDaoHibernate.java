package br.com.iba.cidade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



public class CidadeDaoHibernate implements CidadeDao {
	
	private Session sessao;
	
	@Override
	public void salvar(Cidade cidade) {
		this.sessao.save(cidade);

	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listar() {
		List<Cidade> cidades = new ArrayList<>();		
		try {
			// o carreto seria abrir a sessão aqui, usar abaixo e então fechar em finally
			
			cidades = (ArrayList<Cidade>)sessao.createCriteria(Cidade.class)
				.setFetchMode("estado", FetchMode.JOIN)
				.list();
			
			/*
			 * Exemplo de Criteria para obter a cidade ja com o objeto esta a que pertence, 
			 * mas trazendo somente a cidade do id_cidade = 123, ou o que vc's passar por parametro
			 */
			/*cidades = (ArrayList<Cidade>)sessao.createCriteria(Cidade.class)
					.setFetchMode("estado", FetchMode.JOIN)
					.add(Restrictions.eq("id_cidade", 123))
					.list();*/
			
		} catch (Exception e) {
			System.err.println(String.format("ocorreu um erro ao listar as cidades cadastradas. Erro: %s", e.getMessage()));
		} finally {
			// o correto aqui é fechar a sessão
		}
		
		return cidades;
	}

	@Override
	public void excluir(Cidade cidade) {
		this.sessao.delete(cidade);
		
	}

	@Override
	public Cidade pesquisar(String string) {
		Query consultaNome = this.sessao
				.createQuery("from cidade c where c.nome_cidade like :nome_cidade");
		consultaNome.setString("nome_cidade", "%" + string + "%");
		return (Cidade) consultaNome.uniqueResult();
	}

	@Override
	public void alterar(Cidade cidade) {
		this.sessao.update(cidade);
	}
	
	
@Override
public Cidade carregar(Integer idcidade){
	return (Cidade) this.sessao.get(Cidade.class, idcidade);
}





@SuppressWarnings("unchecked")
@Override
public List<Cidade> listarCidadePorEstado(Integer estado) {
	List<Cidade> cidades = new ArrayList<>();		
	try {
		// o carreto seria abrir a sessão aqui, usar abaixo e então fechar em finally
		
		cidades = (ArrayList<Cidade>)sessao.createCriteria(Cidade.class)
			.setFetchMode("estado", FetchMode.JOIN)
			.add(Restrictions.eq("estado.id_estado", estado))
			.list();
		
		/*
		 * Exemplo de Criteria para obter a cidade ja com o objeto esta a que pertence, 
		 * mas trazendo somente a cidade do id_cidade = 123, ou o que vc's passar por parametro
		 */
		/*cidades = (ArrayList<Cidade>)sessao.createCriteria(Cidade.class)
				.setFetchMode("estado", FetchMode.JOIN)
				.add(Restrictions.eq("id_cidade", 123))
				.list();*/
		
	} catch (Exception e) {
		System.err.println(String.format("ocorreu um erro ao listar as cidades cadastradas. Erro: %s", e.getMessage()));
	} finally {
		// o correto aqui é fechar a sessão
	}
	
	return cidades;
}




}
