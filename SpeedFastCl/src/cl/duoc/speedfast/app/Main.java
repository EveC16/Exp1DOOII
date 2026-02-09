package cl.duoc.speedfast.app;
/**
 * CLASE PRINCIPAL RESPONSABLE DE INSTANCIAR LOS PEDIDOS Y ORQUESTAR LOS HILOS
 */
import cl.duoc.speedfast.gestores.Repartidor;
import cl.duoc.speedfast.model.*;
import cl.duoc.speedfast.service.ZonaDeCarga;
import cl.duoc.speedfast.utils.ConsolaIU;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        ConsolaIU.mostrarEncabezado();

        zonaDeCarga.agregarPedido(new PedidoComida(1315, "Av. La Florida N° 1698, comuna de "
                + "La Florida", PrioridadPedido.ALTA, "Tengo Hambre"));
        zonaDeCarga.agregarPedido(new PedidoExpress(1316, "Macul N° 1302, comuna de Macul",
                PrioridadPedido.ALTA, "Rapido & Furioso"));
        zonaDeCarga.agregarPedido(new PedidoEncomienda(1317, "Maipu N° 908, comuna de Maipu",
                PrioridadPedido.BAJA, "Compras Innecesarias"));
        zonaDeCarga.agregarPedido(new PedidoComida(1318, "Calle Perdida N° 902, comuna de " +
                "Santiago", PrioridadPedido.MEDIA, "Pizza y Arroz Chino"));
        zonaDeCarga.agregarPedido(new PedidoExpress(1319, "En el mar, N° 108, comuna " +
                "de Viña del Mar", PrioridadPedido.ALTA, "Lo Merezco"));

        Thread t1 = new Thread(new Repartidor("Marcelo", zonaDeCarga));
        Thread t2 = new Thread(new Repartidor("Cristiano", zonaDeCarga));
        Thread t3 = new Thread(new Repartidor("Deyna", zonaDeCarga));

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch(InterruptedException e){
            System.out.println("Error");
        }
        ConsolaIU.mostrarMensajeFinal();
    }
}