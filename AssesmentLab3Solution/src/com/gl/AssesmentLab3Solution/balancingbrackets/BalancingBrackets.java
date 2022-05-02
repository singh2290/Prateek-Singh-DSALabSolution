/** @author Prateek Singh
 *  @code version 1.0.0
 *  @inputParms  bracket expression ;
 *  @result to check if given expression is balanced or not
 * */
package com.gl.AssesmentLab3Solution.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets {
	protected String expression;
	private boolean status = false;

	public boolean bracketCheck(String expression) {
		// Stack of character which is required for storing individual character for
		// comparison
		Stack<Character> expressionStack = new Stack<Character>();
		// traverse individual character from string and store it in exp
		for (int i = 0; i < expression.length(); i++) {
			char checkExpression = expression.charAt(i);
			// push the expression if string matches
			if (checkExpression == '(' || checkExpression == '{' || checkExpression == '[') {
				expressionStack.push(checkExpression);
				continue;
			}
			// pop expression and check if stack is empty
			char popExpression = expressionStack.pop();
			if (popExpression != ')' || popExpression != '}' || popExpression != ']') {
				status = false;
			}
			if (expressionStack.isEmpty()) {
				status = true;
			}
		}
		return status;
	}

	public static void main(String[] args) {
		String expression = "([[{}]])";
		BalancingBrackets balance = new BalancingBrackets();
		boolean result = balance.bracketCheck(expression);
		System.out.println((result) ? "The entered String has Balanced Brackets"
				: "The entered Strings do not contain Balanced Brackets");

	}
}
