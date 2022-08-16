package Entidades;

public class Oferta {
    private String idOferta;
    BilleteraVirtual billeteraVendedor;
    private CriptoMoneda criptoMoneda;
    private Double cantidadOfrecida;
    private Double precioPorUnidad;

    public String getIdOferta() {
        return idOferta;
    }

    public CriptoMoneda getCriptoMoneda() {
        return criptoMoneda;
    }

    public Double getCantidadOfrecida() {
        return cantidadOfrecida;
    }

    public Double getPrecioPorCantida(Double cantidad) {
        return precioPorUnidad * cantidad;
    }

    public BilleteraVirtual getbilleteraVendedor(){return billeteraVendedor;}

    public Oferta(BilleteraVirtual billeteraVendedor, CriptoMoneda criptoMoneda, Double cantidadOfrecida, Double precioPorUnidad) {
        this.billeteraVendedor = billeteraVendedor;
        this.criptoMoneda = criptoMoneda;
        this.cantidadOfrecida = cantidadOfrecida;
        this.precioPorUnidad = precioPorUnidad;
    }
}
