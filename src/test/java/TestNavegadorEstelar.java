package org.misioncronos.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.misioncronos.modules.NavegadorEstelar;
import org.misioncronos.excepciones.NavegadorException;

public class TestNavegadorEstelar {

    @Test
    public void testMultiplicarMatrices() {
        NavegadorEstelar ne = new NavegadorEstelar();
        int[][] m1 = { {1,2}, {3,4} };
        int[][] m2 = { {2,0}, {1,2} };
        try {
            int[][] resultado = ne.multiplicarMatrices(m1, m2);
            // resultado esperado:
            // [ [1*2 + 2*1, 1*0 + 2*2],
            //   [3*2 + 4*1, 3*0 + 4*2] ]
            // = [ [4, 4], [10, 8] ]
            assertArrayEquals(new int[]{4,4}, resultado[0]);
            assertArrayEquals(new int[]{10,8}, resultado[1]);
        } catch (NavegadorException e) {
            fail("No debería lanzar excepción con dimensiones 2x2.");
        }
    }

    @Test
    public void testMultiplicarMatricesError() {
        NavegadorEstelar ne = new NavegadorEstelar();
        int[][] m1 = { {1,2,3}, {4,5,6} };
        int[][] m2 = { {1,2}, {3,4} };
        // m1 es 2x3, m2 es 2x2 -> No se pueden multiplicar (3 != 2).
        assertThrows(NavegadorException.class, () -> {
            ne.multiplicarMatrices(m1, m2);
        });
    }
}
