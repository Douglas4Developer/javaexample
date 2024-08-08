package com.doug.javaexample.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        try {
            return formatter.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Data inválida. Formato correto: " + DATE_FORMAT);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format((Date) value);
    }
}
