package com.peru.libreria;

import java.util.ArrayList;
import java.util.List;

public final class Database {

  public static final List<Libro> LIBROS;

  static {
    LIBROS = new ArrayList<>();
    LIBROS.add(new Libro("100", "Jose", 200));
    LIBROS.add(new Libro("101", "Maria", 300));
    LIBROS.add(new Libro("102", "Pedro", 1_000));
  }

}
