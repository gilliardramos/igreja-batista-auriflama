package br.com.iba.estado;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "estado")
public class Estado {

	@Id
	@NotNull
	@GeneratedValue
	private Integer id_estado;
	private String nome_estado;
	@NotNull
	private String sigla_estado;
	@Column(updatable = false)
	private Date data_cadastro;

	public Estado() {

	}

	public Estado(String nome_estado, String sigla_estado) {
		super();
		this.nome_estado = nome_estado;
		this.sigla_estado = sigla_estado;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}

	public String getSigla_estado() {
		return sigla_estado;
	}

	public void setSigla_estado(String sigla_estado) {
		this.sigla_estado = sigla_estado;
	}

	public Date getDataCadastro() {
		return data_cadastro;
	}

	public void setDataCadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((data_cadastro == null) ? 0 : data_cadastro.hashCode());
		result = prime * result
				+ ((id_estado == null) ? 0 : id_estado.hashCode());
		result = prime * result
				+ ((nome_estado == null) ? 0 : nome_estado.hashCode());
		result = prime * result
				+ ((sigla_estado == null) ? 0 : sigla_estado.hashCode());
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
		Estado other = (Estado) obj;
		if (data_cadastro == null) {
			if (other.data_cadastro != null)
				return false;
		} else if (!data_cadastro.equals(other.data_cadastro))
			return false;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		if (nome_estado == null) {
			if (other.nome_estado != null)
				return false;
		} else if (!nome_estado.equals(other.nome_estado))
			return false;
		if (sigla_estado == null) {
			if (other.sigla_estado != null)
				return false;
		} else if (!sigla_estado.equals(other.sigla_estado))
			return false;
		return true;
	}

}
