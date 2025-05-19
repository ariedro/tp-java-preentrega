public class Producto {
  private int id;
  private String nombre;
  private float precio;
  private int stock;

  static int idActual = 0;

  public Producto(String nombre, float precio, int stock) {
    this.id = idActual++;
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
  }

  public void imprimir() {
    System.out.println("[" + this.id + "] " + this.nombre + " $" + this.precio + " (" + this.stock + ")");
  }

  public int getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public float getPrecio() {
    return this.precio;
  }

  public void setNombre(String nuevoNombre) {
    this.nombre = nuevoNombre;
  }

  public void setPrecio(float nuevoPrecio) {
    this.precio = nuevoPrecio;
  }

  public void sacar(int cantidad) throws StockInsuficienteException {
    if (this.stock < cantidad) {
      throw new StockInsuficienteException();
    }
    this.stock -= cantidad;
  }
}
