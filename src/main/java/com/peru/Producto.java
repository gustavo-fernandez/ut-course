package com.peru;

public class Producto {

  private String id;
  private double precio;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "id='" + id + '\'' +
        ", precio=" + precio +
        '}';
  }
}
