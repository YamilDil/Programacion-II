import math

class Vector3D:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    def mostrar(self):
        return (self.x, self.y, self.z)

    def __add__(self, otro):
        return Vector3D(self.x + otro.x, self.y + otro.y, self.z + otro.z)

    def __mul__(self, otro):
        if isinstance(otro, (int, float)):   # escalar * vector
            return Vector3D(self.x*otro, self.y*otro, self.z*otro)
        elif isinstance(otro, Vector3D):     # producto escalar
            return self.x*otro.x + self.y*otro.y + self.z*otro.z

    def __rmul__(self, otro):
        # permite que funcione 3 * a
        return self.__mul__(otro)

    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    def normalizar(self):
        m = self.magnitud()
        return Vector3D(self.x/m, self.y/m, self.z/m) if m != 0 else Vector3D()

    def producto_vectorial(self, otro):
        return Vector3D(
            self.y*otro.z - self.z*otro.y,
            self.z*otro.x - self.x*otro.z,
            self.x*otro.y - self.y*otro.x
        )


# ----------- Prueba -------------
a = Vector3D(1, 2, 3)
b = Vector3D(4, 5, 6)

print("a =", a.mostrar())
print("b =", b.mostrar())
print("a+b =", (a+b).mostrar())
print("3*a =", (3*a).mostrar())
print("a·b =", a*b)
print("|a| =", a.magnitud())
print("a normalizado =", a.normalizar().mostrar())
print("a×b =", a.producto_vectorial(b).mostrar())
