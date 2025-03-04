package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.SistemaAlertaMonitoreo;
import org.misioncronos.excepciones.MonitorException;
import java.util.List;

public class TestSistemaAlertaMonitoreo {

    @Test
    public void testDetectarEventos() {
        SistemaAlertaMonitoreo sam = new SistemaAlertaMonitoreo(80, 30, 1);
        try {
            List<Integer> primos = sam.detectarEventos(10);
            // Primos hasta 10: 2, 3, 5, 7
            assertEquals(4, primos.size());
        } catch (MonitorException e) {
            fail("No debería fallar con límite 10.");
        }
    }

    @Test
    public void testDetectarEventosError() {
        SistemaAlertaMonitoreo sam = new SistemaAlertaMonitoreo(80, 30, 1);
        assertThrows(MonitorException.class, () -> {
            sam.detectarEventos(1);
        });
    }

    @Test
    public void testDescomponerProblema() {
        SistemaAlertaMonitoreo sam = new SistemaAlertaMonitoreo(80, 30, 1);
        List<Integer> factores = sam.descomponerProblema(60);
        // 60 = 2 * 2 * 3 * 5
        assertArrayEquals(new Integer[]{2,2,3,5}, factores.toArray());
    }
}
