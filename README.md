# MTF-Algorithm-

# Proyecto 3 - Algoritmo Move-To-Front (MTF)

Este proyecto implementa el algoritmo **Move-To-Front (MTF)** como parte del curso de **Análisis y Diseño de Algoritmos**. El algoritmo se evalúa utilizando distintos tipos de secuencias para medir su costo, incluyendo casos promedio, mejor caso y peor caso. También se compara contra una variante denominada IMTF.

## Descripción del Algoritmo MTF

El algoritmo **Move-To-Front (MTF)** reorganiza una lista de elementos moviendo al frente (posición 0) cada elemento accedido, con el objetivo de reducir el costo de acceso en secuencias futuras.

- El **costo** de acceder a un elemento es su **posición actual (índice + 1)**.
- Tras cada acceso, el elemento se mueve al frente de la lista.
- Se acumula el costo total de todos los accesos para evaluar el rendimiento.

Casos de Prueba

El programa incluye cuatro casos:

    Caso Promedio: Acceso cíclico a todos los elementos.

    Caso Variado: Combinación de accesos secuenciales e inversos.

    Mejor Caso: Accesos repetidos al primer elemento (costo mínimo).

    Peor Caso: Accesos repetidos al último elemento (costo máximo).

Cada caso muestra:

    La lista inicial.

    Cada paso del algoritmo con el elemento accedido, su posición, costo y la lista resultante.

    El costo total acumulado.

    La lista final.

