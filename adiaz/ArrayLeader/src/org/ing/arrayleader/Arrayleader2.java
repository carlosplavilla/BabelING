package org.ing.arrayleader;

import java.util.stream.IntStream;

public class Arrayleader2 {

	public static int[] solution(int K, int M, int[] A) {

		// Array de tamaño M, porque sera el numero mayor que aparezca en A, +1 porque
		// el array empieza en 0, +1 porque el numero se le sumara 1
		boolean[] leaders = new boolean[M + 2];

		int[] freq = new int[M + 2];

		int threshold = A.length / 2;

		// Incrementamos el primer segmento
		for (int i = 0; i < K; i++) {
			A[i]++;
		}

		// Calculamos la frecuencia de todos los elementos en A
		// Para cada elemento de A[i] , actualizamos su frecuencia en esa posicion del
		// array freq
		for (int i = 0; i < A.length; i++) {
			freq[A[i]]++;
		}

		// If there are leaders save them
		for (int i = 0; i < freq.length; i++) {
			leaders[i] = freq[i] > threshold || leaders[i];
		}

		for (int i = 1; i < A.length - K + 1; i++) {
			// Actualizamos la frecuencia del elemento (en la izquierda) que deja el
			// segmento
			// Bajamos la frecuencia del elemeto que sale y que ya estaba modificado
			int left = i - 1;
			freq[A[left]]--;
			// Subimos la frencuencia del elemento que queda , no modificado
			A[left]--;
			freq[A[left]]++;

			// Actualizamos la frecuencia del elemento (en la derecha) que entra en el
			// segmento
			// Bajamos la frecuencia del elemeto que vamos a modificar
			int right = i + K - 1;
			freq[A[right]]--;
			// Subimos la frencuencia del elemento que queda ,modificado
			A[right]++;
			freq[A[right]]++;

			// Guarda el leader.
			leaders[A[right]] = freq[A[right]] > threshold || leaders[A[right]];
			leaders[A[left]] = freq[A[left]] > threshold || leaders[A[left]];
		}
		// devolvemos los lideres en orden.
		return IntStream.range(0, leaders.length).filter(i -> leaders[i]).toArray();
	}
}
