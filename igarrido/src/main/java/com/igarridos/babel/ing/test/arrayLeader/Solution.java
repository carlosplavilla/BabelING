package com.igarridos.babel.ing.test.arrayLeader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Solution {

	Logger logger = LoggerFactory.getLogger(Solution.class);

	@Value("${arrayLeader.groupingBy}")
	boolean groupingBy;

	public int[] solution(int K, int M, int[] A) {

		/*
		 * According to description, I suppose no validation is needed:
		 */

		// calculate max initial index for segment mofication
		int maxIndex = A.length - K;

		// repetitions number must be at least (A.length/2)+1, to simplify conditions we
		// just use (A.length/2)
		int leaderRepetitionsThreshold = (A.length / 2);

		// max value in the array after modifications will not be greater than M+1. If
		// we search manually leaders, we can use this value to limit the search
		//int maxValue = M + 1;
		//or better, get directly the max value from the array to avoid searching for unnecessary values
		int maxValue = Arrays.stream(A).boxed().max(Comparator.naturalOrder()).get()+1;
		
		//the same for min values
		int minValue = Arrays.stream(A).boxed().min(Comparator.naturalOrder()).get();

		logger.debug("Segment Max Index:{}, leaderThreshold:{}, maxValue:{}, minValue={}", maxIndex, leaderRepetitionsThreshold,
				maxValue, minValue);

		Set<Integer> leaders = new HashSet<>();
		for (int a = 0; a <= maxIndex; a++) {

			int[] auxA = modifySegment(K, a, A);
			
			if (groupingBy) {
				// with grouping by (it seems to be less efficient)
				searchLeaders(auxA, leaderRepetitionsThreshold, leaders);
			} else {
				// without grouping by
				searchLeaders(auxA, minValue, maxValue, leaderRepetitionsThreshold, leaders);
			}

		}

		return orderedIntArray(leaders);
	}

	protected int[] modifySegment(int segmentSize, int segmentInit, int[] originalArray) {
		int[] auxA = Arrays.copyOf(originalArray, originalArray.length);
		logger.debug("Segment to modify: {} - {}", segmentInit, segmentInit + segmentSize);
		for (int s = segmentInit; s < segmentInit + segmentSize; s++) {
			auxA[s]++;
		}
		logger.trace("Modified segment: {}", auxA);
		return auxA;
	}

	protected void searchLeaders(int[] modifiedArray, int minValue, int maxValue, int minLeaderRepetitions, Set<Integer> leaders) {
		for (int v = minValue; v <= maxValue; v++) {
			int nor = numberOfRepetitions(modifiedArray, v);
			if (nor > minLeaderRepetitions) {
				logger.debug("{} is a leader, it appears {} times", v, nor);
				leaders.add(v);
			}
		}

	}

	protected void searchLeaders(int[] modifiedArray, int minLeaderRepetitions, Set<Integer> leaders) {

		Map<Integer, Long> candidateLeaders = Arrays.stream(modifiedArray).boxed()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		for (Integer key : candidateLeaders.keySet()) {
			if (candidateLeaders.get(key) > minLeaderRepetitions) {
				logger.debug("{} is a leader, it appears {} times", key, candidateLeaders.get(key));
				leaders.add(key);
			}
		}

	}

	protected int numberOfRepetitions(int[] modifiedArray, int valueToSearch) {
		int count = 0;
		for (int v : modifiedArray) {
			if (v == valueToSearch)
				count++;
		}
		logger.debug("{} appears {} times", valueToSearch, count);
		return count;
	}

	protected int[] orderedIntArray(Set<Integer> leaders) {
		int[] orderedIntArray = new int[leaders.size()];

		int i = 0;
		for (Integer l : leaders) {
			orderedIntArray[i++] = l;
		}

		Arrays.sort(orderedIntArray);

		return orderedIntArray;
	}

}
