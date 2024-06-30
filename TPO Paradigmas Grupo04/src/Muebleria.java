import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muebleria {
    private List<Mueble> inventario;

    public Muebleria() {
        this.inventario = new ArrayList<>();
    }

    public void agregarOModificarMueble(Mueble mueble) {
        String tipoMinuscula = mueble.getTipo().toLowerCase();
        String materialMinuscula = mueble.getMaterial().toLowerCase();

        for (Mueble m : inventario) {
            if (m.getTipo().toLowerCase().equals(tipoMinuscula) && m.getMaterial().toLowerCase().equals(materialMinuscula)) {
                m.setStock(m.getStock() + mueble.getStock());
                return;
            }
        }
        inventario.add(mueble);
    }

    public List<Mueble> buscarYOrdenarMuebles(String tipo, String material, String orden) {
        List<Mueble> resultados = inventario.stream()
                .filter(mueble -> (tipo.isEmpty() || mueble.getTipo().toLowerCase().contains(tipo.toLowerCase())) &&
                        (material.isEmpty() || mueble.getMaterial().toLowerCase().contains(material.toLowerCase())))
                .collect(Collectors.toList());

        if (orden != null) {
            ordenar(resultados, orden);
        }

        return resultados;
    }

    public void venderMueble(String tipo, String material) throws Exception {
        for (Mueble m : inventario) {
            if (m.getTipo().equalsIgnoreCase(tipo) && m.getMaterial().equalsIgnoreCase(material)) {
                m.reducirStock(1);
                return;
            }
        }
        throw new Exception("Mueble no encontrado.");
    }

    public void eliminarMueble(String tipo, String material) {
        inventario.removeIf(mueble -> mueble.getTipo().equalsIgnoreCase(tipo) && mueble.getMaterial().equalsIgnoreCase(material));
    }

    public List<Mueble> getInventario() {
        return new ArrayList<>(inventario);
    }

    public void ordenar(List<Mueble> muebles, String orden) {
        switch (orden) {
            case "Precio Ascendente":
                muebles.sort((m1, m2) -> Integer.compare(m1.getPrecio(), m2.getPrecio()));
                break;
            case "Precio Descendente":
                muebles.sort((m1, m2) -> Integer.compare(m2.getPrecio(), m1.getPrecio()));
                break;
            case "Stock Ascendente":
                muebles.sort((m1, m2) -> Integer.compare(m1.getStock(), m2.getStock()));
                break;
            case "Stock Descendente":
                muebles.sort((m1, m2) -> Integer.compare(m2.getStock(), m1.getStock()));
                break;
            default:
                break;
        }
    }
}