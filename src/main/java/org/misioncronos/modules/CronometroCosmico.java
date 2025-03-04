package org.misioncronos.modules;


import org.misioncronos.excepciones.ConversionException;
import java.util.HashMap;
import java.util.Map;

/**
 * Módulo que calcula y muestra el tiempo en la Tierra y en el nuevo planeta,
 * y verifica límites de representación de datos.
 */
public class CronometroCosmico {

    private long tiempoTierra;
    private long tiempoPlaneta;
    private double conversionFactor;
    private Map<String, Long> limitesRepresentacion;

    public CronometroCosmico(double conversionFactor) {
        this.conversionFactor = conversionFactor;
        this.tiempoTierra = 0;
        this.tiempoPlaneta = 0;
        this.limitesRepresentacion = new HashMap<>();
        // Definimos límites basados en long
        this.limitesRepresentacion.put("maxLong", Long.MAX_VALUE);
        this.limitesRepresentacion.put("minLong", Long.MIN_VALUE);
    }

    /**
     * Convierte el tiempo de Tierra al tiempo del nuevo planeta.
     * @param tiempo Valor en segundos en la Tierra.
     * @return Tiempo en el nuevo planeta.
     * @throws ConversionException si hay overflow o underflow.
     */
    public long convertirTiempo(long tiempo) throws ConversionException {
        // Comprobación previa basada en el factor de conversión.
        if (conversionFactor > 0 && tiempo >= (long)(Long.MAX_VALUE / conversionFactor) + 1) {
            throw new ConversionException("Overflow en la conversión de tiempo (previo al cálculo).");
        }
        if (conversionFactor < 0 && tiempo <= (long)(Long.MIN_VALUE / conversionFactor) - 1) {
            throw new ConversionException("Underflow en la conversión de tiempo (previo al cálculo).");
        }

        // Calcula el resultado en double.
        double resultadoDouble = tiempo * conversionFactor;

        // Comprueba si el resultado excede el rango representable por long.
        // (Long.MAX_VALUE es 9223372036854775807, así que si el resultado es mayor o igual a 9223372036854775808.0,
        // se considera overflow.)
        if (resultadoDouble >= ((double) Long.MAX_VALUE) + 1.0 ||
                resultadoDouble <= ((double) Long.MIN_VALUE) - 1.0) {
            throw new ConversionException("Overflow en la conversión de tiempo (resultado fuera de rango).");
        }

        // Convierte a long.
        long convertido = (long) resultadoDouble;

        // Verifica que el valor convertido esté dentro de los límites.
        if (!verificarLimites(convertido)) {
            throw new ConversionException("Overflow en la conversión de tiempo (verificación final).");
        }

        this.tiempoPlaneta = convertido;
        return convertido;
    }



    public String mostrarTiempo() {
        return "Tiempo Tierra: " + tiempoTierra + " seg, "
                + "Tiempo Planeta: " + tiempoPlaneta + " seg";
    }

    private boolean verificarLimites(long valor) {
        long max = limitesRepresentacion.get("maxLong");
        long min = limitesRepresentacion.get("minLong");
        return (valor <= max && valor >= min);
    }

    // Getters / Setters
    public void setTiempoTierra(long tiempoTierra) {
        this.tiempoTierra = tiempoTierra;
    }
    public long getTiempoTierra() {
        return tiempoTierra;
    }
    public long getTiempoPlaneta() {
        return tiempoPlaneta;
    }
}
