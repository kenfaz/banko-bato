package HelperFunctionClasses;

public class StringFormatters {
	// Method to capitalize each word
    public static String toTitleCase(String input) { 
        if (input == null || input.isEmpty()) return input;

        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1))
                         .append(" ");
            }
        }

        return titleCase.toString().trim();
    }
}

