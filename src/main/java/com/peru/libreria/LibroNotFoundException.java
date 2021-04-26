package com.peru.libreria;

public class LibroNotFoundException extends Exception {

  public LibroNotFoundException(String isbn) {
    super("Libro con isbn " + isbn + " no fue encontrado");
  }

}
