public class Menu {
  private String[] mainOpciones = {
      "1) Agregar producto",
      "2) Listar productos",
      "3) Buscar/Actualizar producto",
      "4) Eliminar producto",
      "5) Crear un pedido",
      "6) Listar pedidos",
      "7) Salir",
      "Elija una opción: "
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

  public void imprimirBusquedaMenu() {
    System.out.println("Se buscará...");
    for (String opcion : this.busuqedaOpciones) {
      System.out.println(opcion);
    }
  }
}
