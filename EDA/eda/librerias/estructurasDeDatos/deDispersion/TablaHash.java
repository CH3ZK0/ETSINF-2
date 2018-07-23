package librerias.estructurasDeDatos.deDispersion;

import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.modelos.ListaConPI; 
import librerias.estructurasDeDatos.lineales.LEGListaConPI;

/**
 * Implementacion de una TablaHash Enlazada con Listas con PI 
 * @param <C>, tipo de las claves de la Tabla Hash, deben implementar hashCode
 * @param <V>, tipo de los valores asociados a las claves de una Tabla Hash
 * @author (EDA)
 * @version (Febrero 2016)
 */
public class TablaHash<C, V> implements Map<C, V> {

    /** El valor del factor de carga de una Tabla Hash 
     *  (valor por defecto en la clase java.util.HashMap) */
    public static final double FACTOR_CARGA = 0.75;
    
    // TIENE UN array de Listas Con PI de Tipo Generico EntradaHash<C, V>:
    // elArray[h] es la cubeta (lista de colisiones) asociada al indice hash h
    // elArray[h] contiene la referencia a la Lista Con PI donde se encuentran  
    //   todas las entradas cuya clave tiene un indice hash h 
    protected ListaConPI<EntradaHash<C, V>>[] elArray;
    
    // TIENE UNA talla que representa el numero de entradas almacenadas.
    protected int talla; 
            
    /** Crea una Tabla Hash vacia, con una capacidad (inicial) maxima  
     *  de tallaMaximaEstimada entradas y factor de carga 0.75
     */
    @SuppressWarnings("unchecked") 
    public TablaHash(int inicial) {
        int capacidad = siguientePrimo((int) (inicial / FACTOR_CARGA));
        elArray = new LEGListaConPI[capacidad];
        for (int i = 0; i < elArray.length; i++) { 
            elArray[i] = new LEGListaConPI<EntradaHash<C, V>>();
        }
        talla = 0;
    }
    
    // Devuelve un numero primo MAYOR o IGUAL a n, i.e. el primo que sigue a n
    public static final int siguientePrimo(int n) {
        int nn = n;
        if (nn % 2 == 0) { nn++; }
        for ( ; !esPrimo(nn); nn += 2) { ; } 
        return nn;
    } 
    
