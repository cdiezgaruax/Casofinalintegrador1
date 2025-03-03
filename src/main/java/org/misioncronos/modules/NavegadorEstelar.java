package org.misioncronos.modules;


import org.misioncronos.excepciones.NavegadorException;

/**
 * Módulo para calcular y visualizar rutas de exploración utilizando matrices.
 */
public class NavegadorEstelar {

    /**
     * Ejemplo de multiplicación de matrices para "optimizar" rutas.
     * @param m1 Primera matriz.
     * @param m2 Segunda matriz.
     * @return Resultado de la multiplicación.
     * @throws NavegadorException si las dimensiones no son compatibles.
     */
    public int[][] multiplicarMatrices(int[][] m1, int[][] m2) throws NavegadorException {
        int filasM1 = m1.length;
        int colsM1 = m1[0].length;
        int filasM2 = m2.length;
        int colsM2 = m2[0].length;

        if (colsM1 != filasM2) {
            throw new NavegadorException("Dimensiones incompatibles para multiplicación de matrices.");
        }

        int[][] resultado = new int[filasM1][colsM2];
        for (int i = 0; i < filasM1; i++) {
            for (int j = 0; j < colsM2; j++) {
                int suma = 0;
                for (int k = 0; k < colsM1; k++) {
                    suma += m1[i][k] * m2[k][j];
                }
                resultado[i][j] = suma;
            }
        }
        return resultado;
    }

    /**
     * Planifica una ruta simple dadas coordenadas de inicio y fin (simulación).
     * @param xInicio Coordenada X de inicio.
     * @param yInicio Coordenada Y de inicio.
     * @param xFin Coordenada X de fin.
     * @param yFin Coordenada Y de fin.
     * @return Cadena que describe la "ruta".
     */
    public String planificarRuta(int xInicio, int yInicio, int xFin, int yFin) {
        return "Ruta planificada desde (" + xInicio + "," + yInicio + ") hasta (" + xFin + "," + yFin + ").";
    }
}
