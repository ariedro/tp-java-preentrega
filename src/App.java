import java.util.ArrayList;

public class App {
    static Menu menu = new Menu();
    static ArrayList<Producto> productos = new ArrayList<Producto>();
    static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        while (opcion != 7) {
            menu.imprimirMainMenu();
            opcion = menu.pedirInt("Elija una opción");
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    crearPedido();
                    break;
                case 6:
                    listarPedidos();
                    break;
            }
        }
    }

    private static void agregarProducto() {
        String nombre = menu.pedirString("Ingrese el nombre");

        float precio = 0;
        while (precio <= 0) {
            precio = menu.pedirFloat("Ingrese el precio");
            if (precio <= 0) {
                System.out.println("Ingrese un precio válido");
            }
        }

        int stock = -1;
        while (stock < 0) {
            stock = menu.pedirInt("Ingrese el stock");
            if (stock < 0) {
                System.out.println("Ingrese un stock válido");
            }
        }

        Producto nuevoProducto = new Producto(nombre, precio, stock);
        productos.add(nuevoProducto);
    }

    private static void listarProductos() {
        for (Producto producto : productos) {
            producto.imprimir();
        }
    }

    private static void buscarProducto() {
        // TODO: Refactor
        Producto productoEncontrado = null;
        int opcionNumerica = 0;
        while (opcionNumerica < 1 || opcionNumerica > 2) {
            opcionNumerica = menu.pedirMenuBusqueda();
            switch (opcionNumerica) {
                // Por id
                case 1:
                    int idBuscada = menu.pedirInt("Ingrese el id del producto que desea buscar");
                    for (Producto producto : productos) {
                        if (producto.getId() == idBuscada) {
                            productoEncontrado = producto;
                            break;
                        }
                    }
                    break;
                // Por nombre
                case 2:
                    String nombreBuscado = menu.pedirString("Ingrese el nombre del producto que desea buscar");
                    for (Producto producto : productos) {
                        if (producto.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
                            productoEncontrado = producto;
                            break;
                        }
                    }
                    break;
            }
        }
        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        productoEncontrado.imprimir();

        String opcionSiNo = "";
        while (!opcionSiNo.contains("S") && !opcionSiNo.contains("N")) {
            opcionSiNo = menu.pedirString("Desea modificar el producto? (S/N)");
        }
        if (opcionSiNo.contains("S")) {
            String nombre = menu.pedirString("Ingrese el nombre");

            float precio = 0;
            while (precio <= 0) {
                precio = menu.pedirFloat("Ingrese el precio");
                if (precio <= 0) {
                    System.out.println("Ingrese un precio válido");
                }
            }

            productoEncontrado.setNombre(nombre);
            productoEncontrado.setPrecio(precio);
        }
    }

    private static void eliminarProducto() {
        // TODO: Refactor
        Producto productoEncontrado = null;
        int idBuscada = menu.pedirInt("Ingrese el id del producto que desea eliminar");
        for (Producto producto : productos) {
            if (producto.getId() == idBuscada) {
                productoEncontrado = producto;
                break;
            }
        }
        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        productoEncontrado.imprimir();

        String opcionSiNo = "";
        while (!opcionSiNo.contains("S") && !opcionSiNo.contains("N")) {
            opcionSiNo = menu.pedirString("Desea eliminar el producto? (S/N)");
        }
        if (opcionSiNo.contains("S")) {
            productos.remove(productoEncontrado);
        }
    }

    private static void crearPedido() {
        Pedido nuevoPedido = new Pedido();
        Producto productoEncontrado = null;
        String opcion = "S";
        while (opcion.contains("S")) {
            System.out.println();
            int idBuscada = menu.pedirInt("Ingrese el id del producto que desea agregar al pedido");
            for (Producto producto : productos) {
                if (producto.getId() == idBuscada) {
                    productoEncontrado = producto;
                    break;
                }
            }
            if (productoEncontrado == null) {
                System.out.println("Producto no encontrado");
                return;
            }
            int cantidad = menu.pedirInt("Ingrese la cantidad que desea agregar");
            try {
                nuevoPedido.agregarProducto(productoEncontrado, cantidad);
            } catch (StockInsuficienteException error) {
                System.out.println(error.getMessage());
            }
            opcion = menu.pedirString("Desea agregar otro producto al pedido? (S/N)");
        }
        pedidos.add(nuevoPedido);
    }

    private static void listarPedidos() {
        for (Pedido pedido : pedidos) {
            pedido.imprimir();
        }
    }
}
