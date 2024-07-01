import java.util.Date;

public class Venta {
    private String tipo;
    private String material;
    private Date fechaVenta;

    public Venta(String tipo, String material) {
        this.tipo = tipo;
        this.material = material;
        this.fechaVenta = new Date(); // Fecha actual
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "tipo='" + tipo + '\'' +
                ", material='" + material + '\'' +
                ", fechaVenta=" + fechaVenta +
                '}';
    }
}
