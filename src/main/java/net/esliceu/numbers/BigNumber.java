package net.esliceu.numbers;

public class BigNumber implements BigNumberOperator {
    String valor;

    // Constructor 1
    public BigNumber(String s) {
        this.valor = quitarCeros(s);
    }

    // Constructor 2
    public BigNumber(BigNumber b) {
    }

    // Suma
    public String add(BigNumber other) {
        String b1 = this.valor;
        String b2 = other.valor;
        String res = "";
        int anterior = 0;
        int suma = 0;
        boolean llevo1 = false;
        //Si no tienen la misma longitud entramos en la función que se los añade
        if (b1.length() != b2.length()) {
            String[] temp = agregarCeros(b1, b2);
            b1 = temp[0];
            b2 = temp[1];
        }
        //Número a número comenzamos a sumar de derecha a izquierda
        for (int i = b2.length(); i > 0; i--) {
            //Cogemos las cifras de los dos números
            int c1 = Integer.parseInt(String.valueOf(b1.charAt(i - 1)));
            int c2 = Integer.parseInt(String.valueOf(b2.charAt(i - 1)));
            //Si llevo1 es true sumamos "1" al número en el que estamos
            if (llevo1) {
                c1++;
                llevo1 = false;
            }
            //Sumamos los números que hemos seleccionado antes.
            suma = c1 + c2;
            //Si la suma acaba siendo mayor a 9 ponemos llevo en true
            if (suma > 9) {
                llevo1 = true;
                //Concatenamos el número de la derecha a res
                res = String.valueOf(suma).substring(1) + res;
            } else {
                //Si no es mayor a 9 concatenamos igual
                res = suma + res;
            }
            //Guardamos en una variable el número que hemos guardado en suma
            anterior = suma;
        }
        //Si anterior es major a 9 añadimos al resultado 1
        if (anterior > 9) res = 1 + res;

        return res;
    }

    @Override
    public String subtract(BigNumber secondBigNumber) {
        return null;
    }

    private String[] agregarCeros(String b1, String b2) {
        //Si b1 es mayor que b2 le añadimos a b2 0 hasta que tengan la misma longitud
        if (b1.length() > b2.length()) {
            while (b2.length() != b1.length()) {
                b2 = 0 + b2;
            }
        } else {
            //Si b1 no es igual que b2 le añadimos a b1 0 hasta que tengan la misma longitud
            while (b1.length() != b2.length()) {
                b1 = 0 + b1;
            }
        }
        return new String[]{b1, b2};
    }

    // Resta
    public BigNumber sub(BigNumber other) {
        String b1 = this.valor;
        String b2 = other.valor;
        String res = "";
        int resta = 0;
        boolean llevo1 = false;
        //Si los dos números no tienen la misma longitud vamos a la función de añadir ceros
        if (b1.length() != b2.length()) {
            String[] temp = agregarCeros(b1, b2);
            b1 = temp[0];
            b2 = temp[1];
        }
        //Recorremos el número de derecha a izquierda
        for (int i = b2.length() - 1; i >= 0; i--) {
            //Seleccionamos las cifras que hay dentro de los números en la posición indicada por i
            int c1 = Integer.parseInt(String.valueOf(b1.charAt(i)));
            int c2 = Integer.parseInt(String.valueOf(b2.charAt(i)));
            //Si llevo1 es true le sumamos 1 a c2
            if (llevo1) {
                c2++;
                llevo1 = false;
            }
            //Si c2 es mayor que c1 llevo1 es true sumamos 10 a c1 i restamos con c2
            if (c2 > c1) {
                llevo1 = true;
                resta = (c1 + 10) - c2;
            } else {
                //Si no se cumple hacemos la resta normal
                resta = c1 - c2;
            }
            //Con cada ciclo le añadimos la resta al resultado
            res = resta + res;
        }
        return new BigNumber(res);
    }

    private String agregarCerosMultDerecha(String b2, String res, int i) {
        //Aquí entraremos cada vez que cambiemos para multiplicar con el número de abajo, siempre a partir del primer número
        if (b2.length() != i) {
            int cantidad = 0;
            cantidad = b2.length() - i;
            //Añadiremos tantos ceros a la derecha en base al número con el que multiplicamos
            for (int j = cantidad; j > 0; j--) {
                res += 0;
            }
        }
        return res;
    }

    String quitarCeros(String b1) {
        //Si nos dan un número con 0 al principio entramos
        if (b1.charAt(0) == '0') {
            //Recorremos el número
            for (int i = 0; i < b1.length(); i++) {
                //Guardamos la cifra en una variable temporal
                char c = b1.charAt(i);
                //Si no es cero entramos
                if (c != '0') {
                    //Quitamos a partir del indice de i
                    b1 = b1.substring(i);
                    break;
                }
            }
        }
        //Si el primer caracter del número es 0 le asignamos 0 como string
        if (b1.charAt(0) == '0') b1 = "0";
        return b1;
    }
}