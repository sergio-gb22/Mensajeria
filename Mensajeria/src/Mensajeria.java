
import java.util.GregorianCalendar;



/**
 *
 * @author Sergio García de Baya y Joaquín Torrubia Oria
 */
public class Mensajeria {

    public static void main(String[] args) {
        //Entorno:
            String usuario;
            String ip;
            String texto;
            Mensaje mensaje;
            int opcion;
            Cola mcola;
            boolean acabar;
            char salir;
       //Algoritmo:
            acabar=true;
            mcola = new Cola();
            do {
                System.out.println ("1. Envío instantáneo");
                System.out.println ("2. Enviar mensaje");
                System.out.println ("3. Recibir mensaje");
                System.out.println ("4. Salir");
                System.out.println("");
                opcion = Leer.datoInt();
                
                switch (opcion) {
                    case 1:
                        mensaje = new Mensaje();
                        mcola.meterEnCola(mensaje);
                        System.out.println("Mensaje Enviado");
                        System.out.println("");
                        break;
                    case 2:
                        do {
                            System.out.println ("Introduzca usuario:");
                            usuario = Leer.dato().trim();
}                       while (!usuario.matches("[a-zA-Z][a-zA-Z0-9]*"));
                        System.out.println ("Introduzca la IP:");
                        ip = Leer.dato().trim();
                        System.out.println ("Introduzca el texto:");
                        texto = Leer.dato().trim();
                        mensaje = new Mensaje (usuario, ip, texto);
                        mcola.meterEnCola(mensaje);
                        System.out.println("Mensaje Enviado");
                        break;
                    case 3:
                        mensaje = (Mensaje) mcola.sacarDeCola();
                        if (mensaje == null) {
                            System.out.println ("No hay mas mensajes");
                        }else{
                            System.out.print ("Usuario: " + mensaje.getUsuario() + "\n");
                            System.out.print ("Fecha: " + mensaje.getFecha() + "\n");
                            System.out.print ("IP: " + mensaje.getIp() + "\n");
                            System.out.print ("Texto: \n" + mensaje.getTexto());
                            System.out.println("");
                        }//Fin Si
                        break;
                    case 4:
                        if (mcola.esColaVacia()==true) {
                            acabar = false;
                        }
                        if (mcola.esColaVacia()==false) {
                            do {
                            System.out.println("Hay mensajes pendientes de "
                                    + "recibir ¿Salir de todas formas? (S/N)");                         
                                salir = Leer.datoChar();
                            } while (salir != 'S' && salir != 'N');
                            if (salir == 'S') {
                                acabar = false;
                            }//Fin Si
                        }//Fin Si
                        System.out.println("");
                }//Fin Segun Sea
            } while (acabar != false);
    }//Fin Programa
}
