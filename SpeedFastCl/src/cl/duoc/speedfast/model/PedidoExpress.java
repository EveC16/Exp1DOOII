package cl.duoc.speedfast.model;
/**
 * REPRESENTA EL SERVICIO DE ENTREGA EXPRESS Y EXTIENDE DE LA CLASE PEDIDO
 */
public class PedidoExpress extends Pedido  {

    private String nombreComercio;

    public PedidoExpress(int codigoPedido, String direccionEntrega, PrioridadPedido prioridadPedido, String nombreComercio) {
        super(codigoPedido, direccionEntrega, prioridadPedido);
        this.nombreComercio = nombreComercio;
    }
}
