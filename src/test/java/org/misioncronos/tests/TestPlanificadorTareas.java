package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.PlanificadorTareas;
import org.misioncronos.excepciones.TareaException;
import java.util.Arrays;

public class TestPlanificadorTareas {

    @Test
    public void testAsignarTareas() {
        PlanificadorTareas pt = new PlanificadorTareas(
                Arrays.asList("Tarea1", "Tarea2"),
                Arrays.asList("Alice", "Bob")
        );
        assertDoesNotThrow(() -> pt.asignarTareas());
    }

    @Test
    public void testCalcularCargaTrabajo() {
        PlanificadorTareas pt = new PlanificadorTareas(
                Arrays.asList("Tarea1", "Tarea2"),
                Arrays.asList("Alice", "Bob")
        );
        int[] v1 = {2, 3};
        int[] v2 = {4, 5};
        try {
            int resultado = pt.calcularCargaTrabajo(v1, v2);
            assertEquals(23, resultado, "2*4 + 3*5 = 8 + 15 = 23");
        } catch (TareaException e) {
            fail("No debería lanzar excepción.");
        }
    }
}
