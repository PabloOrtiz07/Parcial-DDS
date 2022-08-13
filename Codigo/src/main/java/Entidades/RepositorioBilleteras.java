package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioBilleteras {

    private static RepositorioBilleteras repositorioBilleteras = null;
    public static  RepositorioBilleteras getInstance(){
        if(repositorioBilleteras == null){
            repositorioBilleteras = new RepositorioBilleteras();
        }
        return  repositorioBilleteras;
    }
    private List<BilleteraVirtual> billeterasVirtuales=new ArrayList<>();

    public  void agregarBilleteraVirtual(BilleteraVirtual billeteraVirtual)throws Exception{
        if(repositorioBilleteras.existeBilleteraVirtual(billeteraVirtual.getIdBilleteraVirtual()))
            throw  new Exception("No se pudo crear la billtera. Ya existe una con el mismo id");
        billeterasVirtuales.add(billeteraVirtual);
    }

    public Boolean existeBilleteraVirtual(String  idBilletera){
        return billeterasVirtuales.stream().anyMatch(billeteraVirtual ->billeteraVirtual.getIdBilleteraVirtual().equals(idBilletera));
    }

    public BilleteraVirtual getBilleteraVirtualPorId (String idBilletera) throws NoSuchElementException{
        return billeterasVirtuales.stream().filter(billeteraVirtual -> idBilletera.equals(billeteraVirtual.getIdBilleteraVirtual())).findAny().get();
    }

    public List<BilleteraVirtual> getBilleterasVirtuales() {
        return billeterasVirtuales;
    }

    public void setBilleterasVirtuales(List<BilleteraVirtual> billeterasVirtuales) {
        this.billeterasVirtuales = billeterasVirtuales;
    }

    //Agrego en el constructor que se inicializen unas organizaciones default;
    public RepositorioBilleteras(){
        try {
            BilleteraVirtual billeteraVirtualMaestra = new BilleteraVirtual("00", 10000.0);
            billeterasVirtuales.add(billeteraVirtualMaestra);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
