/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Anderson
 */


public class ComunicadosManager {

    private List<String> comunicados;
    private final String archivoComunicados = "data/comunicados.txt";

    public ComunicadosManager() {
        comunicados = new ArrayList<>();
        cargarComunicados();
    }

    public void crearComunicado(String contenido) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String comunicadoConHora = contenido + " | " + timestamp;
        comunicados.add(comunicadoConHora);
        guardarComunicado(contenido);
    }

    private void guardarComunicado(String contenido) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String comunicadoConHora = contenido + " | " + timestamp;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoComunicados, true))) {
            writer.write(comunicadoConHora);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el comunicado: " + e.getMessage());
        }

    }

    private void cargarComunicados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoComunicados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                comunicados.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los comunicados: " + e.getMessage());
        }
    }

    public void mostrarComunicados() {
        if (comunicados.isEmpty()) {
            System.out.println("No hay comunicados disponibles.");
        } else {
            int comunicadoNum = comunicados.size();
            System.out.println("COMUNICADOS ORDENADOS DEL MAS RECIENTE AL MAS ANTIGUO:");
            for (int i = comunicados.size() - 1; i >= 0; i--) {
                String comunicado = comunicados.get(i);
                String[] partes = comunicado.split(" \\| ");
                String contenido = partes[0];
                String fecha = partes.length > 1 ? partes[1] : "Fecha desconocida";
                System.out.println("+-------------------------------------------+");
                System.out.printf("| Comunicado %2d - %s |\n", comunicadoNum--, fecha);
                System.out.println("+-------------------------------------------+");
                System.out.printf("| %-42s |\n", contenido);
                System.out.println("+-------------------------------------------+");
            }
        }
    }

    public static void main(String[] args) {
        ComunicadosManager manager = new ComunicadosManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Crear un nuevo comunicado");
            System.out.println("2. Mostrar todos los comunicados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el contenido del comunicado: ");
                    String contenido = scanner.nextLine();
                    manager.crearComunicado(contenido);
                    break;
                case 2:
                    manager.mostrarComunicados();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
