package cl.duoc.speedfast.gestores;
/**
 * CLASE RESPONSABLE DE GESTIONAR LOS PEDIDOS
 */
import cl.duoc.speedfast.model.EstadoPedido;
import cl.duoc.speedfast.model.Pedido;
import cl.duoc.speedfast.service.ZonaDeCarga;

import static cl.duoc.speedfast.utils.ConsolaIU.RESET;
import static cl.duoc.speedfast.utils.ConsolaIU.verde;

public class Repartidor implements Runnable {

    private final String nombreRepartidor;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombreRepartidor, ZonaDeCarga zonaDeCarga) {
        this.nombreRepartidor = nombreRepartidor;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                System.out.println("-> NO HAY PEDIDOS PENDIENTES <-");
                break;
            }

            try {
                pedido.setEstadoPedido(EstadoPedido.EN_REPARTO);
                System.out.println("[Repartidor/a " + verde + nombreRepartidor + RESET + "]" + " Retiro el pedido numero "
                        + pedido.getCodigoPedido() + ", y va en camino a " + pedido.getDireccionEntrega() + " a entregarlo." +
                        "\n      -> PEDIDO " + pedido.getEstadoPedido()+ "<-      ");
                System.out.println("");
                Thread.sleep(5000);

                pedido.setEstadoPedido(EstadoPedido.ENTREGADO);

                System.out.println("[Repartidor/a " + verde + nombreRepartidor + RESET + "] entregando el pedido numero " +
                        pedido.getCodigoPedido() + "\n      -> PEDIDO " + pedido.getEstadoPedido()+ "<-      ");
            } catch (InterruptedException e) {
                System.out.println("[Repartidor/a " + verde + nombreRepartidor + RESET + "] no logro entregar el pedido con exito.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
