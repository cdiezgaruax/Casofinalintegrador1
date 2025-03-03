package org.misioncronos;

import org.misioncronos.excepciones.*;
import org.misioncronos.modules.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal que integra y demuestra el uso de todos los módulos de la misión Cronos.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Misión Espacial Cronos: Ejecución Integrada ===");

        // 1. Cronómetro Cósmico
        System.out.println("\n--- [1] Cronómetro Cósmico ---");
        CronometroCosmico cronometro = new CronometroCosmico(2.0);
        long tiempoTierra = 100;
        cronometro.setTiempoTierra(tiempoTierra);
        try {
            long tiempoPlaneta = cronometro.convertirTiempo(tiempoTierra);
            System.out.println("Tiempo en el nuevo planeta: " + tiempoPlaneta + " seg");
        } catch (ConversionException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println(cronometro.mostrarTiempo());

        // 2. Recursos y Suministros
        System.out.println("\n--- [2] Recursos y Suministros ---");
        RecursosSuministros recursos = new RecursosSuministros(10, 5, 3, 2);
        try {
            double consumo = recursos.calcularConsumo(10);  // múltiplo de 5
            System.out.println("Consumo para 10 días: " + consumo);
        } catch (ResourceException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("¿Se requiere alerta? " + recursos.activarAlerta());
        List<Double> consumos = Arrays.asList(60.0, 50.0, 70.0);
        List<Double> stats = recursos.calcularEstadisticas(consumos);
        if (!stats.isEmpty()) {
            System.out.println("Mínimo: " + stats.get(0) + ", Máximo: " + stats.get(1) + ", Promedio: " + stats.get(2));
        }

        // 3. Sistema de Alerta y Monitoreo
        System.out.println("\n--- [3] Sistema de Alerta y Monitoreo ---");
        SistemaAlertaMonitoreo sistemaMonitoreo = new SistemaAlertaMonitoreo(80, 30, 1);
        try {
            List<Integer> primos = sistemaMonitoreo.detectarEventos(20);
            System.out.println("Primos hasta 20: " + primos);
        } catch (MonitorException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("¿Valores peligrosos? " + sistemaMonitoreo.monitorear());
        System.out.println("Descomponer 60 en factores primos: " + sistemaMonitoreo.descomponerProblema(60));

        // 4. Planificador de Tareas
        System.out.println("\n--- [4] Planificador de Tareas ---");
        List<String> tareas = Arrays.asList("Reparar paneles", "Analizar muestras", "Configurar antena");
        List<String> tripulacion = Arrays.asList("Alice", "Bob");
        PlanificadorTareas planificador = new PlanificadorTareas(tareas, tripulacion);
        try {
            planificador.asignarTareas();
            planificador.mostrarTablaTareas(5);
            int[] horasDisponibles = {2, 3};
            int[] esfuerzoRequerido = {4, 5};
            int carga = planificador.calcularCargaTrabajo(horasDisponibles, esfuerzoRequerido);
            System.out.println("Carga de trabajo (producto escalar): " + carga);
        } catch (TareaException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 5. Navegador Estelar
        System.out.println("\n--- [5] Navegador Estelar ---");
        NavegadorEstelar navegador = new NavegadorEstelar();
        int[][] m1 = { {1,2}, {3,4} };
        int[][] m2 = { {2,0}, {1,2} };
        try {
            int[][] resultado = navegador.multiplicarMatrices(m1, m2);
            System.out.println("Multiplicación de matrices:");
            for (int i = 0; i < resultado.length; i++) {
                System.out.println(Arrays.toString(resultado[i]));
            }
        } catch (NavegadorException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println(navegador.planificarRuta(0,0,5,5));

        // 6. Comunicador Interplanetario
        System.out.println("\n--- [6] Comunicador Interplanetario ---");
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        comunicador.agregarMensaje("Hola Base");
        comunicador.agregarMensaje("Somos Astronautas");
        for (String msg : comunicador.getMensajes()) {
            System.out.println("Mensaje: " + msg + ", Vocales: " + comunicador.contarVocales(msg));
            System.out.println("Invertido: " + comunicador.invertirMensaje(msg));
            System.out.println("¿Es palíndromo?: " + comunicador.esPalindromo(msg));
            try {
                System.out.println(comunicador.traducirMensaje(msg));
            } catch (MensajeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n=== Fin de la ejecución integrada de la Misión Cronos ===");
    }
}
