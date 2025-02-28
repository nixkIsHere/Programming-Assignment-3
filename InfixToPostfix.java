import java.io.*;
import java.util.*;

public class InfixToPostfix {
    
    // Check if character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Define precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    // Check if expression is a valid infix expression
    private static boolean isValidInfix(String exp) {
        exp = exp.replaceAll("\\s+", "");
        int balance = 0;
        boolean prevOperator = true;
        
        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                prevOperator = false;
            } else if (ch == '(') {
                balance++;
                prevOperator = true;
            } else if (ch == ')') {
                balance--;
                if (balance < 0) return false;
                prevOperator = false;
            } else if (isOperator(ch)) {
                if (prevOperator) return false;
                prevOperator = true;
            } else {
                return false;
            }
        }
        return balance == 0 && !prevOperator;
    }

    // Convert infix to postfix
    public static String infixToPostfix(String exp) {
        Stack stack = new Stack();
        StringBuilder result = new StringBuilder();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java InfixToPostfix input1.csv");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        int expCount = 1; // Expression counter

        while ((line = reader.readLine()) != null) { // Read every line
            line = line.trim();
            if (line.isEmpty()) continue; // Skip blank lines

            System.out.println("Expression " + expCount + ":"); // Show order
            System.out.println("Infix exp: " + line);

            if (isValidInfix(line)) {
                System.out.println("Valid");
                System.out.println("Postfix exp: " + infixToPostfix(line));
            } else {
                System.out.println("Not-Valid");
            }
            System.out.println("----------------------------");
            expCount++; // Add Expression Counter
        }
        reader.close();
    }
}
