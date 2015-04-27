package br.com.iba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.iba.pessoa.Pessoa;
import br.com.iba.pessoa.PessoaRN;

@FacesConverter(value = "converterPessoa")// q q coisa mudar pra forvalue
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				PessoaRN clienteRN = new PessoaRN();
				return clienteRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException(
						"Não foi possível encontrar o cliente de código "
								+ value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Pessoa cliente = (Pessoa) value;
			return cliente.getId_pessoa().toString();
		}
		return "";
	}
}
