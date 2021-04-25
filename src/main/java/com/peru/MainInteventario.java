package com.peru;

public class MainInteventario {

  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    String id = "ABC";
    Producto p = inventario.getProducto(id);
    System.out.println(p);
  }

}
