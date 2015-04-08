package br.com.iba.cidade;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.iba.estado.Estado;
import br.com.iba.estado.EstadoDaoHibernate;
import br.com.iba.estado.EstadoRN;



public class TesteCidade {

	Cidade cidadeSelecionada = new Cidade();
	

	
	public static void main(String[] args) throws Exception {
		Cidade cidadeSelecionada = new Cidade();
		CidadeRN cidadeRN = new CidadeRN();
		Estado estado = new Estado();
		EstadoRN estadoRN = new EstadoRN();
		//EstadoDaoHibernate estadoDaoHibernate = new EstadoDaoHibernate();
		//cidadeSelecionada.getEstado().setId_estado(22);
		cidadeSelecionada.setNome_cidade("le");
		cidadeSelecionada.setCep_inicial("1111111111");
		cidadeSelecionada.setId_cidade(0);
		estado = estadoRN.pesquisar("22");
		//estado = estadoRN.buscarPorId(cidadeSelecionada.getEstado().getId_estado());
		System.out.print("id  do estado procurado: "+ estado.getNome_estado());
		cidadeSelecionada.setDataCadastro(new Date());
		cidadeSelecionada.setEstado(estado);
		cidadeRN.salvar(cidadeSelecionada);
		FacesMessage faces = new FacesMessage(
				"Cidade cadastrada com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
		//this.lista = null;
		//this.setCidadeSelecionada(null);
	}
}
