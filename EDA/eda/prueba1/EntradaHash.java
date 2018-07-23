package prueba1;

/** Clase envolvente del par (clave, valor) de una Tabla Hash para 
 *  usar como dato en la ListaConPI que representa cada cubeta
 *  @author (EXAMEN EDA)
 *  @version (Abril 2017)
 *  @param <C>, el tipo de las claves
 *  @param <V>, el tipo de los valores asociados a las claves
 */
class EntradaHash<C, V> {    
    protected C clave;
    protected V valor;
    EntradaHash(C c, V v) {
        this.clave = c; this.valor = v;
    }
}