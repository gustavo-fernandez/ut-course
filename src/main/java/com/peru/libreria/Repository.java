package com.peru.libreria;

import java.util.Optional;

public interface Repository {

  Optional<Libro> getLibroByIsbn(String isbn);

  int registrarLibro(Libro libro);

  Libro obtenerUltimoLibro();

}
