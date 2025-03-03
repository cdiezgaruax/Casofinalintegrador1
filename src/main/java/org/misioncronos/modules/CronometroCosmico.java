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
        long convertido = (long) (tiempo * conversionFactor);
        if (!verificarLimites(convertido)) {
            throw new ConversionException("Overflow en la conversión de tiempo.");
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
