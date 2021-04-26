package com.peru;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

  // @Disabled -> JUnit 5 // En JUnit 4 es @Ignore
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

  @Test
  public void divisionEntreCero() {
    assertThrows(Exception.class, () -> calc.dividir(10, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = { 2, 0, -1 })
  void probarDuplicar(int valorADuplicar) {
    // given
    Calculadora calc = new Calculadora();
    // when
    int valorDuplicado = calc.duplicar(valorADuplicar);
    // then
    int esperado = valorADuplicar * 2;
    assertEquals(esperado, valorDuplicado);
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { "hola", "java", "junit" })
  void testParametrizado(String cadena) {
    Calculadora calc = new Calculadora();

    int i = calc.calcularTamano(cadena);

    int tamanoEsperado = cadena == null ? 0 : cadena.length();
    assertEquals(tamanoEsperado, i);
  }

  @ParameterizedTest
  @CsvSource(value = {"2;4", "0;0", "-1;-2"}, delimiter = ';')
  void probarDuplicarConCsv(int valorADuplicar, int valorEsperado) {
    int valorDuplicado = calc.duplicar(valorADuplicar);
    assertEquals(valorEsperado, valorDuplicado);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/duplicados.csv", numLinesToSkip = 1)
  void probarDuplicarConArchivoCsv(int valorADuplicar, int valorEsperado) {
    int valorDuplicado = calc.duplicar(valorADuplicar);
    assertEquals(valorEsperado, valorDuplicado);
  }

  @Test
  void dummyTestWithAssumption() {
    String javaHomeEnvVar = System.getenv("JAVA_HOME");
    assumeTrue(javaHomeEnvVar.contains("11.0.2"));

    int a = 2;
    int b = 3;

    int sum = a + b;

    assertEquals(5, sum);
  }

  @Test
  @RepeatedTest(10)
  void repeatedTest() {
    Calculadora calc = new Calculadora();

    int i = calc.obtenerValorAleatorioMenorA(10);

    assertTrue(i < 10);
  }

}
