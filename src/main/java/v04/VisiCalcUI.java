package v04;

import java.util.Scanner;
import librerias.Consola;

public class VisiCalcUI {
    private Viewport viewport;
    private Scanner scanner;

    public VisiCalcUI(HojaDeCalculo hoja) {
        this.viewport = new Viewport(hoja, 15, 10);
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean estaOperativo = true;
        while (estaOperativo) {
            mostrarHoja();
            char comando = scanner.next().toUpperCase().charAt(0);
            estaOperativo = procesarComando(comando);
        }
        System.out.println("Saliendo del programa.");
        scanner.close();
    }

    private boolean procesarComando(char comando) {
        switch (comando) {
            case 'W':
                viewport.moverCursor(-1, 0);
                break;
            case 'A':
                viewport.moverCursor(0, -1);
                break;
            case 'S':
                viewport.moverCursor(1, 0);
                break;
            case 'D':
                viewport.moverCursor(0, 1);
                break;
            case 'E':
                editarCeldaActual();
                break;
            case 'O':
                ordenarColumna();
                break;
            case 'Q':
                return false;
            default:
                System.out.println("Comando inválido. Intente nuevamente.");
        }
        return true;
    }

    private void ordenarColumna() {
        System.out.print("Ingrese la columna a ordenar (A-Z): ");
        char columnaChar = scanner.next().toUpperCase().charAt(0);
        int columna = columnaChar - 'A';

        System.out.print("Ingrese la fila de inicio: ");
        int filaInicio = scanner.nextInt() - 1;

        System.out.print("Ingrese la fila de fin: ");
        int filaFin = scanner.nextInt() - 1;

        System.out.print("Orden ascendente? (S/N): ");
        boolean ascendente = scanner.next().equalsIgnoreCase("S");

        viewport.getHoja().ordenarColumna(columna, filaInicio, filaFin, ascendente);
    }
}