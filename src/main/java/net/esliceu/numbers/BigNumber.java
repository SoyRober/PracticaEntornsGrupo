package net.esliceu.numbers;

public class BigNumber {
    String valor;

    // Constructor 1
    public BigNumber(String s) {
        this.valor = quitarCeros(s);
    }

    // Constructor 2
    public BigNumber(BigNumber b) {
    }

    // Suma
    BigNumber add(BigNumber other) {
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

        return new BigNumber(res);
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
    BigNumber sub(BigNumber other) {
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


    // Multiplica
    BigNumber mult(BigNumber other) {
        String b1 = this.valor;
        String b2 = other.valor;
        String res = "";
        int mult = 0;
        int llevoCantidad = 0;
        boolean llevoNumero = false;
        BigNumber resFinal = new BigNumber("0");
        //Recorremos el número de abajo de derecha a izquierda
        for (int i = b2.length(); i > 0; i--) {
            //Seleccionamos la cifra de abajo que le pertoca por el valor de i
            int c2 = Integer.parseInt(String.valueOf(b2.charAt(i - 1)));
            res = agregarCerosMultDerecha(b2, res, i);
            //Recorremos el número de abajo de derecha a izquierda
            for (int j = b1.length(); j > 0; j--) {
                int c1 = Integer.parseInt(String.valueOf(b1.charAt(j - 1)));
                //Multiplicacmos los números
                mult = c1 * c2;
                //Si llevo número es true se lo concatenamos a mult y llevoNumero lo ponemos en false
                if (llevoNumero) {
                    mult += llevoCantidad;
                    llevoNumero = false;
                }
                //Si la multiplicación ha sido mayor que 9
                if (mult > 9) {
                    llevoNumero = true;
                    //Cogemos la cifra de la derecha para luego podersela concatenar
                    llevoCantidad = Integer.parseInt(String.valueOf(String.valueOf(mult).charAt(0)));
                    //Le concatenamos
                    res = String.valueOf(mult).substring(1) + res;
                } else {
                    //Si la multiplicación es menor o igual a 9 la añadiremos directamente al resultado
                    res = mult + res;
                }
            }
            // Añadir ceros a "sumar" a la derecha segun sea el digito que calculas
            if (llevoNumero) {
                res = llevoCantidad + res;
                llevoNumero = false;
            }
            //Vamos sumando los resultados con cada bucle
            BigNumber t = new BigNumber(res);
            resFinal = resFinal.add(t);
            res = "";
        }
        return resFinal;
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

    // Divideix
    BigNumber div(BigNumber other) {
        StringBuilder coef = new StringBuilder();
        String selecDeNum = "";
        String mult = "";
        //Miramos cual de los dos numeros es más grande
        int majorMenor = this.compareTo(other);
        //Si this es menor devolvemos 0
        if (majorMenor == -1) {
            return new BigNumber("0");
            //Si son iguales devolvemos 1
        } else if (majorMenor == 0) {
            return new BigNumber("1");
        } else {
            for (int i = 0; i < this.valor.length(); i++) {
                BigNumber c = new BigNumber(String.valueOf(this.valor.charAt(i)));
                selecDeNum += c;
                if (new BigNumber(selecDeNum).compareTo(other) >= 0) {
                    for (int j = 1; j < 11; j++) {
                        mult = String.valueOf(other.mult(new BigNumber(String.valueOf(j))));
                        if (new BigNumber(mult).compareTo(new BigNumber(selecDeNum)) > 0) {
                            coef.append(j - 1);
                            selecDeNum = String.valueOf(new BigNumber(selecDeNum).sub((other.mult(
                                    new BigNumber(String.valueOf(j - 1))))));
                            break;
                        }
                    }
                } else {
                    if (!coef.toString().equals("")) {
                        coef.append("0");
                    }
                }
            }
        }
        return new BigNumber(String.valueOf(coef));
    }

    // Arrel quadrada
    BigNumber sqrt() {
        BigNumber temp;
        //Lo dividimos entre dos ya que no será mayor que la mitad
        BigNumber res = (new BigNumber(this.valor).div(new BigNumber("2")));
        //Hacemos que entre en el bucle
        do {
            //Guardamos el resultado en la variable temporal
            temp = res;
            //Hacemos la división del número con su mitad
            BigNumber a = (new BigNumber(this.valor).div((temp)));
            //Luego sumamos el temporal
            BigNumber b = (temp.add(a));
            res = ((b).div(new BigNumber("2")));
        } while (!String.valueOf(temp.sub(res)).equals("0"));
        return (res);
    }

    // Potència
    BigNumber power(int n) {
        BigNumber potencia = new BigNumber(this.valor);
        //Multiplicamos por el mismo número hasta que n sea menor que i
        for (int i = 1; i < n; i++) {
            potencia = potencia.mult(this);
        }
        return potencia;
    }

    // Factorial
    BigNumber factorial() {
        BigNumber res = new BigNumber(this.valor);
        BigNumber menos1 = new BigNumber("1");
        //Restamos 1 al número
        BigNumber numero = new BigNumber(String.valueOf(this.sub(menos1)));
        //Mientras que numero no sea 1 entramos en el bucle
        while (!numero.valor.equals("1")) {
            res = res.mult(numero);
            numero = numero.sub(menos1);
        }
        return res;
    }

    // MCD. Torna el Màxim comú divisor
    BigNumber mcd(BigNumber other) {
        String b1 = this.valor;
        String b2 = other.valor;
        // Mientras que b2 no este vació entramos en el bucle
        while (!String.valueOf(b2).equals("")) {
            //Esta variable temporal es para no perder b2
            String temporal = b2;
            //Calculamos el resto mediante la multiplicación, division i resta
            b2 = String.valueOf(new BigNumber(b1).sub(new BigNumber(b1).div(new BigNumber(b2)).mult(new BigNumber(b2))));
            b1 = temporal;
            String c = String.valueOf(b2.charAt(0));
            if (c.equals("0")) {
                b2 = "";
            }
        }
        return (new BigNumber(b1));
    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1
    // si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        String b1 = this.valor;
        String b2 = other.valor;
        //Sí el primer número és más largo que el segundo devolvemos "1"
        if (b1.length() > b2.length()) {
            return 1;
            //Sí el segundo número és más largo que el primero devolvemos "-1"
        } else if (b1.length() < b2.length()) {
            return -1;
        } else {
            //En este punto ambos número son igual de largos
            for (int i = 0; i < b1.length(); i++) {
                //Cogemos la cifra de cada numero que le pertoca designada por i
                int c1 = Integer.parseInt(String.valueOf(b1.charAt(i)));
                int c2 = Integer.parseInt(String.valueOf(b2.charAt(i)));
                //Sí entramos en este condicional el primer número será el grande y devolvemos 1
                if (c1 > c2) {
                    return 1;
                    //Si entramos en este es que el segundo número es más grande i devolvemos -1
                } else if (c1 < c2) {
                    return -1;
                }
            }
        }
        //Si no hemos entrado en ninguno de los "if" anteriores quiere decir que ambos número son exactamente iguales
        return 0;
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

    // Torna un String representant el número
    public String toString() {
        return this.valor;
    }

    // Mira si dos objectes BigNumber són iguals
    public boolean equals(Object other) {
        BigNumber b = (BigNumber) other;
        if (b.valor.equals(this.valor)) return true;
        return false;
    }
}