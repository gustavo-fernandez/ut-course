package com.peru;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalculadoraTest {

  @Test
  public void testSuma() {
    // given (establacemos variables, clases, objetos necesarios para el test)
    Calculadora calc = new Calculadora();
    int sumando1 = 14;
    int sumando2 = 10;
    // when (Ejecutamos el código o método que queremos testear)
    int resultado = calc.sumar(sumando1, sumando2);
    // then (Verificamos el código que hemos ejecutado, esto es que cumpla con el resultado esperado)
    assertTrue(resultado == 24);
  }

}
