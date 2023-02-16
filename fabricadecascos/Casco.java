package fabricadecascos;

public class Casco {
    private String ID;
    private double precio;
    private TipoCasco tipoCasco;

    public Casco(String ID, double precio, TipoCasco tipoCasco) {
        this.ID = ID;
        this.precio = precio;
        this.tipoCasco = tipoCasco;
    }

    public TipoCasco getTipoCasco() {
        return tipoCasco;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "ID='" + ID + '\'' +
                ", precio=" + precio +
                ", tipoCasco=" + tipoCasco +
                '}';
    }
}
