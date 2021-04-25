package com.peru;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Producto producto = (Producto) o;
    return id.equals(producto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
