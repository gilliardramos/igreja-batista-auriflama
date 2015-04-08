package br.com.iba.cidade;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.iba.estado.Estado;
import br.com.iba.estado.EstadoRN;

@ManagedBean(name = "cidadeBean")
@RequestScoped
public class CidadeBean {
	
	private Cidade cidadeSelecionada = new Cidade();
	private List<Cidade> lista = null;
	private List<Estado> listaEstado = null;
	private List<Cidade> listaCidadePorEstado = null;
	
	private Estado estadoSelecionado = new Estado();


	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Cidade> getListaCidadePorEstado() {
		CidadeRN cidadeRN = new CidadeRN();
		if (listaCidadePorEstado == null) {
			listaCidadePorEstado = cidadeRN.listar();

		}
		return listaCidadePorEstado;

	}

	public void setListaCidadePorEstado(List<Cidade> listaCidadePorEstado) {
		this.listaCidadePorEstado = listaCidadePorEstado;
	}

	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

	public List<Cidade> getLista() {
		CidadeRN cidadeRN = new CidadeRN();
		if (lista == null) {
			lista = cidadeRN.listar();

		}
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}

	public List<Estado> getListaEstado() {
		EstadoRN estadoRN = new EstadoRN();
		if (listaEstado == null) {
			listaEstado = estadoRN.listar();

		}
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}
	
	public void salvar() {
		
		if (this.cidadeSelecionada.getId_cidade() == 0) {
			this.cidadeSelecionada.setDataCadastro(new Date());
			CidadeRN cidadeRN = new CidadeRN();
			cidadeRN.salvar(this.cidadeSelecionada);
			FacesMessage faces = new FacesMessage("Cidade cadastrada com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
			this.lista = null;
			this.listaEstado = null;
			this.setCidadeSelecionada(null);

		} else {
			alterar();
		}
	}
	


	public void excluir() {
		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.excluir(this.cidadeSelecionada);
		FacesMessage faces = new FacesMessage("Cidade Excluida com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
		this.lista = null;
		this.listaEstado = null;
		this.setCidadeSelecionada(null);
	}
	
	public void alterar() {
		this.cidadeSelecionada.setDataCadastro(new Date());
		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.alterar(this.cidadeSelecionada);
		FacesMessage faces = new FacesMessage("Cidade Alterada com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
		this.lista = null;
		this.listaEstado = null;
		this.setCidadeSelecionada(null);	
	}
	
	
	
	public void listarCidadePorEstado(){
		
		//this.setListaCidadePorEstado(this.estadoSelecionado.getId_estado());
		
//		System.out.println(this.estadoSelecionado.getId_estado());
//		if (this.estadoSelecionado.getId_estado().equals(0)){
//			this.setListaCidadePorEstado(null);
//		}else{
//		
		CidadeRN cidadeRN = new CidadeRN();
		this.setListaCidadePorEstado(cidadeRN.listarCidadePorEstado(this.estadoSelecionado.getId_estado()));
		
		//System.out.println("numero 1 da lista; "+this.listaCidadePorEstado.get(0).getNome_cidade());

		//this.setListaCidadePorEstado(cidadeRN.listarCidadePorEstado(this.estadoSelecionado.getId_estado()));
		//System.out.println("numero 1 da lista; "+this.listaCidadePorEstado.get(0).getNome_cidade());
		//	System.out.println(this.cidadeSelecionada.getEstado().getNome_estado());
		//System.out.println("numero 2 da lista; "+this.listaFuncionarioPorServico.get(1).getNome_pessoa());
		//System.out.println(this.estadoSelecionado.getNome_estado());
		
		}
	}
	
	
	

