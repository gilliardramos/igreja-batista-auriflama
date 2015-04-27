package br.com.iba.pessoa;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.iba.cidade.Cidade;
import br.com.iba.cidade.CidadeRN;
import br.com.iba.estado.Estado;

@ManagedBean(name = "pessoaBean")
@RequestScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> lista;
	private String destinoSalvar;
	private String comboSexo;

	private Estado estadoSelecionado = new Estado();
	private List<Cidade> listaCidadePorEstado = null;
	private Integer idEstadoSelecionado;

/*	public String novo() {
		this.destinoSalvar = "pessoaSucesso";
		this.pessoa = new Pessoa();
		this.pessoa.setAtivo(true);
		return "pessoa";
	}

	public String editar() {
		return "/publico/pessoa"; // /<------------------------------------------------------------
	}*/

	/*
	 * public String salvar() { PessoaRN pessoaRN = new PessoaRN();
	 * this.pessoa.setAtivo(true); pessoaRN.salvar(this.pessoa); return
	 * "/publico/pessoaSucesso"; //
	 * /<------------------------------------------------------------ }
	 */

	public void salvar() {

		this.pessoa.setSexo(this.getComboSexo());

		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.salvar(this.pessoa);

		FacesMessage faces = new FacesMessage("Pessoa cadastrada com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);

		this.lista = null;
		this.setPessoa(null);
		this.setEstadoSelecionado(null);
		this.setComboSexo("");
		this.setIdEstadoSelecionado(null);

	}

	public String excluir() {
		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.excluir(this.pessoa);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.pessoa.isAtivo())
			this.pessoa.setAtivo(false);
		else
			this.pessoa.setAtivo(true);

		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.salvar(this.pessoa);
		return null;
	}

	public List<Pessoa> getLista() {
		if (this.lista == null) {
			PessoaRN pessoaRN = new PessoaRN();
			this.lista = pessoaRN.listar();
		}
		return this.lista;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String atribuiPermissao(Pessoa pessoa, String permissao) {
		java.util.Set<String> permissoes = this.pessoa.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Cidade> getListaCidadePorEstado() {
		return listaCidadePorEstado;
	}

	public void setListaCidadePorEstado(List<Cidade> listaCidadePorEstado) {
		this.listaCidadePorEstado = listaCidadePorEstado;
	}

	public Integer getIdEstadoSelecionado() {
		return idEstadoSelecionado;
	}

	public void setIdEstadoSelecionado(Integer idEstadoSelecionado) {
		this.idEstadoSelecionado = idEstadoSelecionado;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

	public void populaCampos() {
		this.setIdEstadoSelecionado(this.estadoSelecionado.getId_estado());
		CidadeRN cidadeRN = new CidadeRN();
		this.setListaCidadePorEstado(cidadeRN
				.listarCidadePorEstado(this.estadoSelecionado.getId_estado()));
	}

	public void listarCidadePorEstado() {
		if (this.idEstadoSelecionado.equals(null)) {
			this.setListaCidadePorEstado(null);
		} else {
			CidadeRN cidadeRN = new CidadeRN();
			this.setListaCidadePorEstado(cidadeRN
					.listarCidadePorEstado(this.idEstadoSelecionado));
		}
	}

	public String getComboSexo() {
		return comboSexo;
	}

	public void setComboSexo(String comboSexo) {
		this.comboSexo = comboSexo;
	}

}
