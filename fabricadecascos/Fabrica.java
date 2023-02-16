package fabricadecascos;

import java.util.ArrayList;
import java.util.Iterator;

public class Fabrica {
    private ArrayList<Sucursal> sucursales;

    public Fabrica() {
        this.sucursales = new ArrayList<>();
    }


    public Fabrica(ArrayList<Sucursal> sucursales) {
        this.sucursales = new ArrayList<>();
    }


    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void agregarSucursal(Sucursal suc) {
        sucursales.add(suc);
    }

    public void listarCascos() {
        for (Sucursal sucursal : sucursales) {
            System.out.println(sucursal.getNombreSucursal());
            sucursal.listarCascos();
        }
    }

    public ArrayList<Casco> listarCascosPorTipo(TipoCasco tipo) {
        ArrayList<Casco> cascoEncontradoPorTipo = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            cascoEncontradoPorTipo.addAll(sucursal.listarCascosPorTipo(tipo));
        }
        return cascoEncontradoPorTipo;
    }

    private Sucursal buscarSucursal(String nombreSucursal) {
        Sucursal sucursalEncontrada = null;
        Iterator<Sucursal> s = this.sucursales.iterator();
        while (s.hasNext() && sucursalEncontrada == null) {
            Sucursal suc = s.next();
            if (suc.getNombreSucursal().equalsIgnoreCase(nombreSucursal)) {
                sucursalEncontrada = suc;
            }
        }
        return sucursalEncontrada;
    }

    public double[] porcCascosPorTipo(String nombreSucursal) {

            double[] porcentajes = null;
            Sucursal sucursalEncontrada = buscarSucursal(nombreSucursal);
            if (sucursalEncontrada != null) {
                porcentajes = sucursalEncontrada.porcCascosPorTipo();
                System.out.println("Porcentaje de cascos por tipo:");
            } return porcentajes;


        }





    //Borrar cascos a nivel de fábrica
    public Casco borrarCasco(String ID) {
        Casco borrado = null;
        int i = 0;
        while (i < sucursales.size() && borrado == null) {
            borrado = sucursales.get(i).borrarCasco(ID);
            i++;
        }
        return borrado;
    }

}
