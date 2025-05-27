import java.util.*;

/**
 * Implementación del algoritmo MTF (Move to Front) y IMTF (Improved Move to
 * Front)
 * Proyecto 3 - Analisis y Diseño de Algoritmos
 * 
 * El algoritmo MTF es una heurística de organización de listas que mueve
 * cada elemento accedido al frente de la lista.
 */
public class MTFAlgorithm {

    /**
     * Clase para representar el resultado de una operación MTF
     */
    static class MTFResult {
        List<Integer> finalList;
        int totalCost;
        List<String> steps;

        MTFResult(List<Integer> list, int cost, List<String> steps) {
            this.finalList = new ArrayList<>(list);
            this.totalCost = cost;
            this.steps = new ArrayList<>(steps);
        }
    }

    /**
     * Implementa el algoritmo MTF básico
     * 
     * @param initialList Lista inicial de configuración
     * @param requests    Secuencia de solicitudes
     * @return Resultado con costo total y pasos
     */
    public static MTFResult executeMTF(List<Integer> initialList, List<Integer> requests) {
        List<Integer> currentList = new ArrayList<>(initialList);
        int totalCost = 0;
        List<String> steps = new ArrayList<>();

        System.out.println("=== ALGORITMO MTF ===");
        System.out.println("Lista inicial: " + currentList);
        System.out.println();

        for (int i = 0; i < requests.size(); i++) {
            int request = requests.get(i);
            int position = currentList.indexOf(request);
            int cost = position + 1; // Costo es la posición + 1 (indexado desde 1)

            totalCost += cost;

            // Crear paso detallado
            String step = String.format("Paso %d: Lista=[%s], Solicitud=%d, Posición=%d, Costo=%d",
                    i + 1, listToString(currentList), request, position + 1, cost);
            steps.add(step);

            System.out.println(step);

            // Mover el elemento al frente (MTF)
            if (position > 0) {
                currentList.remove(position);
                currentList.add(0, request);
            }

            System.out.println("    Lista despues de MTF: " + currentList);
            System.out.println();
        }

        System.out.println("COSTO TOTAL: " + totalCost);
        System.out.println("LISTA FINAL: " + currentList);
        System.out.println("==========================================\n");

        return new MTFResult(currentList, totalCost, steps);
    }

    /**
     * Encuentra la secuencia que produce el mínimo costo
     */
    public static void findBestCase() {
        List<Integer> initialList = Arrays.asList(0, 1, 2, 3, 4);

        // El mejor caso es acceder siempre al primer elemento
        List<Integer> bestSequence = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            bestSequence.add(0);
        }

        System.out.println("=== MEJOR CASO (MINIMO COSTO) ===");
        System.out.println("Secuencia: " + bestSequence);
        MTFResult result = executeMTF(initialList, bestSequence);
        System.out.println(
                "Esta secuencia produce el mínimo costo porque siempre accede al elemento en la primera posición.\n");
    }

    /**
     * Encuentra la secuencia que produce el maximo costo
     */
    public static void findWorstCase() {
        List<Integer> initialList = Arrays.asList(0, 1, 2, 3, 4);

        // El peor caso es acceder siempre al último elemento en orden inverso
        List<Integer> worstSequence = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            worstSequence.add(4 - (i % 5)); // 4, 3, 2, 1, 0, 4, 3, 2, 1, 0, ...
        }

        System.out.println("=== PEOR CASO (MAXIMO COSTO) ===");
        System.out.println("Secuencia: " + worstSequence);
        MTFResult result = executeMTF(initialList, worstSequence);
        System.out.println(
                "Esta secuencia produce el maximo costo porque accede a elementos en orden inverso,\ncausando que cada elemento se mueva al frente y los demás se desplacen.\n");
    }

    /**
     * Analiza patrones en secuencias repetitivas
     */
    public static void analyzeRepeatedSequences() {
        List<Integer> initialList = Arrays.asList(0, 1, 2, 3, 4);

        // Secuencia de 20 elementos repetidos (2)
        List<Integer> sequence2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sequence2.add(2);
        }

        System.out.println("=== ANALISIS SECUENCIA REPETIDA: 2 ===");
        MTFResult result2 = executeMTF(initialList, sequence2);

        // Secuencia de 20 elementos repetidos (3)
        List<Integer> sequence3 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sequence3.add(3);
        }

        System.out.println("=== ANALISIS SECUENCIA REPETIDA: 3 ===");
        MTFResult result3 = executeMTF(initialList, sequence3);

        System.out.println("=== ANALISIS DE PATRONES ===");
        System.out.println("Secuencia de 2's - Costo total: " + result2.totalCost);
        System.out.println("Secuencia de 3's - Costo total: " + result3.totalCost);
        System.out.println();
        System.out.println("PATRON OBSERVADO:");
        System.out.println("- Primer acceso: costo = posición inicial del elemento");
        System.out.println("- Accesos subsecuentes: costo = 1 (elemento ya está al frente)");
        System.out.println("- Costo total = posición_inicial + (n-1) donde n es número de repeticiones");
        System.out.println("- Para elemento en posición i: costo_total = (i+1) + 19 = i + 20");
        System.out.println();
    }

    /**
     * Método auxiliar para convertir lista a string
     */
    private static String listToString(List<Integer> list) {
        return list.toString().replaceAll("[\\[\\]]", "");
    }

}