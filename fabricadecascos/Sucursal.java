package fabricadecascos;

import java.util.ArrayList;
import java.util.Iterator;

public class Sucursal {
    private String nombreSucursal;
    private ArrayList<Casco> cascos;

    public Sucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.cascos = new ArrayList<>();
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void agregarCasco(Casco casc) {
        cascos.add(casc);
    }

    public void listarCascos() {
        for (Casco casco : cascos) {
            System.out.println(casco);
        }
    }

    public ArrayList<Casco> listarCascosPorTipo(TipoCasco tipo) {
        ArrayList<Casco> cascoEncontradoPorTipo = new ArrayList<>();
        for (Casco casco : cascos) {
            if (casco.getTipoCasco() == tipo) {
                cascoEncontradoPorTipo.add(casco);
            }
        }
        return cascoEncontradoPorTipo;
    }

    //Método buscar Cascos usando la propiedad Iterator, la más universal para hacer búsquedas lineales

    private Casco buscarCascos(String ID) {
        Casco cascoEncontrado = null;
        Iterator<Casco> it = this.cascos.iterator();
        while (it.hasNext() && cascoEncontrado == null) {
            Casco c = it.next();
            if (c.getID().equalsIgnoreCase(ID)) {
                cascoEncontrado = c;
            }
        }
        return cascoEncontrado;
    }

    public double[] porcCascosPorTipo() {
        final int CANT_INSTRUMENTOS = TipoCasco.values().length;
        double[] porcentajes = new double[CANT_INSTRUMENTOS];
        for (Casco casco : cascos) {
            porcentajes[casco.getTipoCasco().ordinal()]++;
        }
        porcentajeAbsoluto(porcentajes);
        return porcentajes;
    }

    private void porcentajeAbsoluto(double[] porcentajes) {
        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = (porcentajes[i] * 100) / cascos.size();
        }
    }

    public Casco borrarCasco(String ID) {
        Casco cascoABorrar = buscarCascos(ID);
        this.cascos.remove(cascoABorrar);
        return cascoABorrar;
    }
}

