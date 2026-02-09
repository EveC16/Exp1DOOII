package cl.duoc.speedfast.service;
/**
 * RESPONSABLE DE MANTENER LOS PEDIDOS DE FORMA ORDENADA Y CONTROLADA
 */
import cl.duoc.speedfast.model.EstadoPedido;
import cl.duoc.speedfast.model.Pedido;

import java.util.ArrayList;
import java.util.List;

import static cl.duoc.speedfast.utils.ConsolaIU.*;

public class ZonaDeCarga {

    private final List<Pedido> pedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p){
        p.setEstadoPedido(EstadoPedido.PENDIENTE);

        pedidos.add(p);

        pedidos.sort((p1, p2) ->
        Integer.compare(p1.getPrioridadPedido().ordinal(), p2.getPrioridadPedido().ordinal())
        );
        System.out.println("Pedido numero: " + rojo + p.getCodigoPedido() +  RESET + " recibido. Estado del pedido -> "
                + rojo + p.getEstadoPedido() + RESET);
    }

    public synchronized Pedido retirarPedido() {
        if (pedidos.isEmpty()) return null;
        return pedidos.remove(0);
    }
}
