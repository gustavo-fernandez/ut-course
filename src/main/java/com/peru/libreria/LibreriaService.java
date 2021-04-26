package com.peru.libreria;

import java.util.Optional;

// Inversion de control
// Injeyeccion de dependencia (Bajo acoplamiento entre componentes)
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
        .orElseThrow(() ->
            new LibroNotFoundException(isbn));
  }

  private String calcularIsbn() {
    Libro libro = repository.obtenerUltimoLibro();
    int ultimoIsbn = Integer.parseInt(libro.getIsbn());
    return String.valueOf(ultimoIsbn + 1);
  }

  public String[] obtener3Isbn() {
    String isbn1 = repository.getLibroByIsbn("101").get().getIsbn();
    String isbn2 = repository.getLibroByIsbn("102").get().getIsbn();
    String isbn3 = repository.getLibroByIsbn("103").get().getIsbn();
    return new String[] { isbn1, isbn2, isbn3 };
  }

}
