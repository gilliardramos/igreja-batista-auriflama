package br.com.iba.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.iba.estado.Estado;
import br.com.iba.estado.EstadoRN;

@FacesConverter(value = "converterEstado") // q q coisa mudar pra forvalue
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				EstadoRN estadoRN = new EstadoRN();
				return estadoRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o estado de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Estado estado = (Estado) value;
			return estado.getId_estado().toString();
		}
		return "";
	}
}
