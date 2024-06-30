import java.util.List;

public class Reporte {
    private List<Mueble> inventario;
    private List<Venta> registroVentas;

    public Reporte(List<Mueble> inventario, List<Venta> registroVentas) {
        this.inventario = inventario;
        this.registroVentas = registroVentas;
    }

    public String generarReporteInventario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Inventario:\n");
        for (Mueble mueble : inventario) {
            reporte.append("Tipo: ").append(mueble.getTipo()).append(", Material: ").append(mueble.getMaterial())
                    .append(", Stock: ").append(mueble.getStock()).append(", Precio: ").append(mueble.getPrecio()).append("\n");
        }
        return reporte.toString();
    }

    public String generarReporteVentas() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Ventas:\n");
        for (Venta venta : registroVentas) {
            reporte.append("Venta: ").append(venta.getTipo()).append(" de ").append(venta.getMaterial())
                    .append(", Fecha: ").append(venta.getFechaVenta()).append("\n");
        }
        return reporte.toString();
    }
}