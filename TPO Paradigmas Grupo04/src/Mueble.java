public class Mueble {
    private String tipo;
    private String material;
    private int stock;
    private int precio;

    public Mueble(String tipo, String material, int stock, int precio) {
        this.tipo = tipo;
        this.material = material;
        this.stock = stock;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void reducirStock(int cantidad) throws Exception {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            throw new Exception("Stock insuficiente.");
        }
    }
}
