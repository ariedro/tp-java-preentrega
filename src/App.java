import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Menu menu = new Menu();
    static ArrayList<Producto> productos = new ArrayList<Producto>();

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        while (opcion != 7) {
            menu.imprimirMainMenu();
            opcion = sc.nextInt();
            sc.nextLine();
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
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }

    private static void agregarProducto() {
        System.out.println("Creando un nuevo producto");

        System.out.println("Ingrese el nombre");
        String nombre = sc.next();
        sc.nextLine();

        float precio = 0;
        System.out.println("Ingrese el precio");
        while (precio <= 0) {
            precio = sc.nextFloat();
            sc.nextLine();
            if (precio <= 0) {
                System.out.println("Ingrese un precio válido");
            }
        }

        Producto nuevoProducto = new Producto(nombre, precio);
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
            menu.imprimirBusquedaMenu();
            opcionNumerica = sc.nextInt();
            sc.nextLine();
            switch (opcionNumerica) {
                // Por id
                case 1:
                    System.out.println("Ingrese el id del producto que desea buscar");
                    int idBuscada = sc.nextInt();
                    sc.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getId() == idBuscada) {
                            productoEncontrado = producto;
                            break;
                        }
                    }
                    break;
                // Por nombre
                case 2:
                    System.out.println("Ingrese el nombre del producto que desea buscar");
                    String nombreBuscado = sc.next();
                    sc.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getNombre().toLowerCase().matches(nombreBuscado.toLowerCase())) {
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
        while (opcionSiNo != "S" || opcionSiNo != "N") {
            System.out.println("Desea modificar el producto? (S/N)");
            opcionSiNo = sc.next();
            sc.nextLine();
        }
        if (opcionSiNo == "S") {
            // TODO
        }
    }
}
