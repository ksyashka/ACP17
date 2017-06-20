package interviewtasks;

import java.util.Objects;

public class ExtractorInnerExpressionTask {

    /*
        extractInnerExpression("xyz(abc)123") → "(abc)"
        extractInnerExpression("x(hello)") → "(hello)"
        extractInnerExpression("(xy)1") → "(xy)"
    }*/

    public static void main(String[] args) {
        String input = "{{{{()}}}}";
        System.out.println(extractInnerExpression(input));
        System.out.println(extractInnerExpression("xyz(abc)123"));
        System.out.println(extractInnerExpression("(xy)1"));
        System.out.println(extractInnerExpression("x(hello)"));
        System.out.println(Objects.equals(extractInnerExpression("xyz(abc)123"), "(abc)"));
    }

    private static String extractInnerExpression(String input) {
        if (input == null || input.length() < 2) return null;

        if (input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') return input;

        if (input.charAt(0) == '(') return extractInnerExpression(input.substring(0, input.length() - 1));

        if (input.charAt(input.length() - 1) == ')')
            return extractInnerExpression(input.substring(1));

        return extractInnerExpression(input.substring(1, input.length() - 1));


    }

}