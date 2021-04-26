package com.peru.libreria;

import java.util.Optional;

public class LibreriaService {

  public Libro registrarLibro(String autor, int numeroDePaginas) throws LibroNotFoundException {
    String isbn = calcularIsbn();
    LibreriaRepository repository = new LibreriaRepository();
    int indice = repository.registrarLibro(new Libro(isbn, autor, numeroDePaginas));
    Optional<Libro> libroEncontradoOpt = repository.getLibroByIsbn(isbn);
    return libroEncontradoOpt.orElseThrow(() -> new LibroNotFoundException(isbn));
  }

  public Libro obtenerLibroPorIsbn(String isbn) throws LibroNotFoundException {
    return new LibreriaRepository()
        .getLibroByIsbn(isbn)
        .orElseThrow(() -> new LibroNotFoundException(isbn));
  }

  private String calcularIsbn() {
    LibreriaRepository repository = new LibreriaRepository();
    Libro libro = repository.obtenerUltimoLibro();
    int ultimoIsbn = Integer.parseInt(libro.getIsbn());
    return String.valueOf(ultimoIsbn + 1);
  }

}
