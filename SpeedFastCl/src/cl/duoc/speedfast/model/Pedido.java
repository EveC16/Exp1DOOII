package cl.duoc.speedfast.model;

/**
 *  CLASE SUPER ABSTRACTA TIENE RELACIÓN DE HERENCIA CON LAS CLASES PEDIDO COMIDA, PEDIDO ENCOMIENDA Y PEDIDO EXPRESS
 */

public abstract class Pedido implements Comparable<Pedido>{

    protected int codigoPedido;
    protected String direccionEntrega;
    protected EstadoPedido estadoPedido; // PENDIENTE, EN_REPARTO, ENTREGADO
    protected PrioridadPedido prioridadPedido; // ALTA, MEDIA, BAJA

    public Pedido(int codigoPedido, String direccionEntrega, PrioridadPedido prioridadPedido) {
        this.codigoPedido = codigoPedido;
        this.direccionEntrega = direccionEntrega;
        this.prioridadPedido = prioridadPedido;
    }

    // COMPARA LOS PEDIDOS CON USO DE .ORDINAR() PARA ACCEDER A LA POSICIÓN DEL ENUM
      @Override
      public int compareTo(Pedido diferente) {
            return Integer.compare(this.prioridadPedido.ordinal(), diferente.prioridadPedido.ordinal());
      }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public PrioridadPedido getPrioridadPedido() {
        return prioridadPedido;
    }

    public void setEstadoPedido(Enum nuevoEstadoPedido){

    }

        @Override
        public String toString() {
            return "Pedido: " + "codigoPedido: " + codigoPedido + ", direccionEntrega: " + direccionEntrega + '\'' +
                    ", estadoPedido: " + estadoPedido + ", prioridadPedido: " + prioridadPedido + ", prioridad de pedido: "
                    + prioridadPedido;
        }
}
