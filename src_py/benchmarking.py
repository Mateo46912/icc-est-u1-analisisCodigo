from metodos_ordenamiento import Metodos_Ordenamiento
import random
import time
class Benchmarking:
    
    # public Benchmarking
    def __init__(self):
        print ("Benchmarking instanciado")

        self.mO = Metodos_Ordenamiento()

        arreglo = self.build_arreglo(50000)

        #Burbuja
        tarea = lambda: self.mO.sort_bubble(arreglo)                                          # lambda es ()->

        tiempo_milisegundos = self.contar_con_current_time_milles(tarea)
        print (f"El tiempo en milisegundos con burbuja: {tiempo_milisegundos}",)

        tiempo_nanosegundos = self.contar_con_nano_time(tarea)
        print (f"El tiempo en nanosegundos con burbuja: {tiempo_nanosegundos}",)

        #BB mejorado
        tarea = lambda: self.mO.sort_burbuja_mejorado_optimizado(arreglo)

        tiempo_nanosegundos = self.contar_con_nano_time(tarea)
        print (f"El tiempo en nanosegundos con BB mejorado es: {tiempo_nanosegundos}",)

        #Seleccion
        tarea = lambda: self.mO.sort_seleccion(arreglo)

        tiempo_nanosegundos = self.contar_con_nano_time(tarea)
        print (f"El tiempo en nanosegundos con seleccion es: {tiempo_nanosegundos}",)





    def build_arreglo(self, tamano):
        arreglo = [tamano]
        for i in range(tamano):
            numero = random.randint(0,99999)
            arreglo.append(numero)
        return arreglo
        
    # importar time        
    def contar_con_current_time_milles(self, tarea):
        inicio = time.time()
        tarea()
        end = time.time()
        tiempo_segundos = end - inicio
        return (tiempo_segundos)
        

    def contar_con_nano_time(self, tarea):    
        inicio = time.time_ns()
        tarea()
        end = time.time_ns()
        tiempo_segundos = (end - inicio) / 1_000_000_000.0
        return (tiempo_segundos)