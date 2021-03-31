package es.babel.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.babel.Solution;

class TestSolution {

	@Test
	void testCaseMultipleLeader() {
		Assertions.assertArrayEquals(new int[] {2,3}, Solution.solution(3, 5, new int[] {2,1,3,1,2,2,3})); 
	}

	@Test
	void testCaseSingleLeader() {
		Assertions.assertArrayEquals(new int[] {2}, Solution.solution(2, 4, new int[] {1,1,4,4,2,2}));
	}
	
	@Test
	void testCaseNoLider() {
		Assertions.assertArrayEquals(new int[] {}, Solution.solution(6, 2, new int[] {1,2,2,1,1,2}));
	}
	
	@Test
	void testNullArray() {
		Throwable exception = Assertions.assertThrows(NullPointerException.class, () -> {
			Solution.solution(3, 2, null);
		});
		Assertions.assertEquals(exception.getMessage(), "Array of integers can not be null");
	}

	@Test
	void testRangeMinN() {
		int [] array = new int[] {};
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(3, 2, array);
		});
		Assertions.assertEquals(exception.getMessage(), "number of ints of the array N must be in range [1..100000]");
	}

	@Test
	void testRangeMaxN() {
		int[] array = new int[100001];
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(3, 2, array);
		});
		Assertions.assertEquals(exception.getMessage(), "number of ints of the array N must be in range [1..100000]");
	}

	@Test
	void testRangeMinM() {
		int [] array = new int[] {1,2,2,1,2};
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(3, 0, array);
		});
		Assertions.assertEquals(exception.getMessage(), "number of ints of the array M must be in range [1..100000]");
	}

	@Test
	void testRangeMaxM() {
		int[] array = new int[] {1,2,2,1,2};
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(3, 100001, array);
		});
		Assertions.assertEquals(exception.getMessage(), "number of ints of the array M must be in range [1..100000]");
	}

	@Test
	void testRangeMinK() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(0, 2, new int[] {1,2,2,1,2});
		});
		Assertions.assertEquals(exception.getMessage(), "segment size K must be in range [1..N]");
	}

	@Test
	void testRangeMaxK() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(6, 2, new int[] {1,2,2,1,2});
		});
		Assertions.assertEquals(exception.getMessage(), "segment size K must be in range [1..N]");
	}

	@Test
	void testConditionM() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Solution.solution(3, 2, new int[] {2,1,3,1,2,2,3});
		});
		Assertions.assertEquals(exception.getMessage(), "Array of integers can not include values greater than M");
	}
	
}
