package org.example;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static boolean checkForPalindrome(String text) {
        if (text == null) return false;

        String cleanedStr = text.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z0-9]", "");

        System.out.println("Temizlenmiş: [" + cleanedStr + "]");

        if (cleanedStr.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cleanedStr.length(); i++) {
            stack.push(cleanedStr.charAt(i));
        }

        for (int i = 0; i < cleanedStr.length(); i++) {
            if (stack.isEmpty()) return false;

            char poppedChar = stack.pop();
            if (poppedChar != cleanedStr.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testWords = {
                "I did, did I?",
                "Racecar",
                "hello",
                "Was it a car or a cat I saw ?",
                "Test",
                "Welcome"
        };

        System.out.println("--- Palindrom Test Sonuçları ---");
        for (String word : testWords) {
            boolean result = checkForPalindrome(word);
            System.out.println("Kelime: [" + word + "] -> Sonuç: " + result);
        }
    }

    public static String convertDecimalToBinary(int number) {
        Stack<Integer> binaryStack = new Stack<>();

        while (number > 0) {
            int remainder = number % 2;
            binaryStack.push(remainder);
            number = number / 2;
        }

        StringBuilder binaryResult = new StringBuilder();

        while (!binaryStack.isEmpty()) {
            binaryResult.append(binaryStack.pop());
        }

        return binaryResult.toString();
    }

}