package com.peru.libreria;

import java.util.Optional;

public class LibreriaRepository implements Repository {

  @Override
  public Optional<Libro> getLibroByIsbn(String isbn) {
    return Database.LIBROS.stream()
        .filter(libro -> libro.getIsbn().equals(isbn))
        .findFirst();
  }

  @Override
  public int registrarLibro(Libro libro) {
    libro.getIsbn().length(); // ...
    Database.LIBROS.add(libro);
    return Database.LIBROS.size() - 1;
  }

  @Override
  public Libro obtenerUltimoLibro() {
    return Database.LIBROS.get(Database.LIBROS.size() - 1);
  }

}
