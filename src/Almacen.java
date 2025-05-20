import java.util.ArrayList;

public class Almacen {
  private ArrayList<Producto> productos;

  public Almacen() {
    this.productos = new ArrayList<Producto>();
  }

  public void agregarProducto(Producto nuevoProducto) {
    this.productos.add(nuevoProducto);
  }

  public void listarProductos() {
    for (Producto producto : productos) {
      producto.imprimir();
    }
  }

  public Producto buscarProducto(int idBuscada) {
    for (Producto producto : productos) {
      if (producto.getId() == idBuscada) {
        return producto;
      }
    }
    return null;
  }

  public Producto buscarProducto(String nombreBuscado) {
    for (Producto producto : productos) {
      if (producto.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
        return producto;
      }
    }
    return null;
  }

  public void eliminarProducto(Producto producto) {
    productos.remove(producto);
  }

}
