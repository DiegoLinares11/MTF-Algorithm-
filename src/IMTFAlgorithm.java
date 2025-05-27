import java.util.ArrayList;
import java.util.List;

public class IMTFAlgorithm {
    /**
     * Implementa el algoritmo IMTF (Improved Move to Front)
     * 
     * @param initialList Lista inicial de configuración
     * @param requests    Secuencia de solicitudes
     * @return Resultado con costo total y pasos
     */
    public static MTFAlgorithm.MTFResult executeIMTF(List<Integer> initialList, List<Integer> requests) {
        List<Integer> currentList = new ArrayList<>(initialList);
        int totalCost = 0;
        List<String> steps = new ArrayList<>();

        System.out.println("=== ALGORITMO IMTF (MEJORADO) ===");
        System.out.println("Lista inicial: " + currentList);
        System.out.println();

        for (int i = 0; i < requests.size(); i++) {
            int request = requests.get(i);
            int position = currentList.indexOf(request);
            int cost = position + 1;

            totalCost += cost;

            // Verificar si debe moverse al frente según la regla IMTF
            boolean shouldMoveToFront = shouldMoveToFrontIMTF(requests, i, request, position);

            String step = String.format("Paso %d: Lista=[%s], Solicitud=%d, Posición=%d, Costo=%d, Mover=%s",
                    i + 1, listToString(currentList), request, position + 1, cost, shouldMoveToFront);
            steps.add(step);

            System.out.println(step);

            // Aplicar IMTF: mover solo si cumple la condición
            if (shouldMoveToFront && position > 0) {
                currentList.remove(position);
                currentList.add(0, request);
                System.out.println("    Lista despues de IMTF: " + currentList);
            } else {
                System.out.println("    Lista sin cambios: " + currentList);
            }
            System.out.println();
        }

        System.out.println("COSTO TOTAL IMTF: " + totalCost);
        System.out.println("LISTA FINAL IMTF: " + currentList);
        System.out.println("==========================================\n");

        return new MTFAlgorithm.MTFResult(currentList, totalCost, steps);
    }

    /**
     * Determina si un elemento debe moverse al frente según la regla IMTF
     */
    private static boolean shouldMoveToFrontIMTF(List<Integer> requests, int currentIndex, int element, int position) {
        // Buscar en los proximos (position - 1) elementos
        int lookAheadCount = position; // position es 0-indexado, necesitamos position elementos hacia adelante
        int found = 0;

        for (int j = currentIndex + 1; j < requests.size() && j < currentIndex + 1 + lookAheadCount; j++) {
            if (requests.get(j) == element) {
                found++;
            }
        }

        return found > 0; // Mover si aparece al menos una vez en el look-ahead
    }

    /**
     * convertir lista a string
     */
    private static String listToString(List<Integer> list) {
        return list.toString().replaceAll("[\\[\\]]", "");
    }
}
