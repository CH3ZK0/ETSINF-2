/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author jose
 */
public class ListaDatos {
    
         
        private final ObservableList<Registro> dataList;            // lista para la TableView
        private final ObservableList<PieChart.Data> pieChartData;   //lista para el PieChart
        private final ObservableList<XYChart.Data> xyList;          //lista para el LineChart

  
         
        public ListaDatos(){
            dataList = FXCollections.observableArrayList();
            pieChartData = FXCollections.observableArrayList();
            xyList = FXCollections.observableArrayList();
        }
        
        public  ObservableList<Registro> getDataList(){
          return this.dataList;
        }
        public  ObservableList<PieChart.Data> getPieData(){
          return this.pieChartData;
        }
        public  ObservableList<XYChart.Data> getXYData(){
          return this.xyList;
        }
         
        public void add(Registro r){
            dataList.add(r);
            pieChartData.add(new PieChart.Data(r.getcampoDia(), r.getcampoValor1()));
            xyList.add(new XYChart.Data(r.getcampoDia(), r.getcampoValor2()));
        }
         
        public void updatepieList(int pos, Double val){
            pieChartData.set(pos, new PieChart.Data(pieChartData.get(pos).getName(), val));
        }
         
        public void updatexyList(int pos, Double val){
            xyList.set(pos, new XYChart.Data(xyList.get(pos).getXValue(), val));
        }
    }
     
    

