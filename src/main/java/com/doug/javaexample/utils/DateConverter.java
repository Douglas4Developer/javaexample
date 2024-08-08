package com.doug.javaexample.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateConverter")
public class DateConverter extends DateTimeConverter {

    public DateConverter() {
        setPattern("yyyy-MM-dd");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(value);
            return date;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'dd/MM/yyyy'.");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        Date date = (Date) value;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
