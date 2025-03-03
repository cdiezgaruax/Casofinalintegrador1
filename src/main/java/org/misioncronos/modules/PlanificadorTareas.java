package org.misioncronos.modules;


import org.misioncronos.excepciones.TareaException;
import java.util.List;

/**
 * Módulo para asignar y optimizar tareas diarias. Permite calcular la carga de trabajo (producto escalar).
 */
public class PlanificadorTareas {

    private List<String> listaTareas;
    private List<String> miembrosTripulacion;

    public PlanificadorTareas(List<String> listaTareas, List<String> miembrosTripulacion) {
        this.listaTareas = listaTareas;
        this.miembrosTripulacion = miembrosTripulacion;
    }

    /**
     * Asigna tareas de forma sencilla: cada miembro recibe una parte de la lista de tareas.
     * @throws TareaException si no hay tareas o no hay tripulantes.
     */
    public void asignarTareas() throws TareaException {
        if (listaTareas == null || listaTareas.isEmpty()) {
            throw new TareaException("No hay tareas disponibles para asignar.");
        }
        if (miembrosTripulacion == null || miembrosTripulacion.isEmpty()) {
            throw new TareaException("No hay miembros de tripulación disponibles.");
        }
        // Lógica simple de asignación (ejemplo)
        int index = 0;
        for (String tarea : listaTareas) {
            String miembro = miembrosTripulacion.get(index);
            System.out.println("Asignando tarea '" + tarea + "' a " + miembro);
            index = (index + 1) % miembrosTripulacion.size();
        }
    }

    /**
     * Muestra una tabla de "multiplicar" simulando la visualización de tareas por día (metáfora).
     * @param numero Hasta qué número mostrar la "tabla".
     */
    public void mostrarTablaTareas(int numero) {
        System.out.println("=== Tabla de Multiplicar (Metáfora de Tareas) ===");
        for (int i = 1; i <= numero; i++) {
            for (int j = 1; j <= numero; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Calcula la carga de trabajo óptima (ejemplo simplificado de producto escalar).
     * @param vector1 Vector con horas disponibles por tripulante.
     * @param vector2 Vector con esfuerzo requerido por tarea.
     * @return Resultado del producto escalar.
     * @throws TareaException si los vectores no tienen la misma longitud.
     */
    public int calcularCargaTrabajo(int[] vector1, int[] vector2) throws TareaException {
        if (vector1.length != vector2.length) {
            throw new TareaException("Los vectores deben tener la misma longitud.");
        }
        int resultado = 0;
        for (int i = 0; i < vector1.length; i++) {
            resultado += vector1[i] * vector2[i];
        }
        return resultado;
    }

    // Getters / Setters
    public List<String> getListaTareas() {
        return listaTareas;
    }
    public List<String> getMiembrosTripulacion() {
        return miembrosTripulacion;
    }
}
