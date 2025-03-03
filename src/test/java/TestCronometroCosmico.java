package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.CronometroCosmico;
import org.misioncronos.excepciones.ConversionException;

public class TestCronometroCosmico {

    @Test
    public void testConvertirTiempoExitoso() {
        CronometroCosmico cron = new CronometroCosmico(2.0);
        long tiempoTierra = 100;
        try {
            long tiempoPlaneta = cron.convertirTiempo(tiempoTierra);
            assertEquals(200, tiempoPlaneta, "Debería duplicar el tiempo");
        } catch (ConversionException e) {
            fail("No debería lanzarse excepción aquí.");
        }
    }

    @Test
    public void testConvertirTiempoOverflow() {
        CronometroCosmico cron = new CronometroCosmico(2.0);
        long tiempoGrande = (Long.MAX_VALUE / 2) + 1;
        assertThrows(ConversionException.class, () -> {
            cron.convertirTiempo(tiempoGrande);
        }, "Debería lanzar excepción por overflow");
    }
}
