package br.com.iba.usuario;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoHibernate implements UsuarioDao {

	private Session	sessao;

	public void setSession(Session sessao) {
		this.sessao = sessao;
	}

	public void salvar(Usuario usuario) {
		this.sessao.save(usuario);
	}

	public void atualizar(Usuario usuario) {

		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.sessao.evict(usuarioPermissao);
		}

		this.sessao.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.sessao.delete(usuario);
	}

	public Usuario carregar(Integer codigo) {
		//TODO o hibernate nao conseguira fazer a carga caso seja passado o Usuario
		// no parametro, tem que ser diretamente a chave (integer)
		return (Usuario) this.sessao.get(Usuario.class, codigo);
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("login", login);

		//TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Usuario) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return this.sessao.createCriteria(Usuario.class).list();
	}
}
