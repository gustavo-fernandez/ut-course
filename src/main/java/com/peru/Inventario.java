package com.peru;

public class Inventario {

  public Producto getProducto(String id) {
    Producto p = new Producto();
    p.setId(id);
    p.setPrecio(200.0);
    return p;
  }

}
