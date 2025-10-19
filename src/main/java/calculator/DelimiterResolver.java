package calculator;

import java.util.regex.Pattern;

public class DelimiterResolver {
    public record DelimiterResult(String input, String delimiter) {}

    public static DelimiterResult addCustomDelimiter(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int end = input.indexOf("\\n");
            if (end < 0) end = input.indexOf('\n');
            if (end < 0) throw new IllegalArgumentException("Invalid delimiter header");

            String custom = input.substring(2, end);
            if (custom.length() != 1)
                throw new IllegalArgumentException("Custom delimiter must be 1 character");

            delimiter = "[,:|" + Pattern.quote(custom) + "]";
            int skip = (input.startsWith("//") && input.charAt(end) == '\\') ? 2 : 1;
            input = input.substring(end + skip);
        }
        return new DelimiterResult(input, delimiter);
    }
}
