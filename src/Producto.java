public class Producto {
  private int id;
  private String nombre;
  private float precio;

  static int idActual = 0;

  public Producto(String nombre, float precio) {
    this.id = idActual++;
    this.nombre = nombre;
    this.precio = precio;
  }

  public void imprimir() {
    System.out.println("[" + this.id + "] " + this.nombre + " ($" + this.precio + ")");
  }

  public int getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }
}
