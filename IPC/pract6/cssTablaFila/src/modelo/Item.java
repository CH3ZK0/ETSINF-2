/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jsoler
 */
public class Item {

    private final StringProperty descripcion = new SimpleStringProperty();

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String value) {
        descripcion.set(value);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }
    

    private final IntegerProperty unidades = new SimpleIntegerProperty();

    public int getUnidades() {
        return unidades.get();
    }

    public void setUnidades(int value) {
        unidades.set(value);
    }

    public IntegerProperty unidadesProperty() {
        return unidades;
    }

    public Item(String desc, int unit) {
        descripcion.set(desc);
        unidades.set(unit);
    }
    
    
}
