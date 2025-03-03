package org.misioncronos.modules;


import org.misioncronos.excepciones.MensajeException;
import java.util.ArrayList;
import java.util.List;

/**
 * Módulo para analizar y traducir mensajes entre la Tierra y la base.
 * Incluye conteo de vocales, inversión y verificación de palíndromos.
 */
public class ComunicadorInterplanetario {

    private List<String> mensajes;

    public ComunicadorInterplanetario() {
        this.mensajes = new ArrayList<>();
    }

    public void agregarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    /**
     * Cuenta las vocales en un mensaje.
     */
    public int contarVocales(String mensaje) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (char c : mensaje.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Invierte el contenido de un mensaje.
     */
    public String invertirMensaje(String mensaje) {
        return new StringBuilder(mensaje).reverse().toString();
    }

    /**
     * Verifica si un mensaje es palíndromo.
     */
    public boolean esPalindromo(String mensaje) {
        String limpio = mensaje.replaceAll("\\s+", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }

    /**
     * Simula la "traducción" de un mensaje (simple ejemplo).
     */
    public String traducirMensaje(String mensaje) throws MensajeException {
        if (mensaje == null || mensaje.isEmpty()) {
            throw new MensajeException("Mensaje vacío o nulo, no se puede traducir.");
        }
        // Ejemplo: añade un prefijo indicando "Traducción: "
        return "Traducción: " + mensaje;
    }

    public List<String> getMensajes() {
        return mensajes;
    }
}
