package com.igarridos.babel.ing.test.evenNumbersListTest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EvenList {

	
	public List<Integer> returnEventNumbers(List<Integer> numberList){
		return numberList.stream().filter(nl -> nl%2==0).collect(Collectors.toList());
	}
	
}
