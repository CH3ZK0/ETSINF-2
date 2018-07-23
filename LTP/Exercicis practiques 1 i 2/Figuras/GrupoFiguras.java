
/**
 * Clase utilizada para representar una agrupación de figuras geométricas.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 12 Octubre 2014
 */

public class GrupoFiguras 
{
    static final int MAX_NUM_FIGURAS = 10;
    private Figura [] listaFiguras = new Figura [MAX_NUM_FIGURAS];
    private int numF=0;

    //Constructor
    public GrupoFiguras(){}

    public int numFiguras() 
    {
        return numF;
    }

    public void anyadeFigura(Figura f) 
    {
        listaFiguras[numF++]= f;
    }
    
    public double volumen()
    {
        double res = 0.0;
        if(numF==0){return res;}
        else{
            for(int i=0; i < numF; i++){
                if(listaFiguras[i] instanceof Volumen){
                    res += ((Volumen) listaFiguras[i]).volumen();
                }
            }
        }
        return res;
    }
    
}
