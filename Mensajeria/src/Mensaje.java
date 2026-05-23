
import java.util.GregorianCalendar;


/**
 *
 * @author Sergio García de Baya y Joaquín Torrubia Oria
 */
public class Mensaje {
    //Atributos:
        private String APIPA = "169.254.0.1";
        private String usuario;
        private GregorianCalendar fecha;
        private String ip;
        private String texto;
    //Constructores:
        public Mensaje() {
            this.usuario="System";
            this.fecha= new GregorianCalendar();
            this.ip=APIPA;
            this.texto="Por defecto";
        }
        
        public Mensaje(String usuario, String ip, GregorianCalendar fecha, String texto) {   
                this.usuario=usuario;
                this.fecha= new GregorianCalendar();
                
                this.texto=texto;
        }
    //Metodos:

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public String getTexto() {
        return texto;
    }
    
    private boolean esValida (String ip) {
        //Etorno:
            String valido;
        //Algoritmo:
            if (ip) {
                valido="^(?:(?:25[0-5]|2[0-4]\d|1?\d{1,2})(?:\.(?!$)|$)){4}$";
            }else{
                valido=false;
            }//Fin Si
            return valido;
    }
        
}
