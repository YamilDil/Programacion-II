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

    def _jugar_con_numero(self, numero_secreto: int):
        self.reiniciaPartida()
        self.numeroAAdivinar = numero_secreto
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

class JuegoAdivinaNumero(Juego):
    def __init__(self, vidas: int):
        super().__init__(vidas)
        self.numeroAAdivinar = None

    def juega(self):
        numero = random.randint(0, 10)
        self._jugar_con_numero(numero)

class JuegoAdivinaPar(JuegoAdivinaNumero):
    def juega(self):
        while True:
            candidato = random.randint(0, 10)
            if candidato % 2 == 0:
                self._jugar_con_numero(candidato)
                break

class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def juega(self):
        while True:
            candidato = random.randint(0, 10)
            if candidato % 2 != 0:
                self._jugar_con_numero(candidato)
                break

if __name__ == "__main__":
    print("\n########## AdivinaNumero ##########")
    juego1 = JuegoAdivinaNumero(3)
    juego1.juega()
    print(f"Record final: {juego1.record}")

    print("\n########## AdivinaPar ##########")
    juego2 = JuegoAdivinaPar(3)
    juego2.juega()
    print(f"Record final: {juego2.record}")

    print("\n########## AdivinaImpar ##########")
    juego3 = JuegoAdivinaImpar(3)
    juego3.juega()
    print(f"Record final: {juego3.record}")
