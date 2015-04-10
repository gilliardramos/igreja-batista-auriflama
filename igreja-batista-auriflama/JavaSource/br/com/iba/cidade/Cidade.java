package br.com.iba.cidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.iba.estado.Estado;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue
	private Integer id_cidade;
	private String nome_cidade;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@Column(name = "data_cadastro", updatable = false)
	private Date datacadastro;

	public Cidade() {

	}

	public Cidade(String nome_cidade, Estado estado, String cep_inicial) {
		super();
		this.nome_cidade = nome_cidade;
		this.estado = estado;
	}

	public Date getDataCadastro() {
		return datacadastro;
	}

	public void setDataCadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Integer getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datacadastro == null) ? 0 : datacadastro.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((id_cidade == null) ? 0 : id_cidade.hashCode());
		result = prime * result
				+ ((nome_cidade == null) ? 0 : nome_cidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (datacadastro == null) {
			if (other.datacadastro != null)
				return false;
		} else if (!datacadastro.equals(other.datacadastro))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (nome_cidade == null) {
			if (other.nome_cidade != null)
				return false;
		} else if (!nome_cidade.equals(other.nome_cidade))
			return false;
		return true;
	}

}
