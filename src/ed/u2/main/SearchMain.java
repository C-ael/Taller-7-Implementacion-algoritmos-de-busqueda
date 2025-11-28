package ed.u2.main;

import ed.u2.algorithms.ArraySearch;
import ed.u2.algorithms.Node;
import ed.u2.algorithms.SLLSearch;
import ed.u2.utils.DatasetLoader;
import ed.u2.utils.DatasetConverter;
import ed.u2.utils.PrintUtils;

import java.util.Arrays;
import java.util.Scanner;

import static ed.u2.algorithms.SLLSearch.findAll;

public class SearchMain {

    // Pedir clave al usuario
    public static int AskKey() {
        Scanner sc = new java.util.Scanner(System.in);
        int key;

        while (true) {
            System.out.print("\nIngrese la clave (key) que desea buscar: ");

            if (sc.hasNextInt()) {
                key = sc.nextInt();
                break;
            } else {
                System.out.println("Tipo de dato no válido. Ingrese un número entero.");
                sc.next();
            }
        }
        return key;
    }

    public static void main(String[] args) throws Exception {

        // 1. Cargar datasets desde .txt
        int[] A = DatasetLoader.load("datasets/datasetA.txt");
        int[] B = DatasetLoader.load("datasets/datasetB.txt");
        int[] C = DatasetLoader.load("datasets/datasetC.txt");
        int[] D = DatasetLoader.load("datasets/datasetD.txt");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=========================================");
            System.out.println(" DATOS CARGADOS DESDE TXT");
            System.out.println("=========================================");

            System.out.println("=== DATASET A (mezclado) ===");
            PrintUtils.printArray(A);

            System.out.println("\n=== DATASET B (descendente) ===");
            PrintUtils.printArray(B);

            System.out.println("\n=== DATASET C (ascendente) ===");
            PrintUtils.printArray(C);

            System.out.println("\n=== DATASET D (casi ordenado) ===");
            PrintUtils.printArray(D);

            // 2. Convertir a SLL
            Node listA = DatasetConverter.toSLL(A);
            Node listB = DatasetConverter.toSLL(B);
            Node listC = DatasetConverter.toSLL(C);
            Node listD = DatasetConverter.toSLL(D);

            System.out.println("\n=========================================");
            System.out.println(" LISTAS SIMPLEMENTE ENLAZADAS");
            System.out.println("=========================================");

            System.out.println("=== LISTA A ===");
            PrintUtils.printSLL(listA);

            System.out.println("\n=== LISTA B ===");
            PrintUtils.printSLL(listB);

            System.out.println("\n=== LISTA C ===");
            PrintUtils.printSLL(listC);

            System.out.println("\n=== LISTA D ===");
            PrintUtils.printSLL(listD);

            // Pedir clave de búsqueda
            int key = AskKey();

            System.out.println("\n=========================================");
            System.out.println(" BÚSQUEDAS EN ARRAYS");
            System.out.println("=========================================");
            System.out.println("Clave buscada: " + key);
            System.out.println("Nota: -1 significa que la clave NO aparece.\n");


            System.out.println("========= Dataset A (mezclado) =========");
            System.out.println("Secuencial: " + ArraySearch.sequential(A, key));
            System.out.println("Centinela: " + ArraySearch.sequentialSentinel(A, key));
            System.out.println("Primera ocurrencia: " + ArraySearch.firstOccurrence(A, key));
            System.out.println("Última ocurrencia: " + ArraySearch.lastOccurrence(A, key));
            System.out.println("Binaria: " + ArraySearch.binary(A, key));


            System.out.println("\n====== Dataset B (descendente) ======");
            System.out.println("Secuencial: " + ArraySearch.sequential(B, key));
            System.out.println("Centinela: " + ArraySearch.sequentialSentinel(B, key));
            System.out.println("Primera ocurrencia: " + ArraySearch.firstOccurrence(B, key));
            System.out.println("Última ocurrencia: " + ArraySearch.lastOccurrence(B, key));
            System.out.println("Binaria: " + ArraySearch.binary(B, key));


            System.out.println("\n======== Dataset C (ascendente) ========");
            System.out.println("Secuencial: " + ArraySearch.sequential(C, key));
            System.out.println("Centinela: " + ArraySearch.sequentialSentinel(C, key));
            System.out.println("Primera ocurrencia: " + ArraySearch.firstOccurrence(C, key));
            System.out.println("Última ocurrencia: " + ArraySearch.lastOccurrence(C, key));
            System.out.println("Binaria: " + ArraySearch.binary(C, key));


            System.out.println("\n====== Dataset D (casi ordenado) ======");
            System.out.println("Secuencial: " + ArraySearch.sequential(D, key));
            System.out.println("Centinela: " + ArraySearch.sequentialSentinel(D, key));
            System.out.println("Primera ocurrencia: " + ArraySearch.firstOccurrence(D, key));
            System.out.println("Última ocurrencia: " + ArraySearch.lastOccurrence(D, key));
            System.out.println("Binaria: " + ArraySearch.binary(D, key));


            System.out.println("\n=========================================");
            System.out.println(" BÚSQUEDAS EN SLL");
            System.out.println("=========================================");


            System.out.println("\n========= Lista A =========");
            int[] allA = findAll(listA, key);
            System.out.println("Coincidencias totales: " + Arrays.toString(allA));
            if (allA.length == 0) System.out.println("La clave no aparece en esta lista.");
            System.out.println("Primera ocurrencia: " + SLLSearch.firstOccurrence(listA, key));
            System.out.println("Última ocurrencia: " + SLLSearch.lastOccurrence(listA, key));


            System.out.println("\n========= Lista B =========");
            int[] allB = findAll(listB, key);
            System.out.println("Coincidencias totales: " + Arrays.toString(allB));
            if (allB.length == 0) System.out.println("La clave no aparece en esta lista.");
            System.out.println("Primera ocurrencia: " + SLLSearch.firstOccurrence(listB, key));
            System.out.println("Última ocurrencia: " + SLLSearch.lastOccurrence(listB, key));


            System.out.println("\n========= Lista C =========");
            int[] allC = findAll(listC, key);
            System.out.println("Coincidencias: " + Arrays.toString(allC));
            if (allC.length == 0) System.out.println("La clave no aparece en esta lista.");
            System.out.println("Primera ocurrencia: " + SLLSearch.firstOccurrence(listC, key));
            System.out.println("Última ocurrencia: " + SLLSearch.lastOccurrence(listC, key));


            System.out.println("\n========= Lista D =========");
            int[] allD = findAll(listD, key);
            System.out.println("Coincidencias: " + Arrays.toString(allD));
            if (allD.length == 0) System.out.println("La clave no aparece en esta lista.");
            System.out.println("Primera ocurrencia: " + SLLSearch.firstOccurrence(listD, key));
            System.out.println("Última ocurrencia: " + SLLSearch.lastOccurrence(listD, key));

            String opcion;
            while (true) {
                System.out.print("\n¿Desea realizar otra búsqueda? (s/n): ");
                opcion = sc.next();

                if (opcion.equalsIgnoreCase("s")) {
                    break;
                } else if (opcion.equalsIgnoreCase("n")) {
                    System.out.println("Gracias por usar el sistema.");
                    System.out.println("Saliendo...");
                    return;
                } else {
                    System.out.println("Opción no válida. Ingrese 's' o 'n'.");
                }
            }
        }
    }
}
