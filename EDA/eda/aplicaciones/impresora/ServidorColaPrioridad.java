package aplicaciones.impresora;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import librerias.estructurasDeDatos.jerarquicos.MonticuloBinarioR0;

/** Clase ServidorColaPrioridad: implementa un ServidorDeImpresion
 *  que usa un modelo de maxima prioridad (ColaPrioridad) para 
 *  gestionar los trabajos en espera que almacena.
 *  
 *  @author (profesores EDA 16-17)
 *  @version (04 2017)
 */

public class ServidorColaPrioridad implements ServidorDeImpresion {
    
    // Un ServidorColaPrioridad TIENE UNA ColaPrioridad cP 
    // de trabajos en espera
    private ColaPrioridad<Trabajo> cP;
    
    /** Crea un Servidor de Impresion vacio. */
    public ServidorColaPrioridad() { 
        /*COMPLETAR*/
        cP = new MonticuloBinarioR0<Trabajo>();
    }
    
    /** Incluye un nuevo trabajo en espera t en un ServidorDeImpresion.
     *  @param t   Trabajo
     */
    public void insertar(Trabajo t) { 
        /*COMPLETAR*/
        cP.insertar(t);
    }
    
    /** Comprueba si hay algun trabajo en espera en un ServidorDeImpresion.
     *  @return boolean
     */
    public boolean hayTrabajos() { 
        /*COMPLETAR*/
        return !cP.esVacia();
    }
    
    /** SII hayTrabajos(): devuelve el Trabajo de un ServidorDeImpresion
     *  que va a ser impreso.
     *  @return Trabajo
     */
    public Trabajo getTrabajo() { 
        /*COMPLETAR*/
        if(!cP.esVacia()) return cP.recuperarMin();
        else return null;
    }
    
    /** SII hayTrabajos(): elimina de un ServidorDeImpresion el 
     *  trabajo que va a ser impreso y devuelve el tiempo que 
     *  este tardara en imprimirse, en base a la velocidad de la impresora.
     *  @return int (seg.)
     */
    public int imprimirTrabajo() { 
        /*COMPLETAR*/
        if(!cP.esVacia()){
            Trabajo t = cP.eliminarMin();
            int tiempoImpresion = 60 * t.getNumPaginas() / PAGINAS_POR_MINUTO;
            return tiempoImpresion;
        }
        return -1;
    }
}
