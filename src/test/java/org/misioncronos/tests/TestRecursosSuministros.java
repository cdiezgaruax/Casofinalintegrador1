package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.RecursosSuministros;
import org.misioncronos.excepciones.ResourceException;
import java.util.Arrays;
import java.util.List;

public class TestRecursosSuministros {

    @Test
    public void testCalcularConsumoExitoso() {
        RecursosSuministros rs = new RecursosSuministros(10, 5, 3, 2);
        try {
            double consumo = rs.calcularConsumo(10);
            assertEquals(180, consumo, 0.001, "Consumo esperado: (10+5+3)*10 = 180");
        } catch (ResourceException e) {
            fail("No debería lanzar excepción.");
        }
    }

    @Test
    public void testCalcularConsumoError() {
        RecursosSuministros rs = new RecursosSuministros(10, 5, 3, 2);
        assertThrows(ResourceException.class, () -> {
            rs.calcularConsumo(7); // No es múltiplo de 5
        });
    }

    @Test
    public void testCalcularEstadisticas() {
        RecursosSuministros rs = new RecursosSuministros(10, 5, 3, 2);
        List<Double> datos = Arrays.asList(60.0, 50.0, 70.0);
        List<Double> stats = rs.calcularEstadisticas(datos);
        assertEquals(3, stats.size());
        assertEquals(50.0, stats.get(0), 0.001);  // min
        assertEquals(70.0, stats.get(1), 0.001);  // max
        assertEquals(60.0, stats.get(2), 0.001);  // promedio
    }
}
