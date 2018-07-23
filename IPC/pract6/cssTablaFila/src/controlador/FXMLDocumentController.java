/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.javafx.binding.SelectBinding;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import modelo.Item;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
   private ObservableList<Item> miLista=null;
    @FXML
    private TableView<Item> miTabla;
    @FXML
    private TableColumn<Item, String> categoriaColumn;
    @FXML
    private TableColumn<Item, Number> unidadesColumn;
    @FXML
    private VBox vboxIdD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // inicializamos el modelo
        initListaConfiguracion();
        
        //inicializamos la tabla
        miTabla.setItems(miLista);
        
        // inicializamos la columnas
        categoriaColumn.setCellValueFactory(e -> e.getValue().descripcionProperty());

        unidadesColumn.setCellValueFactory((e) -> e.getValue().unidadesProperty());
        unidadesColumn.setCellFactory(cell -> new EditingCell());
        
        //ajustamos el tamaño de las columnas para que ocupen toda la tabla
        unidadesColumn.prefWidthProperty().bind(Bindings.divide(miTabla.widthProperty(), 4));
        categoriaColumn.prefWidthProperty().bind(Bindings.multiply(3, Bindings.divide(miTabla.widthProperty(), 4)));


    }

    private void initListaConfiguracion() {
        miLista = FXCollections.observableArrayList();
        miLista.add(new Item("PLACA BASE", 1));
        miLista.add(new Item("CPU", 1));
        miLista.add(new Item("MEMORIA", 1));
        miLista.add(new Item("TARJETA GRÁFICA", 1));
        miLista.add(new Item("Disco HD/SSD", 1));
        miLista.add(new Item("TORRE", -1));
    }

}

class EditingCell extends TableCell<Item, Number> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else if (isEditing()) {
            if (textField != null) {
                textField.setText(getString());
            }

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } else {
            setText(getString());
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            // obtenemos la lista de estilos de las fila que se esta modificando
            final ObservableList<String> estilos = this.getTableRow().getStyleClass();
            if (item.intValue() > 0) {
                // si el valor de la celda es mayor que cero tendremos un estilo
                estilos.remove("row-menor-cero");
                estilos.add("row-mayor-cero");

            } else {
                // si el valor de la celda es menor o igual que cero tendremos un estilo
                estilos.add("row-menor-cero");
                estilos.remove("row-mayor-cero");
            }
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        //textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.selectAll();
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        // anadimos un filtro para que solamente se pueda teclear numeros positivoso y negativos y el retorno de carro
        textField.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent keyEvent) -> {
            if (!"-0123456789/n".contains(keyEvent.getCharacter())) {
                keyEvent.consume();
            }
        });
        //hay que añadir manejadores de eventos en el texfield donde se introduce el nuevo valor
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(Double.parseDouble(textField.getText()));
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
