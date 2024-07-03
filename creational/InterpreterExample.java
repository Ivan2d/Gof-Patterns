package creational;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterpreterExample {
    public static void main(String[] args) {
        String expr = "a + b";
        Expr expr1 = parse(expr);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 3);
        int result = expr1.interpreter(map);
        System.out.println(result);
    }

    interface Expr {
        int interpreter(Map<String, Integer> map);
        static Expr plus(Expr left, Expr right) {
            return map -> left.interpreter(map) + right.interpreter(map);
        }
        static Expr minus(Expr left, Expr right) {
            return map ->  left.interpreter(map) - right.interpreter(map);
        }
        static Expr variable(String name) {
            return map -> map.getOrDefault(name, 0);
        }
    }
    private static Expr parse(String expr) {
        ArrayDeque<Expr> expressionObjects = new ArrayDeque<>();
        String[] expressions = expr.split(" ");
        Arrays.stream(expressions).filter(token -> Character.isLetter(token.charAt(0)))
                .forEach(token -> expressionObjects.push(parseToken(token, expressionObjects)));
        Arrays.stream(expressions).filter(token -> !Character.isLetter(token.charAt(0)))
                .forEach(token -> expressionObjects.push(parseToken(token, expressionObjects)));
        return expressionObjects.pop();
    }
    private static Expr parseToken(String token, ArrayDeque<Expr> deque) {
        switch (token) {
            case "+" -> {
                return Expr.plus(deque.pop(), deque.pop());
            }
            case "-" -> {
                return Expr.minus(deque.pop(), deque.pop());
            }
            default -> {
                return Expr.variable(token);
            }
        }
    }
}


