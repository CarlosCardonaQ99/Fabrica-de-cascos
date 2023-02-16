package fabricadecascos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Fabrica f = new Fabrica(new ArrayList<>());
        cargarFabrica(f);


        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una opción: ");
        System.out.println("1. --> Listar cascos");
        System.out.println("2. --> Listar cascos por tipo");
        System.out.println("3. --> borrar casco por ID ");
        System.out.println("4. --> Calcular porcentaje de cascos por tipo ");
        option = Integer.parseInt(sc.next());


        switch (option) {
            case 1: {
                f.listarCascos();
                break;
            }
            case 2: {
                ArrayList<Casco> listaDeCascos = f.listarCascosPorTipo(TipoCasco.ABATIBLE);
                for (Casco casco : listaDeCascos) {
                    System.out.println(casco);

                }
            }
            break;
            case 3: {
                f.borrarCasco("ABC123");

            }
            break;
            case 4: {
                double[] porcs = f.porcCascosPorTipo("Sucursal A");
                for (int i = 0; i < porcs.length; i++) {
                    System.out.println(porcs[i]);
                }
            }
            break;

            default: {
                System.out.println("Error");
            }
        }

    }

    private static void cargarFabrica(Fabrica f) {
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B ");

        s1.agregarCasco(new Casco("ABC123", 200000, TipoCasco.ABATIBLE));
        s1.agregarCasco(new Casco("123FDS", 450000, TipoCasco.INTEGRAL));
        s1.agregarCasco(new Casco("DFG567", 200000, TipoCasco.INTEGRAL));
        s1.agregarCasco(new Casco("JHGF54", 220000, TipoCasco.ABATIBLE));
        s1.agregarCasco(new Casco("SDA768", 560000, TipoCasco.CROSS));
        s1.agregarCasco(new Casco("WASD", 100000, TipoCasco.CROSS));
        s1.agregarCasco(new Casco("AWS123", 45600, TipoCasco.DESTAPADO));


        s2.agregarCasco(new Casco("CDR234", 200000, TipoCasco.CROSS));
        s2.agregarCasco(new Casco("789YDF", 400000, TipoCasco.CROSS));
        s2.agregarCasco(new Casco("DFG453", 400000, TipoCasco.ABATIBLE));


        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }
}