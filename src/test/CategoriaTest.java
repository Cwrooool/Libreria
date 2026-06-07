package test;

import model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria(1, "Novela", "Libros de ficcion narrativa");
    }

    @Test
    void testConstructorCompleto() {
        assertNotNull(categoria);
        assertEquals(1, categoria.getIdCategoria());
        assertEquals("Novela", categoria.getCategoria());
        assertEquals("Libros de ficcion narrativa", categoria.getDescripcion());
    }

    @Test
    void testConstructorSinId() {
        Categoria c = new Categoria("Terror", "Libros de terror");
        assertNotNull(c);
        assertEquals("Terror", c.getCategoria());
        assertEquals(0, c.getIdCategoria());
    }

    @Test
    void testConstructorVacio() {
        Categoria vacia = new Categoria();
        assertNotNull(vacia);
        assertNull(vacia.getCategoria());
    }

    @Test
    void testSetterGetterIdCategoria() {
        categoria.setIdCategoria(99);
        assertEquals(99, categoria.getIdCategoria());
    }

    @Test
    void testSetterGetterCategoria() {
        categoria.setCategoria("Ciencia Ficcion");
        assertEquals("Ciencia Ficcion", categoria.getCategoria());
    }

    @Test
    void testSetterGetterDescripcion() {
        categoria.setDescripcion("Libros de ciencia y tecnologia");
        assertEquals("Libros de ciencia y tecnologia", categoria.getDescripcion());
    }

    @Test
    void testCategoriaNoNula() {
        assertNotNull(categoria.getCategoria());
    }

    @Test
    void testDescripcionNoNula() {
        assertNotNull(categoria.getDescripcion());
    }

    @Test
    void testToString() {
        String resultado = categoria.toString();
        assertTrue(resultado.contains("Novela"));
        assertTrue(resultado.contains("Libros de ficcion narrativa"));
    }
}
