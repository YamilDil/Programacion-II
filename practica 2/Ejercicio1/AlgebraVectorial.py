import math

class AlgebraVectorial:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    def mostrar(self):
        return (self.x, self.y, self.z)

    def suma(self, otro):
        return AlgebraVectorial(self.x + otro.x, self.y + otro.y, self.z + otro.z)

    def resta(self, otro):
        return AlgebraVectorial(self.x - otro.x, self.y - otro.y, self.z - otro.z)

    def producto_escalar(self, otro):
        return self.x*otro.x + self.y*otro.y + self.z*otro.z

    def producto_vectorial(self, otro):
        return AlgebraVectorial(
            self.y*otro.z - self.z*otro.y,
            self.z*otro.x - self.x*otro.z,
            self.x*otro.y - self.y*otro.x
        )

    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    def es_perpendicular(self, otro):
        return self.producto_escalar(otro) == 0

    def es_paralelo(self, otro):
        return self.producto_vectorial(otro).magnitud() == 0

    def proyeccion_sobre(self, otro):
        factor = self.producto_escalar(otro) / (otro.magnitud()**2)
        return AlgebraVectorial(otro.x*factor, otro.y*factor, otro.z*factor)

    def componente_en(self, otro):
        return self.producto_escalar(otro) / otro.magnitud()


# ----------- Prueba -------------
a = AlgebraVectorial(2, 3, 4)
b = AlgebraVectorial(4, 6, 8)

print("a =", a.mostrar())
print("b =", b.mostrar())
print("a+b =", a.suma(b).mostrar())
print("a·b =", a.producto_escalar(b))
print("a×b =", a.producto_vectorial(b).mostrar())
print("¿a ⟂ b?:", a.es_perpendicular(b))
print("¿a ∥ b?:", a.es_paralelo(b))
print("Proyección de a sobre b:", a.proyeccion_sobre(b).mostrar())
print("Componente de a en b:", a.componente_en(b))
