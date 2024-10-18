package Modelo;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUtils {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Error al limpiar la consola: " + ex.getMessage());
        }
    }
    public static void pauseConsole() {
        System.out.println("Presione enter para contiuar.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("This will be cleared.");
        clearConsole();
        System.out.println("Console cleared.");
    }
}