package BalancedBrackets;

//Java program for checking balanced brackets

import java.util.*;

public class chkBalancedBrackets {

	    // method for checking if brackets are balanced in a given string
	
	    static boolean methodBalancedBrackets(String brackets)
	    {
	        Stack<Character> stack
	            = new Stack<Character>();
	 
	        for (int i = 0; i < brackets.length(); i++)
	        {
	            char a = brackets.charAt(i);
	 
	            if (a == '(' || a == '[' || a == '{')
	            {
	                // Push the element in the stack
	                stack.push(a);
	                continue;
	            }
	 
	            if (stack.isEmpty())
	                return false;
	            char check;
	            switch (a) {
	            case ')':
	                check = stack.pop();
	                if (check == '{' || check == '[')
	                    return false;
	                break;
	 
	            case '}':
	                check = stack.pop();
	                if (check == '(' || check == '[')
	                    return false;
	                break;
	 
	            case ']':
	                check = stack.pop();
	                if (check == '(' || check == '{')
	                    return false;
	                break;
	            }
	        }
	 
	        // Check Empty Stack
	        return (stack.isEmpty());
	    }
	 
	    // Main method
	    public static void main(String[] args)
	    {
	 
	    	Scanner sc = new Scanner(System.in);
	    	String brackets;
	    	System.out.println("enter the string consisitng of brackets ( or ) or { or } or [ or ] : ");
	    	brackets = sc.nextLine();
	    	
	    	//String brackets = "(][{})";
	 
	        // call to the method
	        if (methodBalancedBrackets(brackets))
	            System.out.println("The entered String " + brackets + " has Balanced Brackets");
	        else
	            System.out.println(" The entered String " + brackets + " does not contain Balanced Brackets");
	    }
}