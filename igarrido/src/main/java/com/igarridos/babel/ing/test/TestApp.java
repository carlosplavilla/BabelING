package com.igarridos.babel.ing.test;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igarridos.babel.ing.test.arrayLeader.Solution;

@SpringBootApplication
public class TestApp implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(TestApp.class);
	
	@Value("${arrayLeader.array.generator.use}")
	boolean useGenerator;

	@Value("${arrayLeader.array.generator.maxLength}")
	int generatedArrayMaxLenght;

	@Value("${arrayLeader.array}")
	int[] A;

	@Value("${arrayLeader.K}")
	int K;

	@Value("${arrayLeader.M}")
	int M;
	
	@Resource
	Solution solution;

	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}

//	public void run(String... args) throws Exception {
//		try {
//			if(args.length == 2) {
//				if(args[0].equalsIgnoreCase("cash")){
//					System.out.println(PaymentStrategy.cashPayment(Double.valueOf(args[1])));
//					return;
//				}else if(args[0].equalsIgnoreCase("creditcard")){
//					System.out.println(PaymentStrategy.cardPayment(Double.valueOf(args[1])));
//					return;
//				}
//			}
//		} catch (NumberFormatException e) {
//		}
//		System.out.println("Incorrect arguments: [cash/creditcard] [numeric value]");
//	}
	
	public void run(String... args) throws Exception {
		
		long t0 = System.currentTimeMillis();
		
		if(useGenerator) {
			A = generateRandomArray();
		}
		
		logger.info("Initial array: {}; K={}; M={}", A,K,M);
		
		int[] result = solution.solution(K, M, A);
		
		logger.info("Final solution: {}",Arrays.toString(result));
		
		long td = System.currentTimeMillis() - t0;
		logger.info("Time needed: {}", td);
	}
	
	//warning, no check over generatedArrayMaxLenght, K, M
	protected int[] generateRandomArray() {
		Random random = new Random();
		int[] generatedArray = new int[generatedArrayMaxLenght];
		for(int i = 0; i < generatedArrayMaxLenght; i++) {
			generatedArray[i] = random.nextInt(M)+1;//0 value is not allowed
		}
		
		return generatedArray;
	}

}
