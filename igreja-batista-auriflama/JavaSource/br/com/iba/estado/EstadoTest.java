package br.com.iba.estado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.iba.util.HibernateUtil;

public class EstadoTest {

	private static Session sessao;
	private static Transaction transacao;

	@BeforeClass
	public static void abreConexao() {
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
				System.out.println("Deu erro no fechamanto da sessao"
						+ e2.getMessage());
			}

		}
	}

/*	@Before
	public void setup() {
		Estado e1 = new Estado("TOCANTINS", "TO", new Date());
		Estado e2 = new Estado("RORAIMA", "RR", new Date());
		Estado e3 = new Estado("AMAPA", "AM", new Date());
		Estado e4 = new Estado("ACRE", "AC", new Date());
		Estado e5 = new Estado("PIAUI", "PI", new Date());

		EstadoRN estadoRN = new EstadoRN();

		estadoRN.salvar(e1);
		estadoRN.salvar(e2);
		estadoRN.salvar(e3);
		estadoRN.salvar(e4);
		estadoRN.salvar(e5);

	}

	@After
	public void limpaBanco() {

		EstadoRN estadoRN = new EstadoRN();
		List<Estado> lista = estadoRN.listar();

		for (Estado estado : lista) {
			estadoRN.excluir(estado);
		}
	}

	@Test
	public void salvarTest() {

		Estado e1 = new Estado();

		e1.setNome_estado("Teste");
		e1.setSigla_estado("TT");
		e1.setDataCadastro(new Date());

		EstadoRN estadoRN = new EstadoRN();
		estadoRN.salvar(e1);
		assertEquals(true, true);

	}

	@Test
	public void listarTest() {
		EstadoRN estadoRN = new EstadoRN();
		List<Estado> lista = estadoRN.listar();
		assertEquals(1, lista.size());

	}*/

	@Test
	public void excluirEstadoTest(){
		Query consulta = pesquisar("ALT");
		Estado estadoDeletado = (Estado) consulta.uniqueResult();
		sessao.delete(estadoDeletado);
		
		estadoDeletado = (Estado) consulta.uniqueResult();
		
		assertNull(estadoDeletado);
		
		
	}
	

/*	@Test
	public void pesquisarTest() {
		EstadoRN estadoRN = new EstadoRN();
		Estado estadoPesquisado = estadoRN.pesquisar("AL");

		assertEquals("ALTERADO", estadoPesquisado.getNome_estado());

	}

	@Test
	public void alterarTest() {

		EstadoRN estadoRN = new EstadoRN();
		Estado estadoPesquisado = estadoRN.pesquisar("Tes");

		assertEquals("Teste", estadoPesquisado.getNome_estado());

		estadoPesquisado.setNome_estado("ALTERADO");

		estadoRN.alterar(estadoPesquisado);

		Estado estadoAlterado = estadoRN.pesquisar("AL");

		assertEquals("ALTERADO", estadoAlterado.getNome_estado());

	}*/
	
	private Query pesquisar(String parametro) {
		String sql = "from Estado e where e.nome_estado like :estado";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("estado", "%"+parametro+"%");
		return consulta;
	}


}
