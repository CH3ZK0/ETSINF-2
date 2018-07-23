 

/**
 * Write a description of class AppPilaAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/** ESTA CLASE NO DEBE MODIFICARSE: 
    COMPILARA SIN ERRORES Y SE EJECUTARA CORRECTAMENTE
    CUANDO SE HAYA IMPLEMENTADO ADECUADAMENTE
    LA CLASE PilaAL Y LA INTERFAZ Pila
   */

public class AppPilaAL {
    public static void main (String[] args) throws Exception {
        Pila<Integer> pi = new PilaAL<Integer>();
        
        for (int i=1; i<=10; i++) pi.apilar(i);        
        System.out.println("Pila(enteros)= "+pi);
        
        int n=5;
        for (int i=0; i<n; i++) pi.desapilar();
        System.out.println("Pila(desapilados "+n+" elementos)= "+pi);
     
        int m=3;
        for (int i=1; i<=m; i++) pi.apilar(i);
        System.out.println("Pila(apilados "+m+" elementos)= "+pi);  
        
        Pila<Character> pc = new PilaAL <Character>();
        
        for (char i='a'; i<='f'; i++) pc.apilar( new Character(i) );        
        System.out.println("Pila(caracteres)= "+pc);
        
        int r=3;
        for (int i=0; i<r ; i++) pc.desapilar();
        System.out.println("Pila(desapilados "+r+" elementos)= "+pc);
     
        int s = 4;
        char t = (char)(((int)'k')+s);
        for (char i='k'; i<t; i++) pc.apilar( new Character(i) );
        System.out.println("Pila(apilados "+s+" elementos)= "+pc);
    }
}