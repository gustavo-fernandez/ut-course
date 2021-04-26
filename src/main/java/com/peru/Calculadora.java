package com.peru;

import java.util.Random;

public class Calculadora {

  public static int count = 0;

  public int sumar(int a, int b) {
    return a + b;
  }

  public Integer convertAInteger(int a) {
    return Integer.valueOf(a);
  }

  public int[] obtenerDivisionYResto(int dividendo, int divisor) {
    int division = dividendo / divisor;
    int resto = dividendo % divisor;
    return new int[] { division, resto };
  }

  public int dividir(int dividendo, int divisor) throws Exception {
    if (divisor == 0) {
      throw new Exception("divisor no puede ser 0");
    }
    return dividendo / divisor;
  }

  public int duplicar(int x) {
    return x * 2;
  }

  public int calcularTamano(String s) {
    return s == null ? 0 : s.length();
  }

  public int obtenerValorAleatorioMenorA(int maximo) {
    Random random = new Random();
    return random.nextInt(maximo);
  }

}
