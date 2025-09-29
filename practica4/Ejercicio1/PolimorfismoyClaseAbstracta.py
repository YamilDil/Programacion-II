# ejercicio1.py
from abc import ABC, abstractmethod

class Empleado(ABC):
    def __init__(self, nombre: str):
        self.nombre = nombre

    @abstractmethod
    def calcular_salario_mensual(self) -> float:
        """Retorna salario mensual (implementado en subclases)."""
        pass

    def __str__(self):
        return f"Empleado(nombre={self.nombre})"

class EmpleadoTiempoCompleto(Empleado):
    def __init__(self, nombre: str, salario_anual: float):
        super().__init__(nombre)
        self.salario_anual = salario_anual

    def calcular_salario_mensual(self) -> float:
        return self.salario_anual / 12.0

    def __str__(self):
        return f"EmpleadoTiempoCompleto(nombre={self.nombre}, salario_anual={self.salario_anual})"

class EmpleadoTiempoHorario(Empleado):
    def __init__(self, nombre: str, horas_trabajadas: float, tarifa_por_hora: float):
        super().__init__(nombre)
        self.horas_trabajadas = horas_trabajadas
        self.tarifa_por_hora = tarifa_por_hora

    def calcular_salario_mensual(self) -> float:
        return self.horas_trabajadas * self.tarifa_por_hora

    def __str__(self):
        return (f"EmpleadoTiempoHorario(nombre={self.nombre}, horas={self.horas_trabajadas}, "
                f"tarifa={self.tarifa_por_hora})")

def leer_float(prompt: str) -> float:
    while True:
        valor = input(prompt).strip()
        try:
            return float(valor)
        except ValueError:
            print("Entrada no válida: introduce un número.")

def leer_cadena(prompt: str) -> str:
    while True:
        s = input(prompt).strip()
        if s:
            return s
        print("El texto no puede estar vacío.")

if __name__ == "__main__":
    print("=== Ejercicio 1: Crear 3 empleados tiempo completo y 2 por horario ===")
    empleados = []

    # Leer 3 empleados a tiempo completo
    for i in range(1, 4):
        print(f"\nEmpleado a tiempo completo #{i}:")
        nombre = leer_cadena("  Nombre: ")
        salario = leer_float("  Salario anual (por ejemplo 24000.50): ")
        emp = EmpleadoTiempoCompleto(nombre, salario)
        empleados.append(emp)

    # Leer 2 empleados por horario
    for i in range(1, 3):
        print(f"\nEmpleado por horario #{i}:")
        nombre = leer_cadena("  Nombre: ")
        horas = leer_float("  Horas trabajadas (en el mes): ")
        tarifa = leer_float("  Tarifa por hora: ")
        emp = EmpleadoTiempoHorario(nombre, horas, tarifa)
        empleados.append(emp)

    print("\n--- Resultado: nombre y salario mensual de cada empleado ---")
    for emp in empleados:
        salario_mensual = emp.calcular_salario_mensual()
        print(f"{emp.nombre:20s} -> Salario mensual: {salario_mensual:.2f}")
