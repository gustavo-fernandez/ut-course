package com.peru.libreria;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibreriaServiceTest {

  @Test
  public void probarObtenerLibro() throws LibroNotFoundException {
    // Given
    Repository repository = new LibreriaRepository();
    LibreriaService libreriaService = new LibreriaService(repository);
    String isbn = "100";

    // When
    Libro libro = libreriaService.obtenerLibroPorIsbn(isbn);

    // Then
    assertEquals("100", libro.getIsbn());
    assertEquals("Pepito", libro.getAutor());
    assertEquals(10, libro.getNumeroPaginas());
  }

  class LibreriaRepositoryStub implements Repository {
    @Override
    public Optional<Libro> getLibroByIsbn(String isbn) {
      return Optional.of(new Libro(isbn, "Pepito", 10));
    }

    @Override
    public int registrarLibro(Libro libro) {
      return 0;
    }

    @Override
    public Libro obtenerUltimoLibro() {
      return null;
    }
  }

}
