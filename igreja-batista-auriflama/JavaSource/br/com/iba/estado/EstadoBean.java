package br.com.iba.estado;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "estadoBean")
@RequestScoped
public class EstadoBean {

	private Estado estadoSelecionado = new Estado();
	private List<Estado> lista = null;

	public void salvar() {
		if (this.estadoSelecionado.getId_estado() == null) {
			EstadoRN estadoRN = new EstadoRN();
			estadoSelecionado.setDataCadastro(new Date());
			estadoRN.salvar(estadoSelecionado);
			FacesMessage faces = new FacesMessage(
					"Estado cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
			this.lista = null;
			this.setEstadoSelecionado(null);
		} else {
			alterar();
		}
	}

	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Estado> getLista() {
		EstadoRN estadoRN = new EstadoRN();
		if (lista == null) {
			lista = estadoRN.listar();

		}
		return lista;
	}

	/*public Estado buscarPorId() {
		EstadoRN estadoRN = new EstadoRN();
		if (this.estadoSelecionado.getId_estado() == null) {
			return null;
		}else{
			
		estadoRN.buscarPorId(this.estadoSelecionado.getId_estado());

		return estadoBuscado;
	}
	}*/
	public void excluir() {
		EstadoRN estadoRN = new EstadoRN();
		estadoRN.excluir(this.estadoSelecionado);
		FacesMessage faces = new FacesMessage("Estado Excluido com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
		this.lista = null;
		this.setEstadoSelecionado(null);
	}

	public void alterar() {
		EstadoRN estadoRN = new EstadoRN();
		estadoRN.alterar(this.estadoSelecionado);
		FacesMessage faces = new FacesMessage("Estado Alterado com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
		this.lista = null;
		this.setEstadoSelecionado(null);
	}
}
