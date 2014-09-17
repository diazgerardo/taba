package ar.com.scriptorum.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MathUtilsTest {

   @Test
   public void round(){
       
       MathUtils mu = new MathUtils();
       int decimals = 2;
       
       // a) 4,123 ⇒ Regla 1: Si el dígito a la derecha del último requerido es
       // menor que 5, se deja el dígito precedente intacto. Respuesta: 4,12
       //
       double d = mu.round(4.123, decimals).doubleValue();
       assertTrue(4.12==d);
       
       d = mu.round(4.1249999999, decimals).doubleValue();
       assertTrue(4.12==d);
       
       // b) 8,627 ⇒ Regla 2: Si el dígito a la derecha del último requerido es
       // mayor que 5, se aumenta una unidad el dígito precedente. Respuesta: 8,63
       //
       d = mu.round(8.627, decimals).doubleValue();
       assertTrue(8.63 == d);
       
       // c) 9,4252 ⇒ Regla 3: Si el dígito a la derecha del último requerido es un
       // 5 seguido de cualquier dígito diferente de cero, se aumenta una unidad el
       // dígito precedente. Respuesta: 9,43
       //
       d = mu.round(9.4252, decimals).doubleValue();
       assertTrue(9.43 == d);
       
       // d) 7,385 ⇒ Regla 4: Si el dígito a la derecha del último requerido es un
       // 5 no seguido de dígitos, se deja el dígito precedente sin cambiar si es
       // par... Respuesta: 7,38
       //
       d = mu.round(7.385, decimals).doubleValue();
       assertTrue(7.38 == d);

       // e) 6,275 ⇒ Regla 5: Si el dígito a la derecha del último requerido es un
       // 5 no seguido de dígitos..., se aumenta el dígito precedente una unidad si
       // es impar. Respuesta: 6,28
       d = mu.round(6.275, decimals).doubleValue();
       assertTrue(6.28 == d);

       
       // 0 decimals
       d = mu.round(6.275, 0).doubleValue();
       assertTrue(6 == d);

       // fractionary numbers
       double dividend = 1D/3; 
       d = mu.round(dividend, 2).doubleValue();
       assertTrue(0.33 == d);

       dividend = 0.0001D/7;
       d = mu.round(dividend, 5).doubleValue();
       assertTrue(0.00001 == d);

       dividend = 3D/7; //0.42857142857142855
       d = mu.round(dividend, 2).doubleValue();
       assertTrue(0.43 == d);

       // rule 5
       d = mu.round(dividend, 16).doubleValue();
       assertTrue(0.4285714285714286 == d);
       
       double squareRootOf2 = Math.pow(2D, 1D/2); 
       assertTrue(squareRootOf2==1.4142135623730951);
       d= mu.round(squareRootOf2, 2).doubleValue();
       assertTrue(1.41 == d);
       d=mu.round(squareRootOf2, 10).doubleValue();
       assertTrue(d==1.4142135624);
       d=mu.round(squareRootOf2, 11).doubleValue();
       assertTrue(d==1.41421356237);
       
   }
   
    
}
