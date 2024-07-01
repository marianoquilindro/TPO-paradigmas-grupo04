import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Muebleria {
    private List<Mueble> inventario;

    public Muebleria() {
        inventario = new ArrayList<>();
    }

    public void agregarOModificarMueble(Mueble mueble) {
        for (Mueble m : inventario) {
            if (m.getTipo().equals(mueble.getTipo()) && m.getMaterial().equals(mueble.getMaterial())) {
                m.setStock(m.getStock() + mueble.getStock());
                if (mueble.getPrecio() > m.getPrecio()) {
                    m.setPrecio(mueble.getPrecio());
                }
                return;
            }
        }
        inventario.add(mueble);
    }

    public List<Mueble> buscarYOrdenarMuebles(String tipo, String material, String orden) {
        List<Mueble> resultados = new ArrayList<>();
        for (Mueble mueble : inventario) {
            if ((tipo == null || tipo.isEmpty() || mueble.getTipo().equalsIgnoreCase(tipo)) &&
                    (material == null || material.isEmpty() || mueble.getMaterial().equalsIgnoreCase(material))) {
                resultados.add(mueble);
            }
        }
        if (orden != null) {
            Comparator<Mueble> comparator = "Precio Ascendente".equals(orden) ? Comparator.comparing(Mueble::getPrecio)
                    : "Precio Descendente".equals(orden) ? Comparator.comparing(Mueble::getPrecio).reversed()
                    : "Stock Ascendente".equals(orden) ? Comparator.comparing(Mueble::getStock)
                    : Comparator.comparing(Mueble::getStock).reversed();
            resultados.sort(comparator);
        }
        return resultados;
    }

    public void venderMueble(String tipo, String material) throws Exception {
        for (Mueble m : inventario) {
            if (m.getTipo().equals(tipo) && m.getMaterial().equals(material)) {
                if (m.getStock() > 0) {
                    m.setStock(m.getStock() - 1);
                } else {
                    throw new Exception("No hay stock disponible para este mueble.");
                }
                return;
            }
        }
        throw new Exception("Mueble no encontrado.");
    }

    public void eliminarMueble(String tipo, String material) {
        inventario.removeIf(m -> m.getTipo().equals(tipo) && m.getMaterial().equals(material));
    }

    public List<Mueble> getInventario() {
        return new ArrayList<>(inventario);
    }

    public void ordenar(List<Mueble> muebles, String criterio) {
        Comparator<Mueble> comparator = criterio.equals("Precio Ascendente") ? Comparator.comparing(Mueble::getPrecio)
                : criterio.equals("Precio Descendente") ? Comparator.comparing(Mueble::getPrecio).reversed()
                : criterio.equals("Stock Ascendente") ? Comparator.comparing(Mueble::getStock)
                : Comparator.comparing(Mueble::getStock).reversed();
        muebles.sort(comparator);
    }
}
