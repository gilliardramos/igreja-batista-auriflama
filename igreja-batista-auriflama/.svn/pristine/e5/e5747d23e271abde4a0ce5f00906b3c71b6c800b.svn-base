package com.toledo.salao

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class EstadoTeste {

	private static Session sessao;
	private static Transaction transacao;

	@BeforeClass
	public  static void abreConexao() {
		sessao = HibernateUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
	}

	@AfterClass
	public static void fechaConexao() {

		try {

			transacao.commit();

		} catch (Throwable e) {
			System.out.println("deu problema no commit : " + e.getMessage());
		} finally {
			try {
				if (sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Deu erro no fechamanto da sess‹o"
						+ e2.getMessage());
			}

		}
	}

	@Before
	public void setup(){
		Estado e1 = new Estado("Teste1", "ts1");
		Estado e2 = new Estado("Teste2", "ts2");
		Estado e3 = new Estado("Teste3", "ts3");
		Estado e4 = new Estado("Teste4", "ts4");
		Estado e5 = new Estado("Teste5", "ts5");		
		
		sessao.save(e1);
		sessao.save(e2);
		sessao.save(e3);
		sessao.save(e4);
		sessao.save(e5);
		
	}
	
	@After
	public void limpaBanco(){
		Criteria lista = sessao.createCriteria(Estado.class);
		@SuppressWarnings("unchecked")
		List<Estado> estados = lista.list();
		
		for (Estado estado : estados) {
			sessao.delete(estado);
			
		}
	}
	
	
	@Test
	public void salvarEstadoTeste() {
		
		Query consulta = pesquisar("Te");
		Estado estadoPesquisado = (Estado) consulta.uniqueResult();
		
		assertEquals("Teste2", produtoPesquisado.getUnidade());

	}
	
	@Test
	public void listaEstadoTeste(){
		
		Criteria lista = sessao.createCriteria(Estado.class);
		@SuppressWarnings("unchecked")
		List<Estado> estados = lista.list();
		
		assertEquals(5, estados.size());
		
		
	}
	
	@Test
	public void excluirEstadoTeste(){
		Query consulta = pesquisar("teste");
		Produto produtoDeletado = (Produto) consulta.uniqueResult();
		sessao.delete(produtoDeletado);
		
		estadoDeletado = (Estado) consulta.uniqueResult();
		
		assertNull(estadoDeletado);
		
		
	}
	
	@Test
	public void alteracaoEstadoTeste(){
		Query consulta = pesquisar("Teste1");
		Estado estadoAlterado = (Estado) consulta.uniqueResult();
		estadoAlterado.setNome_estado("deu");
		
		sessao.update(estadoAlterado);
		
		estadoAlterado = (Estado) consulta.uniqueResult();
		
		assertEquals("deu", estadoAlterado.getNome_estado());
		
	}

	private Query pesquisar(String parametro) {
		String sql = "from Estado p where p.sigla_estado like :sigla";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("sigla", "%"+parametro+"%");
		return consulta;
	}

}
