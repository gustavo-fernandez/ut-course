package com.peru.libreria;

import java.util.Optional;

public class LibreriaRepository {

  public Optional<Libro> getLibroByIsbn(String isbn) {
    return Database.LIBROS.stream()
        .filter(libro -> libro.getIsbn().equals(isbn))
        .findFirst();
  }

  public int registrarLibro(Libro libro) {
    Database.LIBROS.add(libro);
    return Database.LIBROS.size() - 1;
  }

  public Libro obtenerUltimoLibro() {
    return Database.LIBROS.get(Database.LIBROS.size() - 1);
  }

}
