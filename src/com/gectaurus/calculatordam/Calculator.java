package com.gectaurus.calculatordam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
	private static final int LEFT_ASSOC = 0;
	private static final int RIGHT_ASSOC = 1;

	// Supported operators
	private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();
	static {
		OPERATORS.put("+", new int[] { 0, LEFT_ASSOC });
		OPERATORS.put("-", new int[] { 0, LEFT_ASSOC });
		OPERATORS.put("x", new int[] { 5, LEFT_ASSOC });
		OPERATORS.put("/", new int[] { 5, LEFT_ASSOC });
		OPERATORS.put("%", new int[] { 5, LEFT_ASSOC });
		OPERATORS.put("^", new int[] { 10, RIGHT_ASSOC });
	}

	private static boolean isOperator(String token) {
		return OPERATORS.containsKey(token);
	}
	
	private static boolean isAssociative(String token, int type) {
		if (!isOperator(token)) {
			throw new IllegalArgumentException("Invalid token: " + token);
		}
		if (OPERATORS.get(token)[1] == type) {
			return true;
		}
		return false;
	}

	private static final int cmpPrecedence(String token1, String token2) {
		if (!isOperator(token1) || !isOperator(token2)) {
			throw new IllegalArgumentException("Invalied tokens: " + token1
					+ " " + token2);
		}
		return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
	}
	private static String[] infixToRPN(String[] inputTokens) {
		ArrayList<String> out = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();

		for (String token : inputTokens) {
			if (isOperator(token)) {

				while (!stack.empty() && isOperator(stack.peek())) {

					if ((isAssociative(token, LEFT_ASSOC) && cmpPrecedence(
							token, stack.peek()) <= 0)
							|| (isAssociative(token, RIGHT_ASSOC) && cmpPrecedence(
									token, stack.peek()) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				
				stack.push(token);
			} else if (token.equals("(")) {
				stack.push(token); 
			} else if (token.equals(")")) {

				while (!stack.empty() && !stack.peek().equals("(")) {
					out.add(stack.pop()); 
				}
				stack.pop();
			} else {
				out.add(token); 
			}
		}
		while (!stack.empty()) {
			out.add(stack.pop());
		}
		String[] output = new String[out.size()];
		return out.toArray(output);
	}
	
	public static BigDecimal calculate(String input) {
		boolean neg = input.startsWith("-");
		if (neg) input = input.substring(1);
		for (String op : OPERATORS.keySet()) {
			input = input.replace(op, " " + op + " ");
		}
		if(neg) input = "-" + input;
		
		String[] rpn = infixToRPN(input.split(" "));
		
		System.out.println(Arrays.toString(rpn));
		
		Stack<BigDecimal> stack = new Stack<BigDecimal>();
		
		for (String o : rpn) {
			if (!OPERATORS.keySet().contains(o)) {
				stack.push(new BigDecimal(o));
				continue;
			} 
			BigDecimal n2 = stack.pop();
			BigDecimal n1 = stack.pop();
			
			if (o.equals("+")) {
				stack.push(n1.add(n2));
			} else if (o.equals("-")) {
				stack.push(n1.subtract(n2));
			} else if (o.equals("x")) {
				stack.push(n1.multiply(n2));
			} else if(o.equals("/")) {
				stack.push(n1.divide(n2, RoundingMode.DOWN));
			}
		}
		
		return stack.pop();
	}
	
}
