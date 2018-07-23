/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class FXMLPersonasTableController implements Initializable {

    
    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.
    
    @FXML
    private Button addButton;
    @FXML
    private Button modButton;
    @FXML
    private Button delButton;
    @FXML
    private TableView<?> personasTable;
    @FXML
    private TableColumn<?, ?> nomColum;
    @FXML
    private TableColumn<?, ?> apellColum;

    
    private void inicializaModelo() {
        ArrayList<Persona> misdatos = new ArrayList<Persona>();
        misdatos.add(new Persona("Pepe", "García"));
        misdatos.add(new Persona("María", "Pérez"));
        datos = FXCollections.observableArrayList(misdatos);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializaModelo();
        
        
    }    
    
}
