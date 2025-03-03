package org.misioncronos.modules;


import org.misioncronos.excepciones.MonitorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Módulo para monitorear variables ambientales y detectar eventos raros (números primos).
 * También permite la descomposición de un valor en sus factores primos.
 */
public class SistemaAlertaMonitoreo {

    private double radiacion;
    private double temperatura;
    private double presion;

    public SistemaAlertaMonitoreo(double radiacion, double temperatura, double presion) {
        this.radiacion = radiacion;
        this.temperatura = temperatura;
        this.presion = presion;
    }

    /**
     * Detecta eventos "raros" (simbolizados por números primos) en un rango.
     * @param limite Superior del rango para buscar números primos.
     * @return Lista de números primos hasta el límite.
     * @throws MonitorException si el límite es negativo o cero.
     */
    public List<Integer> detectarEventos(int limite) throws MonitorException {
        if (limite <= 1) {
            throw new MonitorException("Límite inválido para detectar eventos.");
        }
        List<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }
        return primos;
    }

    private boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Descompone un valor en sus factores primos.
     * @param valor Valor a descomponer.
     * @return Lista de factores primos.
     */
    public List<Integer> descomponerProblema(int valor) {
        List<Integer> factores = new ArrayList<>();
        int divisor = 2;
        while (valor > 1) {
            while (valor % divisor == 0) {
                factores.add(divisor);
                valor /= divisor;
            }
            divisor++;
        }
        return factores;
    }

    /**
     * Monitorea si los valores de radiación, temperatura o presión están fuera de rango.
     * @return true si se detecta algún valor peligroso.
     */
    public boolean monitorear() {
        // Ejemplo: si radiación > 100, temperatura > 50 o presión < 0, se considera peligroso
        if (radiacion > 100 || temperatura > 50 || presion < 0) {
            return true;
        }
        return false;
    }

    // Getters / Setters
    public double getRadiacion() {
        return radiacion;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public double getPresion() {
        return presion;
    }
    public void setRadiacion(double radiacion) {
        this.radiacion = radiacion;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    public void setPresion(double presion) {
        this.presion = presion;
    }
}
