package org.ing.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.ing.arrayleader.Arrayleader2;

class Test {

	@org.junit.jupiter.api.Test
	void test() {

		/*
		 * given integers K = 3, M = 5 and the following array A:
		 * 
		 * A[0] = 2 A[1] = 1 A[2] = 3 A[3] = 1 A[4] = 2 A[5] = 2 A[6] = 3 the function
		 * should return [2, 3].
		 */
		int[] array1 = { 2, 1, 3, 1, 2, 2, 3 };
		int M = 5, K = 3;
		int[] respuestaEsperada = { 2, 3 };
		int[] respuesta = Arrayleader2.solution(K, M, array1);
		assertArrayEquals(respuestaEsperada, respuesta, "Using { 2, 1, 3, 1, 2, 2, 3 } and K=3 should return {2,3}");

		/*
		 * And, for example, given integers K = 4, M = 2 and the following array:
		 * 
		 * A[0] = 1 A[1] = 2 A[2] = 2 A[3] = 1 A[4] = 2 the function should return [2,
		 * 3], because choosing a segment A[0], A[1], A[2], A[3] and A[1], A[2], A[3],
		 * A[4] turns 2 and 3 into the leaders, respectively.
		 */
		int[] array2 = { 1, 2, 2, 1, 2 };
		M = 2;
		K = 4;
		respuesta = Arrayleader2.solution(K, M, array2);
		assertArrayEquals(respuestaEsperada, respuesta, "Using { 1, 2, 2, 1, 2 } and K=4 should return {2,3}");
	}

}
