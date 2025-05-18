import java.util.ArrayList;

public class Pedido {
  private int id;
  private ArrayList<Producto> productos;
  private float costoTotal;

  static int idActual = 0;

  public Pedido() {
    this.id = idActual++;
    this.productos = new ArrayList<Producto>();
    this.costoTotal = 0;
  }

  public void imprimir() {
    System.out.println("Pedido [ " + this.id + ']');
    for (Producto producto : this.productos) {
      producto.imprimir();
    }
  }

  public void agregarProducto(Producto producto, int cantidad) {
    producto.sacar(cantidad);
    this.productos.add(producto);
    this.costoTotal += producto.getPrecio() * cantidad;
  }

  public float getCostoTotal() {
    return this.costoTotal;
  }
}
