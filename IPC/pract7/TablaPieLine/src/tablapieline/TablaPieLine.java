package tablapieline;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import vista.FXMLDocumentController;
import modelo.ListaDatos;
import modelo.Registro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jose
 */
public class TablaPieLine extends Application {

    private ListaDatos miListaDatos;

    @Override
    public void start(Stage stage) throws Exception {

        miListaDatos = new ListaDatos();
        inicializaDatos();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controlador = loader.getController();

        //===============================================================
        //hay que definir el metodo publico iniListas en el controlador
        controlador.initListas(miListaDatos);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    private void inicializaDatos() {

        miListaDatos.add(new Registro("Lunes", 100, 120));
        miListaDatos.add(new Registro("Martes", 200, 210));
        miListaDatos.add(new Registro("Miercoles", 50, 70));
        miListaDatos.add(new Registro("Jueves", 75, 50));
        miListaDatos.add(new Registro("Viernes", 110, 120));
        miListaDatos.add(new Registro("Sabado", 300, 200));
        miListaDatos.add(new Registro("Domingo", 111, 100));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
