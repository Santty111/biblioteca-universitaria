import java.util.Objects;

/**
 * Representa un libro dentro del catálogo de la biblioteca universitaria.
 */
public class Libro {

  private final String titulo;
  private final String autor;
  private boolean disponible = true;

  /**
   * Crea una nueva instancia de {@code Libro} disponible para préstamo.
   *
   * @param titulo título del libro
   * @param autor autor del libro
   */
  public Libro(String titulo, String autor) {
    this.titulo = titulo;
    this.autor = autor;
  }

  /**
   * Obtiene el título del libro.
   *
   * @return título del libro
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Obtiene el autor del libro.
   *
   * @return autor del libro
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Indica si el libro se encuentra disponible para préstamo.
   *
   * @return {@code true} si está disponible; {@code false} en caso contrario
   */
  public boolean estaDisponible() {
    return disponible;
  }

  /**
   * Registra el préstamo del libro si está disponible.
   *
   * @throws IllegalStateException si el libro ya se encuentra prestado
   */
  public void prestar() {
    if (!disponible) {
      throw new IllegalStateException("Libro no disponible");
    }
    disponible = false;
  }

  /**
   * Registra la devolución del libro, dejándolo nuevamente disponible.
   */
  public void devolver() {
    disponible = true;
  }

  /**
   * Compara por contenido si el título del libro coincide con el título dado.
   *
   * @param otroTitulo título a comparar
   * @return {@code true} si ambos títulos coinciden en contenido; {@code false} en caso contrario
   */
  public boolean esMismoTitulo(String otroTitulo) {
    return Objects.equals(titulo, otroTitulo);
  }
}
