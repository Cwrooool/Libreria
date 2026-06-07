package test;

import model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    private Autor autor;

    @BeforeEach
    void setUp() {
        autor = new Autor(1, "Gabriel", "Garcia", "Colombia",
                          "Medellin", "0963002130", "gabriel@correo.com");
    }

    @Test
    void testConstructorCompleto() {
        assertNotNull(autor);
        assertEquals(1, autor.getIdAutor());
        assertEquals("Gabriel", autor.getNombre());
        assertEquals("Garcia", autor.getApellido());
        assertEquals("Colombia", autor.getPais());
        assertEquals("Medellin", autor.getDireccion());
        assertEquals("0963002130", autor.getTelefono());
        assertEquals("gabriel@correo.com", autor.getCorreo());
    }

    @Test
    void testConstructorSinId() {
        Autor a = new Autor("Julio", "Verne", "Francia",
                            "Lyon", "0875673723", "jv@gmail.com");
        assertNotNull(a);
        assertEquals("Julio", a.getNombre());
        assertEquals(0, a.getIdAutor()); // id por defecto es 0
    }

    @Test
    void testConstructorVacio() {
        Autor vacio = new Autor();
        assertNotNull(vacio);
        assertNull(vacio.getNombre());
    }

    @Test
    void testSetterGetterIdAutor() {
        autor.setIdAutor(99);
        assertEquals(99, autor.getIdAutor());
    }

    @Test
    void testSetterGetterNombre() {
        autor.setNombre("Julio");
        assertEquals("Julio", autor.getNombre());
    }

    @Test
    void testSetterGetterApellido() {
        autor.setApellido("Verne");
        assertEquals("Verne", autor.getApellido());
    }

    @Test
    void testSetterGetterPais() {
        autor.setPais("Francia");
        assertEquals("Francia", autor.getPais());
    }

    @Test
    void testSetterGetterDireccion() {
        autor.setDireccion("Paris");
        assertEquals("Paris", autor.getDireccion());
    }

    @Test
    void testSetterGetterTelefono() {
        autor.setTelefono("0999999999");
        assertEquals("0999999999", autor.getTelefono());
    }

    @Test
    void testSetterGetterCorreo() {
        autor.setCorreo("nuevo@correo.com");
        assertEquals("nuevo@correo.com", autor.getCorreo());
    }

    @Test
    void testToString() {
        String resultado = autor.toString();
        assertTrue(resultado.contains("Gabriel"));
        assertTrue(resultado.contains("Garcia"));
        assertTrue(resultado.contains("Colombia"));
    }
}