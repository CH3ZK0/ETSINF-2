/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jose
 */
public class Registro {

    private final SimpleStringProperty campoDia;
    private final DoubleProperty campoValor1;
    private final DoubleProperty campoValor2;

    public Registro(String fDia, double fValor1, double fValor2) {
        this.campoDia = new SimpleStringProperty(fDia);
        this.campoValor1 = new SimpleDoubleProperty(fValor1);
        this.campoValor2 = new SimpleDoubleProperty(fValor2);
    }

    public String getcampoDia() {
        return campoDia.get();
    }

    public double getcampoValor1() {
        return campoValor1.get();
    }

    public double getcampoValor2() {
        return campoValor2.get();
    }

    public void setcampoDia(String fDay) {
        campoDia.set(fDay);
    }

    public void setcampoValor1(Double fValue1) {
        campoValor1.set(fValue1);
    }

    public void setcampoValor2(Double fValue2) {
        campoValor2.set(fValue2);
    }

    public SimpleStringProperty campoDiaProperty() {
        return campoDia;
    }

    public DoubleProperty campoValor1Property() {
        return campoValor1;
    }

    public DoubleProperty campoValor2Property() {
        return campoValor2;
    }
}
