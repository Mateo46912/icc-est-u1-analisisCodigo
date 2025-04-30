import java.util.Arrays;

public class MetodosOrdenamiento {

    // Método de burbuja tradicional con errores
    // Error encontrado: return devuelve un arreglo vacio
    // Solucion modificar el return para devolver la variable arreglo

    public int[] burbujaTradicional(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arreglo[i] > arreglo[j]) {
                    // Intercambio de elementos
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
        return arreglo;
    }

    // Método de burbuja tradicional con errores
    // Error encontrado: El arreglo ordenaba de manera descendente.
    // Solucion: cambiar la condicion if en vez de que arreglo[i] < arreglo [j] ahora arreglo[i] > arreglo [j]

    public int[] burbujaTradicionalSegundo(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arreglo[i] > arreglo[j]) {
                    // Intercambio de elementos
                    // Estas 3 lineas NO DEBEN ser modificadas
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }

        return arreglo;

    }

    // Método de burbuja tradicional con errores
    // Error encontrado: El error era que i no estaba en el rango del arreglo correcto,
    // ademas j empezaba en la posicion 0 cuando deberia empezar en la primera posicion
    // por ultimo en el if j mayo j mas 1 esta mal deberia ser j menor a i.

    // Solucion: Ajustar el tamaño de i de menor que n -1 a menor que n,
    // hacer que j empieze valiendo i mas 1.
    // por ultimo se ajusto el if.
    public int[] burbujaTradicionalTercero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1 ; j < n; j++) {
                if (arreglo[j] < arreglo[i]) {
                    // Intercambio de elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = temp;
                }
            }
        }
        return arreglo;
    }

    // Método de selección con errores
    // Error encontrado: El metodo no devolvia el arreglo ordenado.

    //Solucion: Agregamos el return arreglo al final de los bucles. 
    public int[] seleccionPrimero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int smallerNumber = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = smallerNumber;
        }
        return arreglo;

    }

    // Método de selección con errores
    // Error encontrado: El error era que j no crecia disminuia ademas faltaba la condicion para el intercambio
    // Solucion: Se cambio j-- por j++ y se agrego la condicion if (i!= indiceMinimo) en el intercambio
    public int[] seleccionSegundo(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (i!= indiceMinimo){
                int smallerNumber = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = arreglo[i];
                arreglo[i] = smallerNumber;
    
            }
        }
        return arreglo;
    }

    // Método de selección con errores
    // Error encontrado: El error era que la condicion de cambio guardabamos mal la posicion del indice,
    // guardabamos indice en i y deberia ser alreves.
    // Solucion: Guardar el indice en i y este indice igualarlo al indice. 
    public int[] seleccionTercero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length -1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (i!= indiceMinimo){
                int smallerNumber = arreglo[i];
                arreglo[i] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = smallerNumber;
            }
        }
        return arreglo;
    }

    // Método de inserción con errores
    // Error encontrado: Ordenaba de manera descendente
    // Solucion: Cambiar el sentido de la condicion Del while asi arreglo[i] > key.

    public int[] insercionPrimero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j - 1;

            while (i >= 0 && arreglo[i] > key) {
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = key;
        }
        return arreglo;
    }

    // Método de inserción con errores
    // Error encontrado:
    public int[] insercionSegundo(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int j = 1; j < arreglo.length; j++) {
            int actual = arreglo[j];

            int i = j - 1;
            
            for (; i >= 0 && arreglo[j] > actual; ) {
                arreglo[j + 1] = arreglo[i];
                j--;
            }
            arreglo[i + 1] = actual;
        }
        return arreglo;
    }

    // Método de inserción con errores
    // Error encontrado: faltaba return y ordenaba mal
    // Solucion : agregar return y cambiar condicion de cambio
    public int[] insercionTercero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j-1;

            while (i >= 0 && arreglo[i] > key) {
                arreglo[i + 1] = arreglo[i];
                i++;
            }
            arreglo[i + 1] = key;
        }
        return arreglo;
    }

}
