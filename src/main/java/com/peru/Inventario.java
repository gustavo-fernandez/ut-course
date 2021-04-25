package com.peru;

public class Inventario {

  public Producto getProducto(String id) {
    Producto p = new Producto();
    p.setId(id);
    p.setPrecio(200.0);
    return p;
  }

  public Producto actualizarPrecio(Producto p) {
    p.setPrecio(p.getPrecio() + 10.0);
    return p;
  }

  public void actualizarInventario() {
    System.out.println("Ejecutando...");
    try {
      Thread.sleep(5_000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println("Termino ejecución");
  }

}
