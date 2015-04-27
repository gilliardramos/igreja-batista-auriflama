package br.com.iba.pessoa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PessoaDaoHibernate implements PessoaDao {

	private Session sessao;
	
	public void setSessao(Session sessao) {
		this.sessao = sessao;
		
	}

	public void salvar(Pessoa pessoa) {
		this.sessao.save(pessoa);

	}

	public void alterar(Pessoa pessoa) {
		if (pessoa.getPermissao() == null || pessoa.getPermissao().size() == 0){
			Pessoa pessoaPermissao = this.carregar(pessoa.getId_pessoa());
			pessoa.setPermissao(pessoaPermissao.getPermissao());
			this.sessao.evict(pessoaPermissao);
		}
		this.sessao.update(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		this.sessao.delete(pessoa);

	}

	public Pessoa carregar(Integer id_pessoa) {

		return (Pessoa) this.sessao.get(Pessoa.class, id_pessoa);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {

		return this.sessao.createCriteria(Pessoa.class).list();
	}

	public Pessoa buscarPorEmail(String email) {
		String hql = "select p from Pessoa p where u.email = :login";
		Query consulta = this.sessao.getNamedQuery(hql);
		consulta.setString("email", email);
		return (Pessoa) consulta.uniqueResult();

	}

}
