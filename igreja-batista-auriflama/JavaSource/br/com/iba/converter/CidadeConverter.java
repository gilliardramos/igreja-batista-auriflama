package br.com.iba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.iba.cidade.Cidade;
import br.com.iba.cidade.CidadeRN;

@FacesConverter(value = "converterCidade") // q q coisa mudar pra forvalue
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				CidadeRN cidadeRN = new CidadeRN();
				return cidadeRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("N�o foi poss�vel encontrar o cidade de c�digo " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cidade cidade = (Cidade) value;
			return cidade.getId_cidade().toString();
		}
		return "";
	}
}
