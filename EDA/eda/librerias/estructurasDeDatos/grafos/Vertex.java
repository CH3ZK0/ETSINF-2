package librerias.estructurasDeDatos.grafos;


/**
 * Write a description of class Vertex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vertex implements Comparable<Vertex>{
    protected int destino;
    protected double peso;
    
    /** Construye el vertice adyacente a otro de un grafo y el peso 
      * de la arista que los une.
      * @param  codigo del vertice adyacente a otro
      * @param  peso de la arista que une este vertice y su adyacente 
      */
    public Vertex(int codAdy, double pesoArista) { 
        destino = codAdy;   peso = pesoArista; 
    }
    
    /** Devuelve el vertice adyacente */
    public int getDestino() { return destino; }
     
    /** Devuelve el peso del arco al vertice adyacente */
    public double getPeso() { return peso; }
     
    /**Devuelve un String que representa a un vertice adyacente a otro  
     * y al peso de la arista que los une.
     * @return  String  que representa a un adyacente
     */          
    public String toString() { 
        return destino + "(" + peso + ") ";
    }
    
    public int compareTo(Vertex v){
        if(peso > v.getPeso()){ return 1; }
        else if(peso < v.getPeso()){ return -1; }
        else{return 0;}
    }
}
