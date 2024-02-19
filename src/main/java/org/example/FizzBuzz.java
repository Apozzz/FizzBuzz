package org.example;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface FizzBuzzRule {
    String apply(int number);
}

public class FizzBuzz {
    public static List<String> fizzBuzz(int n, List<FizzBuzzRule> rules) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();

            for (FizzBuzzRule rule : rules) {
                sb.append(rule.apply(i));
            }

            if (sb.length() == 0) {
                sb.append(i);
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 20;
        List<FizzBuzzRule> rules = new ArrayList<>();

        rules.add(num -> num % 3 == 0 ? "Fizz" : "");
        rules.add(num -> num % 5 == 0 ? "Buzz" : "");
        rules.add(num -> num % 7 == 0 ? "Jazz" : "");

        List<String> result = fizzBuzz(n, rules);

        for (String s : result) {
            System.out.println(s + " ");
        }
    }
}