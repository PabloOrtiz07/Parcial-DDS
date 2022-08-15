package Estados;

import Entidades.Cliente;

public abstract class NivelUsuario {

    Cliente cliente;

    public NivelUsuario(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract double comisionPorVentaP2P(Double precioVenta);
    public abstract double recargoPorCompraAlExchange(Double precioCompra);
    public abstract double comisionPorConversionCriptomonedas(Double valorEnDolares);

}

