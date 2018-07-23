
public class GrupoFiguras{

    static final int MAX_NUM_FIGURAS = 10;
    private Figura [] listaFiguras = new Figura [MAX_NUM_FIGURAS];
    private int numF=0;
    
    public void anyadeFigura(Figura f){
        if(f instanceof Circulo){
            anyadeCirculo((Circulo) f);
        }
        if(f instanceof Triangulo){
            anyadeTriangulo((Triangulo) f);
        }
        if(f instanceof Rectangulo){
            anyadeRectangulo((Rectangulo) f);
        }
    }
    
    public void anyadeCirculo(Circulo c) {
        boolean aux = false;
        for(int i = 0; i <= numF && aux == true; i++){
            aux = equals(c);
        }
        if (aux == false) {listaFiguras[numF++]= c;}
    }

    public void anyadeTriangulo(Triangulo t) {
        boolean aux = false;
        for(int i = 0; i <= numF && aux == true; i++){
            aux = equals(t);
        }
        if (aux == false){listaFiguras[numF++]= t;}
    }
    
    public void anyadeRectangulo(Rectangulo r) {
        boolean aux = false;
        for(int i = 0; i <= numF && aux == true; i++){
            aux = equals(r);
        }
        if (aux == false){listaFiguras[numF++]= r;}
    }

    public String toString(){
        String s= "Circulos:";
        for(int i = 0;i < numF; i++)
        if (listaFiguras[i] instanceof Circulo) s+="\n"+listaFiguras[i];
        s+= "\nTriangulos:";
        for(int i = 0;i < numF; i++)
        if (listaFiguras[i] instanceof Triangulo)s+="\n"+listaFiguras[i];
        s+= "\nRectangulos:";
        for(int i = 0;i < numF; i++)
        if (listaFiguras[i] instanceof Rectangulo)s+="\n"+listaFiguras[i];
        return s;
    }
    
    private int IndexOf (Object o) {
        int aux = -1;
        int i = 0;
        while (i < numF && aux < 0) {
            if (listaFiguras[i].equals(o)) {
                aux = i;
            }
            else {i++;}
        }
        return aux;
    }
    
    private boolean incluido(GrupoFiguras g) {
        int i = 0;
        boolean aux = true;
        while (aux == true && i < numF){
            if (IndexOf(g.listaFiguras[i]) < 0) {
                aux = false;
            }
            else{ i++;}
        }
        return aux;
    }
    
    public boolean equals(Object o) {
        return o instanceof GrupoFiguras && this.incluido((GrupoFiguras)o) 
                && ((GrupoFiguras)o).incluido(this);
    }
    
    public double area (){
        double aux = 0.0;
        for(int i = 0; i < numF; i++){
                aux += listaFiguras[i].area();
        }
        return aux;
    }
    
    public double volumen(){
        double res = 0.0;
        for(int i = 0; i < numF; i++){
            if(listaFiguras[i] instanceof Volumen){
                res += ((Volumen)listaFiguras[i]).volumen();
            }
        }
        return res;
    }
}
