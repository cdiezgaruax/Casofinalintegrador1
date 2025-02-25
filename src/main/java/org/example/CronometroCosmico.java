package org.example;

import java.util.HashMap;
import java.util.Map;
import org.example.excepciones.ConversionException;

public class CronometroCosmico {
    private long tiempoTierra;
    private long tiempoPlaneta;
    private double conversionFactor;
    private Map<String, Long> limitesRepresentacion;

    /**
     * Constructor que inicializa el factor de conversión y los límites de representación.
     * @param conversionFactor Factor para convertir el tiempo de Tierra a Planeta.
     */
    public CronometroCosmico(double conversionFactor) {
        this.conversionFactor = conversionFactor;
        this.tiempoTierra = 0;
        this.tiempoPlaneta = 0;
        limitesRepresentacion = new HashMap<>();
        // Se definen los límites usando los valores máximos y mínimos de long
        limitesRepresentacion.put("maxLong", Long.MAX_VALUE);
        limitesRepresentacion.put("minLong", Long.MIN_VALUE);
    }

    /**
     * Convierte el tiempo de Tierra a tiempo en el nuevo planeta utilizando el factor de conversión.
     * @param tiempo Tiempo en segundos en Tierra.
     * @return Tiempo convertido en el planeta.
     * @throws ConversionException si el resultado excede los límites representables.
     */
    public long convertirTiempo(long tiempo) throws ConversionException {
        long convertido = (long) (tiempo * conversionFactor);

        if (!verificarLimites(convertido)) {
            throw new ConversionException("Error: Overflow en la conversión de tiempo.");
        }
        this.tiempoPlaneta = convertido;
        return convertido;
    }

    /**
     * Retorna una cadena con la visualización del tiempo en Tierra y en el planeta.
     * @return String con los tiempos.
     */
    public String mostrarTiempo() {
        return "Tiempo Tierra: " + tiempoTierra + " segundos, Tiempo Planeta: " + tiempoPlaneta + " segundos";
    }

    /**
     * Verifica que el valor t se encuentre dentro de los límites representables.
     * @param t Valor a verificar.
     * @return true si está dentro de los límites; false de lo contrario.
     */
    public boolean verificarLimites(long t) {
        long max = limitesRepresentacion.get("maxLong");
        long min = limitesRepresentacion.get("minLong");
        return (t <= max && t >= min);
    }

    // Métodos getters y setters adicionales
    public void setTiempoTierra(long tiempoTierra) {
        this.tiempoTierra = tiempoTierra;
    }

    public long getTiempoTierra() {
        return this.tiempoTierra;
    }

    public long getTiempoPlaneta() {
        return this.tiempoPlaneta;
    }
}

