package es.babel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public abstract class Solution {

	// function that returns and array with segment elements modified by adding 1 to its value
	// fromElement is the first element of the segment starting from 1, if it is zero means that the segment has same size of array
	// segmentSize is number of elements within the segment
	// array is the original array to be processed
	private static int[] getModifiedArray(int fromElement, int segmentSize, int[] array) {
		return IntStream
					.concat(
								IntStream.concat(
												Arrays.stream(array).limit(fromElement),
												Arrays.stream(array)
													.skip(fromElement)
													.limit(segmentSize)
													.map(i -> i + 1)),
								Arrays.stream(array).skip(fromElement + segmentSize))
					.toArray();
	}
	
	// function to calculate the leader of a given array that returns leader or -1 if no element is the leader
	// array to calculate leader
	private static int getArrayLeader(int[] array) {
		// get the number of occurrences of a number to be array leader
		final int leaderPoint = (array.length / 2) + 1;
		// get the distinct elements of the array
		int[] arrayElements = Arrays.stream(array).distinct().toArray();
		// filter those elements which occurrences in array is greater or equals than leader point
		return Arrays.stream(arrayElements)
					.filter(i -> Arrays.stream(array).filter(i2 -> i2 == i).count() >= leaderPoint)
					.findFirst()
					.orElse(-1);
	}
	
	/**
	 * @param k segment size
	 * @param m max value of each element within the array
	 * @param a array to process consisting of N integers
	 * @return array leaders result
	 * 
	 * @throws NullPointerException when array is null
	 * @throws IllegalArgumentException when m or array length are not into range from 1 to 100,000
	 * 			Also throws when k is not into range 1 to array length or some element of the array 
	 * 			is greater than m 
	 */
	public static int[] solution(int k, int m, int[] a) {
		Objects.requireNonNull(a, "Array of integers can not be null");
		int n = a.length;
		// preconditions check
		if (n < 1 || n > 100000) {
			throw new IllegalArgumentException("number of ints of the array N must be in range [1..100000]");
		}
		if (m < 1 || m > 100000) {
			throw new IllegalArgumentException("number of ints of the array M must be in range [1..100000]");
		}
		if (k < 1 || k > n) {
			throw new IllegalArgumentException("segment size K must be in range [1..N]");
		}
		if (Arrays.stream(a).parallel().anyMatch(i -> i > m)) {
			throw new IllegalArgumentException("Array of integers can not include values greater than M");
		}
		
		// array leaders calculation
		int segmentCount = (a.length - k) + 1;
		final Set<Integer> arrayLeaders = new HashSet<>();

		for (int i = 0; i < segmentCount; i++) {
			int leader = getArrayLeader(getModifiedArray(i, k, a));
			// only adds result to set if it is not null
			if (leader != -1) {
				arrayLeaders.add(leader);
			}
		}
		return arrayLeaders.stream().mapToInt(Integer::intValue).sorted().toArray();
	}

}
