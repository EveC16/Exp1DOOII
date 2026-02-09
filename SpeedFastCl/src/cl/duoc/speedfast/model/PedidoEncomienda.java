package cl.duoc.speedfast.model;
/**
 * REPRESENTA EL SERVICIO DE ENTREGA EXPRESS Y EXTIENDE DE LA CLASE PEDIDO
 */
public class PedidoEncomienda extends Pedido {

    private String remitente;

    public PedidoEncomienda(int codigoPedido, String direccionEntrega, PrioridadPedido prioridadPedido, String remitente) {
        super(codigoPedido, direccionEntrega, prioridadPedido);
        this.remitente = remitente;
    }
}
