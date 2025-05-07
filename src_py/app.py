# Archivo principal main
from datetime import datetime 
import benchmarking as bm
from metodos_ordenamiento import MetodosOrdenamiento
import matplotlib.pyplot as plt
#import metodos_ordenamiento as ms
#from benchmarking import Benchmarking


if __name__ == "__main__":

    print ("Funciona") 

    bench = bm.Benchmarking()
    metodos = MetodosOrdenamiento()
    
    #tam = 1000
     #para practica crear solo un arreglo grabde y ese dividirlo

    tamanios = [500, 1000, 2000,]
    resultados = []
    

    for tam in tamanios:
        arreglo_base = bench.build_arreglo(tam)


        metodos_dic = {
        "burbuja":metodos.sort_bubble,
        "Burbuja mejorado" : metodos.sort_burbuja_mejorado_optimizado,      
        "Seleccion": metodos.sort_seleccion,
        "Shell": metodos.sort_Shell
        }

    

        for nombre, fun_metodo in metodos_dic.items():                         # . items devuelve un arreglo de tuplas el primero a clave y el segundo a valor
            tiempo_resultado = bench.medir_tiempo(fun_metodo, arreglo_base)
            tupla_resultado = (tam, nombre, tiempo_resultado)
            resultados.append(tupla_resultado)

        for tam, nombre, tiempo_resultado in resultados:
            print(f"\n -TAMAÑO-: {tam} , --NOMBRE METODO--: {nombre}, -TIEMPO-: {tiempo_resultado: .6f} segundos") 

  #Preparar datos para ser graficados
  #1 crear diccionario para almacenra resultados de los metodos  
    tiempos_by_metodo = {
        "burbuja":[],
        "Burbuja mejorado" : [],      
        "Seleccion": [],
        "Shell": [],

    }


    for tam,nombre,tiempo in resultados: 
        tiempos_by_metodo[nombre].append(tiempo)

    # plt.figure(figsize = (10,6))

    # #Graficar tiempos de ejecucion para cada metodo
    # for nombre, tiempos in tiempos_by_metodo.items():
    #     plt.plot(tamanios, tiempos, label= nombre , marker ="o")


    # #parametros    
    
    # plt.title("Comparacion de tiempo para cada metodo de ordenamiento")
    # plt.xlabel ("tamanio de los arreglos")
    # plt.ylabel("Tiempo de ejecucion (s)")

    # #Agregar leyenda 
    # plt.legend()
    # plt.grid(True)
    # plt.tight_layout
    
    # #Mostrar ventana
    # plt.show()
    

    # x = [1,2,3,4,5] 
    # y = [2,4,6,8,10]


  
    # plt.plot(x,y, label = "linea", color = "blue")

    # plt.title("Mi primer grafico")
    # plt.xlabel ("Eje x")
    # plt.ylabel("Eje y")
 
    # plt.legend()
    # plt.grid(True)
    # plt.tight_layout

    # plt.show()

    ahora = datetime.now().strftime("%d/%m/%Y %H:%M:%S")
    nombre_autor = "MATEO CORDERO"

    # Crear una figura con 2 subgráficos (1 fila, 2 columnas)
    fig, axs = plt.subplots(1, 2, figsize=(14, 6))
    fig.canvas.manager.set_window_title(f"{nombre_autor} - {ahora}")

    # Subgráfico 1: Comparación de tiempos
    for nombre, tiempos in tiempos_by_metodo.items():
        axs[0].plot(tamanios, tiempos, label=nombre, marker="o")

    axs[0].set_title("Comparación de Tiempos de Ejecución de Algoritmos de Ordenamiento")
    axs[0].set_xlabel("Tamaño del arreglo")
    axs[0].set_ylabel("Tiempo de ejecución (segundos)")
    axs[0].legend()
    axs[0].grid(True)

    # Subgráfico 2: Línea de ejemplo
    x = [1, 2, 3, 4, 5]
    y = [2, 4, 6, 8, 10]
    axs[1].plot(x, y, label="Línea 1", color="blue")
    axs[1].set_title("Gráfico de Ejemplo con Matplotlib")
    axs[1].set_xlabel("Eje X")
    axs[1].set_ylabel("Eje Y")
    axs[1].legend()
    axs[1].grid(True)

    # Título global con nombre y fecha
    fig.suptitle(f"{nombre_autor} – {ahora}", fontsize=14, fontweight='bold')

    plt.tight_layout(rect=[0, 0, 1, 0.95])  # deja espacio para el título
    plt.show()





