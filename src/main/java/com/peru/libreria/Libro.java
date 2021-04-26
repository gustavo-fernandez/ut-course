package com.peru.libreria;

public class Libro {

  private String isbn;
  private String autor;
  private int numeroPaginas;

  public Libro() {}

  public Libro(String isbn, String autor, int numeroPaginas) {
    this.isbn = isbn;
    this.autor = autor;
    this.numeroPaginas = numeroPaginas;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  public void setNumeroPaginas(int numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

}
