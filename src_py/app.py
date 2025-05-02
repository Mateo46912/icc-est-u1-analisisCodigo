# Archivo principal main
import benchmarking as bm
from metodos_ordenamiento import MetodosOrdenamiento
#import metodos_ordenamiento as ms
#from benchmarking import Benchmarking


if __name__ == "__main__":

    print ("Funciona") 

    bench = bm.Benchmarking()
    metodos = MetodosOrdenamiento()
    
    #tam = 1000
     #para practica crear solo un arreglo grabde y ese dividirlo

    tamanios = [5000, 10000, 20000]
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

    












