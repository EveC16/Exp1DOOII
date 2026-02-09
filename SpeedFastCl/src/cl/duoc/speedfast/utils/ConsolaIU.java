package cl.duoc.speedfast.utils;
/**
 * RESPONSABLE DEL FORMATO DE LA CONSOLA
 */
public class ConsolaIU {

    public static final String RESET = "\u001B[0m";

    public static final String rojo = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";

    public static void mostrarEncabezado() {
        System.out.println(azul + "================================");
        System.out.println(azul + "=======ENTREGAS SPEEDFAST=======");
        System.out.println(azul + "================================" + RESET);
    }

    public static void mostrarMensajeFinal(){
        System.out.println("");
        System.out.println(azul + "->   ZONA DE CARGA VACÍA, HASTA PRONTO  <-" + RESET);
    }
}