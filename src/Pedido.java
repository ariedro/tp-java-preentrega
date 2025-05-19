import java.util.ArrayList;

public class Pedido {
  private int id;
  private ArrayList<Producto> productos;

  static int idActual = 0;

  public Pedido() {
    this.id = idActual++;
    this.productos = new ArrayList<Producto>();
  }

  public void imprimir() {
    System.out.println("Pedido [" + this.id + "]:");
    for (Producto producto : this.productos) {
      producto.imprimir();
    }
  }

  public void agregarProducto(Producto producto, int cantidad) throws StockInsuficienteException {
    producto.sacar(cantidad);
    Producto productoAAgregar = new Producto(producto.getNombre(), producto.getPrecio(), cantidad);
    this.productos.add(productoAAgregar);
  }

  public float getCostoTotal() {
    float suma = 0;
    for (Producto producto : this.productos) {
      suma += producto.getPrecio();
    }
    return suma;
  }
}
