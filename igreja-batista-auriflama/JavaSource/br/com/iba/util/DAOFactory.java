package br.com.iba.util;

import br.com.iba.cidade.CidadeDao;
import br.com.iba.cidade.CidadeDaoHibernate;
import br.com.iba.estado.EstadoDao;
import br.com.iba.estado.EstadoDaoHibernate;

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



}
