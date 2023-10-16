package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private String palabraAdivinar;
    private StringBuilder palabraDescubierta;
    private int intentosRestantes;

    public Main(String palabraSecreta, int intentosMaximos) {
        this.palabraAdivinar = palabraSecreta;
        this.intentosRestantes = intentosMaximos;
        this.palabraDescubierta = new StringBuilder("_".repeat(palabraSecreta.length()));
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);

        while (intentosRestantes > 0) {
            System.out.println("Palabra: " + palabraDescubierta.toString());
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Adivina una letra: ");
            char letra = sc.next().charAt(0);
            if (adivinar(letra)) {
                System.out.println("¡Yeahhh! La letra '" + letra + "' está en la palabra.");
            } else {
                System.out.println("¡Nope! La letra '" + letra + "' no está en la palabra.");
                intentosRestantes--;
            }

            if (palabraDescubierta.toString().equals(palabraAdivinar)) {
                System.out.println("¡SIUUUUUUUUUUUUUU! Has adivinado la palabra: " + palabraAdivinar);
                break;
            }
        }

        if (intentosRestantes == 0) {
            System.out.println("¡Otra vez será! La palabra a adivinar era: " + palabraAdivinar);
        }
    }

    private boolean adivinar(char letra) {
        boolean acertado = false;
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letra) {
                palabraDescubierta.setCharAt(i, letra);
                acertado = true;
            }
        }
        return acertado;
    }

    public static void main(String[] args) {
        String palabraSecreta = "palabra";
        int intentosMaximos = 6;

        Main juego = new Main(palabraSecreta, intentosMaximos);
        juego.jugar();
    }
}