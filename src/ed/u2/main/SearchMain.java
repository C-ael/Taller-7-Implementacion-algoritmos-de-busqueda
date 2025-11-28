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
    public static int AskKey() {
        Scanner sc = new java.util.Scanner(System.in);
        int key;
        while(true){
            System.out.print("\nIngrese la clave (key) que desea buscar: ");

            if (sc.hasNextInt()) {
                key = sc.nextInt();
                break;
            } else {
                System.out.println("Tipo de datos no valido");
                sc.next();
            }
        }

        return key;
    }
    public static void main(String[] args) throws Exception {

        //  1. Cargar datasets txt
        int[] A = DatasetLoader.load("datasets/datasetA.txt");
        int[] B = DatasetLoader.load("datasets/datasetB.txt");
        int[] C = DatasetLoader.load("datasets/datasetC.txt");
        int[] D = DatasetLoader.load("datasets/datasetD.txt");

        // Pruebas de búsqueda
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("=== DATASET A (mezclado) ===");
            PrintUtils.printArray(A);

            System.out.println("=== DATASET B (descendente) ===");
            PrintUtils.printArray(B);

            System.out.println("=== DATASET C (ascendente) ===");
            PrintUtils.printArray(C);

            System.out.println("=== DATASET D (casi ordenado) ===");
            PrintUtils.printArray(D);

            //  2. Convertir a SLL
            Node listA = DatasetConverter.toSLL(A);
            Node listB = DatasetConverter.toSLL(B);
            Node listC = DatasetConverter.toSLL(C);
            Node listD = DatasetConverter.toSLL(D);

            System.out.println("\n=== LISTA A ===");
            PrintUtils.printSLL(listA);

            System.out.println("=== LISTA B ===");
            PrintUtils.printSLL(listB);

            System.out.println("=== LISTA C ===");
            PrintUtils.printSLL(listC);

            System.out.println("=== LISTA D ===");
            PrintUtils.printSLL(listD);

            int key = AskKey();
            System.out.println("\n=============================");
            System.out.println(" BÚSQUEDAS EN ARRAY");
            System.out.println("=============================");

            System.out.println("\n================Dataset A================");
            System.out.println("Secuencial A = " + ArraySearch.sequential(A, key));
            System.out.println("Centinela A = " + ArraySearch.sequentialSentinel(A, key));
            System.out.println("Primera ocurrencia A = " + ArraySearch.firstOccurrence(A, key));
            System.out.println("Última ocurrencia A = " + ArraySearch.lastOccurrence(A, key));
            System.out.println("Binaria A = " + ArraySearch.binary(A, key));

            System.out.println("\n================Dataset B================");
            System.out.println("Secuencial B = " + ArraySearch.sequential(B, key));
            System.out.println("Centinela B = " + ArraySearch.sequentialSentinel(B, key));
            System.out.println("Primera ocurrencia B = " + ArraySearch.firstOccurrence(B, key));
            System.out.println("Última ocurrencia B = " + ArraySearch.lastOccurrence(B, key));
            System.out.println("Binaria B = " + ArraySearch.binary(B, key));

            System.out.println("\n================Dataset C================");
            System.out.println("Secuencial C = " + ArraySearch.sequential(C, key));
            System.out.println("Centinela C = " + ArraySearch.sequentialSentinel(C, key));
            System.out.println("Primera ocurrencia C = " + ArraySearch.firstOccurrence(C, key));
            System.out.println("Última ocurrencia C = " + ArraySearch.lastOccurrence(C, key));
            System.out.println("Binaria C = " + ArraySearch.binary(C, key));

            System.out.println("\n================Dataset D================");
            System.out.println("Secuencial D = " + ArraySearch.sequential(D, key));
            System.out.println("Centinela D = " + ArraySearch.sequentialSentinel(D, key));
            System.out.println("Primera ocurrencia D = " + ArraySearch.firstOccurrence(D, key));
            System.out.println("Última ocurrencia D = " + ArraySearch.lastOccurrence(D, key));
            System.out.println("Binaria D = " + ArraySearch.binary(D, key));

            System.out.println("\n=============================");
            System.out.println(" BÚSQUEDAS EN SLL");
            System.out.println("=============================");

            System.out.println("\nSLL búsqueda A = " + Arrays.toString(findAll(listA, key)));
            System.out.println("SLL primera ocurrencia A = " + SLLSearch.firstOccurrence(listA, key));
            System.out.println("SLL última ocurrencia A = " + SLLSearch.lastOccurrence(listA, key));

            System.out.println("\nSLL búsqueda total B = " + Arrays.toString(findAll(listB, key)));
            System.out.println("SLL primera ocurrencia B = " + SLLSearch.firstOccurrence(listB, key));
            System.out.println("SLL última ocurrencia B = " + SLLSearch.lastOccurrence(listB, key));

            System.out.println("\nSLL búsqueda total C = " + Arrays.toString(findAll(listC, key)));
            System.out.println("SLL primera ocurrencia C = " + SLLSearch.firstOccurrence(listC, key));
            System.out.println("SLL última ocurrencia C = " + SLLSearch.lastOccurrence(listC, key));

            System.out.println("\nSLL búsqueda total D = " + Arrays.toString(findAll(listD, key)));
            System.out.println("SLL primera ocurrencia D = " + SLLSearch.firstOccurrence(listD, key));
            System.out.println("SLL última ocurrencia D = " + SLLSearch.lastOccurrence(listD, key));


            String opcion;
            while (true) {
                System.out.println("Desea realizar otra busqueda (key) (s/n):");
                opcion = sc.next();

                if (opcion.equalsIgnoreCase("s")) {
                    break;
                } else if (opcion.equalsIgnoreCase("n")) {
                    System.out.println("Gracias por usar el sistema. ");
                    System.out.println("Saliendo del sistema...");
                    return;
                } else {
                    System.out.println("Opcion no valida. Vuelva a ingresar:");
                }
            }

        }
    }
}
