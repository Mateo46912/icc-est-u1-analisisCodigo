import java.util.Random;

public class Benchmarking {

    private MetodosOrdenamiento mOrdenamiento;
    
    public Benchmarking(){
        long currentMillis = System.currentTimeMillis();   // sirve para sacar la fecha   todos los sistemas operativos cuentan desde el uno de enero 1970 hasta hoy 1745971944398
        long currentNano = System.nanoTime();

        System.out.println(currentMillis);
        System.out.println(currentNano);

        mOrdenamiento = new MetodosOrdenamiento();
        int[] arreglo = generarArregloAleatorio(10);
        Runnable tarea = () -> mOrdenamiento.burbujaTradicional(arreglo);
        double tiempoDuracionMilis = medirCurrentTimeMiles(tarea);
        double tiempoDuracionNano = medirNanoTime(tarea);
        System.out.println("Tiempo en milisegundos: "+tiempoDuracionMilis);
        System.out.println("Tiempo en nanosegundos: "+tiempoDuracionNano);

    }



    private int [] generarArregloAleatorio (int tamaño){
        int [] array = new int [tamaño];
        Random random = new Random();
        for ( int i = 0; i < tamaño; i++){
            // 0 a 99.999
            array [i] = random.nextInt(100000);

        }
        return array;
    }


    public double medirCurrentTimeMiles (Runnable tarea){
        long inicio = System.currentTimeMillis();
        tarea.run();
        long end  = System.currentTimeMillis();
        double tiempoSegundos = (end - inicio)/1000.0 ;
        return tiempoSegundos;
    }

    public double medirNanoTime (Runnable tarea){
        long inicio = System.nanoTime();
        tarea.run();
        long end  = System.nanoTime();
        double tiempoSegundos = (end - inicio)/1_000_000_000.0 ;
        return tiempoSegundos;
    }
}
