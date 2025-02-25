import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestCronometroCosmico {

    @Test
    public void testConvertirTiempoExitoso() {
        // Factor de conversión de 2.0: se espera que 100 segundos en Tierra sean 200 en el nuevo planeta.
        CronometroCosmico cron = new CronometroCosmico(2.0);
        long tiempoTierra = 100;
        try {
            long tiempoPlaneta = cron.convertirTiempo(tiempoTierra);
            assertEquals(200, tiempoPlaneta, "La conversión debería duplicar el tiempo");
        } catch (ConversionException e) {
            fail("No se debió lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    public void testVerificarLimites() {
        CronometroCosmico cron = new CronometroCosmico(1.0);
        // Se prueba con valores dentro de los límites
        assertTrue(cron.verificarLimites(0), "El cero debe estar dentro de los límites");
        assertTrue(cron.verificarLimites(Long.MAX_VALUE), "Long.MAX_VALUE debe estar dentro de los límites");
        assertTrue(cron.verificarLimites(Long.MIN_VALUE), "Long.MIN_VALUE debe estar dentro de los límites");
    }

    @Test
    public void testConvertirTiempoOverflow() {
        // Se utiliza un valor que provoque overflow en la conversión
        CronometroCosmico cron = new CronometroCosmico(2.0);
        // Valor calculado para forzar overflow: (Long.MAX_VALUE / 2) + 1
        long tiempoTierra = (Long.MAX_VALUE / 2) + 1;
        assertThrows(ConversionException.class, () -> {
            cron.convertirTiempo(tiempoTierra);
        }, "Debe lanzarse ConversionException por overflow");
    }
}
