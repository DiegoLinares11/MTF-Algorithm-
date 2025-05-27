import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("PROYECTO 3 - ALGORITMO MTF (MOVE TO FRONT)");
        System.out.println("==========================================\n");

        // Caso 1
        System.out.println("CASO 1:");
        List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> requests1 = Arrays.asList(0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4);
        MTFAlgorithm.executeMTF(list1, requests1);

        // Caso 2
        System.out.println("CASO 2:");
        List<Integer> list2 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> requests2 = Arrays.asList(4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4);
        MTFAlgorithm.executeMTF(list2, requests2);

        // Caso 3: Mejor caso
        System.out.println("CASO 3:");
        MTFAlgorithm.findBestCase();

        // Caso 4: Peor caso
        System.out.println("CASO 4:");
        MTFAlgorithm.findWorstCase();

        // Caso 5: Secuencias repetidas
        System.out.println("CASO 5:");
        MTFAlgorithm.analyzeRepeatedSequences();

        // Caso 6: Comparacion IMTF vs MTF
        System.out.println("CASO 6 - COMPARACION IMTF:");

        // IMTF para el mejor caso de MTF
        System.out.println("IMTF aplicado al MEJOR CASO de MTF:");
        List<Integer> bestCase = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            bestCase.add(0);
        IMTFAlgorithm.executeIMTF(Arrays.asList(0, 1, 2, 3, 4), bestCase);

        // IMTF para el peor caso de MTF
        System.out.println("IMTF aplicado al PEOR CASO de MTF:");
        List<Integer> worstCase = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            worstCase.add(4 - (i % 5));
        }
        IMTFAlgorithm.executeIMTF(Arrays.asList(0, 1, 2, 3, 4), worstCase);
    }
}
