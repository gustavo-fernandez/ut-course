package com.peru.libreria;

import java.util.Optional;

public class LibreriaService {

  private Repository repository;

  public LibreriaService(Repository repository) {
    this.repository = repository;
  }

  public Libro registrarLibro(String autor, int numeroDePaginas) throws LibroNotFoundException {
    String isbn = calcularIsbn();
    int indice = repository.registrarLibro(new Libro(isbn, autor, numeroDePaginas));
    Optional<Libro> libroEncontradoOpt = repository.getLibroByIsbn(isbn);
    return libroEncontradoOpt.orElseThrow(() -> new LibroNotFoundException(isbn));
  }

  public Libro obtenerLibroPorIsbn(String isbn) throws LibroNotFoundException {
    return repository
        .getLibroByIsbn(isbn)
        .orElseThrow(() -> new LibroNotFoundException(isbn));
  }

  private String calcularIsbn() {
    Libro libro = repository.obtenerUltimoLibro();
    int ultimoIsbn = Integer.parseInt(libro.getIsbn());
    return String.valueOf(ultimoIsbn + 1);
  }

}
