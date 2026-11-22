import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LibroTest {

  @Test
  void deberiaCrearLibroDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    assertEquals("1984", libro.getTitulo());
    assertEquals("George Orwell", libro.getAutor());
    assertTrue(libro.estaDisponible());
  }

  @Test
  void deberiaPrestarLibroDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();

    assertFalse(libro.estaDisponible());
  }

  @Test
  void deberiaLanzarErrorAlPrestarLibroNoDisponible() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();

    IllegalStateException excepcion = assertThrows(
        IllegalStateException.class,
        libro::prestar
    );
    assertEquals("Libro no disponible", excepcion.getMessage());
    assertFalse(libro.estaDisponible());
  }

  @Test
  void deberiaDevolverLibroPrestado() {
    Libro libro = new Libro("1984", "George Orwell");

    libro.prestar();
    libro.devolver();

    assertTrue(libro.estaDisponible());
  }

  @Test
  void deberiaPermitirCicloCompletoPrestamoDevolucionYNuevoPrestamo() {
    Libro libro = new Libro("El Quijote", "Miguel de Cervantes");

    libro.devolver();
    assertTrue(libro.estaDisponible());

    libro.prestar();
    assertFalse(libro.estaDisponible());

    libro.devolver();
    assertTrue(libro.estaDisponible());

    libro.prestar();
    assertFalse(libro.estaDisponible());
  }

  @Test
  void deberiaCompararTitulosPorContenido() {
    Libro libro = new Libro("1984", "George Orwell");

    String otroTitulo = new String("1984");

    assertTrue(libro.esMismoTitulo(otroTitulo));
  }

  @Test
  void deberiaRetornarFalseCuandoElTituloEsDiferente() {
    Libro libro = new Libro("1984", "George Orwell");

    assertFalse(libro.esMismoTitulo("Un mundo feliz"));
  }

  @Test
  void deberiaManejarValoresNulosYLimitesEnTituloYAutor() {
    Libro libroConTitulo = new Libro("1984", "George Orwell");
    assertFalse(libroConTitulo.esMismoTitulo(null));

    Libro libroVacio = new Libro("", "");
    assertEquals("", libroVacio.getTitulo());
    assertEquals("", libroVacio.getAutor());
    assertTrue(libroVacio.esMismoTitulo(""));
    assertFalse(libroVacio.esMismoTitulo("1984"));

    Libro libroNulo = new Libro(null, null);
    assertNull(libroNulo.getTitulo());
    assertNull(libroNulo.getAutor());
    assertTrue(libroNulo.esMismoTitulo(null));
    assertFalse(libroNulo.esMismoTitulo("1984"));
  }
}