    // Comprueba si n es un numero primo
    protected static final boolean esPrimo(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) { return false; } // n NO es primo
        }
        return true; // n SI es primo
    } 
    
    // Devuelve el indice hash de la clave c i.e. la cubeta en la que se 
    // debe encontrar la entrada de clave c
    protected int indiceHash(C c) {
        int indiceHash = c.hashCode() % this.elArray.length;
        if (indiceHash < 0) { indiceHash += this.elArray.length; }
        return indiceHash;
    }
    
    /** Devuelve el valor de la entrada con clave c,
     *  o null si no hay una entrada con clave c en la Tabla
     */
    public V recuperar(C c) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[pos];
        V valor = null;        
        //Busqueda en cub de la entrada de clave c 
        //cuyo valor se quiere recuperar 
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        //Resolucion de la Busqueda: SII esta la Entrada se recupera su valor
        if (!l.esFin()) {
            valor = l.recuperar().valor;
        }
        return valor;
    }
    
    
    /** Elimina la entrada con clave c y devuelve su valor 
     *  asociado, o null si no hay ninguna entrada con clave c 
     */
    public V eliminar(C c) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[pos];
        V valor = null;      
        //Busqueda en cubeta de la entrada de clave c a eliminar
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        //Resolucion de la Busqueda: 
        //    SII esta la entrada se elimina, tras recuperar su valor
        if (!l.esFin()) {
            valor = l.recuperar().valor;
            l.eliminar();
            talla--;
        }
        return valor;
    }
        
    /** Inserta la entrada (c, v)  a una Tabla Hash y devuelve  
     *  el antiguo valor asociado a c, o null si no hay ninguna 
     *  entrada con clave c en la Tabla
     */
    public V insertar(C c, V v) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[pos];
        V antiguoValor = null;
        //Busqueda en cubeta de la Entrada de clave c 
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        //Resolucion de la busqueda: 
        //si la Entrada (c, v) ya existe se actualiza su valor y sino se inserta
        if (l.esFin()) { // si no esta, insercion efectiva de (c, v)
            l.insertar(new EntradaHash<C, V>(c, v));
            talla++;
            if (factorCarga() > FACTOR_CARGA) {
                rehashing();
            }
        }
        else { 
            //si ya esta, actualiza (valor de la) entrada y retorna el antiguo
            antiguoValor = l.recuperar().valor; 
            l.recuperar().valor = v;
        }
        return antiguoValor;//retorna el antiguo valor
    }
    /** Comprueba si una Tabla Hash esta vacia, i.e. si tiene 0 entradas. */
    public boolean esVacio() { return talla == 0; }
    
    /** Devuelve la talla, o numero de entradas, de una Tabla Hash. */
    public int talla() { return talla; } 
        
    /** Devuelve el factor de carga actual de una Tabla Hash, i.e. la longitud
     *  media de sus cubetas */
    public final double factorCarga() {
        //COMPLETAR
        double media = 0;
        for(int i = 0; i < elArray.length; i++){
            media += elArray[i].talla();
        }    
        return media / elArray.length;
        
    }
    
    // rehashing: crea una nueva tabla con un array de talla aprox.
    // el doble y reubica las entradas
    @SuppressWarnings("unchecked")
    protected final void rehashing() {
        //COMPLETAR
        int tamano = siguientePrimo((int) elArray.length*2);
        
        ListaConPI<EntradaHash<C, V>>[] l = elArray;
        elArray = new LEGListaConPI[tamano];
        
        for(int i=0; i<elArray.length; i++){
            elArray[i] = new LEGListaConPI<EntradaHash<C, V>>();
        }
        
        int pos;
        for(int j=0; j<l.length; j++){
            l[j].inicio();
            
            while(!l[j].esFin()){
                pos = indiceHash(l[j].recuperar().clave);
                
                elArray[pos].insertar(l[j].recuperar());
                l[j].siguiente();
            }
        }
    } 

    /** Devuelve una ListaConPI con las talla() claves de una Tabla Hash */
    public ListaConPI<C> claves() {
        //COMPLETAR
        ListaConPI<C> l = new LEGListaConPI<C>();
        
        for(int i=0; i<elArray.length; i++){
            
            elArray[i].inicio();
            
            while(!elArray[i].esFin()){
                l.insertar(elArray[i].recuperar().clave);
                elArray[i].siguiente();
            }
        }
        return l;
    }
   
    /** Calcula la desviacion tipica de las longitudes de las listas */
    public final double desviacionTipica() {
        //COMPLETAR
        double fc = factorCarga();
        double suma = 0;
        double tElement = 0;
        
        for(int i=0; i<elArray.length; i++){
            tElement = elArray[i].talla();
            suma += Math.pow((tElement - fc), 2);
        }
        
        suma = suma / elArray.length;
        return Math.sqrt(suma);
    }

    /** Devuelve un String que representa el histograma de ocupacion:
      * lineas, cada una de ellas con dos valores: 
      * longitudCubeta  NumeroDeCubetas 
      * donde:
      * - las lineas 0 a 8 contienen el numero de cubetas de esa longitud, 
      *   0<=longitud<9
      * la ultima linea (9) contiene el numero de cubetas de longitud 9 o mas
      */      
    public String histograma() {
        //COMPLETAR
        String res = "";
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        
        for(int i=0; i<elArray.length; i++){
            
            if(elArray[i].talla() == 0){
                a[0]++;
            }else if(elArray[i].talla() == 1){
                a[1]++;
            }else if(elArray[i].talla() == 2){
                a[2]++;
            }else if(elArray[i].talla() == 3){
                a[3]++;
            }else if(elArray[i].talla() == 4){
                a[4]++;
            }else if(elArray[i].talla() == 5){
                a[5]++;
            }else if(elArray[i].talla() == 6){
                a[6]++;
            }else if(elArray[i].talla() == 7){
                a[7]++;
            }else if(elArray[i].talla() == 8){
                a[8]++;
            }else if(elArray[i].talla() >= 9){
                a[9]++;
            }
        }
        
        for (int i=0; i<a.length; i++){
            res += i + "\t" + a[i] + "\n";
        }
        return res;
    }
}