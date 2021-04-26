package com.peru.libreria;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LibreriaServiceTest {

  @Test
  void probarObtenerLibro() throws LibroNotFoundException {
    // Given
    Repository repository = mock(Repository.class); // Implementacion en memoria de Repository
    when(repository.getLibroByIsbn(any())) // Configuro como va a reponder mi método
        .thenReturn(Optional.of(new Libro("100", "Pepito", 10)));

    LibreriaService libreriaService = new LibreriaService(repository);
    String isbn = "100";

    // When
    Libro libro = libreriaService.obtenerLibroPorIsbn(isbn);

    // Then
    assertEquals("100", libro.getIsbn());
    assertEquals("Pepito", libro.getAutor());
    assertEquals(10, libro.getNumeroPaginas());
  }

  @Test
  void probarObtenerLibroCuandoNoExiste() {
    Repository repository = mock(Repository.class);
    when(repository.getLibroByIsbn("100"))
        .thenReturn(Optional.empty());

    LibreriaService libreriaService = new LibreriaService(repository);
    String isbn = "100";

    assertThrows(LibroNotFoundException.class, () -> libreriaService.obtenerLibroPorIsbn(isbn));
  }

  @Test
  void registrarLibroTest() throws LibroNotFoundException {
    // De qué componentes depende? Depende del la interfaz Repository (Lo que tenemos que mockear)
    // De qué funcionalidades de este(os) compoenentes depende?
    //   Depende de registrarLibro, getLibroByIsbn, obtenerUltimoLibro (Los métodos del mock a configurar)

    String autor = "Pepito";
    int numeroDePaginas = 100;

    Repository repository = mock(Repository.class);

    // Mockito defaults: null cuando es un Object, 0 número, false boolean, Collection empty

    when(repository.obtenerUltimoLibro()).thenReturn(new Libro("100", "No me importa ahorita", 0));
    when(repository.registrarLibro(any())).thenReturn(1);
    when(repository.getLibroByIsbn(any())).thenReturn(Optional.of(new Libro("101", autor, numeroDePaginas)));

    LibreriaService libreriaService = new LibreriaService(repository);

    Libro libro = libreriaService.registrarLibro(autor, numeroDePaginas);

    assertNotNull(libro);
    assertEquals("101", libro.getIsbn());
    assertEquals(autor, libro.getAutor());
    assertEquals(numeroDePaginas, libro.getNumeroPaginas());
  }

  @Test
  void obtener3IsbnTest() {
    // Dependencia: Repository
    // Funcionalidades: getLibroByIsbn
    Repository repository = mock(Repository.class);
    when(repository.getLibroByIsbn("101")).thenReturn(Optional.of(new Libro("101", "Pepe", 100)));
    when(repository.getLibroByIsbn("102")).thenReturn(Optional.of(new Libro("102", "Pepe", 100)));
    when(repository.getLibroByIsbn("103")).thenReturn(Optional.of(new Libro("103", "Pepe", 100)));

    LibreriaService service = new LibreriaService(repository);

    String[] strings = service.obtener3Isbn();

    assertArrayEquals(new String[]{"101", "102", "103"}, strings);
    assertAll(
        () ->assertEquals("101", strings[0]),
        () -> assertEquals("102", strings[1]),
        () -> assertEquals("103", strings[2])
    );

    verify(repository, times(3)).getLibroByIsbn(any());
    verify(repository, times(1)).getLibroByIsbn("101");
    verify(repository, times(1)).getLibroByIsbn("102");
    verify(repository, times(1)).getLibroByIsbn("103");
  }

}
