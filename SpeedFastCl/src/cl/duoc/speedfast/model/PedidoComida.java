package cl.duoc.speedfast.model;
/**
 * REPRESENTA EL SERVICIO DE ENTREGA EXPRESS Y EXTIENDE DE LA CLASE PEDIDO
 */
public class PedidoComida extends Pedido {

    private String nombreRestaurante;

    public PedidoComida(int codigoPedido, String direccionEntrega, PrioridadPedido prioridadPedido, String nombreRestaurante) {
        super(codigoPedido, direccionEntrega, prioridadPedido);
        this.nombreRestaurante = nombreRestaurante;
    }
}
