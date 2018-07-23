import java.util.*;
import java.util.Collection.*;

public class GrupoFiguras<T extends Figura>{   
    
    ArrayList<T> listaFiguras = new ArrayList<T>(); 
    
    public double area () {
        double a = 0.0;
        for (int i = 0; i < listaFiguras.size(); i++)
            a += listaFiguras.get(i).area();
        return a;
    }
    
    private boolean estaFiguraEnGrupo(T f){
      for (int i = 0; i < listaFiguras.size(); i++)
        if (f.equals(listaFiguras.get(i)))return true;
      return false;
    }  
    
    public String toString () {
        String result = "";
        for (int i = 0; i < listaFiguras.size(); i++)
            result += listaFiguras.get(i).toString()+"\n";
        return result;
    }
    
    public void anyadeFigura(T a){
        if(!estaFiguraEnGrupo(a)){
            listaFiguras.add(a);
        }
    }
    
    public void desplazaXY(double x, double y){
        for (int i = 0; i < listaFiguras.size(); i++){
            listaFiguras.get(i).desplazaXY(x,y);
        }
    }
    
    public void unir(GrupoFiguras<T> g){
        for (int i = 0; i < g.listaFiguras.size(); i++){
            this.listaFiguras.add(g.listaFiguras.get(i));
        }
    }
}