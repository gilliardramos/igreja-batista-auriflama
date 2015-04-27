package br.com.iba.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class ConexaoHibernateFilter  implements Filter{
	
	private SessionFactory sf;

	@Override
	public void destroy() {
				
	}

	@Override
	public void doFilter(ServletRequest servletFilter, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// Leandro mano tava errado aki precisamos tratatar a excessão
		try {
			this.sf.getCurrentSession().beginTransaction(); //criei a conexao e iniciei a transacao
			chain.doFilter(servletFilter, servletResponse); // enviei e fiz o filtro
			this.sf.getCurrentSession().getTransaction().commit(); //MAndei a transacao e comitei
			this.sf.getCurrentSession().close(); //Fecho
		} catch (Throwable ex) {
			// ManoDeu problema em cima verifica se estiver ativa tenta dar um rollback e joga a excessao
			//na Exception
			try {
				if(this.sf.getCurrentSession().getTransaction().isActive()){
					this.sf.getCurrentSession().getTransaction().rollback();
					}
				// Se o rollback não funcionar agente imprimi o erro no console
			} catch (Throwable t) {
				// Se ele não conseguir fazer o rollback ele imprimi pra nois...o erro
				t.printStackTrace();
			}
			
			throw new ServletException();
		}
		
		

	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		
		// Aki ele inicia a sessao
		
		this.sf = HibernateUtil.getSession();

		
	}

}
