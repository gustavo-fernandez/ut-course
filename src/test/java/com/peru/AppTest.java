package com.peru;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

  @Test
  public void test1() {
    int a = 1;
    int b = 2;

    int suma = a + b;

    // assertions (JUnit)
    assertTrue(3 == suma);
  }

}
