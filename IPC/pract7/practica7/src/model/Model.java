package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Model {

    private final ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
    private final ObservableList<XYChart.Data<String, Number>> barData = FXCollections.observableArrayList();

    void Model() {
    }

    public ObservableList<PieChart.Data> getPieData() {
        return pieData;
    }

    public ObservableList<XYChart.Data<String, Number>> getBarData() {
        return barData;
    }

    public void sumarTipoNota(String nota) {
        boolean encontrado = false;
        for (PieChart.Data d : pieData) {
            if (d.getName().equals(nota)) {
                encontrado = true;
                d.setPieValue(d.getPieValue() + 1);

            }
        }
        for (XYChart.Data<String, Number> b : barData) {
            if (b.getXValue().equals(nota)) {
                b.setYValue(b.getYValue().intValue() + 1);
                return;
            }
        }
        if (!encontrado) {
            pieData.add(new PieChart.Data(nota, 1));
            XYChart.Data<String, Number> p = new XYChart.Data<>(nota, 1);
            barData.add(p);

        }

    }

}
