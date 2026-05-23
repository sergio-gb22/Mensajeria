
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sergio García de Baya y Joaquín Torrubia Oria
 */
public class Mensaje {
    //Atributos:

    private static String APIPA = "169.254.0.1";
    private String usuario;
    private GregorianCalendar fecha;
    private String ip;
    private String texto;
    //Constructores:

    public Mensaje() {
        this.usuario = "System";
        this.fecha = new GregorianCalendar();
        this.ip = APIPA;
        this.texto = encripta("Por defecto");
    }

    public Mensaje(String usuario, String ip, String texto) {
        this.usuario = usuario;
        this.fecha = new GregorianCalendar();
        if (esValida(ip)) {
            this.ip = ip;
        } else {
            this.ip = APIPA;
        }
        this.texto = encripta(texto);
    }
    //Metodos:

    public String getFecha() {
        //Entorno;
        int dia, mes, anio;
        //Algoritmo:
        dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
        mes = fecha.get(GregorianCalendar.MONTH);
        anio = fecha.get(GregorianCalendar.YEAR);
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    public String getTexto() {
        return desencripta(texto);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getIp() {
        return ip;
    }

    private static boolean esValida(String ip) {
        //Entorno:
        boolean resultado;
        //Algoritmo:

        resultado = ip.matches("^(25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]"
                + "|[1-9])\\.(25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|"
                + "[1-9])\\.(25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|"
                + "[1-9])\\.(25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|"
                + "[1-9])$");
        return resultado;
    }

    private static String reverse(String cad) {
        //Entorno:
        String[] palabras;
        int i, p;
        String resultado;
        //Algoritmo:
        palabras = cad.split(" ");
        resultado = "";
        for (i = 0; i < palabras.length; i++) {
            for (p = palabras[i].length() - 1; p >= 0; p--) {
                resultado = resultado + palabras[i].charAt(p);
            }
        }
        return resultado;
    }

    private static String desencripta(String msg) {

        //Entorno:
        String resultado;

        //Algoritmo:
        resultado = reverse(msg);
        return resultado;
    }

    private static String encripta(String msg) {

        //Entorno:
        String resultado;

        //Algoritmo:
        resultado = reverse(msg);
        return resultado;
        
        
      
    }
    
    
}
