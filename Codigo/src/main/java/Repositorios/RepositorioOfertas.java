package Repositorios;

import Entidades.Oferta;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioOfertas {
    private static RepositorioOfertas repositorioOfertas = null;
    public static RepositorioOfertas getInstance(){
        if(repositorioOfertas == null){
            repositorioOfertas = new RepositorioOfertas();
        }
        return repositorioOfertas;
    }
    private List<Oferta> ofertas=new ArrayList<>();

    public void agregarOfertas(Oferta oferta){
        ofertas.add(oferta);
    }

    public Boolean existeOferta(String idOferta){
        return ofertas.stream().anyMatch(billeteraVirtual ->billeteraVirtual.getIdOferta().equals(idOferta));
    }

    public Oferta getOfertaPorId (String idOferta) throws NoSuchElementException{
        return ofertas.stream().filter(oferta -> idOferta.equals(oferta.getIdOferta())).findAny().get();
    }

}
