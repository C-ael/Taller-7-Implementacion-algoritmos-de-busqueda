package ed.u2.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatasetLoader {

    // carga un dataset .txt y lo convierte en int[]
    public static int[] load(String path) throws Exception {

        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));

        // lee enteros mientras existan
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        sc.close();

        // convertir List<Integer> a int[]
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
