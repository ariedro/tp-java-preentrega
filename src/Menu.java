import java.util.Scanner;

public class Menu {
  static Scanner sc = new Scanner(System.in);

  private String[] mainOpciones = {
      "1) Agregar producto",
      "2) Listar productos",
      "3) Buscar/Actualizar producto",
      "4) Eliminar producto",
      "5) Crear un pedido",
      "6) Listar pedidos",
      "7) Salir",
  };

  private String[] busuqedaOpciones = {
      "1) Por id",
      "2) Por nombre"
  };

  public void imprimirMainMenu() {
    for (String opcion : this.mainOpciones) {
      System.out.println(opcion);
    }
  }

  public int pedirMenuBusqueda() {
    System.out.println("Se buscará...");
    for (String opcion : this.busuqedaOpciones) {
      System.out.println(opcion);
    }
    return sc.nextInt();
  }

  public String pedirString(String mensaje) {
    System.out.println(mensaje);
    String output = sc.next();
    sc.nextLine();
    return output;
  }

  public float pedirFloat(String mensaje) {
    System.out.println(mensaje);
    return sc.nextFloat();
  }

  public int pedirInt(String mensaje) {
    System.out.println(mensaje);
    return sc.nextInt();
  }
}
