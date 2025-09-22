import random

class Juego:
    def __init__(self, vidas_iniciales: int):
        self.inicialVidas = vidas_iniciales
        self.numeroDeVidas = vidas_iniciales
        self.record = 0

    def reiniciaPartida(self):
        self.numeroDeVidas = self.inicialVidas

    def actualizaRecord(self):
        if self.numeroDeVidas > self.record:
            self.record = self.numeroDeVidas

    def quitaVida(self) -> bool:
        self.numeroDeVidas -= 1
        return self.numeroDeVidas > 0

class JuegoAdivinaNumero(Juego):
    def __init__(self, vidas: int):
        super().__init__(vidas)
        self.numeroAAdivinar = None

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print(f"Adivina un número entre 0 y 10. Tienes {self.numeroDeVidas} vidas.")

        while True:
            entrada = input("Introduce un número entero: ")
            try:
                intento = int(entrada)
            except ValueError:
                print("Entrada no válida: introduce un entero.")
                continue

            if intento == self.numeroAAdivinar:
                print("¡Acertaste!!")
                self.actualizaRecord()
                print(f"Vidas restantes: {self.numeroDeVidas}. Record: {self.record}")
                break
            else:
                quedan = self.quitaVida()
                if quedan:
                    mayor_menor = "mayor" if self.numeroAAdivinar > intento else "menor"
                    print(f"Incorrecto. El número a adivinar es {mayor_menor} que {intento}. Te quedan {self.numeroDeVidas} vidas.")
                else:
                    print(f"No te quedan más vidas. El número era {self.numeroAAdivinar}. Fin del juego.")
                    break

if __name__ == "__main__":
    juego = JuegoAdivinaNumero(3)
    juego.juega()
    print(f"Record final: {juego.record}")
