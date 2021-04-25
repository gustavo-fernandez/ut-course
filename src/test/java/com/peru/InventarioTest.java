package com.peru;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventarioTest {

  @Test
  void test1() {
    Inventario inventario = new Inventario();
    String id = "X0001";

    Producto productoRetornado = inventario.getProducto(id);

    // then
    Producto productoEsperado = new Producto();
    productoEsperado.setId("X0001");

    assertNotNull(productoRetornado);
    assertEquals(productoEsperado, productoRetornado);
  }

  @Test
  void assertSameTest() {
    Producto productoEnviado = new Producto();
    productoEnviado.setId("H");
    productoEnviado.setPrecio(1000.0);

    Inventario inv = new Inventario();
    Producto productoRetornado = inv.actualizarPrecio(productoEnviado);

    assertSame(productoRetornado, productoEnviado);

    // p.equals(otroProducto); -> assertEquals
    // p == otroProducto -> assertSame
  }

  @Test
  public void validarTiempo() {
    Inventario inv = new Inventario();

    assertTimeout(Duration.ofSeconds(10), () -> inv.actualizarInventario());
  }

  @Test
  public void validarGetProducto() {
    Inventario inv = new Inventario();
    Producto producto = inv.getProducto("B");

    assertAll(
        () -> assertEquals("B", producto.getId()),
        () -> assertEquals(200.0, producto.getPrecio())
    );
  }

}
