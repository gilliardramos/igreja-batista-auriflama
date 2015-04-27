package br.com.iba.util;

import br.com.iba.cidade.CidadeDao;
import br.com.iba.cidade.CidadeDaoHibernate;
import br.com.iba.estado.EstadoDao;
import br.com.iba.estado.EstadoDaoHibernate;
import br.com.iba.pessoa.PessoaDao;
import br.com.iba.pessoa.PessoaDaoHibernate;
import br.com.iba.usuario.UsuarioDao;
import br.com.iba.usuario.UsuarioDaoHibernate;

public class DAOFactory {

	public static EstadoDao criaEstadoDao() {
		EstadoDaoHibernate estadoDaoHibernate = new EstadoDaoHibernate();
		estadoDaoHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return estadoDaoHibernate;
	}

	public static CidadeDao criaCidadeDao() {
		CidadeDaoHibernate cidadeDaoHibernate = new CidadeDaoHibernate();
		cidadeDaoHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return cidadeDaoHibernate;
	}

	public static PessoaDao criaPessoaDao() {
		PessoaDaoHibernate pessoaDaoHibernate = new PessoaDaoHibernate();
		pessoaDaoHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());

		return pessoaDaoHibernate;
	}
	
	public static UsuarioDao criaUsuarioDao() {
		UsuarioDaoHibernate usuarioDaoHibernate = new UsuarioDaoHibernate();
		usuarioDaoHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());

		return usuarioDaoHibernate;
	}

}
