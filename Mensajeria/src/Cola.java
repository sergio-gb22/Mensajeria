
import java.util.LinkedList;



/**
 *
 * @author Sergio García de Baya y Joaquín Torrubia Oria
 */
public class Cola {
    //Atributos:
        private LinkedList<Object> tCola;
    //Constructores:
        public Cola() {
            tCola = new LinkedList<>();
        }
        
    //Metodos:
        public void meterEnCola (Object obj) {
            tCola.addLast(obj);
        }
        
        public Object sacarDeCola() {
            //Entorno:
                Object resultado;
            //Algoritmo:
                if (esColaVacia()) {
                    resultado = null;
                }else{
                    resultado = tCola.removeFirst();
                }//Fin Si
                return resultado;
        }
        
        public boolean esColaVacia() {
            return tCola.isEmpty();
        }
}
