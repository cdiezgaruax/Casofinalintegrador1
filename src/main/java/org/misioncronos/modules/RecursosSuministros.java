package org.misioncronos.modules;


import org.misioncronos.excepciones.ResourceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Módulo para calcular el consumo de recursos vitales (agua, comida, oxígeno),
 * generar estadísticas y lanzar alertas si se superan umbrales.
 */
public class RecursosSuministros {

    private double agua;
    private double comida;
    private double oxigeno;
    private double umbralSeguro;  // Umbral por debajo del cual se lanza alerta

    public RecursosSuministros(double agua, double comida, double oxigeno, double umbralSeguro) {
        this.agua = agua;
        this.comida = comida;
        this.oxigeno = oxigeno;
        this.umbralSeguro = umbralSeguro;
    }

    /**
     * Calcula el consumo total de recursos en un periodo que sea múltiplo de 5.
     * @param dias Número de días (debe ser múltiplo de 5).
     * @return Consumo total estimado.
     * @throws ResourceException si los días no son múltiplo de 5 o hay datos inválidos.
     */
    public double calcularConsumo(int dias) throws ResourceException {
        if (dias % 5 != 0) {
            throw new ResourceException("El período debe ser múltiplo de 5.");
        }
        // Ejemplo simple: consumo diario fijo multiplicado por días
        double consumo = (agua + comida + oxigeno) * dias;
        if (consumo < 0) {
            throw new ResourceException("Consumo negativo no válido.");
        }
        return consumo;
    }

    /**
     * Calcula estadísticas básicas (mínimo, máximo y promedio) de una lista de consumos.
     * @param consumos Lista de valores de consumo.
     * @return Lista con [min, max, promedio].
     */
    public List<Double> calcularEstadisticas(List<Double> consumos) {
        if (consumos == null || consumos.isEmpty()) {
            return new ArrayList<>();
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        for (double c : consumos) {
            if (c < min) min = c;
            if (c > max) max = c;
            sum += c;
        }
        double promedio = sum / consumos.size();

        List<Double> resultado = new ArrayList<>();
        resultado.add(min);
        resultado.add(max);
        resultado.add(promedio);

        return resultado;
    }

    /**
     * Verifica si se está por debajo del umbral seguro de algún recurso.
     * @return true si se requiere alerta.
     */
    public boolean activarAlerta() {
        return (agua < umbralSeguro || comida < umbralSeguro || oxigeno < umbralSeguro);
    }

    // Getters / Setters
    public double getAgua() {
        return agua;
    }
    public double getComida() {
        return comida;
    }
    public double getOxigeno() {
        return oxigeno;
    }
    public void setAgua(double agua) {
        this.agua = agua;
    }
    public void setComida(double comida) {
        this.comida = comida;
    }
    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }
}
