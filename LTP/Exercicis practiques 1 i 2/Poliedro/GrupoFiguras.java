public class GrupoFiguras {   
    private Figura [] listaFiguras = new Figura [MAX_NUM_FIGURAS];
    private int numF = 0;
    private static final int MAX_NUM_FIGURAS = 10;

    public void anyadeFigura (Figura f) {
        listaFiguras[numF++] = f;
    }
    
    public double area () {
        double a = 0.0;
        for (int i = 0; i < numF; i++)
            a += listaFiguras[i].area();
        return a;
    }

    public double volumen () {
        double a = 0.0;
        for (int i = 0; i < numF; i++)
            if ( listaFiguras[i] instanceof Volumen )
                a += ((Volumen)listaFiguras[i]).volumen();
        return a;
    }    
}