package net.esliceu.numbers;

public class BigNumber implements BigNumberOperator {
    String valor;

    // Constructor 1
    public BigNumber(String s) {
        this.valor = quitaCeros(s);
    }

    // Constructor 2
    public BigNumber(BigNumber b) {
    }

    // Suma
    public String add(BigNumber other) {
        String numero1 = this.valor;
        String numero2 = other.valor;
        String resultado = "";
        int anterior = 0;
        int suma;
        boolean llevoNumero = false;

        // En caso de que la longitud de ambos números no coincida, la igualaremos añadiendo ceros a la izquierda en el
        // número pequeño
        if (numero1.length() != numero2.length()) {
            String[] temporal = ponCeros(numero1, numero2);
            numero1 = temporal[0];
            numero2 = temporal[1];
        }

        //Número a número comenzamos a sumar de derecha a izquierda
        for (int i = numero2.length(); i > 0; i--) {
            int caracterNum1 = Integer.parseInt(String.valueOf(numero1.charAt(i - 1)));
            int caracterNum2 = Integer.parseInt(String.valueOf(numero2.charAt(i - 1)));
            //Sí nuestro booleano está activo sumamos "1" al número en el que estamos
            if (llevoNumero) {
                caracterNum1++;
                llevoNumero = false;
            }
            //Sumamos ambos números y guardamos el resultado en una variable.
            suma = caracterNum1 + caracterNum2;

            //Sí la suma excede de 9 activamos el booleano para que al mirar el próximo número sumarle "1" por el acarreo
            if (suma > 9) {
                llevoNumero = true;
                //A "res" le añadimos sólamente el último número
                resultado = String.valueOf(suma).substring(1) + resultado;
            } else {
                //Sí la suma no excede de 9 simplemete lo añadimos a "res" sin hacer nada más
                resultado = suma + resultado;
            }
            //Guardamos en una variable el número que hemos guardado en suma
            anterior = suma;
        }

        //Una vez hemos acabado de sumar todos los números, en caso de que el último haya diso superior a 9 añadiríamos
        // un "1" a la izquierda del todo
        if (anterior > 9) {
            resultado = 1 + resultado;
        }
        return resultado;
    }

    @Override
    public String substract(BigNumber secondBigNumber) {
        String numero1 = this.valor;
        String numero2 = secondBigNumber.valor;
        String resultado = "";
        int resta;
        boolean llevoNumero = false;

        // En caso de que la longitud de ambos números no coincida, la igualaremos añadiendo ceros a la izquierda en el
        // número pequeño
        if (numero1.length() != numero2.length()) {
            String[] temporal = ponCeros(numero1, numero2);
            numero1 = temporal[0];
            numero2 = temporal[1];
        }

        //Iremos número por número, de derecha a izquierda realizando la resta
        for (int i = numero2.length() - 1; i >= 0; i--) {
            int caracterNum1 = Integer.parseInt(String.valueOf(numero1.charAt(i)));
            int caracterNum2 = Integer.parseInt(String.valueOf(numero2.charAt(i)));

            //Si el booleano está activado entraremos en el if para sumarle "1" al número con el que estaremos trabajando
            if (llevoNumero) {
                caracterNum2++;
                llevoNumero = false;
            }

            //Sí el número de abajo es más grande que el de arriba, sumamos 10 al numero de arriba, hacemos la resta y
            // activamos el booleano para llevar a cabo el acarreo en el siguiente número
            if (caracterNum2 > caracterNum1) {
                llevoNumero = true;
                resta = (caracterNum1 + 10) - caracterNum2;
            } else {
                //Si no entramos en el anterior if realizaremos la resta normal ya que significará que el número de
                // arriba es el grande, pues no nos daría problemas
                resta = caracterNum1 - caracterNum2;
            }
            //Constantemente añanimos la resta al resultado final para ir construyendolo poco a poco
            resultado = resta + resultado;
        }
        return resultado;
    }

    private String[] ponCeros(String s1, String s2) {
        //Sí un número es mayor al otro, añadimos tantos ceros a la izquierda como sean necesarios, hasta que
        // la longitud de ambos números sean iguales
        if (s1.length() > s2.length()) {
            while (s2.length() != s1.length()) {
                s2 = 0 + s2;
            }
        } else {
            while (s1.length() != s2.length()) {
                s1 = 0 + s1;
            }
        }
        return new String[]{s1, s2};
    }

    String quitaCeros(String b1) {

        // Sí el primer número empezando por la izquierda es "0" comenzaremos a eliminarlos hasta que aparezca un número
        // diferente
        if (b1.charAt(0) == '0') {
            for (int i = 0; i < b1.length(); i++) {
                char c = b1.charAt(i);
                if (c != '0') {
                    b1 = b1.substring(i);
                    break;
                }
            }
        }
        // En caso de que el primer número siga siendo 0 mantendremos el String con un solo 0
        if (b1.charAt(0) == '0') {
            b1 = "0";
        }
        return b1;
    }
}


