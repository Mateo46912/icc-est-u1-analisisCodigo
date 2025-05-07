import matplotlib.pyplot as plt

x = [1,2,3,4,5] 
y = [2,4,6,8,10]


# Crear una grafica de lineas
plt.plot(x,y, label = "linea", color = "blue")


#agregar parametros

plt.title("Mi primer grafico")
plt.xlabel ("Eje x")
plt.ylabel("Eje y")

#Agregar leyenda 
plt.legend()

#Mostrar ventana
plt.show()