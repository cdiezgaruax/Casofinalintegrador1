package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.ComunicadorInterplanetario;
import org.misioncronos.excepciones.MensajeException;

public class TestComunicadorInterplanetario {

    @Test
    public void testContarVocales() {
        ComunicadorInterplanetario ci = new ComunicadorInterplanetario();
        assertEquals(5, ci.contarVocales("Hola Mundo"), "Hola Mundo tiene 5 vocales");
    }

    @Test
    public void testInvertirMensaje() {
        ComunicadorInterplanetario ci = new ComunicadorInterplanetario();
        assertEquals("odnuM aloH", ci.invertirMensaje("Hola Mundo"));
    }

    @Test
    public void testEsPalindromo() {
        ComunicadorInterplanetario ci = new ComunicadorInterplanetario();
        assertTrue(ci.esPalindromo("anita lava la tina"));
        assertFalse(ci.esPalindromo("Hola"));
    }

    @Test
    public void testTraducirMensaje() {
        ComunicadorInterplanetario ci = new ComunicadorInterplanetario();
        try {
            String trad = ci.traducirMensaje("Hola");
            assertEquals("Traducción: Hola", trad);
        } catch (MensajeException e) {
            fail("No debería lanzar excepción con 'Hola'.");
        }
    }

    @Test
    public void testTraducirMensajeException() {
        ComunicadorInterplanetario ci = new ComunicadorInterplanetario();
        assertThrows(MensajeException.class, () -> {
            ci.traducirMensaje("");
        });
    }
}
