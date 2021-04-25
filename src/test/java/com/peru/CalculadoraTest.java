package com.peru;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

  private Calculadora calc;

  @BeforeAll
  public static void beforeAll() {
    System.out.println(">> Antes de cualquier test se ejecute");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println(">> Después de que todos se ejecutaron");
  }

  @BeforeEach
  public void beforeXYZ() {
    System.out.println("Antes de cada test");
    calc = new Calculadora();
  }

  @AfterEach
  public void after() {
    Calculadora.count = 0;
    System.out.println("después de cada test");
  }

  @Test
  public void testSuma() {
    System.out.println("Ejecutando test suma");
    // given (establacemos variables, clases, objetos necesarios para el test)
    int sumando1 = 14;
    int sumando2 = 10;
    // when (Ejecutamos el código o método que queremos testear)
    int resultado = calc.sumar(sumando1, sumando2);
    // then (Verificamos el código que hemos ejecutado, esto es que cumpla con el resultado esperado)
    // assertTrue(resultado == 24);
    assertEquals(24, resultado);
  }

  @Test
  public void probarConversionAWrapper() {
    // given
    int intPrimitivo = 100;
    // when
    Integer integerWrapper = calc.convertAInteger(intPrimitivo);
    // then
    assertEquals(Integer.valueOf(100), integerWrapper);
    assertNotNull(integerWrapper);
    assertFalse(integerWrapper == null);
  }

  @Test
  public void probarDivision() {
    System.out.println("Ejecutando test division");
    // given
    int dividendo = 9;
    int divisor = 2;
    // when
    int[] resultadoDivision =
        calc.obtenerDivisionYResto(dividendo, divisor);
    // then
    int[] resultadoEsperado = {4, 1};
    assertArrayEquals(resultadoEsperado, resultadoDivision);
  }

  @Test
  public void validarDivision() throws Exception {
    int dividendo = 9;
    int divisor = 4;
    int resDivision = calc.dividir(dividendo, divisor);

    assertEquals(2, resDivision);
  }

  /*@Test(expected = Exception.class)
  public void divisionEntreCero() throws Exception {
    calc.dividir(10, 0);
  }*/

}
