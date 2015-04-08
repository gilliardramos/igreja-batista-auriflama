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

	/*@Override
	public Estado pesquisar(String string) {
		Query consultaNome = this.sessao
				.createQuery("from estado e where e.nome_estado like :nome_estado");
		consultaNome.setString("nome_estado", "%" + string + "%");
		return (Estado) consultaNome.uniqueResult();
	}
*/
	@Override
	public void alterar(Estado estado) {
		this.sessao.update(estado);
	}
	
	/*@Override
	public Estado buscarPorId(Integer id) {
		  if (id == null) {  
	            return null;  
	        } else {  
	            sessao = this.getSessao();  
	            Estado estado = ( Estado )  
	            sessao.get( EstadoDao.class, id );  
	            sessao.getTransaction().commit();  
	            sessao.close();  
	            return estado;  
	        }  
	}*/


	@Override
	public Estado buscarPorId(Integer id) {
		Query consultaId = this.sessao
				.createQuery("from Estado as e where e.id_estado = :id_estado");
		consultaId.setInteger("id_estado", id);
		return (Estado) consultaId.uniqueResult();
	}
	
	
/*	@Override
	public Estado buscarPorId(Integer id) {
		
		System.out.print("dentro do dao hibernate  "+id);
		Query query = sessao.createQuery("from Estado where id_estado = :id_estado ");
		query.setParameter("id_estado", id);
		List<Estado> list = query.list();
		System.out.print("dentro do dao hibernate e na lista  "+list.get(0).toString());
		//return list;
		Estado estado = new Estado();
		return estado;

	}*/
	
	@Override
	public Estado pesquisar(String string) {
		Query consultaNome = this.sessao
				.createQuery("from Estado c where c.id_estado like :id_Estado");
		consultaNome.setString("id_estado", "%" + string + "%");
		return (Estado) consultaNome.uniqueResult();
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Estado buscar(Integer idEstado) {
		List<Cidade> cidades = new ArrayList<>();		
		try {
			// o carreto seria abrir a sessão aqui, usar abaixo e então fechar em finally
			
			
			
			
			 * Exemplo de Criteria para obter a cidade ja com o objeto esta a que pertence, 
			 * mas trazendo somente a cidade do id_cidade = 123, ou o que vc's passar por parametro
			 
			estados = (ArrayList<Estado>)sessao.createCriteria(Estado.class)
					.add(Restrictions.eq("id_estado", idEstado))
					.list();
			
			
			
		} catch (Exception e) {
			System.err.println(String.format("ocorreu um erro ao lista as cidades cadastradas. Erro: %s", e.getMessage()));
		} finally {
			// o correto aqui é fechar a sessão
		}
		
		//return cidades.get(0);
		Estado estado = new Estado();
		estado = estados.get(0);
		return estado;
	}
*/
	
	@Override  
	   public Estado carregar(Integer estado) {  
	      // return (Estado) this.sessao.get(Estado.class, estado);
		String string = Integer.toString(estado);
		Query consultaNome = this.sessao
				.createQuery("from Estado c where c.id_estado like :id_estado");
		consultaNome.setString("id_estado", "%" + string + "%");
		return (Estado) consultaNome.uniqueResult();
	   }  

}
