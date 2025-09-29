# ejercicio2.py
from abc import ABC, abstractmethod
import math
import random

class Coloreado(ABC):
    @abstractmethod
    def como_colorear(self) -> str:
        pass

class Figura(ABC):
    def __init__(self, color: str = "sin color"):
        self._color = color

    def set_color(self, color: str):
        self._color = color

    def get_color(self) -> str:
        return self._color

    def __str__(self):
        return f"Figura(color={self._color})"

    @abstractmethod
    def area(self) -> float:
        pass

    @abstractmethod
    def perimetro(self) -> float:
        pass

class Cuadrado(Figura, Coloreado):
    def __init__(self, lado: float, color: str = "sin color"):
        super().__init__(color)
        self.lado = lado

    def area(self) -> float:
        return self.lado * self.lado

    def perimetro(self) -> float:
        return 4 * self.lado

    def como_colorear(self) -> str:
        return "Colorear los cuatro lados"

    def __str__(self):
        return f"Cuadrado(lado={self.lado:.2f}, color={self._color})"

class Circulo(Figura):
    def __init__(self, radio: float, color: str = "sin color"):
        super().__init__(color)
        self.radio = radio

    def area(self) -> float:
        return math.pi * (self.radio ** 2)

    def perimetro(self) -> float:
        return 2 * math.pi * self.radio

    def __str__(self):
        return f"Circulo(radio={self.radio:.2f}, color={self._color})"

def generar_figura_aleatoria() -> Figura:
    # Genera aleatoriamente un cuadrado o un círculo con dimensiones aleatorias
    tipo = random.choice(["cuadrado", "circulo"])
    if tipo == "cuadrado":
        lado = round(random.uniform(1.0, 10.0), 2)
        color = random.choice(["rojo", "azul", "verde", "amarillo", "negro"])
        return Cuadrado(lado, color)
    else:
        radio = round(random.uniform(1.0, 10.0), 2)
        color = random.choice(["rojo", "azul", "verde", "amarillo", "negro"])
        return Circulo(radio, color)

if __name__ == "__main__":
    random.seed()  # semilla por tiempo
    figuras = []
    # Crear arreglo de 5 figuras (aleatorias)
    for _ in range(5):
        f = generar_figura_aleatoria()
        figuras.append(f)

    # Mostrar área, perímetro y si tiene como_colorear() invocarlo
    for i, f in enumerate(figuras, start=1):
        print(f"\nFigura #{i}: {f}")
        print(f"  Area      : {f.area():.4f}")
        print(f"  Perimetro : {f.perimetro():.4f}")
        # Si implementa Coloreado, llamamos al método
        if isinstance(f, Coloreado):
            print(f"  Como colorear: {f.como_colorear()}")
        else:
            print("  (No implementa Coloreado)")
